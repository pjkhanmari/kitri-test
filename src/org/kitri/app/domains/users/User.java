package org.kitri.app.domains.users;

public class User {
	public static int TYPE_DEFAULT = 0;
	public static int TYPE_ADMIN = 1;
	public static int TYPE_EMPLOYEE = 2;
	public static int TYPE_TEACHER = 3;
	public static int TYPE_STUDENT = 4;
	private String id;
	private String pw;
	public int type;
	public User() {

	}

	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
		type = TYPE_DEFAULT;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
}
