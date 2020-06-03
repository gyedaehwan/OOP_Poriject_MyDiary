// userDB�� user.service �� ��ü���� ������Ŵ
// UserService�� ��ü�� ���� user ����

package service.user;

import service.user.db.UserDB;

public class UserService extends UserDB {

	// UserService ������ ���� ���ÿ� UserDB������ ȣ��ʿ� ����
	// user�� ������ ������ userDB�� ����
	public UserService() {

	}

	// user ���� �� ������ ���� ������Ʈ
	// ����� �κ� : ȸ������, ȸ������ ����
	// user ��ü�� ���ͼ� ���ο������� ����
	// UserService -> UserDB -> DB
	@Override
	public void update(Object obj) {
		user = (User) obj;
		userDB.put(user.getUserID(), user);
	}

	// Delete_User ��ü���� �������̵� ȣ��
	// user ���� ����
	@Override
	public void delete(Object obj) {
		this.user = (User) obj;
		userDB.remove(user.getUserID());
	}
}
