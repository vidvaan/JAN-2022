package com.ciq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ciq.model.Employee;
import com.ciq.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/allEmployees")
	public ModelAndView findAll() {
		List<Employee> employees = employeeService.findAll();
		System.out.println(employees);
		return new ModelAndView("findAll", "emps", employees);
	}
	
	@RequestMapping("/addEmp")
	public String addEmp() {
		return "addEmp";
	}
	
	
	@RequestMapping(value = "/saveEmp",method = RequestMethod.POST)
	public String saveEmp(Employee employee,Model model) {
		System.out.println(employee);
		employeeService.save(employee);
		
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("emps", employees);
		return "findAll";
	}

	
	@RequestMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("eid") Integer eid,Model model) {
		System.out.println("Eid : "+eid);
		employeeService.deleteById(eid);
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("emps", employees);
		return "findAll";
	}
	
	
	@RequestMapping("/updateEmp")
	public String updateEmp(@RequestParam("eid") Integer eid,Model model) {
		Employee employee = employeeService.findById(eid);
		model.addAttribute("emp", employee);
		return "updateEmp";
	}
	
	
	@RequestMapping(value = "/updateEmp",method = RequestMethod.POST)
	public String updateEmpPost(Employee employee,Model model) {
		employeeService.update(employee);
		
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("emps", employees);
		return "findAll";
	}

}
