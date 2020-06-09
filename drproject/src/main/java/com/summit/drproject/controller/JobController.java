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
	
	@RequestMapping(value="/update_job", method = RequestMethod.GET)
	public String updateJob(@RequestParam(value="id") String id , ModelMap model) {
		Job job = null;
		try {
			ResponseEntity<Job> rJob = jobService.getJob(id);
			job = rJob.getBody();
			model.put("job", job);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jobForm";
	}
	//ASk Maruthi about this. Giving null pointer as well as redirecting 
	@RequestMapping(value="/after_update_job", method = RequestMethod.GET)
	public String showUpdateJob(@RequestParam(value="id",required=false) String id , @RequestParam(value="description",required=false) String description,@RequestParam(value="rate",required=false) Integer rate,@RequestParam(value="maxHour",required=false) Double maxHour) {
		Job job = new Job(id, description, rate.intValue(), maxHour.doubleValue());
		jobService.create(job);
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
