package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.Service;
import service.user.UserService;

public class Application {

	public static void main(String[] args) throws IOException {
		Service service = new Service();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		UserService userService = service.getUserService();

		while (true) {
			System.out.println("������ �ϱ���  ------------------------v 1.0");
			System.out.println("(1) �α���");
			System.out.println("(2) ȸ������");

			System.out.println("==============�α��� �ߴٰ� ħ=================");

			// ȸ������ �����ְ� ���� ���� �� �Խñ� ����, �� ��¥(��¥��) ������
			System.out.println("(1) �Խñ� ����");
			System.out.println("(2) �Խñ� ����");
			System.out.println("(3) �Խñ� ����");
			System.out.println("(4) �Խñ� �˻�");
			System.out.println("(5) ȸ������ ����");

			System.out.println("============ȸ������ �� �ߴ� ħ =================");

			System.out.println("(1) ����");
			System.out.println("(1) ����");
		}
		// test
		// userService.print();
	}

}
