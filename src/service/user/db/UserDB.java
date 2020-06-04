// user의 정보 프로그램이 실행하는 동안 저장 할 객체
// 저장할 내용 : ID PW TEL SEX AGE

package service.user.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.user.User;

public abstract class UserDB implements DB {
	protected Map<String, User> userDB;
	protected User user;

	// 생성자 : user의 정보를 담을 HashMap 객체 생성
	public UserDB() {
		userDB = new HashMap<String, User>();
	}

	@Override
	// userID를 받아서 user 리턴
	// User -> Object
	// Read_User객체에서사용
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
