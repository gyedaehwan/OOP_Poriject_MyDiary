// user�� ���� ���α׷��� �����ϴ� ���� ���� �� ��ü
// ������ ���� : ID PW TEL SEX AGE

package service.user.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.user.User;

public abstract class UserDB implements DB {
	protected Map<String, User> userDB;
	protected User user;

	// ������ : user�� ������ ���� HashMap ��ü ����
	public UserDB() {
		userDB = new HashMap<String, User>();
	}

	@Override
	// userID�� �޾Ƽ� user ����
	// User -> Object
	// Read_User��ü�������
	public User get(Object obj) {
		return userDB.get((String) obj);

	}

	// test
	public Map<String, User> getUserDB() {
		return userDB;
	}

	public String userID() {
		return user.getUserID();
	}
}
