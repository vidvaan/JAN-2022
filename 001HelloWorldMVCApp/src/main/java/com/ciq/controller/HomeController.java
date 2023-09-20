package com.ciq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/hel")
	public ModelAndView hello() {
		return new ModelAndView("hello");
	}
	
	

	@RequestMapping("/wel")
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}

}
