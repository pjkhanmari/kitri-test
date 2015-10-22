package org.kitri.app.domains;


public class Employee extends User {
	public static final int AUTH_NONE = 0;
	public static final int AUTH_BOARD = 1;
	public static final int AUTH_COURSE = 2;
	private int auths = AUTH_NONE;

	public Employee() {
		super();
	}
	
	public int getAuths() {
		return auths;
	}
	public void setAuths(int auths) {
		this.auths = auths;
	}
}
