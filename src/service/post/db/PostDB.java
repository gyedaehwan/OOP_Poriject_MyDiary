package service.post.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.post.Post;

public abstract class PostDB implements DB {

	// post ��ȣ�� post ��ü�� ����
	protected Map<Integer, Post> postDB;
	protected Post post = new Post();

	public PostDB() {
		post.setNum(0);
		postDB = new HashMap<Integer, Post>();
	}

	@Override
	public Post get(Object obj) {
		return postDB.get((Integer) obj);
	}

	public abstract int getNum();

	public abstract void setNum(int num);
}