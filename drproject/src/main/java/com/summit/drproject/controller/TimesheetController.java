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
import org.springframework.web.bind.annotation.RestController;


import com.summit.drproject.entity.Timesheet;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.TimesheetService;

@Controller
public class TimesheetController {
	@Autowired
	TimesheetService timesheetService;
	
	@RequestMapping(value = "/timesheets",method = RequestMethod.GET)
	public String getTimesheets(ModelMap model){
		List<Timesheet> timesheets= timesheetService.getAllTimesheets();
		model.put("timesheets", timesheets);
		return "timesheets";
	}
	
	@RequestMapping(value ="/timesheet/{id}",method = RequestMethod.GET)
	public ResponseEntity<Timesheet> getTimesheet(@PathVariable("id") String id) throws ResourceNotFoundException{
		return timesheetService.getTimesheet(id);
	}
	
	@RequestMapping(value ="/timesheet/",method = RequestMethod.POST)
	public Timesheet insert(@RequestBody Timesheet timesheet) {
		return timesheetService.create(timesheet);
	}
		
	
	@RequestMapping(value = "/timesheet/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteTimesheet(@PathVariable("id") String id) throws ResourceNotFoundException{
       return timesheetService.delete(id);
    }
}
