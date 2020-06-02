package service.user;

public class User {
	private String userID;
	private String userPW;

	private String userTEL;
	private String userSEX;
	private int userAGE;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserTEL() {
		return userTEL;
	}

	public void setUserTEL(String userTEL) {
		this.userTEL = userTEL;
	}

	public String getUserSEX() {
		return userSEX;
	}

	public void setUserSEX(String userSEX) {
		this.userSEX = userSEX;
	}

	public int getUserAGE() {
		return userAGE;
	}

	public void setUserAGE(int userAGE) {
		this.userAGE = userAGE;
	}

}
