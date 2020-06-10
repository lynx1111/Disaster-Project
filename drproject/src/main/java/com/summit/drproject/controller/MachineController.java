package com.summit.drproject.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.summit.drproject.entity.Machine;
import com.summit.drproject.exception.ResourceNotFoundException;

import com.summit.drproject.service.MachineService;

@Controller
public class MachineController {

	@Autowired
	MachineService machineService;
	
	@RequestMapping(value = "/machines",method = RequestMethod.GET)
	public String getMachines(ModelMap model){
		System.out.println("In machine controller");
		List<Machine> machines = machineService.getAllMachines();
		model.put("machines", machines);
		return "machines";
	}
	
	@GetMapping("/edit_machine/{id}")
	public String updateMachine(@PathVariable String id , ModelMap model) {
		Machine machine = null;
		try {
			ResponseEntity<Machine> rMachine = machineService.getMachine(id);
			machine = rMachine.getBody();
			model.put("machine", machine);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editMachine";
	}
	
	@PostMapping("/update_machine/{id}")
	public String showUpdateMachine(@PathVariable String id, @Validated @ModelAttribute Machine machine, BindingResult result, Model model ) {
		System.out.println("update_job");
		if (result.hasErrors()) {
            return "editMachine";
        }
		try {
			machineService.getMachine(id);
			machineService.create(machine);
			model.addAttribute("machines", machineService.getAllMachines());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "machines";
	}
	
	@RequestMapping(value="/delete_machine", method=RequestMethod.GET)
	public String deleteMachine(@RequestParam(value="id") String id, ModelMap model) {
		try {
			machineService.delete(id);
			model.put("machines", machineService.getAllMachines());
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "machines";
	}
	@GetMapping(value="/create_machine")
	public String addMachine(Model model) {
		model.addAttribute("machine", new Machine());
		return "machineForm";
	}
	
	@PostMapping(value="/add_machine", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String showAddedMachine(@Validated @ModelAttribute Machine machine, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "machineForm";
		}
		machineService.create(machine);
		model.addAttribute("machines", machineService.getAllMachines());
		return "machines";
	}
}
