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
	// 파일의 내용이 담긴 버퍼를 제어할 객체
	BufferedReader bf;
	// 키보드로 부터 버퍼를 제어할 객체
	BufferedReader br;

	// ID 확인 용
	ArrayList<String> Array_ID = new ArrayList<>();
	// PW 확인 용
	ArrayList<String> Array_PW = new ArrayList<>();
	// TEL 확인용
	ArrayList<String> Array_TEL = new ArrayList<>();
	// SEX 확인용
	ArrayList<String> Array_SEX = new ArrayList<>();
	// AGE 확인용
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

		// login.txt 를 file 객체에 담음
		super();

		// userDB를 가진 객체
		this.userDB = userService;
	}

	// 입력한 id 와 login.txt 파일에있는 id들을 비교하여 같은 id가 있는지 비교
	// 있으면 해당 id의 pw 리턴
	public String check_ID(boolean find) throws IOException {

		// 파일이 존재하면
		if (checkFile()) {
			bf = new BufferedReader(new FileReader("./login.txt"));
			while (true) {
				String line = bf.readLine();

				// 한 줄을 읽되 비어있으면 탈출
				if (line == null) {
					if (find)
						break;
					else {
						break;
					}
				}

				// ' ' 로 데이터 구분
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

		// 존재 하지 않을 시 , 로그인 실패
		// 만약 존재하지 않을시 (최초 실행시) 에는 login.txt 파일 자동생성, 회원가입으로 정보입력 필요
		else {
			System.out.println("		       ※ 등록된 ID가 없습니다 ※");
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
							System.out.println("		일치하는 정보 없음");
							System.out.println("		회원가입을 하세요.");

						}
					}
				} else {
					if (i == Array_ID.size() - 1) {
						System.out.println("		일치하는 SEX 없음");
						System.out.println("		회원가입을 하세요.");

					}
				}
			} else {
				if (i == Array_ID.size() - 1) {
					System.out.println("		일치하는 TEL 없음");
					System.out.println("		회원가입을 하세요.");

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
								System.out.println("		일치하는 정보 없음");
								System.out.println("		회원가입을 하세요.");

							}
						}
					} else {
						if (i == Array_ID.size() - 1) {
							System.out.println("		일치하는 SEX 없음");
							System.out.println("		회원가입을 하세요.");

						}
					}
				} else {
					if (i == Array_ID.size() - 1) {
						System.out.println("		일치하는 TEL 없음");
						System.out.println("		회원가입을 하세요.");

					}
				}
			} else {
				if (i == Array_ID.size() - 1) {
					System.out.println("		일치하는 ID 없음");
					System.out.println("		회원가입을 하세요.");

				}
			}
		}
	}

	public boolean sign_up() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		// userDB에 넣어줄 user객체 생성
		user = new User();
		// login.txt 에 입력 된 정보를 입력해주는 객체
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bf = new BufferedReader(new FileReader(file));
		// 파일의 존재여부와 접근가능여부 확인
		if (file.isFile() && file.canWrite()) {
			System.out.print("ID : ");
			make_user = br.readLine();
			// ID중복 생성 방지
			String check;
			while (true) {
				check = bf.readLine();
				if (check == null)
					break;
				else if (check.split(" ")[0].equals(make_user)) {
					System.out.println("		       ※ 중복된 ID 입니다 ※");
					return false;
				}

			}
			bw.write(make_user);
			bw.write(" ");
			user.setUserID(make_user);

			// 최소 4글자 이상
			while (true) {
				System.out.println("PW : ");
				make_user = br.readLine();
				if (make_user.length() < 4) {
					System.out.println("		4자 이상 입력하세요.");
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
					System.out.println("		- 없이 입력하세요 ");
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
					System.out.println("		male 혹은 female 중에 만 입력");
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

					// UserService 객체의 update 메서드 호출
					// 입력받은 user를 userDB에 추가
					userDB.update(user);
					break;
				} else {
					System.out.println("		숫자만 입력하세요.");
				}

			}

			// 개행문자쓰기
			bw.newLine();

			bw.close();
			return true;
		} else
			return false;

	}
}
