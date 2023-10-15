package com.ciq.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ciq.exception.EmployeNotFoundException;

@RestControllerAdvice
public class EmsExceptionHandler {
	@ExceptionHandler(value = EmployeNotFoundException.class)
	public ResponseEntity<?> employeNotFoundException(EmployeNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<?> numberFormatException(NumberFormatException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentException(IllegalArgumentException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
