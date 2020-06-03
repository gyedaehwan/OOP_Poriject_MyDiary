package service.user.db;

import java.util.HashMap;
import java.util.Map;

import service.DB;
import service.user.User;

public class UserDB extends DB {
	private Map<String, User> userDB;
	User user;

	public UserDB() {
		userDB = new HashMap<String, User>();
	}

	// user 생성 및 수정한 정보 업데이트
	@Override
	public void update(Object obj) {
		this.user = (User) obj;
		userDB.put(user.getUserID(), user);
	}

	// user 정보 삭제
	@Override
	public void delete(Object obj) {
		this.user = (User) obj;
		userDB.remove(user.getUserID());
	}

	// user 정보 읽기
	@Override
	// User -> Object
	public User read(Object obj) {
		this.user = (User) obj;
		return userDB.get(user.getUserID());

	}

	// test
	public Map<String, User> getUserDB() {
		return userDB;
	}

	public String userID() {
		return user.getUserID();
	}
}
