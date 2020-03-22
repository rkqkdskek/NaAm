package librarypj1;

import java.util.List;
import java.util.Scanner;

public class BookService {
	private Scanner sc = new Scanner(System.in);
	private Book book;

	public BookService(Book book) {
		this.book = book;
	}

	public void insertbook() {  //관리자메뉴-1.도서등록
		String code, title, writer, company;
		System.out.print("*등록하실 책의 코드를 설정하세요\n>>");
		code = sc.next();

		if (book.readBook(code) != null) {
			System.out.println("**이미 등록되어 있는 도서입니다.");
			return;
		}

		System.out.print("*등록하실 책 제목을 입력하세요\n>>");
		title = sc.next();

		System.out.print("*저자를 입력하세요.\n>>");
		writer = sc.next();

		System.out.print("*출판사를 입력하세요\n>>");
		company = sc.next();

		BookVO bo = new BookVO();

		bo.setCode(code);
		bo.setTitle(title);
		bo.setWriter(writer);
		bo.setCompany(company);

		book.bput(bo);

		System.out.println("**도서 등록이 완료 되었습니다.");
	}

	public void search() {  //회원메뉴-1.도서검색
		// 도서 검색 
		String title;
		System.out.print("*검색 할 도서명을 입력하세요.\n>>");
		title = sc.next();

		List<BookVO> slist = book.listBook(title);

		if (slist == null) {
			System.out.println("**일치하는 도서 정보가 없습니다.");
			return;
		}

		for (BookVO bo : slist) {
			System.out.println(bo);
		}
	}
	
	public void bprint() {  //관리자메뉴-4.전체도서 조회
		System.out.println("\n보유 도서 수 : " + book.listbook().size());
		System.out.println("=======================================");
		System.out.println("도서코드\t도서명\t\t저자\t출판사");
		System.out.println("=======================================");
		for (BookVO bo : book.listbook()){
			System.out.println(bo);
		}
		System.out.println("=======================================");
	}

}
