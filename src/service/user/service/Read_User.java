// 입력받은 userID 를 통해 userDB에 있는 user 반환

package service.user.service;

import controller.Read;
import service.user.User;
import service.user.db.UserDB;

public class Read_User implements Read {
	String userID;
	UserDB userDB;

	// 생성자를 통해 userID 와 userDB 를 입력받음
	public Read_User(String userID, UserDB userDB) {
		this.userID = userID;
		this.userDB = userDB;
	}

	// userDB 의 get 메서드 접근
	@Override
	public User read() {
		return userDB.get(userID);
	}
}
