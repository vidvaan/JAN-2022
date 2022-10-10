package com.createiq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/hello")
	public ModelAndView hello() {
		return new ModelAndView("hello");
	}
	
	@RequestMapping("/home")
	public ModelAndView home(@RequestParam("name") String name) {
		return new ModelAndView("home", "name", name);
	}

}
