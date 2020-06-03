// ���� �Ѱ� 
// user : �α��� ���� ��ȸ�� ���� �α���, ȸ�������� ���� �α��� ���� �����, 
// post : user id�� Ȯ���Ͽ� �Խñ� ���� ��ȸ, ������ ���� ����, ������ �Խñ� ���, �Խñ� �ۼ�
// �ؾ��Ұ�
// user : ȸ������ �����ϱ�
// post : �Խñ� �����ϱ� , �Խñ� �˻��ϱ� (����) , �Խñ� �����ϱ�

// ���� �Ϸ��� �ٵ��� �Һκ�
// all  : ��ü���� CLI UI ��Ʈ�� ������, �ڵ� ����ȭ 
//        (�θ�-�ڽ� ���� ��� ���� �� ��üȭ ���� �ʿ� & ���� ���� ���� & �ּ������)
// user : 
// post : �α��� �� �Խñ� ��ȸ�� �������θ� �켱 ��� ��ȸ -> �Ŀ� ��ü�Խñ� ��ȸ Ȥ�� �˻��� ���� �Խñ� ���� ǥ��
//   	  �Խñ� ���� �ִ� 9�� (�� ������ ���̵� �߰� ���� �䱸)
//       ���ึ�� DB�� �ʱ�ȭ�Ǳ� ������ �Խù� ��ȣ�� �������� -> �����ʿ�

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
			Login.check();
			Login.choice();
			input = br_keyboard.readLine();

			// �α���
			if (Integer.parseInt(input) == 1) {
				Login.answer_ID();
				input = br_keyboard.readLine();
				// ������ ���̵� ���� �� �α��� ����
				if ((pw = Login.check_ID(input, userService)) == null)
					;

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

		}

		// login ������ t, f ���� ���� ���࿩�� ����
		while (login) {
			Play.print_list(userService, postService);
			Play.menu();
			input = br_keyboard.readLine();

			// �Խñ� ����
			if (Integer.parseInt(input) == 1) {
				Play.title_in();
				input = br_keyboard.readLine();
				Play.make_post(input, userService, postService);
			}
			// �Խñ� ����
			else if (Integer.parseInt(input) == 2) {

			}
			// �Խñ� ����
			else if (Integer.parseInt(input) == 3) {

			}
			// �Խñ� �˻�
			else if (Integer.parseInt(input) == 4) {

			}
			// ȸ������ ����
			else if (Integer.parseInt(input) == 5) {

			}

		}
	}

}
