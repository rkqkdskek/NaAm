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
	
	public UserVO loginUser() {  //���� �α����� ������ ��ȯ
		return us.loginUser();
	}

	public int memberMenu() {  //���θ޴�
		int ch=0;
		try {
		do {
			System.out.println("\n1.�α��� 2.ȸ������ 3.����");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 3);
		
		if(ch==3) System.exit(0);  //3.����

		switch (ch) {
		case 1:us.login(); break;  //1.�α���
		case 2:us.makeid(); break;  //2.ȸ������
		}
		return ch;
		} catch (InputMismatchException E) {
				System.out.println("���ڸ� �Է� �����մϴ�.");
				sc.nextLine();
			} catch (Exception E) {
				
			}
		return ch;
	}

	public void adminMenu() {  //�����ڸ޴�
		int ch;
		UserVO loginUser = us.loginUser();
		if (loginUser == null || !loginUser.getId().equals("admin"))
			return;
		System.out.println("\n**"+loginUser.getName() + "�� �ݰ����ϴ�.");
		try {
		do {
			System.out.print("1.�������  2.�뿩����Ʈ  3.�̹ݳ�����Ʈ  4.��ü���� ��ȸ  5.ȸ���˻�  6.ȸ����� 7.�α׾ƿ�    => ");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 7);

		switch (ch) {
		case 1:ub.insertbook(); break;  //1.�������
		case 2:rs.bcheck(); break;  //2.�뿩����Ʈ
		case 3:rs.nbcheck(); break;  //3.�̹ݳ�����Ʈ
		case 4:ub.bprint(); break;  //4.��ü���� ��ȸ
		case 5:rs.search(); break;  //5.ȸ���˻�
		case 6:us.print(); break; 	//6.��üȸ�����
		case 7:us.logout(); break;  //7.�α׾ƿ�
		}
		} catch (InputMismatchException E) {
			System.out.println("���ڸ� �Է� �����մϴ�.");
			sc.nextLine();
		} catch (Exception E) {
			
		}
	}

	public void userMenu() {  //ȸ���޴�
		int ch;
		UserVO uu = loginUser();
		if( uu == null)
			return;
		try {
		do {
			System.out.print("\n1.�����˻� 2.�����뿩 3.�����ݳ� 4.ȸ���������� 5.ȸ��Ż�� 6.�α׾ƿ� => ");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 6);

		switch (ch) {
		case 1:ub.search(); break;  //1.�����˻�
		case 2:rs.brent(us.loginUser()); break;  //2.�����뿩
		case 3:rs.breturn(us.loginUser()); break;  //3.�����ݳ�
		case 4:us.updateid(); break; //4.ȸ����������
		case 5:us.deleteid(); break; //5.ȸ��Ż��
		case 6:us.logout(); break;  //6.�α׾ƿ�
		}
		} catch (InputMismatchException E) {
			System.out.println("���ڸ� �Է� �����մϴ�.");
			sc.nextLine();
		} catch (Exception E) {
			
		}
	}	
}

