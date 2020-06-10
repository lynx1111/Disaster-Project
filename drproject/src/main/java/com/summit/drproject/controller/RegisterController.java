package com.summit.drproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.summit.drproject.entity.User;
import com.summit.drproject.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@GetMapping(value="/register")
	public String getRegistrationForm(Model model) {
		Map<String,String> roles=new HashMap<String,String>();
		roles.put("ADMIN", "Admin");
		roles.put("OTHER", "Other");
		model.addAttribute("user", new User());
		model.addAttribute("roles", roles);
		return "registerUser";
	}
	
	@PostMapping(value="/create_user")
	public String createUser(Model model, @Validated @ModelAttribute User user) {
		model.addAttribute("success", "Account has successfully been created. Please login");
		userService.create(user);
		return "login";
	}
}
