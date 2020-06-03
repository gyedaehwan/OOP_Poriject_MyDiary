package service;

import service.post.PostService;
import service.post.db.PostDB;
import service.user.UserService;
import service.user.db.UserDB;

public class Service {
	private UserDB userDB;
	private PostDB postDB;
	private UserService userService;
	private PostService postService;

	public Service() {
		userDB = new UserDB();
		postDB = new PostDB();
		userService = new UserService(userDB);
		postService = new PostService(postDB);
	}

	public UserService getUserService() {
		return userService;
	}

	public PostService getPostService() {
		return postService;
	}

}
