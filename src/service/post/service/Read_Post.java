package service.post.service;

import controller.Read;
import service.post.Post;
import service.post.PostService;
import service.post.db.PostDB;

public class Read_Post extends PostService implements Read {
	Post post = new Post();

	public Read_Post(PostDB postDB, int num) {
		super(postDB);
		post.setNum(num);
	}

	@Override
	public Post read() {
		return post_service_DB.read(post);
	}
}
