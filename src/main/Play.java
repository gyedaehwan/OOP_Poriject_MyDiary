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
		System.out.print("Input : ");
	}

	static void print_list(UserService userSerivce, PostService postService_in) throws IOException {
		PostService postService = postService_in;
		Post_File postFile = new Post_File(userSerivce.userID(), postService);
		postFile.print_list();
	}

	static void title_in() {
		// �����Է¹ޱ�
		System.out.println("=====�Խù� ���� �Է�=====");
		System.out.print("����: ");
	}

	static void make_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID());
		System.out.println("=======�Խù� �ۼ�======");
		System.out.println("==���� �ι� �Է½� �ۼ�����==");
		postFile.write(title, userService, postService);
	}
}
