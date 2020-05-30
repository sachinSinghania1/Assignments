package com.modestack.Assignment.entity;

public class Login {
	
	private String userName;
	
	private String password;

	public Login(int id, String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Login() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
