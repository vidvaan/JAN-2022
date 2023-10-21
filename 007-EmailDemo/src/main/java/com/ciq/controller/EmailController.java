package com.ciq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciq.service.EmailService;
import com.ciq.service.model.EmailDetails;

import jakarta.validation.Valid;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody @Valid EmailDetails emailDetails) {
		String result = emailService.sendSimpleMail(emailDetails);
		return result;

	}
	
	@PostMapping("/sendEmailWithAttachment")
	public String sendEmailWithAttachment(@RequestBody @Valid EmailDetails emailDetails) {
		String result = emailService.sendMailWithAttachment(emailDetails);
		return result;

	}

}
