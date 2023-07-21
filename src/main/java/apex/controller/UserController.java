package apex.controller;

//import java.awt.PageAttributes.MediaType;
import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apex.pojo.User;
import apex.services.UserServices;
@RestController
@RequestMapping("dbop")
public class UserController {

	@Autowired
	 private UserServices service;
	
	@GetMapping(path="/users")
	public List<User> getUsers()
	{
	return service.getUsers();
	}
	
	
	@GetMapping(path="/users/{userId}")
	public User getUser(@PathVariable String userId)
	{
	User userObj=service.getUser(userId);
	System.out.println(userObj);
	return userObj;
	}
	
	
	@PostMapping(path="/users",
	consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUsers(@RequestBody User userObject)
	{
	return service.addUsers(userObject);


	} 
	
	
	@DeleteMapping(path="/users/{id}")
	public Boolean deleteUser(@PathVariable String id)
	{
	Integer myid = Integer.parseInt(id);
	return service.deleteUser(myid);
	}
	

	@PutMapping(path="/users/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
		    produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUsers(@RequestBody User userObject , @PathVariable Integer id)
	{
	return service.updateUsers(userObject,id);
	
	} 
}
