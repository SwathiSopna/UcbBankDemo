package com.jaw.UcbBankApp.dao;

import java.util.List;

import com.jaw.UcbBankApp.model.User;

public interface UserDao {

	void insertUser(User user);
	
	int checkExistingRecord(int id);
	
	User getSingleUserDetail(int id);
	void updatePassword(User user);
	List<User> getUserList();
}
