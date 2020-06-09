package com.summit.drproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String getJobs(ModelMap model){
		System.out.println("In job controller");
		List<Timesheet> timesheets = timesheetService.getAllTimesheets();
		model.put("timesheets", timesheets);
		return "timesheets";
	}
	
	@RequestMapping(value ="/timesheet/",method = RequestMethod.POST)
	public Timesheet insert(@RequestBody Timesheet timesheet) {
		return timesheetService.create(timesheet);
	}

}
