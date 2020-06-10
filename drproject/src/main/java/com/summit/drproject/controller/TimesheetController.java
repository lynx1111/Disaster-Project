package com.summit.drproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.summit.drproject.entity.Job;
import com.summit.drproject.entity.Timesheet;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.TimesheetService;

@Controller
public class TimesheetController {
	@Autowired
	TimesheetService timesheetService;
	
	@RequestMapping(value = "/timesheets",method = RequestMethod.GET)
	public String getTimesheets(ModelMap model){
		timesheetService.create(new Timesheet("PA-121","Jason Chen", 80,4000.0));
		List<Timesheet> timesheets = timesheetService.getAllTimesheets();
		model.put("timesheets", timesheets);
		return "timesheets";
	}
	
	@GetMapping(value="/review/{id}")
	public String reviewTimesheets(@PathVariable int id, Model model) {
		Timesheet timesheet = null;
		try {
			ResponseEntity<Timesheet> rTimesheet=timesheetService.getTimesheet(id);
			timesheet=rTimesheet.getBody();
			model.addAttribute("timesheet", timesheet);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reviewTimesheet";
	}
	

}
