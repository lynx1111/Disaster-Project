package com.summit.drproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summit.drproject.entity.User;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.repository.MyUserDetails;
import com.summit.drproject.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Controller
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
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 	model.addAttribute("name", user.getName());
	 	return "home";
	  }
	 
	 @RequestMapping(value="/logout")
	 public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		 System.out.println("Logout method");
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth != null) {
			 new SecurityContextLogoutHandler().logout(request, response, auth);
		 }
		 model.addAttribute("success", "You have logged out successfully!");
		 return "login";
	 }
	 
	 @GetMapping("login-error")
	 public String loginError(Model model) {
		 model.addAttribute("errorMessage", "Invalid Credentials");
		 model.addAttribute("user", new User());
		 return "login";
	 }
}
