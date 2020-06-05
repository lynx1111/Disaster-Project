package com.summit.drproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value ="/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) throws ResourceNotFoundException{
		return userService.getUser(id);
	}
	
	@RequestMapping(value ="/user/",method = RequestMethod.POST)
	public User insert(@RequestBody User user) {
		return userService.create(user);
	}
		
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteUser(@PathVariable("id") Long id) throws ResourceNotFoundException{
       return userService.delete(id);
    }
	
}
