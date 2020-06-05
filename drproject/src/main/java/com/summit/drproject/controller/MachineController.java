package com.summit.drproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.summit.drproject.entity.Machine;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.MachineService;

@RestController
public class MachineController {

	@Autowired
	MachineService machineService;
	

	
	@RequestMapping(value = "/machines",method = RequestMethod.GET)
	public List<Machine> getJobs(){
		return machineService.getAllMachines();
	}
	
	@RequestMapping(value ="/machine/{id}",method = RequestMethod.GET)
	public ResponseEntity<Machine> getMachine(@PathVariable("id") String id) throws ResourceNotFoundException{
		return machineService.getMachine(id);
	}
	
	@RequestMapping(value ="/machine/",method = RequestMethod.POST)
	public Machine insert(@RequestBody Machine machine) {
		return machineService.create(machine);
	}
		
	
	@RequestMapping(value = "/machine/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteMachine(@PathVariable("id") String id) throws ResourceNotFoundException{
       return machineService.delete(id);
    }
	
}
