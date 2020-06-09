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


import com.summit.drproject.entity.Job;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.service.JobService;



@Controller
public class JobController {

	@Autowired
	JobService jobService;
	

	
	@RequestMapping(value = "/jobs",method = RequestMethod.GET)
	public String getJobs(ModelMap model){
		List<Job> jobs = jobService.getAllJobs();
		model.put("jobs", jobs);
		return "jobs";
	}
	
	@RequestMapping(value ="/job/{id}",method = RequestMethod.GET)
	public ResponseEntity<Job> getJob(@PathVariable("id") String id) throws ResourceNotFoundException{
		return jobService.getJob(id);
	}
	
	@RequestMapping(value ="/job/",method = RequestMethod.POST)
	public Job insert(@RequestBody Job job) {
		return jobService.create(job);
	}
		
	
	@RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteJob(@PathVariable("id") String id) throws ResourceNotFoundException{
       return jobService.delete(id);
    }
	
}
