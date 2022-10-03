package com.jwt.dto;

public class UserLoginDto {

	private String userName;
	private String password;
	public UserLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLoginDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	@Override
	public String toString() {
		return "UserLoginDto [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
