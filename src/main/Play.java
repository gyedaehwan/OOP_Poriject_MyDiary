package main;

import java.io.IOException;

import feeling.Feeling;
import file.Post_File;
import service.post.PostService;
import service.user.UserService;

abstract class Play {
	static void menu() {
		System.out.println("  �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�      �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�Ƣ�                       �ƢƢ� �ƢƢ�                     �Ƣ�");
		System.out.println("�Ƣ�                          ��     ������ �ϱ���                        �Ƣ�");
		System.out.println("�Ƣ�                          ��     ȯ�� �մϴ�!!          �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��     (1) �Խñ� ����                  �Ƣ�");
		System.out.println("�Ƣ�                          ��     (2) �Խñ� ��ȸ                  �Ƣ�");
		System.out.println("�Ƣ�                          ��     (3) �Խñ� ����                  �Ƣ�");
		System.out.println("�Ƣ�                          ��     (4) �Խñ� �˻�                  �Ƣ�");
		System.out.println("�Ƣ�                          ��     (5) ��� ��ġ ���              �Ƣ�");
		System.out.println("�Ƣ�                          ��     (6) ����                            �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                          ��                        �Ƣ�");
		System.out.println("�Ƣ�                       �ƢƢ� �ƢƢ�                     �Ƣ�");
		System.out.println("  �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�     �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�  ");
		System.out.println("");
		System.out.print(":: ");
	}

	static void menu_ERROR() {
		System.out.println("		       �� 1 ~ 6 �߿��� ������ ��");
		System.out.println();
		System.out.println();

		print_restart();
	}

	static void print_list(UserService userSerivce, PostService postService_in) throws IOException {
		PostService postService = postService_in;
		Post_File postFile = new Post_File(userSerivce.userID(), postService);
		postFile.print_list();

	}

	static void title_in() {
		// �����Է¹ޱ�
		System.out.println("		������� ���� �Է� �������");
		System.out.print("	����: ");
	}

	static void make_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		System.out.println("		������� �Խñ� �ۼ� �������");
		System.out.println("		      (���� �ι� �Է½� �ۼ����� )");
		postFile.write(title);
	}

	static void input_feeling() {
		// ��� �Է¹ޱ�
		System.out.println("		����� ��̳��� ?");
		System.out.println("		BAD ~ GOOD");
		System.out.println("		 0     100");
		System.out.print("		��ġ �Է� : ");
	}

	static void add_feeling(int feeling, UserService userService, PostService postService) throws IOException {
		Feeling feelingFile = new Feeling(userService.userID(), postService);
		feelingFile.add(feeling);
	}

	static void analyzed_feeling(UserService userService, PostService postService) throws IOException {
		Feeling feelingFile = new Feeling(userService.userID());
		if (feelingFile.average() != 0) {
			System.out.println("		    " + postService.getNum() + "���� �Խñ� ��� ��� ��ġ  ");
			System.out.println("		       ** " + feelingFile.average() + "% **");
			feelingFile.analyzed(feelingFile.average());
		}
	}

	static void num_in() {
		// ������ �Խñ��� ��ȣ �ޱ�
		System.out.println("		������� �Խñ� ���� �������");
		System.out.print("������ �Խñ� ��ȣ : ");
	}

	static void delete_post(int num, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.delete(num);
	}

	static void search_post_in() {
		System.out.println("		������� �Խñ� �˻� �������");
		System.out.print("�Խñ� ���� : ");
	}

	static void search_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.search(title);
	}

	static void print_restart() {
		System.out.println(".......................���� �� �� �� �� �� ��....................... ");
		System.out.println();
	};

	static void print_all(UserService userService, PostService postService) throws IOException {
		System.out.println("		������� ��� �Խù� �������");
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.showAll();

	}
}
