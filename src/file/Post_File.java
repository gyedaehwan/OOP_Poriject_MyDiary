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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import service.post.Post;
import service.post.PostService;
import service.post.db.PostDB;

public class Post_File extends FileIO {
	PostDB postDB;
	Post post;
	File file_copy;

	// ������ ������ ��� ���۸� ������ ��ü
	BufferedReader bf;
	// Ű����� ���� ���۸� ������ ��ü
	BufferedReader br;

	BufferedWriter bw;
	private String writer; // ���� �̸�
	private String inFile; // ���� ���� �����͸� �޾ƿ��� String ��������

	private int post_count = 0; // �Խñ� ����

	// test
	public int getPostCount() {
		return post_count;
	}

	public Post_File(String writer, PostService postService) {
		super(writer);
		this.writer = writer;
		this.postDB = postService;

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
				if (inFile == null)
					break;

				if (inFile.charAt(0) == '=') {
					post = new Post();
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
					postDB.update(post);
				}

				// ��¥�� �־������ ���߿� **
				// post.setDate();
				/**
				 * inFile.charAt(0) == '@' inFile.replace("@",""); post.setDate(inFile);
				 */

			}

			System.out.println();
		}
		// ������
		// �Խñ��� ������ �˸��鼭 �����̸��� ������ ����
		else
			;
	}

	public void print_list() throws IOException {
		list_to_postDB();
		System.out.println("== " + writer + "�� �Խñ� ==");
		if (postDB.getNum() == 0)
			System.out.println("==== ��ϵ� �Խñ��� �����ϴ�. ====");
		else {
			for (int i = 1; i <= postDB.getNum(); i++) {
				post = postDB.get(i);
				System.out.println("# " + post.getNum() + "�� ���� : " + post.getPostName());
			}
		}

	}

	public void write(String title) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		if (checkFile()) {

			bw = new BufferedWriter(new FileWriter(file, true));
			if (file.isFile() && file.canWrite()) {
				// Ű���忡�� �Է¹��� ���۰��� �����صδ� string
				String input;

				// ���� �Խñ��� 0���� Ȯ�� , �� �Խñ� ���� �Ǵ�
				if (postDB.getNum() != 0) {
					// ������ ���� ���� ���� �Խñ� ��ȣ +1
					post_count = postDB.getNum() + 1;
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

				post = new Post();
				post.setNum(post_count);
				post.setPostName(title);
				// ��¥�� �־����
				// post.setDate(date);
				postDB.update(post);
				bw.close();
			}
		}
	}

	public void delete(int num) throws IOException {
		// ���� ������ ������ �Խñ� ���� �����鼭 ���ο� ���Ͽ� ���ÿ� �ۼ�����
		// ���ο� ������ ���������̸��� �����
		// ���� ������ ���� ��ȣ�� ���缭 postDB�� �־���

		// ���纻 ���� ���� ���纻�������� �״�� ���, ������ ����

		file_copy = new File("./copy.txt");

		if (file_copy.exists())
			;

		else {
			FileOutputStream output = new FileOutputStream("./copy.txt");
			output.close();
		}

		// ���� ���Ͽ��� �о���� ��ü����
		bf = new BufferedReader(new FileReader(file));

		// ���纻 ���Ͽ� ����� ��ü����
		bw = new BufferedWriter(new FileWriter(file_copy));

		while (true) {
			inFile = bf.readLine();
			// �Է¹��� ������ ������ null �̸� ����
			if (inFile == null)
				break;

			// ��ȣ ���� ���϶�
			else if (inFile.charAt(0) == '=') {
				post_count++;
				// �Է��� ��ȣ�� ���� ��ȣ �׳� ����
				if (post_count == num) {
					inFile = bf.readLine();
					while (true) {
						// ���� ��ȣ ���� �ٱ��� �׳� �б⸸ ��
						if (inFile == null)
							break;
						else if (inFile.charAt(0) == '=') {
							post_count++;
							break;
						}
						inFile = bf.readLine();
					}
				}
				if (post_count > num) {
					inFile = bf.readLine();
					bw.write("======== " + (post_count - 1) + " ========");
					bw.newLine();

					// postDB���� ���� �Խñ۵��� ��ȣ�� 1�� �ٿ���
					post = new Post();
					post.setNum(post_count - 1);
					post.setPostName(inFile.replace(":����: ", ""));

					postDB.update(post);
				}
			}

			// ������ �Խù� ������ ���� �Խù��� �����Ƿ� Ż��
			if (inFile == null)
				break;
			bw.write(inFile);
			bw.newLine();
		}
		bw.close();

		bf = new BufferedReader(new FileReader(file_copy));
		bw = new BufferedWriter(new FileWriter(file));

		while (true) {
			inFile = bf.readLine();
			if (inFile == null)
				break;
			bw.write(inFile);
			bw.newLine();

		}
		bw.close();

	}

	public void search(String title) throws IOException {
		post = new Post();
		bf = new BufferedReader(new FileReader(file));

		// postDB���� �Էµ� ����� ���� ������ �Խñ� ��ȣ ã��
		for (int i = 1; i <= postDB.getNum(); i++) {
			post.setNum(i);

			// ���� ������ �Խñ�
			if (postDB.get(post.getNum()).getPostName().equals(title)) {
				while (true) {
					inFile = bf.readLine();

					if (inFile == null)
						break;
					else if (inFile.charAt(0) == '=')
						post_count++;

					if (post_count == post.getNum())
						System.out.println(inFile);

				}
			}
		}
	}

}
