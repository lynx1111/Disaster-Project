package com.summit.drproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	 public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	 
	 public User create(User user) {
			return userRepository.save(user);
		}
		
		public ResponseEntity<User> getUser(Long id)throws ResourceNotFoundException {
			User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found for this site code :: " + id));
			return ResponseEntity.ok().body(user);
		}
		
		public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
			User currentUser = userRepository.findById(id)
		        		.orElseThrow(() -> new ResourceNotFoundException("Tour not found for this site code :: " + id));
			 userRepository.delete(currentUser);
		        Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
		}
	
}
