package main;

import java.io.IOException;

import file.Login_File;
import service.user.UserService;

abstract class Login {

	static int version = 1;

	static void start() {
		System.out.println("나만의 일기장 시작");
		System.out.println("환영합니다!!");
		System.out.println("******************");
	}

	static void check() {
		System.out.println("** 로그인이 필요합니다. **");
		System.out.println();
	}

	static void choice() {
		System.out.println("(1) 로그인");
		System.out.println("(2) 회원가입");
		System.out.println("(3) 종료");
		System.out.println(":: ");
	}

	static void choice_ERROR() {
		System.out.println("1 ,2, 3 중에서 고르세요!");
	}

	static void answer_ID() {
		System.out.print("ID : ");
	}

	static void answer_PW() {
		System.out.print("PW : ");
	}

	static String check_ID(String userID, UserService userService) throws IOException {
		Login_File login = new Login_File(userID, userService);
		return login.check_ID();
	}

	static void wrong_PW() {
		System.out.println("잘못된 비밀번호 입니다. ");
	}

	static void sign_up(UserService userService) throws IOException {
		Login_File login = new Login_File(userService);
		login.sign_up();
		System.out.println("회원 가입 성공!");
	}
}
