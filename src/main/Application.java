
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.Service;
import service.post.PostService;
import service.user.UserService;

public class Application {

	public static void main(String[] args) throws IOException {

		// Service 객체를 통해 userDB와 postDB 한번에 제어
		// Service() -> UserService(), PostService() -> UserDB(), PostDB()
		// 종속적으로 생성
		Service service = new Service();

		// 키보드에서 입력받을 버퍼를 제어할 객체 생성
		BufferedReader br_keyboard = new BufferedReader(new InputStreamReader(System.in));

		// Service객체로부터 생성된 UserService와 PostService 객체 이용
		UserService userService = service.getUserService();
		PostService postService = service.getPostService();

		// String 객체 목록
		String input; // 프로그램 실행간에 입력을 중계해줄 String 객체
		String pw; // 비밀번호 확인을 위한 String 객체

		// 변수 목록
		boolean login = false; // 로그인 확인 여부를 위한 변수, 초기값 f (t: 로그인 성공, f: 로그인 실패)

		// 프로그램 연속적 실행
		while (true) {
			Login.start();
			Login.choice();
			input = br_keyboard.readLine();

			try {

				// 로그인
				if (Integer.parseInt(input) == 1) {
					Login.answer_ID();
					input = br_keyboard.readLine();
					// 동일한 아이디가 없을 시 로그인 실패
					if ((pw = Login.check_ID(input, userService)) == null)
						Login.print_restart();

					// 동일한 아이디가 있을 시 PW요구
					else {
						Login.answer_PW();
						input = br_keyboard.readLine();
						// pw 동일 시 로그인 성공
						if (pw.equals(input)) {
							login = true;
							break;
						} else
							Login.wrong_PW();

					}

				}

				// 회원가입
				else if (Integer.parseInt(input) == 2) {
					Login.sign_up(userService);
				}
				// 종료
				else if (Integer.parseInt(input) == 3)
					break;
				else
					Login.choice_ERROR();

			} catch (NumberFormatException e) {
				Login.print_restart();
				System.out.println("		       ※ 1~3의 숫자만 입력하세요 ※");
				Login.print_restart();
				continue;
			}

		}

		// login 변수의 t, f 값에 따라 실행여부 결정
		while (login) {
			Play.print_list(userService, postService);
			Play.menu();
			input = br_keyboard.readLine();

			try {
				// 게시글 쓰기
				if (Integer.parseInt(input) == 1) {
					Play.title_in();
					input = br_keyboard.readLine();
					Play.make_post(input, userService, postService);
				}
				// 게시글 조회
				else if (Integer.parseInt(input) == 2) {
					Play.print_all(userService, postService);
				}
				// 게시글 삭제
				else if (Integer.parseInt(input) == 3) {
					Play.num_in();
					input = br_keyboard.readLine();
					Play.delete_post(Integer.parseInt(input), userService, postService);
				}
				// 게시글 검색
				else if (Integer.parseInt(input) == 4) {
					Play.search_post_in();
					input = br_keyboard.readLine();
					Play.search_post(input, userService, postService);

				} else if (Integer.parseInt(input) == 5) {
					System.out.println("		 ※ 로그아웃 및 종료합니다 ※");
					System.out.println("              MADE BY GYE DAEHWAN_2020 ");

					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("		       ※ 1~5의 숫자만 입력하세요 ※");
				System.out.println();
				System.out.println();
				continue;
			}
		}
	}

}
