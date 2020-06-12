package com.summit.drproject.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.summit.drproject.entity.User;
import com.summit.drproject.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		User user = new User();
		Map<String,String> roles=new HashMap<String,String>();
		roles.put("ADMIN", "Admin");
		roles.put("USER", "Other");
		model.addAttribute("user", user);
		//List<String> roles = Arrays.asList("ADMIN", "USER");
		model.addAttribute("roles", roles);
		return "registerUser";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid  @ModelAttribute("user") User user, Model model, BindingResult bindingResult) {
		
		System.out.println("here1");
		
		if (bindingResult.hasErrors()) {
			System.out.println("here2");
			Map<String,String> roles=new HashMap<String,String>();
			roles.put("ADMIN", "Admin");
			roles.put("USER", "Other");
			model.addAttribute("roles", roles);
			return "registerUser";
		}
		
		model.addAttribute("success", "Account has successfully been created. Please login");
		userService.create(user);
		return "login";
	}
}
