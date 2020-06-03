package service.post.service;

import controller.Read;
import service.post.Post;
import service.post.db.PostDB;

public class Read_Post implements Read {
	int num;
	PostDB postDB;

	public Read_Post(int num, PostDB postDB) {
		this.num = num;
		this.postDB = postDB;
	}

	@Override
	public Post read() {
		return postDB.get((Integer) num);
	}
}
