package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import file.Login_File;
import file.Post_File;
import service.Service;
import service.post.PostService;
import service.user.UserService;

public class Application {

	public static void main(String[] args) throws IOException {
		Service service = new Service();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		UserService userService = service.getUserService();
		Login_File file_login = new Login_File(userService);
		Post_File post_file;

		while (true) {

			System.out.println("������ �ϱ���  ------------------------v 1.0");
			System.out.println("(1) �α���");
			System.out.println("(2) ȸ������");
			System.out.print("input : ");
			String input = bf.readLine();

			String pw;
			boolean login = false;

			// �α���
			if (input.equals("1")) {
				System.out.print("ID : ");
				input = bf.readLine();
				file_login = new Login_File(input, userService);
				if ((pw = file_login.read()) == null)
					;
				else {
					System.out.print("PW :");
					input = bf.readLine();
					if (pw.equals(input)) {
						login = true;
						System.out.println("===================login==============");

					} else {
						login = false;
						System.out.println("��й�ȣ ����.");
					}
				}
			}
			// ȸ������
			else if (input.equals("2")) {
				file_login.write();

			} else {
				System.out.println("1 �� 2 �߿� �Է��ϼ���.");
			}

			// �α��� ����
			// �Խñ� ȭ��
			while (login) {
				PostService postService = service.getPostService();
				String userID = userService.user_service_DB.userID();

				post_file = new Post_File(userID, postService);
				post_file.print_post();

				// ȸ������ �����ְ� ���� ���� �� �Խñ� ����, �� ��¥(��¥��) ������
				System.out.println("(1) �Խñ� ����");
				System.out.println("(2) �Խñ� ����");
				System.out.println("(3) �Խñ� ����");
				System.out.println("(4) �Խñ� �˻�");
				System.out.println("(5) ȸ������ ����");
				System.out.print("Input : ");
				input = bf.readLine();

				if (input.equals("1")) {

					post_file.write();

				} else if (input.equals("2")) {

				} else if (input.equals("3")) {

				} else if (input.equals("4")) {

				} else if (input.equals("5")) {

				} else
					System.out.println("1~5�߿��� ���ÿ�.");
				/**
				 * System.out.println("(1) ����"); System.out.println("(1) ����");
				 **/
			}
		}
		// test
		// userService.print();
	}

}
