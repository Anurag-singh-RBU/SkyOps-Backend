package com.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<String> handleFlightNotFound(FlightNotFoundException e){

		return new ResponseEntity<String>(e.getMessage() , HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException e){

		Map<String, String> errors = new HashMap<>();

		e.getBindingResult().getFieldErrors().forEach(error -> {

			errors.put(error.getField() , error.getDefaultMessage());
			
		});

		return new ResponseEntity<Map<String,String>>(errors , HttpStatus.BAD_REQUEST);
		
	}
}