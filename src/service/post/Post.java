package service.post;

public class Post {
	// post 제목
	private String postName;
	// 작성일시
	private String date;
	// post 번호
	private int num;

	// GETTER & SETTER

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

}