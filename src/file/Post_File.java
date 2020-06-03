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
// userDB�� �������� ���̵�� �´� .txt���� �� �ִ��� Ȯ�� ������ ���
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
		// ������ �׳� ���
		if (checkFile()) {
			int i = 0;
			br = new BufferedReader(new FileReader("./" + writer + ".txt"));
			System.out.println("== " + writer + "�� �Խñ� ==");
			while (true) {
				String line = br.readLine();
				if (i == 0 && line == null) {
					System.out.println("==��ϵ� �Խñ��� �����ϴ�.==");
					postService.post_service_DB.setNum(0);
					break;
				}

				if (line == null) {
					System.out.println("== " + writer + "�� �Խñ� �ҷ����� �� ==");
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
			System.out.println("��ϵ� �Խù��� �����ϴ�.");
		}

	}

	public void write() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

		System.out.println("=====�Խù� ���� �Է�=====");
		System.out.print("����:");
		input = br.readLine();
		System.out.println("=======�Խù� �ۼ�======");
		System.out.println("==���� �ι� �Է½� �ۼ�����==");

		if (file.isFile() && file.canWrite()) {

			int i = 0;
			String before;
			StringBuilder write_in_post = null;
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

			// �Խñ� ��ȣ ����
			// ���� ���� ���� �Խñ� ��ȣ +1
			int post_num = postService.post_service_DB.getNum() + 1;
			bufferedWriter.write("======== " + post_num + " ========");
			bufferedWriter.newLine();

			// ù �� ���� �߰�
			// �ֱ� ������ ��¥ �����ٿ� �߰��ؾ���
			bufferedWriter.write("���� : ");
			bufferedWriter.write(input);
			bufferedWriter.newLine();
			bufferedWriter.newLine();

			while (true) {
				before = bf.readLine();
				// ó�� �Է¶��� append�� �޾��� stringbuilder ����
				if (i == 0) {
					write_in_post = new StringBuilder(before);
					bufferedWriter.write(before);
					bufferedWriter.newLine();
				}
				// enter�� �Է½� �ݺ��� Ż��, �� �Է� ����
				else if (before.length() == 0)
					break;
				// �� �λ����� �ƴϸ� ��� �Է� ����
				else {
					write_in_post.append(before);
					bufferedWriter.write(before);
					// ���� �־��ְ� �� �� �����
					bufferedWriter.newLine();
				}
				i++;

			}
			System.out.println("hi");
			postService.post_service_DB.setNum(post_num);
			postService.create_post(post_num, input, writer, write_in_post.toString());

			// ���๮�ھ���
			bufferedWriter.newLine();

			bufferedWriter.close();
		}

	}
}

// �Խñ��� ��µ� �߰� �� �ƴ� ���� �������
// �Խñ��� �о���� ����
