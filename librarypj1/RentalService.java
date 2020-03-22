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
	
	public void brent(UserVO loginUser) {  //ȸ���޴�-2.�����뿩
		String a;
		System.out.print("*�뿩 �� ���� �ڵ� �Է�:\n>>");
		a = sc.next();
		
		if (rt.readRental(a) != null) {
			System.out.println("**�̹� �뿩���� �����Դϴ�.");
			return;
		}
		
		BookVO bvo = book.readBook(a);
		if(bvo==null) {
			System.out.println("**��ϵ� ������ �ƴմϴ�.");
			return;
		}
		
		Calendar cal = Calendar.getInstance();
		String time = String.format("%tT", cal); // ����ð��� �����½ð����� �Ѵ�.

		RentalVO vo2 = new RentalVO();
		vo2.setCode(a);
		vo2.setId(loginUser.getId());
		vo2.setRentDate(time);

		rt.insertRental(vo2);
		

		System.out.println("**�뿩�� ���������� �Ϸ�Ǿ����ϴ�.");

	}

	public void breturn(UserVO loginUser) {  //ȸ���޴�-3.�����ݳ�
		System.out.println("*�ݳ��Ͻ� ������ �����ڵ� �Է�\n>>");
		String a = sc.next();
		if (rt.readRental(a) == null) {
			System.out.println("**�뿩���� ������ �ƴմϴ�.");
			return;
		}
		
		if(!loginUser.getId().equals(rt.readRental(a).getId())) {
			System.out.println("**ȸ������ �뿩���̽� ������ �ݳ� �����մϴ�.");
			return;
		}
		
		Calendar cal = Calendar.getInstance();
		String time = String.format("%tT", cal); // ����ð��� �ݳ��ð����� �Ѵ�.

		rt.readRental(a).setReturnDate(time);
		System.out.println("**�ݳ��� �Ϸ�Ǿ����ϴ�.");

	}

	public void bcheck() {  //�����ڸ޴�-2.�뿩����Ʈ
		System.out.println("<å�ڵ�>\t<�������>\t<������¥>\t<�ݳ���¥>");
		for (RentalVO vo : rt.listAllRental()) {
			System.out.println(vo);
		}
	}

	public void nbcheck() {  //�����ڸ޴�-3.�̹ݳ�����Ʈ
		System.out.println("<å�ڵ�>\t<�������>\t<������¥>");
		for (RentalVO vo : rt.listAllRental()) {
			if (vo.getReturnDate() == null) {
				System.out.println(vo.toString2());
			}
		}
	}

	public void search() {  //�����ڸ޴�-5.ȸ���˻�
		System.out.print("*�˻��� ȸ���� ���̵� �Է��ϼ���\n>>");
		String name = sc.next();
		
		if(user.readUser(name)==null) {
			System.out.println("**�ش��ϴ� ȸ���� �����ϴ�.");
			return;
		}
		
		System.out.println("**"+name+"���� �뿩/�ݳ� ���");
		System.out.println("<å�ڵ�>\t<������¥>\t<�ݳ���¥>");
		for (RentalVO vo : rt.listUserRental(name)) {
			System.out.print(vo.getCode() + "\t");
			System.out.print(vo.getRentDate() + "\t");
			System.out.println(vo.getReturnDate());
		}
	}
	
	//�뿩��ü��� ��ȯ
	public List<RentalVO> rentallist(){
		return rt.listAllRental();
	}
}
