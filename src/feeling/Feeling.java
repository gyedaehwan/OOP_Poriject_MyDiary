// 나중에 줄 수 부족하면 feeling 파일 따로 생성하여 받아내기 하면됨

package feeling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import file.FileIO;
import service.post.PostService;
import service.post.db.PostDB;

public class Feeling extends FileIO implements FeelingDB {

	String userID;
	PostDB postDB;
	String input;
	// 파일의 내용이 담긴 버퍼를 제어할 객체
	BufferedReader bf;
	// 키보드로 부터 버퍼를 제어할 객체
	BufferedReader br;
	// 파일에 키보드를 사용하여 입력할 객체
	BufferedWriter bw;

	ArrayList<String> get_feeling_num;

	int post_count = 0;

	public Feeling(String userID) {
		super(userID);
		this.userID = userID;
	}

	public Feeling(String userID, PostService postService) {
		super(userID);
		this.userID = userID;
		this.postDB = postService;
	}

	@Override
	public void add(int feeling) throws IOException {

		// user의 게시글 파일에서 읽어드림
		bf = new BufferedReader(new FileReader(file));

		// user의 게시글 파일에 덮어 쓰기
		bw = new BufferedWriter(new FileWriter(file, true));

		while (true) {
			input = bf.readLine();

			if (input == null) {
				break;
			}

			else if (input.charAt(0) == '=')
				post_count++;
			// 마지막 게시글 인지 확인
			if (post_count == postDB.getNum()) {
				// 마지막 게시글이면서 구분 기호가 % 일때
				if (input.charAt(0) == '%') {
					bw.write(String.valueOf(feeling));
					bw.newLine();
				}
			}
		}
		bw.close();
	}

	@Override
	public double average() throws IOException {
		// 게시글의 % 기호 뒤에있는 문자열을 불러들임
		get_feeling_num = new ArrayList<>();
		double analyzed_feeling;
		int sum_feeling = 0;
		bf = new BufferedReader(new FileReader(file));

		while (true) {
			input = bf.readLine();

			if (input == null)
				break;

			else if (input.charAt(0) == '=')
				post_count++;

			else if (input.charAt(0) == '%') {
				// 컬렉션에 담아둠
				get_feeling_num.add(input.replace("% ", ""));
			}
		}
		for (int i = 0; i < get_feeling_num.size(); i++)
			sum_feeling += Integer.parseInt(get_feeling_num.get(i));
		if (post_count == 0) {
			System.out.println("		수치를 통계할 게시글이 없습니다.");
			return 0;
		}
		analyzed_feeling = sum_feeling / post_count;

		return analyzed_feeling;

	}

	public void analyzed(double average) {
		if (average <= 30) {
			System.out.println("			나쁘시네요..");
			if (average <= 10)
				System.out.println("	   BAD   ● ○ ○ ○ ○  ○ ○ ○ ○ ○  GOOD");
			else if (average <= 20)
				System.out.println("	   BAD   ● ● ○ ○ ○  ○ ○ ○ ○ ○  GOOD");
			else if (average <= 30)
				System.out.println("	   BAD   ● ● ● ○ ○  ○ ○ ○ ○ ○  GOOD");
		} else if (30 < average && average <= 60) {
			System.out.println("			보통입니다");
			if (average <= 40)
				System.out.println("	   BAD   ● ● ● ● ○  ○ ○ ○ ○ ○  GOOD");
			else if (average <= 50)
				System.out.println("	   BAD   ● ● ● ● ●  ○ ○ ○ ○ ○  GOOD");
			else if (average <= 60)
				System.out.println("	   BAD   ● ● ● ● ●  ● ○ ○ ○ ○  GOOD");
		} else if (60 < average && average < 90) {
			System.out.println("			좋네요~");
			if (average <= 70)
				System.out.println("	   BAD   ● ● ● ● ●  ● ● ○ ○ ○  GOOD");
			else if (average <= 80)
				System.out.println("	   BAD   ● ● ● ● ●  ● ● ● ○ ○  GOOD");
			else if (average <= 90)
				System.out.println("	   BAD   ● ● ● ● ●  ● ● ● ● ○  GOOD");
		} else {
			System.out.println("			굉장합니다!");
			System.out.println("	   BAD   ● ● ● ● ●  ● ● ● ● ●  GOOD");
		}
	}
}
