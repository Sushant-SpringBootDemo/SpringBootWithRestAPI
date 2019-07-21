package com.zensar.ExceptionHandler;

public class InvalidUserException extends RuntimeException {

	public InvalidUserException(String message) {
		super(message);
	}

}
