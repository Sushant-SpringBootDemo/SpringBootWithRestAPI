package com.zensar.ExceptionHandler;

public class InvalidIndexFoundException extends RuntimeException {
	public InvalidIndexFoundException(String message) {
		super(message);
	}
}
