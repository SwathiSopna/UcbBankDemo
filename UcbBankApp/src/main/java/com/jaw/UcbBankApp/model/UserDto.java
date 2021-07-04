package com.jaw.UcbBankApp.model;

public class UserDto {

	private int userId;
	private String userName;
	private String password;
	
	private String newPassword;
	
	public UserDto() {}

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
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", password=" + password + ", newPassword="
				+ newPassword + "]";
	}

	
	  public static UserDto toDto(User users) {
		  UserDto userDto = new UserDto();

	        userDto.setUserId(users.getUserId());
	        userDto.setUserName(users.getUserName());
	        userDto.setPassword(users.getPassword());
	        userDto.setNewPassword(users.getNewPassword());
	      

	        return userDto;
	    }

	
	
}
