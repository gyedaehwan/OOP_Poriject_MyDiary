// postDB�� post.service�� ��ü���� ����
// PostService �� ��ü�� ���� post ����

package service.post;

import service.post.db.PostDB;

public class PostService extends PostDB {

	public PostService() {

	}

	// Post ������ ������ �޼���
	// Post�� �ٿ�ĳ���� �ؼ� �޾Ƴ��� postDB�� �߰� <����Ʈ��ȣ : ����Ʈ����>
	// ����� �κ� : �Խñ� �߰�, �Խñ� ����
	@Override
	public void update(Object obj) {
		this.post = (Post) obj;
		postDB.put(post.getNum(), post);
	}

	// post ���� ����
	// Post�� �ٿ�ĳ��Ƽ�ؼ� postDB���� ���� (�Խñ� ��ȣ�� ����)
	// ����� �κ� : �Խñ� ���� ,�Խñ� ����
	@Override
	public void delete(Object obj) {
		this.post = (Post) obj;
		postDB.remove(post.getNum());
	}

	// post �Խñ� ��ȣ ����
	// ����� �κ� : �Խñ� ���� , ����
	@Override
	public int getNum() {
		return post.getNum();
	}

	@Override
	public void setNum(int num) {
		post.setNum(num);
	}

}
