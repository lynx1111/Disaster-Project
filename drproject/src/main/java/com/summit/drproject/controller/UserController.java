package com.summit.drproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value ="/user/{username}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("username") String username) throws ResourceNotFoundException{
		return userService.getUser(username);
	}
	
	@RequestMapping(value ="/user/",method = RequestMethod.POST)
	public User insert(@RequestBody User user) {
		return userService.create(user);
	}
		
	
	@RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteUser(@PathVariable("username") String username) throws ResourceNotFoundException{
       return userService.delete(username);
    }
	
}
