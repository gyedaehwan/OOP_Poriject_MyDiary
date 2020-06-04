package main;

import java.io.IOException;

import file.Post_File;
import service.post.PostService;
import service.user.UserService;

abstract class Play {
	static void menu() {
		System.out.println("(1) �Խñ� ����");
		System.out.println("(2) �Խñ� ����");
		System.out.println("(3) �Խñ� ����");
		System.out.println("(4) �Խñ� �˻�");
		System.out.println("(5) ȸ������ ����");
		System.out.println("(6) ����");
		System.out.print(":: ");
	}

	static void menu_ERROR() {
		System.out.println("1 ~ 6 �߿��� ������!");
		System.out.println();
		System.out.println();
	}

	static void print_list(UserService userSerivce, PostService postService_in) throws IOException {
		PostService postService = postService_in;
		Post_File postFile = new Post_File(userSerivce.userID(), postService);
		postFile.print_list();
		System.out.println(postFile.getPostCount());
	}

	static void title_in() {
		// �����Է¹ޱ�
		System.out.println("=====�Խñ� ���� �Է�=====");
		System.out.print("����: ");
	}

	static void make_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		System.out.println("=======�Խñ� �ۼ�======");
		System.out.println("==���� �ι� �Է½� �ۼ�����==");
		postFile.write(title);
		System.out.println(postFile.getPostCount());
	}

	static void num_in() {
		// ������ �Խñ��� ��ȣ �ޱ�
		System.out.println("=======�Խñ� ����======");
		System.out.print(" ������ �Խñ� ��ȣ : ");
	}

	static void delete_post(int num, UserService userService, PostService postService) throws IOException {
		System.out.println(userService.userID());
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.delete(num);
		System.out.println(postFile.getPostCount());
	}

	static void search_post_in() {
		System.out.println("=======�Խù� �˻�======");
		System.out.print("�Խù� ���� : ");
	}

	static void search_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.search(title);
	}
}
