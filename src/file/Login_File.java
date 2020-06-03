// login.txt ���� �´� id�� �ִ��� Ȯ�� �� �α��� ���� ����
// login.txt���� ȸ��������
// ID PW TEL SEX AGE   �� �پ� ���� ( ' '�� ������ ���� )
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import service.user.User;
import service.user.UserService;

public class Login_File extends FileIO {
	String userID;
	UserService userService;
	String make_user;
	User user;
	// ������ ������ ��� ���۸� ������ ��ü
	BufferedReader bf;
	// Ű����� ���� ���۸� ������ ��ü
	BufferedReader br;

	public Login_File() {

	}

	public Login_File(String userID, UserService userService) {
		super(userID);
		this.userID = userID;
		this.userService = userService;
	}

	public Login_File(UserService userService) {

		// login.txt �� file ��ü�� ����
		super();

		// userDB�� ���� ��ü
		this.userService = userService;
	}

	// �Է��� id �� login.txt ���Ͽ��ִ� id���� ���Ͽ� ���� id�� �ִ��� ��
	// ������ �ش� id�� pw ����
	public String check_ID() throws IOException {

		// ������ �����ϸ�
		if (checkFile()) {
			bf = new BufferedReader(new FileReader("./login.txt"));
			while (true) {
				String line = bf.readLine();

				// �� ���� �е� ��������� Ż��
				if (line == null) {
					System.out.println("��ϵ� ID�� �����ϴ�.");
					break;
				}

				// ' ' �� ������ ����
				// [0] : ID , [1] : PW , [2] : TEL , [3] : SEX , [4] : AGE
				String[] split = line.split(" ");

				// �ش� ���� ������� ������ ù��° ������ (id) �� �Էµ� userID�� ���� �� ��
				// ������ �ش� ��й�ȣ ����
				if (split[0].equals(userID)) {
					user = new User();
					user.setUserID(split[0]);
					user.setUserPW(split[1]);
					user.setUserTEL(split[2]);
					user.setUserSEX(split[3]);
					user.setUserAGE(Integer.parseInt(split[4]));
					userService.update(user);
					return split[1];
				}
			}

		}

		// ���� ���� ���� �� , �α��� ����
		// ���� �������� ������ (���� �����) ���� login.txt ���� �ڵ�����, ȸ���������� �����Է� �ʿ�
		else {
			System.out.println("��ϵ� ID�� �����ϴ�.");
		}
		return null;
	}

	public void sign_up() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// userDB�� �־��� user��ü ����
		user = new User();
		// login.txt �� �Է� �� ������ �Է����ִ� ��ü
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

		// ������ ���翩�ο� ���ٰ��ɿ��� Ȯ��
		if (file.isFile() && file.canWrite()) {
			System.out.print("ID : ");
			make_user = br.readLine();
			bw.write(make_user);
			bw.write(" ");
			user.setUserID(make_user);

			System.out.println("PW : ");
			make_user = br.readLine();
			bw.write(make_user);
			bw.write(" ");
			user.setUserPW(make_user);

			System.out.println("TEL : ");
			make_user = br.readLine();
			bw.write(make_user);
			bw.write(" ");
			user.setUserTEL(make_user);

			System.out.println("SEX : ");
			make_user = br.readLine();
			bw.write(make_user);
			bw.write(" ");
			user.setUserSEX(make_user);

			System.out.println("AGE : ");
			make_user = br.readLine();
			bw.write(make_user);
			user.setUserAGE(Integer.parseInt(make_user));

			// UserService ��ü�� update �޼��� ȣ��
			// �Է¹��� user�� userDB�� �߰�
			userService.update(user);

		}

		// ���๮�ھ���
		bw.newLine();

		bw.close();
	}

}
