package com.summit.drproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.repository.MyUserDetails;
import com.summit.drproject.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	 @Autowired
	    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("User not found "));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
         
        return new MyUserDetails(user);
	}

}