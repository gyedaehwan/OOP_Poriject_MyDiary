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
		System.out.println("(6) 종료");
		System.out.print(":: ");
	}

	static void menu_ERROR() {
		System.out.println("1 ~ 6 중에서 고르세요!");
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
		// 제목입력받기
		System.out.println("=====게시글 제목 입력=====");
		System.out.print("제목: ");
	}

	static void make_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		System.out.println("=======게시글 작성======");
		System.out.println("==개행 두번 입력시 작성종료==");
		postFile.write(title);
		System.out.println(postFile.getPostCount());
	}

	static void num_in() {
		// 삭제할 게시글의 번호 받기
		System.out.println("=======게시글 삭제======");
		System.out.print(" 삭제할 게시글 번호 : ");
	}

	static void delete_post(int num, UserService userService, PostService postService) throws IOException {
		System.out.println(userService.userID());
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.delete(num);
		System.out.println(postFile.getPostCount());
	}

	static void search_post_in() {
		System.out.println("=======게시물 검색======");
		System.out.print("게시물 제목 : ");
	}

	static void search_post(String title, UserService userService, PostService postService) throws IOException {
		Post_File postFile = new Post_File(userService.userID(), postService);
		postFile.search(title);
	}
}
