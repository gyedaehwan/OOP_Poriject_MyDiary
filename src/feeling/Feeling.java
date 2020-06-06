// ���߿� �� �� �����ϸ� feeling ���� ���� �����Ͽ� �޾Ƴ��� �ϸ��

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
	// ������ ������ ��� ���۸� ������ ��ü
	BufferedReader bf;
	// Ű����� ���� ���۸� ������ ��ü
	BufferedReader br;
	// ���Ͽ� Ű���带 ����Ͽ� �Է��� ��ü
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

		// user�� �Խñ� ���Ͽ��� �о�帲
		bf = new BufferedReader(new FileReader(file));

		// user�� �Խñ� ���Ͽ� ���� ����
		bw = new BufferedWriter(new FileWriter(file, true));

		while (true) {
			input = bf.readLine();

			if (input == null) {
				break;
			}

			else if (input.charAt(0) == '=')
				post_count++;
			// ������ �Խñ� ���� Ȯ��
			if (post_count == postDB.getNum()) {
				// ������ �Խñ��̸鼭 ���� ��ȣ�� % �϶�
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
		// �Խñ��� % ��ȣ �ڿ��ִ� ���ڿ��� �ҷ�����
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
				// �÷��ǿ� ��Ƶ�
				get_feeling_num.add(input.replace("% ", ""));
			}
		}
		for (int i = 0; i < get_feeling_num.size(); i++)
			sum_feeling += Integer.parseInt(get_feeling_num.get(i));
		if (post_count == 0) {
			System.out.println("		��ġ�� ����� �Խñ��� �����ϴ�.");
			return 0;
		}
		analyzed_feeling = sum_feeling / post_count;

		return analyzed_feeling;

	}

	public void analyzed(double average) {
		if (average <= 30) {
			System.out.println("			���ڽó׿�..");
			if (average <= 10)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
			else if (average <= 20)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
			else if (average <= 30)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
		} else if (30 < average && average <= 60) {
			System.out.println("			�����Դϴ�");
			if (average <= 40)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
			else if (average <= 50)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
			else if (average <= 60)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
		} else if (60 < average && average < 90) {
			System.out.println("			���׿�~");
			if (average <= 70)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
			else if (average <= 80)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
			else if (average <= 90)
				System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
		} else {
			System.out.println("			�����մϴ�!");
			System.out.println("	   BAD   �� �� �� �� ��  �� �� �� �� ��  GOOD");
		}
	}
}
