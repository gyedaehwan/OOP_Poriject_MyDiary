package service.post.service;

import controller.Update;
import service.post.Post;

public class Update_Post implements Update {
	Post post = new Post();

	// 생성자를 통해 post 객체 완성
	public Update_Post(int num, String postName) {
		post.setNum(num);
		post.setPostName(postName);
	}

	@Override
	public Post insert() {
		return post;
	};

}
