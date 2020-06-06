package main;

import java.io.IOException;

import file.Login_File;
import service.user.UserService;

abstract class Login {

	static int version = 1;

	static void start() {
		System.out.println("  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒                       ▒▒▒ ▒▒▒                     ▒▒");
		System.out.println("▒▒ 나만의 일기장                                     ▒     소프트웨어학부 나반               ▒▒");
		System.out.println("▒▒ My Diary                 ▒     20170260           ▒▒");
		System.out.println("▒▒                          ▒     계대환                                  ▒▒");
		System.out.println("▒▒ 로그인이 필요합니다 .           ▒                        ▒▒");
		System.out.println("▒▒                          ▒                        ▒▒");
		System.out.println("▒▒ (1) 로그인                                      ▒                        ▒▒");
		System.out.println("▒▒ (2) 회원가입                                   ▒                        ▒▒");
		System.out.println("▒▒ (3) 회원찾기                                   ▒                        ▒▒");
		System.out.println("▒▒ (4) 종료                                         ▒                        ▒▒");
		System.out.println("▒▒                          ▒                        ▒▒");
		System.out.println("▒▒                          ▒                        ▒▒");
		System.out.println("▒▒                          ▒                        ▒▒");
		System.out.println("▒▒                       ▒▒▒ ▒▒▒                     ▒▒");
		System.out.println("  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ");
		System.out.println("");
	}

	static void choice() {
		System.out.print(":: ");
	}

	static void choice_ERROR() {

		System.out.println("		       ※ 1 ,2, 3 중에서 고르세요 ※");
		System.out.println("			재시작..");
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
		System.out.println("		      ※ 잘못된 비밀번호 입니다 ※ ");
		print_restart();
	}

	static void sign_up(UserService userService) throws IOException {
		Login_File login = new Login_File(userService);
		if (login.sign_up())
			System.out.println("회원 가입 성공!");
		else
			print_restart();
	}

	static void find_user() {
		System.out.println("		회원 찾기 입니다.");
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
		System.out.println(".......................⊙ RESTART ⊙....................... ");
		System.out.println();
	};

}
