package com.ciq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.entity.Department;
import com.ciq.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {
	
	

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/findAll")
	public List<Department> findAll() {
		return departmentService.findAll();
	}

	@GetMapping("/findById/{did}")
	public Department findById(@PathVariable Long did) {
		return departmentService.findById(did);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Department department) {
		Department dept = null;
		try {
		    dept = departmentService.save(department);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Department>(dept, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public Department update(@RequestBody Department department) {
		return departmentService.update(department);
	}

	@DeleteMapping("/delete/{did}")
	public String delete(@PathVariable Long did) {
		departmentService.deleteById(did);
		return "Deleted Successfully";
	}

}
