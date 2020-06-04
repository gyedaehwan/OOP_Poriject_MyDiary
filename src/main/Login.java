package main;

import java.io.IOException;

import file.Login_File;
import service.user.UserService;

abstract class Login {

	static int version = 1;

	static void start() {
		System.out.println("������ �ϱ��� ����");
		System.out.println("ȯ���մϴ�!!");
		System.out.println("******************");
	}

	static void check() {
		System.out.println("** �α����� �ʿ��մϴ�. **");
		System.out.println();
	}

	static void choice() {
		System.out.println("(1) �α���");
		System.out.println("(2) ȸ������");
		System.out.println("(3) ����");
		System.out.println(":: ");
	}

	static void choice_ERROR() {
		System.out.println("1 ,2, 3 �߿��� ������!");
		System.out.println("�����..");
		System.out.println();
		System.out.println();

	}

	static void answer_ID() {
		System.out.print("ID : ");
	}

	static void answer_PW() {
		System.out.print("PW : ");
	}

	static String check_ID(String userID, UserService userService) throws IOException {
		Login_File login = new Login_File(userID, userService);
		return login.check_ID();
	}

	static void wrong_PW() {
		System.out.println("�߸��� ��й�ȣ �Դϴ�. ");
	}

	static void sign_up(UserService userService) throws IOException {
		Login_File login = new Login_File(userService);
		login.sign_up();
		System.out.println("ȸ�� ���� ����!");
	}
}
