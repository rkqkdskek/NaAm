package librarypj1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu mn = new Menu();
		UserVO loginUser = null;

		int ch;
		
		try {
			System.out.println("** ������ **"); 
			while(true) {
				loginUser = mn.loginUser();
				if(loginUser == null) {
					ch = mn.memberMenu();
					if(ch==3) {
						break;
					}
				} else if(loginUser.getId().equals("admin")) {
					mn.adminMenu();
				} else {
					mn.userMenu();
				}
			}
		}  catch (InputMismatchException E) {
			System.out.println("���ڸ� �Է� �����մϴ�.");
			sc.nextLine();
		} catch (Exception E) {
			
		}
		sc.close();
	}
}
