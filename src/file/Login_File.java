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
import java.util.ArrayList;

import service.user.User;
import service.user.UserService;
import service.user.db.UserDB;

public class Login_File extends FileIO {
	String userID;
	UserDB userDB;
	String make_user;
	User user;

	boolean output;
	// ������ ������ ��� ���۸� ������ ��ü
	BufferedReader bf;
	// Ű����� ���� ���۸� ������ ��ü
	BufferedReader br;

	// ID Ȯ�� ��
	ArrayList<String> Array_ID = new ArrayList<>();
	// PW Ȯ�� ��
	ArrayList<String> Array_PW = new ArrayList<>();
	// TEL Ȯ�ο�
	ArrayList<String> Array_TEL = new ArrayList<>();
	// SEX Ȯ�ο�
	ArrayList<String> Array_SEX = new ArrayList<>();
	// AGE Ȯ�ο�
	ArrayList<String> Array_AGE = new ArrayList<>();

	public Login_File() {

	}

	// UserService -> UserDB
	public Login_File(String userID, UserService userService) {
		super(userID);
		this.userID = userID;
		this.userDB = userService;
	}

	public Login_File(UserService userService) {

		// login.txt �� file ��ü�� ����
		super();

		// userDB�� ���� ��ü
		this.userDB = userService;
	}

	// �Է��� id �� login.txt ���Ͽ��ִ� id���� ���Ͽ� ���� id�� �ִ��� ��
	// ������ �ش� id�� pw ����
	public String check_ID(boolean find) throws IOException {

		// ������ �����ϸ�
		if (checkFile()) {
			bf = new BufferedReader(new FileReader("./login.txt"));
			while (true) {
				String line = bf.readLine();

				// �� ���� �е� ��������� Ż��
				if (line == null) {
					if (find)
						break;
					else {
						break;
					}
				}

				// ' ' �� ������ ����
				String[] split = line.split(" ");

				Array_ID.add(split[0]);
				Array_PW.add(split[1]);
				Array_TEL.add(split[2]);
				Array_SEX.add(split[3]);
				Array_AGE.add(split[4]);

			}
			int i = 0;
			for (String str : Array_ID) {
				if (str.equals(userID)) {
					user = new User();
					user.setUserID(str);
					user.setUserPW(Array_PW.get(i));
					user.setUserTEL(Array_TEL.get(i));
					user.setUserSEX(Array_SEX.get(i));
					user.setUserAGE(Integer.parseInt(Array_AGE.get(i)));
					userDB.update(user);

					return user.getUserPW();
				}
				i++;
			}

		}

		// ���� ���� ���� �� , �α��� ����
		// ���� �������� ������ (���� �����) ���� login.txt ���� �ڵ�����, ȸ���������� �����Է� �ʿ�
		else {
			System.out.println("		       �� ��ϵ� ID�� �����ϴ� ��");
		}
		return null;
	}

	public void find_id(String tel, String sex, String age) throws IOException {
		check_ID(true);
		int tel_sign = 0, sex_sign = 0, age_sign = 0;

		for (int i = 0; i < Array_TEL.size(); i++) {
			if (Array_TEL.get(i).equals(tel)) {
				if (Array_SEX.get(i).equals(sex)) {
					if (Array_AGE.get(i).equals(age)) {
						System.out.println("		ID : " + Array_ID.get(i));
						System.out.println();
						break;
					} else {
						if (i == Array_ID.size() - 1) {
							System.out.println("		��ġ�ϴ� ���� ����");
							System.out.println("		ȸ�������� �ϼ���.");

						}
					}
				} else {
					if (i == Array_ID.size() - 1) {
						System.out.println("		��ġ�ϴ� SEX ����");
						System.out.println("		ȸ�������� �ϼ���.");

					}
				}
			} else {
				if (i == Array_ID.size() - 1) {
					System.out.println("		��ġ�ϴ� TEL ����");
					System.out.println("		ȸ�������� �ϼ���.");

				}
			}
		}
	}

