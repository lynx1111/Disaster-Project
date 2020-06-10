package com.summit.drproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.summit.drproject.entity.Timesheet;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.repository.TimesheetRepository;

@Service
public class TimesheetService {

	@Autowired
	private TimesheetRepository timesheetRepository;
	
	 public List<Timesheet> getAllTimesheets() {
	        return timesheetRepository.findAll();
	    }
	 
	 public Timesheet create(Timesheet timesheet) {
			return timesheetRepository.save(timesheet);
		}
		
		public ResponseEntity<Timesheet> getTimesheet(int id)throws ResourceNotFoundException {
			Timesheet timesheet = timesheetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found for this site code :: " + id));
			return ResponseEntity.ok().body(timesheet);
		}
		
		public Map<String, Boolean> delete(int id) throws ResourceNotFoundException {
			Timesheet currentTimesheet = timesheetRepository.findById(id)
		        		.orElseThrow(() -> new ResourceNotFoundException("Tour not found for this site code :: " + id));
			 timesheetRepository.delete(currentTimesheet);
		        Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
		}
	
}
