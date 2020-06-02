package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import file.Login_File;
import service.Service;
import service.user.UserService;

public class Application {

	public static void main(String[] args) throws IOException {
		Service service = new Service();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		UserService userService = service.getUserService();
		Login_File file_login = new Login_File(userService);

		while (true) {

			System.out.println("나만의 일기장  ------------------------v 1.0");
			System.out.println("(1) 로그인");
			System.out.println("(2) 회원가입");
			System.out.print("input : ");
			String input = bf.readLine();

			String pw;
			boolean login = false;

			// 로그인
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
						System.out.println("비밀번호 오류.");
					}
				}
			}
			// 회원가입
			else if (input.equals("2")) {
				file_login.write();

			} else {
				System.out.println("1 과 2 중에 입력하세요.");
			}

			while (login) {
				// 회원정보 보여주고 지금 까지 쓴 게시글 제목, 쓴 날짜(날짜순) 보여줌
				System.out.println("(1) 게시글 쓰기");
				System.out.println("(2) 게시글 수정");
				System.out.println("(3) 게시글 삭제");
				System.out.println("(4) 게시글 검색");
				System.out.println("(5) 회원정보 수정");

				System.out.println("============회원정보 로 했다 침 =================");

				System.out.println("(1) 수정");
				System.out.println("(1) 삭제");
			}
		}
		// test
		// userService.print();
	}

}