	public void find_pw(String id, String tel, String sex, String age) throws IOException {
		check_ID(true);
		int id_sign = 0, tel_sign = 0, sex_sign = 0, age_sign = 0;
		for (int i = 0; i < Array_ID.size(); i++) {

			if (Array_ID.get(i).equals(id)) {
				if (Array_TEL.get(i).equals(tel)) {
					if (Array_SEX.get(i).equals(sex)) {
						if (Array_AGE.get(i).equals(age)) {
							System.out.println("		PW : " + Array_PW.get(i));
							System.out.println();
							break;
						} else {
							if (i == Array_ID.size() - 1) {
								System.out.println("		��ġ�ϴ� ���� ����");
								System.out.println("		ȸ�������� �ϼ���.");

							}
						}
					} else {
						if (i == Array_ID.size() - 1) {
							System.out.println("		��ġ�ϴ� SEX ����");
							System.out.println("		ȸ�������� �ϼ���.");

						}
					}
				} else {
					if (i == Array_ID.size() - 1) {
						System.out.println("		��ġ�ϴ� TEL ����");
						System.out.println("		ȸ�������� �ϼ���.");

					}
				}
			} else {
				if (i == Array_ID.size() - 1) {
					System.out.println("		��ġ�ϴ� ID ����");
					System.out.println("		ȸ�������� �ϼ���.");

				}
			}
		}
	}

	public boolean sign_up() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// userDB�� �־��� user��ü ����
		user = new User();
		// login.txt �� �Է� �� ������ �Է����ִ� ��ü
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bf = new BufferedReader(new FileReader(file));
		// ������ ���翩�ο� ���ٰ��ɿ��� Ȯ��
		if (file.isFile() && file.canWrite()) {
			System.out.print("ID : ");
			make_user = br.readLine();
			// ID�ߺ� ���� ����
			String check;
			while (true) {
				check = bf.readLine();
				if (check == null)
					break;
				else if (check.split(" ")[0].equals(make_user)) {
					System.out.println("		       �� �ߺ��� ID �Դϴ� ��");
					return false;
				}

			}
			bw.write(make_user);
			bw.write(" ");
			user.setUserID(make_user);

			// �ּ� 4���� �̻�
			while (true) {
				System.out.println("PW : ");
				make_user = br.readLine();
				if (make_user.length() < 4) {
					System.out.println("		4�� �̻� �Է��ϼ���.");
				} else {
					bw.write(make_user);
					bw.write(" ");
					user.setUserPW(make_user);
					break;
				}
			}

			while (true) {
				System.out.println("TEL : ");
				make_user = br.readLine();
				if (make_user.contains("-")) {
					System.out.println("		- ���� �Է��ϼ��� ");
					System.out.println("		ex) 01012345678");
				} else {
					bw.write(make_user);
					bw.write(" ");
					user.setUserTEL(make_user);
					break;
				}
			}

			while (true) {
				System.out.println("		( only male or female )");
				System.out.println("SEX : ");
				make_user = br.readLine();
				if (make_user.equals("male") || make_user.equals("female")) {
					bw.write(make_user);
					bw.write(" ");
					user.setUserSEX(make_user);
					break;
				} else {
					System.out.println("		male Ȥ�� female �߿� �� �Է�");
				}
			}

			while (true) {
				System.out.println("AGE : ");
				make_user = br.readLine();

				char tmp;
				for (int i = 0; i < make_user.length(); i++) {
					tmp = make_user.charAt(i);

					if (Character.isDigit(tmp) == false) {
						output = false;
					} else
						output = true;
				}

				if (output) {
					bw.write(make_user);
					user.setUserAGE(Integer.parseInt(make_user));

					// UserService ��ü�� update �޼��� ȣ��
					// �Է¹��� user�� userDB�� �߰�
					userDB.update(user);
					break;
				} else {
					System.out.println("		���ڸ� �Է��ϼ���.");
				}

			}

			// ���๮�ھ���
			bw.newLine();

			bw.close();
			return true;
		} else
			return false;

	}
}
