package service.post;

public class Post {
	// post ����
	private String postName;
	// �ۼ��Ͻ�
	private String date;
	// post ��ȣ
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