package com.summit.drproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class ErrorController {
	
	@RequestMapping( value = "/error",method = RequestMethod.GET)
	public String errorPage(ModelMap model) {
		model.put("errorMessage", "There was an error with your process");
		return "error";
	}
}
