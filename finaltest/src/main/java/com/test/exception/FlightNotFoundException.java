package com.test.exception;

public class FlightNotFoundException extends RuntimeException{

	public FlightNotFoundException(String message) {
		super(message);
	}
}