// user 생성 및 정보 업데이 할때 사용되는 클래스
// 회원가입, 회원정보 수정

package service.user.service;

import controller.Update;
import service.user.User;

public class Update_User implements Update {
	public User user = new User();

	// 생성자 :
	public Update_User(String userID, String userPW, String userTEL, String userSEX, int userAGE) {
		user.setUserID(userID);
		user.setUserPW(userPW);
		user.setUserTEL(userTEL);
		user.setUserSEX(userSEX);
		user.setUserAGE(userAGE);

	}

	// 생성자로 입력후 완성된 user 객체를 내보냄
	@Override
	public User insert() {
		return user;
	}
}
