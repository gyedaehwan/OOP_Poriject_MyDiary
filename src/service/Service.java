package service;

import service.post.PostService;
import service.user.UserService;

public class Service {
	private UserService userService;
	private PostService postService;

	public Service() {
		userService = new UserService();
		postService = new PostService();
	}

	public UserService getUserService() {
		return userService;
	}

	public PostService getPostService() {
		return postService;
	}

}
