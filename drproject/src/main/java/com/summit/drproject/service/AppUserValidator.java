package com.summit.drproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.summit.drproject.entity.RegisterUserForm;
import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;

@Component
public class AppUserValidator implements Validator{
	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz==RegisterUserForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterUserForm registerUserForm = (RegisterUserForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.appUserForm.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.appUserForm.name");
		if(!errors.hasFieldErrors("username")) {
			User user = null;
			try {
				ResponseEntity<User> ruser = userService.getUser(registerUserForm.getUsername());
				user = ruser.getBody();
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user!=null) {
				errors.rejectValue("username","Duplicate.appUserForm.userName");
			}
		}
	}
	
}