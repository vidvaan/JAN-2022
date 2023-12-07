package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.entity.Employee;
import com.createiq.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "home";
	}
	
	@GetMapping("/newEmp")
	public String newEmp() {
		return "newEmp";
		
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/home";
		
	}
}
