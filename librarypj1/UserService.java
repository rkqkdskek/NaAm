package librarypj1;

import java.util.Scanner;

public class UserService {
	private Scanner sc = new Scanner(System.in);
	private UserVO loginUser = null;
	private User user;
	private Rental rental;
	private RentalService rs;

	public UserService(User user, RentalService rs) {
		this.user = user;
		this.rs=rs;
	}

	public User user() {
		return user;
	}

	public void loguser(UserVO vo) { // 로그인유저에 값 넣어주기
		loginUser = vo;
	}

	public UserVO loginUser() {
		return loginUser;
	}

	public void login() { // 메인메뉴-1.로그인
		System.out.println("회원 로그인...\n");
		String id, pwd;
		System.out.print("*아이디를 입력하시오\n>>");
		id = sc.next();

		System.out.print("*비밀번호를 입력하시오\n>>");
		pwd = sc.next();

		if (id.equals("admin") && pwd.equals("12345")) {
			UserVO us = new UserVO();
			us.setId("admin");
			us.setName("관리자");
			us.setPwd("12345");
			us.setTel("114");
			loginUser = us;
			return;
		}

		UserVO us = user.readUser(id);
		if (us != null && us.getPwd().equals(pwd)) {
			loginUser = us;
			return;
		}

		System.out.println("**아이디 또는 패스워드가 일치하지 않습니다.");
	}

	public void logout() { // 로그아웃
		loginUser = null;

		System.out.println("**로그 아웃 되었습니다.");

	}

	public void makeid() { // 1.메인메뉴-2.회원가입
		UserVO us = new UserVO();
		System.out.print("*아이디를 입력하시오?\n>>");
		us.setId(sc.next());

		if (user.readUser(us.getId()) != null) {
			System.out.println("**등록된 아이디 입니다.");
			return;
		}

		System.out.print("*비밀번호를 입력하시오\n>>");
		us.setPwd(sc.next());

		System.out.print("*이름을 입력하시오\n>>");
		us.setName(sc.next());

		System.out.print("*전화번호를 입력하시오\n>>");
		us.setTel(sc.next());
		user.insertUser(us);

		System.out.println("**회원 가입이 정상적으로 처리 되었습니다.");
	}

	public void deleteid() { // 메인메뉴-4.회원탈퇴

		String id;
		System.out.print("*탈퇴할 회원아이디를 입력하시오\n>>");
		id = sc.next();

		UserVO us = user.readUser(id);

		if (us == null) {
			System.out.println("**등록된 회원이 아닙니다.");
			return;
		}
		
		
		//대여중인 도서가 있을시에 탈퇴불가
		for(RentalVO vo:rs.rentallist()) {
			if(vo.getId().equals(id)&&vo.getReturnDate()==null) {
				System.out.println("**대여중인 도서가 있습니다. 반납 후 다시 시도해 주세요.");
				return;
			}
		}
		
		loguser(null); // 탈퇴하면 로그인유저가 없는상태로 메인메뉴로 가야하므로 null을 준다.
		System.out.println(id + "님 삭제완료");
		user.delete(id);

	}

	public void updateid() { // 메인메뉴-3.회원정보수정

		String id;
		System.out.print("*아이디를 입력하시오\n>>");
		id = sc.next();
		UserVO us = user.readUser(id);

		if (us == null) {
			System.out.println("**등록되지 않은 회원입니다");
			return;
		}
		String pwd;
		System.out.print("*비밀번호를 입력하시오\n>>");
		pwd = sc.next();

		if (pwd == null) {
			System.out.println("**비밀번호가 틀렸습니다.");
			return;
		}
		System.out.println("");

		System.out.print("*변경할 성함을 입력하세요\n>>");
		us.setName(sc.next());
		System.out.print("*변경할 전화번호를 입력하세요\n>>");
		us.setTel(sc.next());
		System.out.print("*변경할 비밀번호를 입력하세요\n>>");
		us.setPwd(sc.next());
		System.out.print("**회원 정보가 수정되었습니다");

	}

	public void print() {
		System.out.println("**총 회원수 :" + user.listUser().size());
		System.out.println("아이디 \t 비밀번호 \t 전화번호 \t 대여중인책유무");
		for (UserVO us : user.listUser()) {
			System.out.print(us.getId() + "\t");
			System.out.print(us.getName() + "\t");
			System.out.print(us.getTel() + "\t");
			System.out.println(us.getUserbookcd() + "\n");
		}
	}
}
