package librarypj1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Book book = new BookImpl();
	private User user=new UserImpl();
	private BookService ub = new BookService(book);
	private RentalService rs = new RentalService(book,user);
	private UserService us = new UserService(user,rs);

	public Menu() {
		
	}
	
	public UserVO loginUser() {  //현재 로그인한 유저를 반환
		return us.loginUser();
	}

	public int memberMenu() {  //메인메뉴
		int ch=0;
		try {
		do {
			System.out.println("\n1.로그인 2.회원가입 3.종료");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 3);
		
		if(ch==3) System.exit(0);  //3.종료

		switch (ch) {
		case 1:us.login(); break;  //1.로그인
		case 2:us.makeid(); break;  //2.회원가입
		}
		return ch;
		} catch (InputMismatchException E) {
				System.out.println("숫자만 입력 가능합니다.");
				sc.nextLine();
			} catch (Exception E) {
				
			}
		return ch;
	}

	public void adminMenu() {  //관리자메뉴
		int ch;
		UserVO loginUser = us.loginUser();
		if (loginUser == null || !loginUser.getId().equals("admin"))
			return;
		System.out.println("\n**"+loginUser.getName() + "님 반갑습니다.");
		try {
		do {
			System.out.print("1.도서등록  2.대여리스트  3.미반납리스트  4.전체도서 조회  5.회원검색  6.회원목록 7.로그아웃    => ");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 7);

		switch (ch) {
		case 1:ub.insertbook(); break;  //1.도서등록
		case 2:rs.bcheck(); break;  //2.대여리스트
		case 3:rs.nbcheck(); break;  //3.미반납리스트
		case 4:ub.bprint(); break;  //4.전체도서 조회
		case 5:rs.search(); break;  //5.회원검색
		case 6:us.print(); break; 	//6.전체회원목록
		case 7:us.logout(); break;  //7.로그아웃
		}
		} catch (InputMismatchException E) {
			System.out.println("숫자만 입력 가능합니다.");
			sc.nextLine();
		} catch (Exception E) {
			
		}
	}

	public void userMenu() {  //회원메뉴
		int ch;
		UserVO uu = loginUser();
		if( uu == null)
			return;
		try {
		do {
			System.out.print("\n1.도서검색 2.도서대여 3.도서반납 4.회원정보수정 5.회원탈퇴 6.로그아웃 => ");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 6);

		switch (ch) {
		case 1:ub.search(); break;  //1.도서검색
		case 2:rs.brent(us.loginUser()); break;  //2.도서대여
		case 3:rs.breturn(us.loginUser()); break;  //3.도서반납
		case 4:us.updateid(); break; //4.회원정보수정
		case 5:us.deleteid(); break; //5.회원탈퇴
		case 6:us.logout(); break;  //6.로그아웃
		}
		} catch (InputMismatchException E) {
			System.out.println("숫자만 입력 가능합니다.");
			sc.nextLine();
		} catch (Exception E) {
			
		}
	}	
}

