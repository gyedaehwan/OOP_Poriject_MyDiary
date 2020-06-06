package main;

import java.io.IOException;

import file.Login_File;
import service.user.UserService;

abstract class Login {

	static int version = 1;

	static void start() {
		System.out.println("  �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�      �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�Ƣ�                       �ƢƢ� �ƢƢ�                     �Ƣ�");
		System.out.println("�Ƣ� ������ �ϱ���                                     ��     ����Ʈ�����к� ����               �Ƣ�");
		System.out.println("�Ƣ� My Diary                 ��     20170260           �Ƣ�");
		System.out.println("�Ƣ�                          ��     ���ȯ                                  �Ƣ�");
		System.out.println("�Ƣ� �α����� �ʿ��մϴ� .           ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ� (1) �α���                                      ��                        �Ƣ�");
		System.out.println("�Ƣ� (2) ȸ������                                   ��                        �Ƣ�");
		System.out.println("�Ƣ� (3) ȸ��ã��                                   ��                        �Ƣ�");
		System.out.println("�Ƣ� (4) ����                                         ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                       �ƢƢ� �ƢƢ�                     �Ƣ�");
		System.out.println("  �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�     �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�  ");
		System.out.println("");
	}

	static void choice() {
		System.out.print(":: ");
	}

	static void choice_ERROR() {

		System.out.println("		       �� 1 ,2, 3 �߿��� ������ ��");
		System.out.println("			�����..");
		print_restart();
	}

	static void answer_ID() {
		System.out.print("ID : ");
	}

	static void answer_PW() {
		System.out.print("PW : ");
	}

	static String check_ID(String userID, UserService userService) throws IOException {
		Login_File login = new Login_File(userID, userService);
		return login.check_ID(false);
	}

	static void wrong_PW() {
		System.out.println("		      �� �߸��� ��й�ȣ �Դϴ� �� ");
		print_restart();
	}

	static void sign_up(UserService userService) throws IOException {
		Login_File login = new Login_File(userService);
		if (login.sign_up())
			System.out.println("ȸ�� ���� ����!");
		else
			print_restart();
	}

	static void find_user() {
		System.out.println("		ȸ�� ã�� �Դϴ�.");
		System.out.println("		ID?    PW? ");
	}

	static void find_id(UserService userService, String tel, String sex, String age) throws IOException {
		Login_File login = new Login_File(userService);
		login.find_id(tel, sex, age);
	}

	static void find_pw(UserService userService, String id, String tel, String sex, String age) throws IOException {
		Login_File login = new Login_File(userService);
		login.find_pw(id, tel, sex, age);
	}

	static void print_restart() {
		System.out.println(".......................�� RESTART ��....................... ");
		System.out.println();
	};

}
