package service.post.service;

import controller.Delete;
import service.post.Post;
import service.post.db.PostDB;

public class Delete_Post implements Delete {
	Post post;
	PostDB postDB;

	// �����ڸ� ���� postDB�� ������ �Խù��� ��ȣ�� postDB�� �Է¹���
	public Delete_Post(Post post, PostDB postDB) {
		this.post = post;
		this.postDB = postDB;
	}

	@Override
	public void delete() {
		postDB.delete(post);
	}

}
