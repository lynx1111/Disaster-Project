package com.summit.drproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.service.JobService;



@Controller
public class JobController {

	@Autowired
	JobService jobService;
	
	@RequestMapping(value = "/jobs",method = RequestMethod.GET)
	public String getJobs(ModelMap model){
		System.out.println("In job controller");
		List<Job> jobs = jobService.getAllJobs();
		model.put("jobs", jobs);
		return "jobs";
	}
	@GetMapping("/edit_job/{id}")
	public String updateJob(@PathVariable String id , ModelMap model) {
		Job job = null;
		try {
			ResponseEntity<Job> rJob = jobService.getJob(id);
			job = rJob.getBody();
			model.put("job", job);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editJob";
	}
	
	@PostMapping("/update_job/{id}")
	public String showUpdateJob(@PathVariable String id, @Validated @ModelAttribute Job job, BindingResult result, Model model ) {
		System.out.println("update_job");
		if (result.hasErrors()) {
            return "editJob";
        }
		try {
			jobService.getJob(id);
			jobService.create(job);
			model.addAttribute("jobs", jobService.getAllJobs());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jobs";
	}
	
	@RequestMapping(value="/delete_job", method=RequestMethod.GET)
	public String deleteJob(@RequestParam(value="id") String id, ModelMap model) {
		try {
			jobService.delete(id);
			List<Job> jobs = jobService.getAllJobs();
			model.put("jobs", jobs);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jobs";
	}
	@GetMapping(value="/create")
	public String addJob(Model model) {
		model.addAttribute("job", new Job());
		System.out.println("Creating the job v1");
		return "jobForm";
	}
	
	@PostMapping(value="/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String showAddedJob(@Validated @ModelAttribute Job job, BindingResult result, Model model) {
		System.out.println("Creating the job v24324324");
		if(result.hasErrors()) {
			return "jobForm";
		}
		jobService.create(job);
		model.addAttribute("jobs", jobService.getAllJobs());
		return "jobs";
	}
	
}
