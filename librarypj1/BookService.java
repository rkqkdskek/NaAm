package librarypj1;

import java.util.List;
import java.util.Scanner;

public class BookService {
	private Scanner sc = new Scanner(System.in);
	private Book book;

	public BookService(Book book) {
		this.book = book;
	}

	public void insertbook() {  //�����ڸ޴�-1.�������
		String code, title, writer, company;
		System.out.print("*����Ͻ� å�� �ڵ带 �����ϼ���\n>>");
		code = sc.next();

		if (book.readBook(code) != null) {
			System.out.println("**�̹� ��ϵǾ� �ִ� �����Դϴ�.");
			return;
		}

		System.out.print("*����Ͻ� å ������ �Է��ϼ���\n>>");
		title = sc.next();

		System.out.print("*���ڸ� �Է��ϼ���.\n>>");
		writer = sc.next();

		System.out.print("*���ǻ縦 �Է��ϼ���\n>>");
		company = sc.next();

		BookVO bo = new BookVO();

		bo.setCode(code);
		bo.setTitle(title);
		bo.setWriter(writer);
		bo.setCompany(company);

		book.bput(bo);

		System.out.println("**���� ����� �Ϸ� �Ǿ����ϴ�.");
	}

	public void search() {  //ȸ���޴�-1.�����˻�
		// ���� �˻� 
		String title;
		System.out.print("*�˻� �� �������� �Է��ϼ���.\n>>");
		title = sc.next();

		List<BookVO> slist = book.listBook(title);

		if (slist == null) {
			System.out.println("**��ġ�ϴ� ���� ������ �����ϴ�.");
			return;
		}

		for (BookVO bo : slist) {
			System.out.println(bo);
		}
	}
	
	public void bprint() {  //�����ڸ޴�-4.��ü���� ��ȸ
		System.out.println("\n���� ���� �� : " + book.listbook().size());
		System.out.println("=======================================");
		System.out.println("�����ڵ�\t������\t\t����\t���ǻ�");
		System.out.println("=======================================");
		for (BookVO bo : book.listbook()){
			System.out.println(bo);
		}
		System.out.println("=======================================");
	}

}
