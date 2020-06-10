package com.summit.drproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		List<Timesheet> timesheets = timesheetService.getAllTimesheets();
		model.put("timesheets", timesheets);
		return "timesheets";
	}
	
	@GetMapping(value="/review/{id}")
	public String reviewTimesheets(@PathVariable int id, Model model) {
		Timesheet timesheet = null;
		List<String> status = new ArrayList<>();
		status.add("Yes");
		status.add("No");
		try {
			ResponseEntity<Timesheet> rTimesheet=timesheetService.getTimesheet(id);
			timesheet=rTimesheet.getBody();
			timesheet.setStatusOptions(status);
			model.addAttribute("timesheet", timesheet);
		} catch (ResourceNotFoundException e){
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		return "reviewTimesheet";
	}
	
	@PostMapping(value="/submit_approval/{id}")
	public String submitApproval(@PathVariable int id, @Validated @ModelAttribute Timesheet timesheet,BindingResult result, Model model) {
		Timesheet timesh = null;
		if (result.hasErrors()) {
            return "reviewTimesheet";
        }
		try {
			ResponseEntity<Timesheet> rtime = timesheetService.getTimesheet(id);
			timesh=rtime.getBody();
			if(timesheet.getS().equals("Yes")) {
				timesh.setStatus(true);
			}
			System.out.println(timesh.isStatus());
			timesheetService.create(timesh);
			model.addAttribute("timesheets", timesheetService.getAllTimesheets());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "timesheets";
	}

}
