package com.createiq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createiq.model.User;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		User user = new User("Balaji", "G", "Indian");
		model.addAttribute("msg1", "My First Spring Boot App From Model");
		model.addAttribute("msg2", "My first Spring Boot App with thyme leaf From Model.");
		model.addAttribute("user", user);
		return "home";
	}

}
