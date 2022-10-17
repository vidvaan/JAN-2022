package com.createiq.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@Controller
public class HomeController {

	// @RequestMapping -> @GetMapping @PostMapping @PutMapping
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping({ "/", "findAll" })
	public String home(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "home";
	}
	
	@GetMapping("/addEmp")
	public String addEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmp";
	}
	
	@PostMapping("/addEmp")
	public String addEmp(@Valid @ModelAttribute("employee") Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			return "addEmp";
		}
		employeeService.save(employee);
		return "redirect:/findAll";
	}

}
