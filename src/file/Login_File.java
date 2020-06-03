// login.txt 에서 맞는 id가 있는지 확인 후 로그인 여부 결정
// login.txt에는 회원정보가
// ID PW TEL SEX AGE   한 줄씩 저장 ( ' '로 데이터 구분 )
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
	// 파일의 내용이 담긴 버퍼를 제어할 객체
	BufferedReader bf;
	// 키보드로 부터 버퍼를 제어할 객체
	BufferedReader br;

	public Login_File() {

	}

	public Login_File(String userID, UserService userService) {
		super(userID);
		this.userID = userID;
		this.userService = userService;
	}

	public Login_File(UserService userService) {

		// login.txt 를 file 객체에 담음
		super();

		// userDB를 가진 객체
		this.userService = userService;
	}

	// 입력한 id 와 login.txt 파일에있는 id들을 비교하여 같은 id가 있는지 비교
	// 있으면 해당 id의 pw 리턴
	public String check_ID() throws IOException {

		// 파일이 존재하면
		if (checkFile()) {
			bf = new BufferedReader(new FileReader("./login.txt"));
			while (true) {
				String line = bf.readLine();

				// 한 줄을 읽되 비어있으면 탈출
				if (line == null) {
					System.out.println("등록된 ID가 없습니다.");
					break;
				}

				// ' ' 로 데이터 구분
				// [0] : ID , [1] : PW , [2] : TEL , [3] : SEX , [4] : AGE
				String[] split = line.split(" ");

				// 해당 줄이 비어있지 않으면 첫번째 데이터 (id) 가 입력된 userID와 같은 지 비교
				// 같으면 해당 비밀번호 리턴
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

		// 존재 하지 않을 시 , 로그인 실패
		// 만약 존재하지 않을시 (최초 실행시) 에는 login.txt 파일 자동생성, 회원가입으로 정보입력 필요
		else {
			System.out.println("등록된 ID가 없습니다.");
		}
		return null;
	}

	public void sign_up() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// userDB에 넣어줄 user객체 생성
		user = new User();
		// login.txt 에 입력 된 정보를 입력해주는 객체
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

		// 파일의 존재여부와 접근가능여부 확인
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

			// UserService 객체의 update 메서드 호출
			// 입력받은 user를 userDB에 추가
			userService.update(user);

		}

		// 개행문자쓰기
		bw.newLine();

		bw.close();
	}

}
