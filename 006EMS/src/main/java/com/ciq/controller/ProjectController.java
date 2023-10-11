package com.ciq.controller;

import java.util.List;

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
import com.ciq.entity.Project;
import com.ciq.service.DepartmentService;
import com.ciq.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/findAll")
	public List<Project> findAll() {
		return projectService.findAll();
	}

	@GetMapping("/findById/{pid}")
	public Project findById(@PathVariable Long pid) {
		return projectService.findById(pid);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Project project) {
		Project pro = null;
		try {
		    pro = projectService.save(project);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Project>(pro, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public Project update(@RequestBody Project project) {
		return projectService.update(project);
	}

	@DeleteMapping("/delete/{pid}")
	public String delete(@PathVariable Long pid) {
		projectService.deleteById(pid);
		return "Deleted Successfully";
	}

}
