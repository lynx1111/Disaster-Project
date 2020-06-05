package com.summit.drproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.summit.drproject.entity.Job;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.repository.JobRepository;




@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	 public List<Job> getAllJobs() {
	        return jobRepository.findAll();
	    }
	 
	 public Job create(Job job) {
			return jobRepository.save(job);
		}
		
		public ResponseEntity<Job> getJob(String id)throws ResourceNotFoundException {
			Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found for this site code :: " + id));
			return ResponseEntity.ok().body(job);
		}
		
		public Map<String, Boolean> delete(String id) throws ResourceNotFoundException {
			Job currentJob = jobRepository.findById(id)
		        		.orElseThrow(() -> new ResourceNotFoundException("Tour not found for this site code :: " + id));
			 jobRepository.delete(currentJob);
		        Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
		}
	
}
