// post_file ��ü ������ �ش� ȸ���� �Խñ� ��ȣ�� ������ postservice�� db�� �־������
// ���� ����
/**======== 1 ========    	: �Խñ� ��ȣ
 * :����: 					: �Խñ� ����
 * @2020.06.02				: �Խñ� �ۼ���¥
 * #Today was good.		: �Խñ� ���� (���� ���� �ι��� �Է� ����)
 * 
 * ======== 2 ========
 * :����: 
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

	// ������ ������ ��� ���۸� ������ ��ü
	BufferedReader bf;
	// Ű����� ���� ���۸� ������ ��ü
	BufferedReader br;

	private String writer; // ���� �̸�
	private String inFile; // ���� ���� �����͸� �޾ƿ��� String��ü

	private int post_count = 0; // �Խñ� ����

	public Post_File(String writer) {
		super(writer);
		this.writer = writer;
	}

	public Post_File(String writer, PostService postService) {
		super(writer);
		this.writer = writer;
		this.postService = postService;

	}

	// �ش� user�� id���� ������ �ִ��� Ȯ��
	// ������ �Խñ� ��ȣ�� ������ postService �� postDB �� �־��� (�Խñ� ����)
	// ������ ���� ���� (�Խñ� ����)
	private void list_to_postDB() throws IOException {
		// ������ ������
		if (checkFile()) {
			// �Խñ۹�ȣ ���� ������ ù ���ڰ� '=' �̸� �Խñ� ��ȣ ��� ����
			bf = new BufferedReader(new FileReader(file));

			while (true) {
				inFile = bf.readLine();

				// �� �����̸� Ż��
				if (inFile == null) {
					// �� �̻� ���� �Խñ��� ������ ���������� �о�帰 �Խñ� postDB�� �߰�
					postService.update(post);
					break;
				}

				if (inFile.charAt(0) == '=') {

					// ������ �Խñ� ������ postDB�� �߰�
					if (post_count != 0)
						postService.update(post);
					post_count++;

					// postDB�� ���� post��ü�� �� ����
					post.setNum(post_count);
				}

				// ù char �� ':'
				// ������ ��Ÿ���� ���϶�
				else if (inFile.charAt(0) == ':') {
					// ������ , ���񳻿븸 ����
					inFile = inFile.replace(":����: ", "");
					post.setPostName(inFile);
				}

				// ��¥�� �־������ ���߿� **
				// post.setDate();
				/**
				 * inFile.charAt(0) == '@' inFile.replace("@",""); post.setDate(inFile);
				 */

			}

		}
		// ������
		// �Խñ��� ������ �˸��鼭 �����̸��� ������ ����
		else
			;
	}

	public void print_list() throws IOException {
		list_to_postDB();
		System.out.println("== " + writer + "�� �Խñ� ==");
		if (postService.getNum() == 0)
			System.out.println("==== ��ϵ� �Խñ��� �����ϴ�. ====");
		else {
			for (int i = 1; i <= postService.getNum(); i++) {
				post = postService.get(i);
				System.out.println("# " + post.getNum() + "�� ���� : " + post.getPostName());
			}
		}

	}

	public void write(String title, UserService userService, PostService postService) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		if (checkFile()) {

			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			if (file.isFile() && file.canWrite()) {
				// Ű���忡�� �Է¹��� ���۰��� �����صδ� string
				String input;

				// ���� �Խñ��� 0���� Ȯ�� , �� �Խñ� ���� �Ǵ�
				if (postService.getNum() != 0) {
					// ������ ���� ���� ���� �Խñ� ��ȣ +1
					post_count = postService.getNum() + 1;
				}

				// ������ �Խñ� ��ȣ 1�� ����
				else
					post_count = 1;
				bw.write("======== " + post_count + " ========");
				bw.newLine();

				// ù �� ���� �߰�
				// �ֱ� ������ ��¥ �����ٿ� �߰��ؾ���

				bw.write(":����: ");
				bw.write(title);
				bw.newLine();
				bw.write("@");
				// ��¥ �߰�
				// bw.write(date);
				bw.newLine();

				while (true) {
					input = br.readLine();

					// enter�� �Է½� �ݺ��� Ż��, �� �Է� ����
					if (input.length() == 0)
						break;

					// �� ������ �ƴϸ� ��� �Է� ����
					else {
						bw.write("# ");
						bw.write(input);
						// ���� �־��ְ� �� �� �����
						bw.newLine();
					}

				}

				post.setNum(post_count);
				post.setPostName(title);
				// ��¥�� �־����
				// post.setDate(date);
				postService.update(post);
				bw.close();
			}
		}
	}
}
