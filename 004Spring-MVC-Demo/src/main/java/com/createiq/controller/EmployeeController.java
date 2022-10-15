package com.createiq.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "findAll";
	}

	@RequestMapping("/addEmployee")
	public String showAddEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmp";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmp(@Valid @ModelAttribute Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "addEmp";
		}
		employeeService.add(employee);
		return "redirect:/findAll";
	}

	@RequestMapping("/updateEmp")
	public String showUpdateEmp(@RequestParam("eid") Integer eid, Model model) {
		Employee employee = employeeService.findById(eid);
		model.addAttribute("employee", employee);
		return "updateEmp";
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(Employee employee) {
		employeeService.update(employee);
		return "redirect:/findAll";
	}

	@RequestMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("eid") Integer eid) {
		employeeService.delete(eid);
		return "redirect:/findAll";
	}
}
