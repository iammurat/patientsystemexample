package com.patientsystem.controller.config;

import com.patientsystem.exceptions.BusinessException;
import com.patientsystem.exceptions.NoPatientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler
{
	@ExceptionHandler( BusinessException.class )
	//@ResponseStatus( HttpStatus.NOT_FOUND )
	public ResponseEntity handleBusinessException( NoPatientException e )
	{
		return ResponseEntity.status( HttpStatus.NOT_FOUND )
							 .build();
		//return e.getMessage();
	}

	/*@ExceptionHandler( BusinessException.class )
	//@ResponseStatus( HttpStatus.BAD_REQUEST )
	public ResponseEntity handleBusinessException( BusinessException businessException )
	{
		//return businessException.getMessage();

		return ResponseEntity.status( HttpStatus.BAD_REQUEST )
							 .body( businessException.getMessage() );
	}*/

	@ExceptionHandler( Exception.class )
	@ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
	public String handleException( Exception exception )
	{
		//return "Error!";

		return exception.getMessage();
	}
}