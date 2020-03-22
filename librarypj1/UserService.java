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

	public void loguser(UserVO vo) { // �α��������� �� �־��ֱ�
		loginUser = vo;
	}

	public UserVO loginUser() {
		return loginUser;
	}

	public void login() { // ���θ޴�-1.�α���
		System.out.println("ȸ�� �α���...\n");
		String id, pwd;
		System.out.print("*���̵� �Է��Ͻÿ�\n>>");
		id = sc.next();

		System.out.print("*��й�ȣ�� �Է��Ͻÿ�\n>>");
		pwd = sc.next();

		if (id.equals("admin") && pwd.equals("12345")) {
			UserVO us = new UserVO();
			us.setId("admin");
			us.setName("������");
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

		System.out.println("**���̵� �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.");
	}

	public void logout() { // �α׾ƿ�
		loginUser = null;

		System.out.println("**�α� �ƿ� �Ǿ����ϴ�.");

	}

	public void makeid() { // 1.���θ޴�-2.ȸ������
		UserVO us = new UserVO();
		System.out.print("*���̵� �Է��Ͻÿ�?\n>>");
		us.setId(sc.next());

		if (user.readUser(us.getId()) != null) {
			System.out.println("**��ϵ� ���̵� �Դϴ�.");
			return;
		}

		System.out.print("*��й�ȣ�� �Է��Ͻÿ�\n>>");
		us.setPwd(sc.next());

		System.out.print("*�̸��� �Է��Ͻÿ�\n>>");
		us.setName(sc.next());

		System.out.print("*��ȭ��ȣ�� �Է��Ͻÿ�\n>>");
		us.setTel(sc.next());
		user.insertUser(us);

		System.out.println("**ȸ�� ������ ���������� ó�� �Ǿ����ϴ�.");
	}

	public void deleteid() { // ���θ޴�-4.ȸ��Ż��

		String id;
		System.out.print("*Ż���� ȸ�����̵� �Է��Ͻÿ�\n>>");
		id = sc.next();

		UserVO us = user.readUser(id);

		if (us == null) {
			System.out.println("**��ϵ� ȸ���� �ƴմϴ�.");
			return;
		}
		
		
		//�뿩���� ������ �����ÿ� Ż��Ұ�
		for(RentalVO vo:rs.rentallist()) {
			if(vo.getId().equals(id)&&vo.getReturnDate()==null) {
				System.out.println("**�뿩���� ������ �ֽ��ϴ�. �ݳ� �� �ٽ� �õ��� �ּ���.");
				return;
			}
		}
		
		loguser(null); // Ż���ϸ� �α��������� ���»��·� ���θ޴��� �����ϹǷ� null�� �ش�.
		System.out.println(id + "�� �����Ϸ�");
		user.delete(id);

	}

	public void updateid() { // ���θ޴�-3.ȸ����������

		String id;
		System.out.print("*���̵� �Է��Ͻÿ�\n>>");
		id = sc.next();
		UserVO us = user.readUser(id);

		if (us == null) {
			System.out.println("**��ϵ��� ���� ȸ���Դϴ�");
			return;
		}
		String pwd;
		System.out.print("*��й�ȣ�� �Է��Ͻÿ�\n>>");
		pwd = sc.next();

		if (pwd == null) {
			System.out.println("**��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return;
		}
		System.out.println("");

		System.out.print("*������ ������ �Է��ϼ���\n>>");
		us.setName(sc.next());
		System.out.print("*������ ��ȭ��ȣ�� �Է��ϼ���\n>>");
		us.setTel(sc.next());
		System.out.print("*������ ��й�ȣ�� �Է��ϼ���\n>>");
		us.setPwd(sc.next());
		System.out.print("**ȸ�� ������ �����Ǿ����ϴ�");

	}

	public void print() {
		System.out.println("**�� ȸ���� :" + user.listUser().size());
		System.out.println("���̵� \t ��й�ȣ \t ��ȭ��ȣ \t �뿩����å����");
		for (UserVO us : user.listUser()) {
			System.out.print(us.getId() + "\t");
			System.out.print(us.getName() + "\t");
			System.out.print(us.getTel() + "\t");
			System.out.println(us.getUserbookcd() + "\n");
		}
	}
}
