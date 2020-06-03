package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import service.user.UserService;

public class Login_File extends FileIO {
	String input_ID;
	UserService userService;
	BufferedReader br;

	public Login_File(UserService userService) {
		this.userService = userService;
	}

	public Login_File(String id, UserService userService) {
		super("login");
		this.userService = userService;
		// 입력한 id
		input_ID = id;
	}

	public String read() throws IOException {
		// test - what is input id
		System.out.println(input_ID);

		if (checkFile()) {
			br = new BufferedReader(new FileReader("./login.txt"));
			while (true) {
				String line = br.readLine();

				if (line == null) {
					System.out.println("등록된 ID가 없습니다.");
					break;
				}
				String[] split = line.split(" ");
				if (split[0].equals(input_ID)) {
					userService.create_user(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
					return split[1];
				}
			}

		} else {
			System.out.println("등록된 ID가 없습니다.");
		}
		return null;
	}

	public void write() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		if (file.isFile() && file.canWrite()) {
			String[] make_user = new String[5];
			System.out.print("ID : ");
			make_user[0] = br.readLine();
			bufferedWriter.write(make_user[0]);
			bufferedWriter.write(" ");
			System.out.println("PW : ");
			make_user[1] = br.readLine();
			bufferedWriter.write(make_user[1]);
			bufferedWriter.write(" ");
			System.out.println("TEL : ");
			make_user[2] = br.readLine();
			bufferedWriter.write(make_user[2]);
			bufferedWriter.write(" ");
			System.out.println("SEX : ");
			make_user[3] = br.readLine();
			bufferedWriter.write(make_user[3]);
			bufferedWriter.write(" ");
			System.out.println("AGE : ");
			make_user[4] = br.readLine();
			bufferedWriter.write(make_user[4]);
			userService.create_user(make_user[0], make_user[1], make_user[2], make_user[3],
					Integer.parseInt(make_user[4]));

		}

		// 개행문자쓰기
		bufferedWriter.newLine();

		// bufferedWriter.close();
	}

}
