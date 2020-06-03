// 구현 한것 
// user : 로그인 파일 조회를 통한 로그인, 회원가입을 통한 로그인 파일 만들기, 
// post : user id를 확인하여 게시글 파일 조회, 없으면 새로 생성, 있으면 게시글 출력, 게시글 작성
// 해야할것
// user : 회원정보 수정하기
// post : 게시글 수정하기 , 게시글 검색하기 (제목) , 게시글 삭제하기

// 구현 완료후 다듬어야 할부분
// all  : 전체적인 CLI UI 컨트롤 디자인, 코드 간결화 
//        (부모-자식 간의 상속 정리 및 객체화 정리 필요 & 변수 선언 정리 & 주석깔끔이)
// user : 
// post : 로그인 후 게시글 조회시 제목으로만 우선 목록 조회 -> 후에 전체게시글 조회 혹은 검색을 통한 게시글 내용 표출
//   	  게시글 개수 최대 9개 (더 많을시 아이디 추가 생성 요구)
//       실행마다 DB과 초기화되기 때문에 게시물 번호가 맞지않음 -> 수정필요

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
			Login.check();
			Login.choice();
			input = br_keyboard.readLine();

			// 로그인
			if (Integer.parseInt(input) == 1) {
				Login.answer_ID();
				input = br_keyboard.readLine();
				// 동일한 아이디가 없을 시 로그인 실패
				if ((pw = Login.check_ID(input, userService)) == null)
					;

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

		}

		// login 변수의 t, f 값에 따라 실행여부 결정
		while (login) {
			Play.print_list(userService, postService);
			Play.menu();
			input = br_keyboard.readLine();

			// 게시글 쓰기
			if (Integer.parseInt(input) == 1) {
				Play.title_in();
				input = br_keyboard.readLine();
				Play.make_post(input, userService, postService);
			}
			// 게시글 수정
			else if (Integer.parseInt(input) == 2) {

			}
			// 게시글 삭제
			else if (Integer.parseInt(input) == 3) {

			}
			// 게시글 검색
			else if (Integer.parseInt(input) == 4) {

			}
			// 회원정보 수정
			else if (Integer.parseInt(input) == 5) {

			}

		}
	}

}
