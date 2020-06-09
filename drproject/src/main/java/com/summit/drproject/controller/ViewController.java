package com.summit.drproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.summit.drproject.service.UserService;

@Controller
//@SessionAttributes("username")
public class ViewController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage() {
		return "home";
	}
	
	
	 @RequestMapping(value="/", method = RequestMethod.POST)
	    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
		 	System.out.println("Hi");
	        boolean isValidUser = service.validateUser(username, password);
	        System.out.println(isValidUser);

	        if (!isValidUser) {
	            model.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }

	        model.put("username", username);
	        model.put("password", password);

	        return "home";
	    }

}
