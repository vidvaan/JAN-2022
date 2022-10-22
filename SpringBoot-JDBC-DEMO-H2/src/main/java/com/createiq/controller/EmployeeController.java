package com.createiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.createiq.service.EmployeeService;

@Controller

public class EmployeeController {

	// @RequestMapping -> @GetMapping @PostMapping @PutMapping
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping({ "/", "findAll" })
	public String home(Model model) {
		
		System.out.println(employeeService.findAll());
		
		model.addAttribute("employees", employeeService.findAll());
		return "findAll";
	}
	

}
