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
import com.summit.drproject.entity.Machine;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.MachineService;

@Controller
public class MachineController {

	@Autowired
	MachineService machineService;
	

	
	@RequestMapping(value = "/machines",method = RequestMethod.GET)
	public String getJobs(ModelMap model){
		System.out.println("In machine controller");
		List<Machine> machines = machineService.getAllMachines();
		model.put("machines", machines);
		return "machines";
	}
	
	@RequestMapping(value="/update_machine", method = RequestMethod.GET)
	public String updateJob(@RequestParam(value="id") String id , ModelMap model) {
		Machine machine = null;
		try {
			ResponseEntity<Machine> rMachine = machineService.getMachine(id);
			machine = rMachine.getBody();
			model.put("machine", machine);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "machineForm";
	}
	@RequestMapping(value="/after_update_machine", method = RequestMethod.GET)
	public String showUpdateJob(@RequestParam(value="id",required=false) String id , @RequestParam(value="description",required=false) String description,@RequestParam(value="rate",required=false) Integer rate,@RequestParam(value="maxHour",required=false) Double maxHour) {
		Machine machine = new Machine(id, description, rate.intValue(), maxHour.doubleValue());
		machineService.create(machine);
		return "machines";
	}
	@RequestMapping(value="/delete_machine", method=RequestMethod.GET)
	public String deleteJob(@RequestParam(value="id") String id, ModelMap model) {
		try {
			machineService.delete(id);
			List<Machine> machines = machineService.getAllMachines();
			model.put("machines", machines);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "machines";
	}
}
