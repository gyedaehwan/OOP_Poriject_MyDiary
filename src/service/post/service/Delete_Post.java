package service.post.service;

import controller.Delete;
import service.post.Post;
import service.post.db.PostDB;

public class Delete_Post implements Delete {
	Post post;
	PostDB postDB;

	// 생성자를 통해 postDB에 접근할 게시물의 번호와 postDB를 입력받음
	public Delete_Post(Post post, PostDB postDB) {
		this.post = post;
		this.postDB = postDB;
	}

	@Override
	public void delete() {
		postDB.delete(post);
	}

}
