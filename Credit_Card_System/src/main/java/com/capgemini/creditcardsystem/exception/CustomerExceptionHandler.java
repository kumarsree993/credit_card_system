package com.capgemini.creditcardsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<Object> CustomerNotFoundException(CustomerNotFoundException ex){
		return new ResponseEntity<Object>("customer not found", HttpStatus.BAD_REQUEST);
	}

}
