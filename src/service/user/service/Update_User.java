// user ���� �� ���� ������ �Ҷ� ���Ǵ� Ŭ����
// ȸ������, ȸ������ ����

package service.user.service;

import controller.Update;
import service.user.User;

public class Update_User implements Update {
	public User user = new User();

	// ������ :
	public Update_User(String userID, String userPW, String userTEL, String userSEX, int userAGE) {
		user.setUserID(userID);
		user.setUserPW(userPW);
		user.setUserTEL(userTEL);
		user.setUserSEX(userSEX);
		user.setUserAGE(userAGE);

	}

	// �����ڷ� �Է��� �ϼ��� user ��ü�� ������
	@Override
	public User insert() {
		return user;
	}
}
