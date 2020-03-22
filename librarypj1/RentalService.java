package librarypj1;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class RentalService {
	private Scanner sc = new Scanner(System.in);
	private Rental rt = new RentalImpl();
	private Book book;
	private User user;
	 
	public RentalService(Book book, User user) {
		this.book = book;
		this.user = user;
	}
	
	public void brent(UserVO loginUser) {  //회원메뉴-2.도서대여
		String a;
		System.out.print("*대여 할 도서 코드 입력:\n>>");
		a = sc.next();
		
		if (rt.readRental(a) != null) {
			System.out.println("**이미 대여중인 도서입니다.");
			return;
		}
		
		BookVO bvo = book.readBook(a);
		if(bvo==null) {
			System.out.println("**등록된 도서가 아닙니다.");
			return;
		}
		
		Calendar cal = Calendar.getInstance();
		String time = String.format("%tT", cal); // 현재시간을 빌리는시간으로 한다.

		RentalVO vo2 = new RentalVO();
		vo2.setCode(a);
		vo2.setId(loginUser.getId());
		vo2.setRentDate(time);

		rt.insertRental(vo2);
		

		System.out.println("**대여가 성공적으로 완료되었습니다.");

	}

	public void breturn(UserVO loginUser) {  //회원메뉴-3.도서반납
		System.out.println("*반납하실 도서의 도서코드 입력\n>>");
		String a = sc.next();
		if (rt.readRental(a) == null) {
			System.out.println("**대여중인 도서가 아닙니다.");
			return;
		}
		
		if(!loginUser.getId().equals(rt.readRental(a).getId())) {
			System.out.println("**회원님이 대여중이신 도서만 반납 가능합니다.");
			return;
		}
		
		Calendar cal = Calendar.getInstance();
		String time = String.format("%tT", cal); // 현재시간을 반납시간으로 한다.

		rt.readRental(a).setReturnDate(time);
		System.out.println("**반납이 완료되었습니다.");

	}

	public void bcheck() {  //관리자메뉴-2.대여리스트
		System.out.println("<책코드>\t<빌린사람>\t<빌린날짜>\t<반납날짜>");
		for (RentalVO vo : rt.listAllRental()) {
			System.out.println(vo);
		}
	}

	public void nbcheck() {  //관리자메뉴-3.미반납리스트
		System.out.println("<책코드>\t<빌린사람>\t<빌린날짜>");
		for (RentalVO vo : rt.listAllRental()) {
			if (vo.getReturnDate() == null) {
				System.out.println(vo.toString2());
			}
		}
	}

	public void search() {  //관리자메뉴-5.회원검색
		System.out.print("*검색할 회원의 아이디를 입력하세요\n>>");
		String name = sc.next();
		
		if(user.readUser(name)==null) {
			System.out.println("**해당하는 회원이 없습니다.");
			return;
		}
		
		System.out.println("**"+name+"님의 대여/반납 목록");
		System.out.println("<책코드>\t<빌린날짜>\t<반납날짜>");
		for (RentalVO vo : rt.listUserRental(name)) {
			System.out.print(vo.getCode() + "\t");
			System.out.print(vo.getRentDate() + "\t");
			System.out.println(vo.getReturnDate());
		}
	}
	
	//대여전체목록 반환
	public List<RentalVO> rentallist(){
		return rt.listAllRental();
	}
}
