package service.post.service;

import controller.Delete;
import service.post.Post;
import service.post.PostService;
import service.post.db.PostDB;

public class Delete_Post extends PostService implements Delete {
	Post post = new Post();

	public Delete_Post(PostDB postDB, int num) {
		super(postDB);
		post.setNum(num);
	}

	@Override
	public void delete() {
		post_service_DB.delete(post);
	}

}
