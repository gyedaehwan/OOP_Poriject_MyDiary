// userDB와 user.service 의 객체들을 연동시킴
// UserService로 객체를 만들어서 user 제어

package service.user;

import service.user.db.UserDB;

public class UserService extends UserDB {

	// UserService 생성자 생성 동시에 UserDB생성자 호출됨에 따라
	// user의 정보를 저장할 userDB도 생성
	public UserService() {

	}

	// user 생성 및 수정한 정보 업데이트
	// 사용할 부분 : 회원가입, 회원정보 수정
	// user 객체가 들어와서 새로운정보를 받음
	// UserService -> UserDB -> DB
	@Override
	public void update(Object obj) {
		user = (User) obj;
		userDB.put(user.getUserID(), user);
	}

	// Delete_User 객체에서 오버라이딩 호출
	// user 정보 삭제
	@Override
	public void delete(Object obj) {
		this.user = (User) obj;
		userDB.remove(user.getUserID());
	}
}
