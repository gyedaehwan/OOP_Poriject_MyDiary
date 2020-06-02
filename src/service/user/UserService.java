package service.user;

import controller.Delete;
import controller.Read;
import controller.Update;
import service.user.db.UserDB;
import service.user.service.Create_User;
import service.user.service.Delete_User;
import service.user.service.Read_User;

public class UserService {
	protected UserDB user_service_DB = new UserDB();
	Update update;
	Delete delete;
	Read read;

	public UserService() {

	}

	public UserService(UserDB userDB) {
		user_service_DB = userDB;
	}

	public void create_user(String userID, String userPW, String userTEL, String userSEX, int userAGE) {
		update = new Create_User(user_service_DB, userID, userPW, userTEL, userSEX, userAGE);
		update.insert();
	}

	public void delete_user(String userID) {
		delete = new Delete_User(user_service_DB, userID);
		delete.delete();
	}

	public User read_user(String userID) {
		read = new Read_User(user_service_DB, userID);
		return (User) read.read();
	}

	/**
	 * test public void print() {
	 * System.out.println(user_service_DB.getUserDB().get("abc").getUserAGE()); }
	 **/
}
