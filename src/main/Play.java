package main;

import java.io.IOException;

import file.Post_File;
import service.post.PostService;
import service.user.UserService;

abstract class Play {
	static void menu() {
		System.out.println("(1) 게시글 쓰기");
		System.out.println("(2) 게시글 수정");
		System.out.println("(3) 게시글 삭제");
		System.out.println("(4) 게시글 검색");
		System.out.println("(5) 회원정보 수정");
		System.out.print("Input : ");
	}

	static void print_list(UserService userSerivce, PostService postService_in) throws IOException {
		PostService postService = postService_in;
		Post_File postFile = new Post_File(userSerivce.userID(), postService);
		postFile.print_list();
	}

	static void title_in() {
		// 제목입력받기
		System.out.println("=====게시물 제목 입력=====");
		System.out.print("제목: ");
	}

	static void make_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID());
		System.out.println("=======게시물 작성======");
		System.out.println("==개행 두번 입력시 작성종료==");
		postFile.write(title, userService, postService);
	}
}
