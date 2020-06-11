package com.summit.drproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.service.UserService;

@Controller
@RequestMapping
public class ViewController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(Model model) {
		return "welcome";
	}
	
	@GetMapping(value="/login")
	public String showLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
//	 @PostMapping(value="/")
//	 public String showWelcomePage(ModelMap model, @Validated @ModelAttribute User user){
//	        boolean isValidUser = service.validateUser(user.getUsername(), user.getPassword());
//	        if (!isValidUser) {
//	            model.put("errorMessage", "Invalid Credentials");
//	            return "login";
//	        }
//	        
//	        try {
//				model.put("name", service.getUser(user.getUsername()).getBody().getName());
//			} catch (ResourceNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        return "home";
//	 }
	 @RequestMapping(value = "/home")
	 public String showHomePage(Model model) {
	 	
	 		return "home";
	  }
	 
	 @RequestMapping(value="/user_home")
	 public ModelAndView showUserPage() {
		 return new ModelAndView ("user_home");
	 }

}
