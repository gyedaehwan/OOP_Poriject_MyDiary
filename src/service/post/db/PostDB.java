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

	// post 생성 및 수정한 정보 업데이트
	@Override
	public void update(Object obj) {
		this.post = (Post) obj;
		postDB.put(this.post.getPostName(), this.post);
	}

	// post 정보 삭제
	@Override
	public void delete(Object obj) {
		this.post = (Post) obj;
		postDB.remove(this.post.getPostName());
	}

	// post 정보 읽기
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
