// �Է¹��� userID �� ���� userDB�� �ִ� user ��ȯ

package service.user.service;

import controller.Read;
import service.user.User;
import service.user.db.UserDB;

public class Read_User implements Read {
	String userID;
	UserDB userDB;

	// �����ڸ� ���� userID �� userDB �� �Է¹���
	public Read_User(String userID, UserDB userDB) {
		this.userID = userID;
		this.userDB = userDB;
	}

	// userDB �� get �޼��� ����
	@Override
	public User read() {
		return userDB.get(userID);
	}
}
