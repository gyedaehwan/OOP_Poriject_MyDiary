
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.Service;
import service.post.PostService;
import service.user.UserService;

public class Application {

	public static void main(String[] args) throws IOException {

		// Service ��ü�� ���� userDB�� postDB �ѹ��� ����
		// Service() -> UserService(), PostService() -> UserDB(), PostDB()
		// ���������� ����
		Service service = new Service();

		// Ű���忡�� �Է¹��� ���۸� ������ ��ü ����
		BufferedReader br_keyboard = new BufferedReader(new InputStreamReader(System.in));

		// Service��ü�κ��� ������ UserService�� PostService ��ü �̿�
		UserService userService = service.getUserService();
		PostService postService = service.getPostService();

		// String ��ü ���
		String input; // ���α׷� ���ణ�� �Է��� �߰����� String ��ü
		String pw; // ��й�ȣ Ȯ���� ���� String ��ü

		// ���� ���
		boolean login = false; // �α��� Ȯ�� ���θ� ���� ����, �ʱⰪ f (t: �α��� ����, f: �α��� ����)

		// ���α׷� ������ ����
		while (true) {
			Login.start();
			Login.choice();
			input = br_keyboard.readLine();

			try {

				// �α���
				if (Integer.parseInt(input) == 1) {
					Login.answer_ID();
					input = br_keyboard.readLine();
					// ������ ���̵� ���� �� �α��� ����
					if ((pw = Login.check_ID(input, userService)) == null)
						Login.print_restart();

					// ������ ���̵� ���� �� PW�䱸
					else {
						Login.answer_PW();
						input = br_keyboard.readLine();
						// pw ���� �� �α��� ����
						if (pw.equals(input)) {
							login = true;
							break;
						} else
							Login.wrong_PW();

					}

				}

				// ȸ������
				else if (Integer.parseInt(input) == 2) {
					Login.sign_up(userService);
				}
				// ����
				else if (Integer.parseInt(input) == 3)
					break;
				else
					Login.choice_ERROR();

			} catch (NumberFormatException e) {
				Login.print_restart();
				System.out.println("		       �� 1~3�� ���ڸ� �Է��ϼ��� ��");
				Login.print_restart();
				continue;
			}

		}

		// login ������ t, f ���� ���� ���࿩�� ����
		while (login) {
			Play.print_list(userService, postService);
			Play.menu();
			input = br_keyboard.readLine();

			try {
				// �Խñ� ����
				if (Integer.parseInt(input) == 1) {
					Play.title_in();
					input = br_keyboard.readLine();
					Play.make_post(input, userService, postService);
				}
				// �Խñ� ��ȸ
				else if (Integer.parseInt(input) == 2) {
					Play.print_all(userService, postService);
				}
				// �Խñ� ����
				else if (Integer.parseInt(input) == 3) {
					Play.num_in();
					input = br_keyboard.readLine();
					Play.delete_post(Integer.parseInt(input), userService, postService);
				}
				// �Խñ� �˻�
				else if (Integer.parseInt(input) == 4) {
					Play.search_post_in();
					input = br_keyboard.readLine();
					Play.search_post(input, userService, postService);

				} else if (Integer.parseInt(input) == 5) {
					System.out.println("		 �� �α׾ƿ� �� �����մϴ� ��");
					System.out.println("              MADE BY GYE DAEHWAN_2020 ");

					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("		       �� 1~5�� ���ڸ� �Է��ϼ��� ��");
				System.out.println();
				System.out.println();
				continue;
			}
		}
	}

}
