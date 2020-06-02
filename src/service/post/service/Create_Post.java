package service.post.service;

import controller.Update;
import service.post.Post;
import service.post.PostService;
import service.post.db.PostDB;

public class Create_Post extends PostService implements Update {
	Post post = new Post();

	public Create_Post(PostDB postDB, String postName, String postContents, String postWriter) {
		super(postDB);
		post.setPostContents(postContents);
		post.setPostName(postName);
		post.setPostWriter(postWriter);
	}

	@Override
	public void insert() {
		post_service_DB.update(post);
	};

}
