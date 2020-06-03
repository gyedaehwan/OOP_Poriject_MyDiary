package service.post.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.post.Post;

public abstract class PostDB extends DB {

	// post ��ȣ�� post ��ü�� ����
	protected Map<Integer, Post> postDB;
	protected Post post;

	public PostDB() {
		postDB = new HashMap<Integer, Post>();
	}

	@Override
	public Post get(Object obj) {
		return postDB.get((Integer) obj);
	}

}