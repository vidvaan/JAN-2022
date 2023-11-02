package com.ciq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.entity.Role;
import com.ciq.entity.User;
import com.ciq.service.RoleService;
import com.ciq.service.UserService;

@RestController
//@RequestMapping("/public")
public class RegController {
	
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/public/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
	@PostMapping("/public/saveRole")
	public ResponseEntity<?> saveRole(@RequestBody Role role){
		return new ResponseEntity<Role>(roleService.save(role), HttpStatus.CREATED);
	}
	
	

}
