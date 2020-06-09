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
import org.springframework.web.servlet.ModelAndView;

import com.summit.drproject.service.UserService;

@Controller
public class ViewController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage() {
		System.out.println("login page");
		return "login";
	}
	
	
	 @RequestMapping(value="/", method = RequestMethod.POST)
	 public ModelAndView showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
		 	System.out.println("Hi");
	        boolean isValidUser = service.validateUser(username, password);
	        System.out.println(isValidUser);
	        if (!isValidUser) {
	            model.put("errorMessage", "Invalid Credentials");
	            return new ModelAndView("redirect:/", model);
	        }

	        model.put("username", username);

	        return new ModelAndView("redirect:/home", model);
	 }
	 @RequestMapping(value = "/home", method = RequestMethod.GET)
		public String showHomePage() {
		 System.out.println("going to home page");
			return "home";
		}

}
