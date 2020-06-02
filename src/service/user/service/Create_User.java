package service.user.service;

import controller.Update;
import service.user.User;
import service.user.UserService;
import service.user.db.UserDB;

public class Create_User extends UserService implements Update {
	User user = new User();

	public Create_User(UserDB userDB, String userID, String userTEL, String userSEX, int userAGE) {
		super(userDB);
		user.setUserID(userID);
		user.setUserTEL(userTEL);
		user.setUserSEX(userSEX);
		user.setUserAGE(userAGE);

	}

	@Override
	public void insert() {
		user_service_DB.update(user);
	}

}
