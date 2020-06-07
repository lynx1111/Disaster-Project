package com.summit.drproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.summit.drproject.service.UserService;

@Controller
@SessionAttributes("username")
public class ViewController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "hello";
	}
	 @RequestMapping(value="/loginaaaaa", method = RequestMethod.POST)
	    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){

	        boolean isValidUser = service.validateUser(username, password);

	        if (!isValidUser) {
	            model.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }

	        model.put("name", username);
	        model.put("password", password);

	        return "welcome";
	    }

}
