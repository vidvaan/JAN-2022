package com.ciq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/public/home")
	public String home() {
		return "Home Page";
	}
	
	@GetMapping("/public/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/public/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/user")
	public String user() {
		return "User";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Admin";
	}

}
