package com.summit.drproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.summit.drproject.entity.Machine;
import com.summit.drproject.exception.ResourceNotFoundException;
import com.summit.drproject.repository.MachineRepository;

@Service
public class MachineService {

	@Autowired
	private MachineRepository machineRepository;
	
	 public List<Machine> getAllMachines() {
	        return machineRepository.findAll();
	    }
	 
	 public Machine create(Machine machine) {
			return machineRepository.save(machine);
		}
		
		public ResponseEntity<Machine> getMachine(String id)throws ResourceNotFoundException {
			Machine machine = machineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Machine not found for this site code :: " + id));
			return ResponseEntity.ok().body(machine);
		}
		
		public Map<String, Boolean> delete(String id) throws ResourceNotFoundException {
			Machine currentMachine = machineRepository.findById(id)
		        		.orElseThrow(() -> new ResourceNotFoundException("Tour not found for this site code :: " + id));
			machineRepository.delete(currentMachine);
		        Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
		}
	
}
