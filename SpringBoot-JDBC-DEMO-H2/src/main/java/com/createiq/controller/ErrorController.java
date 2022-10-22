package com.createiq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.createiq.exception.EmployeeNotFoundException;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> employeeNotFoundExHandler(EmployeeNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
