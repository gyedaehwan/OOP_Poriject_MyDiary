package service.user.service;

import controller.Delete;
import service.user.User;
import service.user.db.UserDB;

public class Delete_User implements Delete {
	User user;
	UserDB userDB;

	// 객체 생성시 user와 userDB를 불러옴
	Delete_User(User user, UserDB userDB) {
		this.user = user;
		this.userDB = userDB;
	}

	// 생성자로 입력받은 user 와 userDB 를 통해 userDB의 user 삭제
	@Override
	public void delete() {
		userDB.delete(user);
	}
}
