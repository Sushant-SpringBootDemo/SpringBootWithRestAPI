package com.zensar.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAPIExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> invalidInput(Exception e)
	{
		ErrorMessage error  = new ErrorMessage(e.getMessage(),"Please check Connetivity");
		
		return  new ResponseEntity<ErrorMessage>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(InvalidIndexFoundException.class)
	public ResponseEntity<ErrorMessage> invalidIndexFoundException(InvalidIndexFoundException e)
	{
		ErrorMessage error  = new ErrorMessage(e.getMessage(),"Input valid index");
		
		return  new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorMessage> invalidInputException(InvalidInputException e)
	{
		ErrorMessage error  = new ErrorMessage(e.getMessage(),"Verify Input User and id as input");
		
		return  new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorMessage> invalidUserException(InvalidUserException e)
	{
		ErrorMessage error  = new ErrorMessage(e.getMessage(),"Verify User Object");
		
		return  new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
		
	}
	

}
