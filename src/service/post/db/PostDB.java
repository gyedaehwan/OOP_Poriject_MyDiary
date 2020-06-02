package service.post.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.post.Post;

public class PostDB extends DB {
	private Map<String, Post> postDB;
	Post post;

	public PostDB() {
		postDB = new HashMap<String, Post>();
	}

	// post ���� �� ������ ���� ������Ʈ
	@Override
	public void update(Object obj) {
		this.post = (Post) obj;
		postDB.put(this.post.getPostName(), this.post);
	}

	// post ���� ����
	@Override
	public void delete(Object obj) {
		this.post = (Post) obj;
		postDB.remove(this.post.getPostName());
	}

	// post ���� �б�
	@Override
	public Post read(Object obj) {
		this.post = (Post) obj;
		return postDB.get(this.post.getPostName());

	}

	// test
	public Map<String, Post> getPostDB() {
		return postDB;
	}

}
