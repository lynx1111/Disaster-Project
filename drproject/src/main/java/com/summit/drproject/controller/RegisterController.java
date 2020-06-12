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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.summit.drproject.entity.RegisterUserForm;
import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		RegisterUserForm ruf = new RegisterUserForm();
		Map<String,String> roles=new HashMap<String,String>();
		roles.put("ADMIN", "Admin");
		roles.put("USER", "Other");
		model.addAttribute("ruf", ruf);
		//List<String> roles = Arrays.asList("ADMIN", "USER");
		model.addAttribute("roles", roles);
		return "registerUser";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid  @ModelAttribute("ruf") RegisterUserForm ruf, BindingResult bindingResult,Model model) {
		User user= null;
		try {
			user = userService.getUser(ruf.getUsername()).getBody();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			//model.addAttribute("username", "This username exist already. Please choose another one.");
			Map<String,String> roles=new HashMap<String,String>();
			roles.put("ADMIN", "Admin");
			roles.put("USER", "Other");
			model.addAttribute("roles", roles);
			return "registerUser";
		}
		if (bindingResult.hasErrors()) {
			Map<String,String> roles=new HashMap<String,String>();
			roles.put("ADMIN", "Admin");
			roles.put("USER", "Other");
			model.addAttribute("roles", roles);
			return "registerUser";
		}
		model.addAttribute("success", "Account has successfully been created. Please login");
		model.addAttribute("user", ruf);
		userService.create(new User(ruf.getUsername(), ruf.getName(), ruf.getRole(), ruf.getPassword(), null));
		return "login";
	}
}