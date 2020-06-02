package service.user.service;

import controller.Read;
import service.user.User;
import service.user.UserService;
import service.user.db.UserDB;

public class Read_User extends UserService implements Read {
	User user = new User();

	public Read_User(UserDB userDB, String userID) {
		super(userDB);
		user.setUserID(userID);
	}

	@Override
	public User read() {
		return user_service_DB.read(user);
	}
}
