package com.jaw.UcbBankApp.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaw.UcbBankApp.dao.UserDao;
import com.jaw.UcbBankApp.exception.DuplicateUserIdEntryException;
import com.jaw.UcbBankApp.model.Reqres;
import com.jaw.UcbBankApp.model.UnEntrollDto;
import com.jaw.UcbBankApp.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	RestTemplate tempate;
	
	private static FileWriter file ;

	@Override
	public void createUser(User user) throws DuplicateUserIdEntryException {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (userDao.checkExistingRecord(user.getUserId()) >= 1) {
			throw new DuplicateUserIdEntryException("UserId Already Present Try Someother Id.");
		}
			userDao.insertUser(user);
		
	}

	@Override
	public void updateUser(User user,int id) {
		//User users = userDao.getSingleUserDetail(id);
		/*if(user.getUserId()==id) {*/
		 user.setNewPassword(passwordEncoder.encode(user.getNewPassword()));
			userDao.updatePassword(user);
		/*}*/
	}
	
	@Override
	public Reqres getReqResDetail(int id) {
		// TODO Auto-generated method stub
		
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      //headers.setAccept(MediaType.APPLICATION_JSON);
	      headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return tempate.exchange("https://reqres.in/api/users/1", HttpMethod.GET, entity, Reqres.class).getBody();

	}

	@Override
	public User getSingleUser(int id) {
		User usr= userDao.getSingleUserDetail(id);
		passwordEncoder.matches("Jesus@123", usr.getPassword());
		System.out.println("Userrrrrrrrrrrrrrrrrrr"+usr);
		return usr;
	}

	@Override // 
	public List<User> getUserList() {
		List<User> list = userDao.getUserList();
		//list.stream().filter(pasword ->passwordEncoder.matches(rawPassword, encodedPassword));
		 list.sort(Comparator.comparing(User::getUserName));
		 list.forEach(System.out::println);
		return list;
	}
	@Override  // MaxBy and MinBy
	public Optional<User> getUserCount() {
		List<User> list = userDao.getUserList();
	Optional<User> user=list.stream().collect(Collectors.minBy(Comparator.comparing(User::getUserId)));
	if(user.isPresent()) {
		 user.get();
	}
	return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveUnenrollFile(UnEntrollDto unEntrollDto) {
		// TODO Auto-generated method stub
		//UnEntrollDto unEnroll = new UnEntrollDto(1,"MLA","2019-10-23");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", unEntrollDto.getId());
		jsonObj.put("eventName", unEntrollDto.getEventName());
		jsonObj.put("date", unEntrollDto.getDate());

	    try {  
	    	String path = "C:\\UnEnrollFile\\";
	    	String fileName = path+unEntrollDto.getId();
	    	File dynFile = new File(fileName);
	    	boolean fileCreated = dynFile.createNewFile();


	        // Writing to a file
	    	file = new FileWriter(dynFile);
	    	file.write(jsonObj.toJSONString());
	    	System.out.println("Successfully Completed");

	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }
	    finally {
	    	try {
				file.flush();
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
		
		
	}

	/*@Override  
	public Optional<User> getUserMapping() {
		List<User> list = 	 userDao.getUserList();
	Optional<User> user=list.stream().collect(Collectors.mapping((User usr)->,Comparator.comparing(User::getUserId)));
	if(user.isPresent()) {
		 user.get();
	}
	return user;
	}*/

}
