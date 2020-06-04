// postDB와 post.service의 객체들을 연동
// PostService 로 객체를 만들어서 post 제어

package service.post;

import service.post.db.PostDB;

public class PostService extends PostDB {

	public PostService() {

	}

	// Post 정보를 수정할 메서드
	// Post로 다운캐스팅 해서 받아내서 postDB에 추가 <포스트번호 : 포스트제목>
	// 사용할 부분 : 게시글 추가, 게시글 수정
	@Override
	public void update(Object obj) {
		this.post = (Post) obj;
		postDB.put(post.getNum(), post);
	}

	// post 정보 삭제
	// Post로 다운캐스티해서 postDB에서 삭제 (게시글 번호를 통해)
	// 사용할 부분 : 게시글 삭제 ,게시글 수정
	@Override
	public void delete(Object obj) {
		this.post = (Post) obj;
		postDB.remove(post.getNum());
	}

	// post 게시글 번호 리턴
	// 사용할 부분 : 게시글 수정 , 삭제
	@Override
	public int getNum() {
		return post.getNum();
	}

	@Override
	public void setNum(int num) {
		post.setNum(num);
	}

}
