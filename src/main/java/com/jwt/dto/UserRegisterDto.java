package com.jwt.dto;

import java.util.Arrays;
import java.util.Set;

import com.jwt.model.Role;

public class UserRegisterDto {
	private String userName;
	private String password;
	private String email;
	private Set<Role> roles;
	public UserRegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserRegisterDto(String userName, String password, String email, Set<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.roles = roles;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserRegisterDto [userName=" + userName + ", password=" + password + ", email=" + email + ", roles="
				 + "]";
	}
	
	
	

}
