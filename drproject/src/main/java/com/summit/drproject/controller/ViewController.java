package com.summit.drproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ViewController {

	/*@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}*/

	@RequestMapping("/userDashboard")
	public ModelAndView userDashboard() {
		return new ModelAndView("userdashboard");
	}

	@RequestMapping("/adminDashboard")
	public ModelAndView adminDashboard() {
		return new ModelAndView("admindashboard");
	}
	
}
