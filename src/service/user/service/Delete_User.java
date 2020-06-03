package service.user.service;

import controller.Delete;
import service.user.User;
import service.user.db.UserDB;

public class Delete_User implements Delete {
	User user;
	UserDB userDB;

	// ��ü ������ user�� userDB�� �ҷ���
	Delete_User(User user, UserDB userDB) {
		this.user = user;
		this.userDB = userDB;
	}

	// �����ڷ� �Է¹��� user �� userDB �� ���� userDB�� user ����
	@Override
	public void delete() {
		userDB.delete(user);
	}
}
