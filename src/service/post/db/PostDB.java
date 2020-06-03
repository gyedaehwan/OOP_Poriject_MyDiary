package service.post.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.post.Post;

public class PostDB extends DB {
	private Map<Integer, Post> postDB;
	Post post;

	public PostDB() {
		postDB = new HashMap<Integer, Post>();
		post = new Post();
	}

	// post 생성 및 수정한 정보 업데이트
	@Override
	public void update(Object obj) {
		this.post = (Post) obj;
		postDB.put(this.post.getNum(), this.post);
	}

	// post 정보 삭제
	@Override
	public void delete(Object obj) {
		this.post = (Post) obj;
		postDB.remove(this.post.getNum());
	}

	// post 정보 읽기
	@Override
	public Post read(Object obj) {
		this.post = (Post) obj;
		return postDB.get(this.post.getNum());

	}

	// test
	/**
	 * public Map<String, Post> getPostDB() { return postDB; }
	 **/

	public int getNum() {
		return post.getNum();
	}

	public void setNum(int num) {
		post.setNum(num);
	}

}
