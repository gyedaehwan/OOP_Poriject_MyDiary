// post_file 객체 생성시 해당 회원의 게시글 번호와 제목을 postservice의 db에 넣어줘야함
// 파일 예시
/**======== 1 ========    	: 게시글 번호
 * :제목: 					: 게시글 제목
 * @2020.06.02				: 게시글 작성날짜
 * #Today was good.		: 게시글 내용 (개행 연속 두번시 입력 종료)
 * 
 * ======== 2 ========
 * :제목: 
 * @2020.06.03
 * #Yesterday was good.
 */

package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import service.post.Post;
import service.post.PostService;
import service.user.UserService;

public class Post_File extends FileIO {
	PostService postService;
	Post post = new Post();

	// 파일의 내용이 담긴 버퍼를 제어할 객체
	BufferedReader bf;
	// 키보드로 부터 버퍼를 제어할 객체
	BufferedReader br;

	private String writer; // 파일 이름
	private String inFile; // 파일 내의 데이터를 받아오는 String객체

	private int post_count = 0; // 게시글 개수

	public Post_File(String writer) {
		super(writer);
		this.writer = writer;
	}

	public Post_File(String writer, PostService postService) {
		super(writer);
		this.writer = writer;
		this.postService = postService;

	}

	// 해당 user의 id명의 파일이 있는지 확인
	// 있으면 게시글 번호와 제목을 postService 의 postDB 에 넣어줌 (게시글 있음)
	// 없으면 파일 생성 (게시글 없음)
	private void list_to_postDB() throws IOException {
		// 파일이 있으면
		if (checkFile()) {
			// 게시글번호 구별 문장의 첫 글자가 '=' 이면 게시글 번호 출력 문장
			bf = new BufferedReader(new FileReader(file));

			while (true) {
				inFile = bf.readLine();

				// 빈 문장이면 탈출
				if (inFile == null) {
					// 더 이상 읽을 게시글이 없으면 마지막으로 읽어드린 게시글 postDB에 추가
					postService.update(post);
					break;
				}

				if (inFile.charAt(0) == '=') {

					// 마지막 게시글 전까지 postDB에 추가
					if (post_count != 0)
						postService.update(post);
					post_count++;

					// postDB에 넣을 post객체의 값 설정
					post.setNum(post_count);
				}

				// 첫 char 가 ':'
				// 제목을 나타내는 줄일때
				else if (inFile.charAt(0) == ':') {
					// 지워줌 , 제목내용만 남김
					inFile = inFile.replace(":제목: ", "");
					post.setPostName(inFile);
				}

				// 날짜도 넣어줘야함 나중에 **
				// post.setDate();
				/**
				 * inFile.charAt(0) == '@' inFile.replace("@",""); post.setDate(inFile);
				 */

			}

		}
		// 없으면
		// 게시글이 없음을 알리면서 유저이름의 새파일 생성
		else
			;
	}

	public void print_list() throws IOException {
		list_to_postDB();
		System.out.println("== " + writer + "의 게시글 ==");
		if (postService.getNum() == 0)
			System.out.println("==== 등록된 게시글이 없습니다. ====");
		else {
			for (int i = 1; i <= postService.getNum(); i++) {
				post = postService.get(i);
				System.out.println("# " + post.getNum() + "번 제목 : " + post.getPostName());
			}
		}

	}

	public void write(String title, UserService userService, PostService postService) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		if (checkFile()) {

			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			if (file.isFile() && file.canWrite()) {
				// 키보드에서 입력받은 버퍼값을 저장해두는 string
				String input;

				// 현재 게시글이 0인지 확인 , 즉 게시글 유무 판단
				if (postService.getNum() != 0) {
					// 있으면 노출 전에 원래 게시글 번호 +1
					post_count = postService.getNum() + 1;
				}

				// 없으면 게시글 번호 1로 성정
				else
					post_count = 1;
				bw.write("======== " + post_count + " ========");
				bw.newLine();

				// 첫 줄 제목 추가
				// 최근 수정된 날짜 다음줄에 추가해야함

				bw.write(":제목: ");
				bw.write(title);
				bw.newLine();
				bw.write("@");
				// 날짜 추가
				// bw.write(date);
				bw.newLine();

				while (true) {
					input = br.readLine();

					// enter만 입력시 반복문 탈출, 즉 입력 종료
					if (input.length() == 0)
						break;

					// 위 사항이 아니면 계속 입력 받음
					else {
						bw.write("# ");
						bw.write(input);
						// 한줄 넣어주고 한 줄 띄어줌
						bw.newLine();
					}

				}

				post.setNum(post_count);
				post.setPostName(title);
				// 날짜도 넣어야함
				// post.setDate(date);
				postService.update(post);
				bw.close();
			}
		}
	}
}
