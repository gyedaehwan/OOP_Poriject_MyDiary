package service.user.service;

import controller.Delete;
import service.user.User;
import service.user.UserService;
import service.user.db.UserDB;

public class Delete_User extends UserService implements Delete {
	User user = new User();

	public Delete_User(UserDB userDB, String userID) {
		super(userDB);
		user.setUserID(userID);
	}

	@Override
	public void delete() {
		user_service_DB.delete(user);
	}
}
