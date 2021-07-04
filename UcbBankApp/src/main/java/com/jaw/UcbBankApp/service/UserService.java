package com.jaw.UcbBankApp.service;

import java.util.List;
import java.util.Optional;

import com.jaw.UcbBankApp.exception.DuplicateUserIdEntryException;
import com.jaw.UcbBankApp.model.Reqres;
import com.jaw.UcbBankApp.model.UnEntrollDto;
import com.jaw.UcbBankApp.model.User;

public interface UserService {

	 public void createUser(User user)throws DuplicateUserIdEntryException;
	 
	 void updateUser(User user,int id);
	 User getSingleUser(int id);
	 List<User> getUserList();
	 public Optional<User> getUserCount();
	 void saveUnenrollFile(UnEntrollDto unEntrollDto);
	 
	 Reqres getReqResDetail(int id);
	 
}
