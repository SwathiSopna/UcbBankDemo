package com.jaw.UcbBankApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.jaw.UcbBankApp.exception.DuplicateUserIdEntryException;
import com.jaw.UcbBankApp.model.Reqres;
import com.jaw.UcbBankApp.model.UnEntrollDto;
import com.jaw.UcbBankApp.model.User;
import com.jaw.UcbBankApp.model.UserDto;
import com.jaw.UcbBankApp.service.UserService;



@RestController
@CrossOrigin
@RequestMapping("/bank/users")
@ExposesResourceFor(User.class)

public class UserController {
	
@Autowired
private EntityLinks entityLinks;


	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity  addEntity(@RequestBody UserDto user) throws DuplicateUserIdEntryException {
		User users = User.toEntity(user);
		 userService.createUser(users);
		 return new ResponseEntity<>( HttpStatus.CREATED);
	}

	@RequestMapping(value = "saveEnroll", method = RequestMethod.POST)
	public ResponseEntity  saveFileEntity(@RequestBody UnEntrollDto unEnroll) throws DuplicateUserIdEntryException {
		UnEntrollDto users = UnEntrollDto.toEntity(unEnroll);
		 userService.saveUnenrollFile(users);
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public void updateEntity(@PathVariable(value="id") int id, @RequestBody User user) {
		userService.updateUser(user, id);
	}
	/*@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public ResponseEntity<EntityModel<User>> getSingleUserDetail(@PathVariable(value="id") int id) {
		User user=	userService.getSingleUser(id);
	    EntityModel<User> resources=new EntityModel<User>(user);
		resources.add(this.entityLinks.linkToCollectionResource(User.class));
		return new ResponseEntity<EntityModel<User>>(resources,HttpStatus.OK);
		}*/
	
     @RequestMapping( method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity getReqResDetails(@PathVariable(value="id") int id){
    	Reqres response = userService.getReqResDetail(id);
	   
		return new ResponseEntity<Reqres>(response,HttpStatus.OK);
    	
    }
	
	/*@RequestMapping( value = "", method = RequestMethod.GET )
	public ResponseEntity<CollectionModel<User>> getUserList() {
		List<User> user=	userService.getUserList();
		CollectionModel<User> resources=new CollectionModel<User>(user);
		resources.add(this.entityLinks.linkToCollectionResource(User.class));
		return new ResponseEntity<CollectionModel<User>>(resources,HttpStatus.OK);
		}*/
	@RequestMapping( value = "", method = RequestMethod.GET )
	public List<User> getUserList() {
		List<User> longs=	userService.getUserList();
		
		return longs;
		}
	@RequestMapping( value = "count", method = RequestMethod.GET )
	public Optional<User> getUserCount() {
		Optional<User> longs=	userService.getUserCount();
		return longs;
		}
}
