package com.jaw.UcbBankApp.model;

import org.springframework.hateoas.RepresentationModel;

public class User extends RepresentationModel {

	private int userId;
	private String userName;
	private String password;
	
	private String newPassword;
	

	public User() {
		
	}
	public User(int userId,String userName,String password,String newPassword) {
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		this.newPassword=newPassword;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		// this.password = BCrypt.hashpw(password, BCrypt.gensalt());

	}
	

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", newPassword="
				+ newPassword + "]";
	}
	public static User toEntity(UserDto user) {
		
		 return new User( user.getUserId(), user.getUserName(), user.getPassword(), user.getNewPassword());
	}
	

	
}
