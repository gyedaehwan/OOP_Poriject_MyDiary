package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import service.post.Post;
import service.post.PostService;

public class Post_File extends FileIO {
// userDB를 바탕으로 아이디와 맞는 .txt파일 이 있는지 확인 있으면 출력
	String writer;
	String input = null;
	PostService postService;
	Post post = new Post();
	BufferedReader br;

	public Post_File(String writer, PostService postService) {
		super(writer);
		this.writer = writer;
		this.postService = postService;
	}

	public void print_post() throws IOException {
		// 있을때 그냥 출력
		if (checkFile()) {
			int i = 0;
			br = new BufferedReader(new FileReader("./" + writer + ".txt"));
			System.out.println("== " + writer + "의 게시글 ==");
			while (true) {
				String line = br.readLine();
				if (i == 0 && line == null) {
					System.out.println("==등록된 게시글이 없습니다.==");
					postService.post_service_DB.setNum(0);
					break;
				}

				if (line == null) {
					System.out.println("== " + writer + "의 게시글 불러오기 끝 ==");
					break;
				}

				System.out.println(line);
				i++;
				/**
				 * String[] split = line.split(" "); if (split[1].equals(String.valueOf(i))) {
				 * postService.create_post(split[0], split[1], split[2], split[3],
				 * Integer.parseInt(split[4])); return split[1]; }
				 **/

			}
		} else {
			System.out.println("등록된 게시물이 없습니다.");
		}

	}

	public void write() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

		System.out.println("=====게시물 제목 입력=====");
		System.out.print("제목:");
		input = br.readLine();
		System.out.println("=======게시물 작성======");
		System.out.println("==개행 두번 입력시 작성종료==");

		if (file.isFile() && file.canWrite()) {

			int i = 0;
			String before;
			StringBuilder write_in_post = null;
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

			// 게시글 번호 노출
			// 노출 전에 원래 게시글 번호 +1
			int post_num = postService.post_service_DB.getNum() + 1;
			bufferedWriter.write("======== " + post_num + " ========");
			bufferedWriter.newLine();

			// 첫 줄 제목 추가
			// 최근 수정된 날짜 다음줄에 추가해야함
			bufferedWriter.write("제목 : ");
			bufferedWriter.write(input);
			bufferedWriter.newLine();
			bufferedWriter.newLine();

			while (true) {
				before = bf.readLine();
				// 처음 입력때는 append를 받아줄 stringbuilder 생성
				if (i == 0) {
					write_in_post = new StringBuilder(before);
					bufferedWriter.write(before);
					bufferedWriter.newLine();
				}
				// enter만 입력시 반복문 탈출, 즉 입력 종료
				else if (before.length() == 0)
					break;
				// 위 두사항이 아니면 계속 입력 받음
				else {
					write_in_post.append(before);
					bufferedWriter.write(before);
					// 한줄 넣어주고 한 줄 띄어줌
					bufferedWriter.newLine();
				}
				i++;

			}
			System.out.println("hi");
			postService.post_service_DB.setNum(post_num);
			postService.create_post(post_num, input, writer, write_in_post.toString());

			// 개행문자쓰기
			bufferedWriter.newLine();

			bufferedWriter.close();
		}

	}
}

// 게시글을 썼는데 추가 가 아닌 새로 만들어짐
// 게시글을 읽어오질 못함
