package service.post;

import java.util.Date;

public class Post {
	// post ����
	private String postName;
	// �ۼ��Ͻ�
	private Date date;
	// post ��ȣ
	private int num;

	// GETTER & SETTER

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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