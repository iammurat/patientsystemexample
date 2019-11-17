package com.patientsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "Invalid age!" )
public class InvalidPatientAgeException extends BusinessException
{
	public InvalidPatientAgeException( String message, String localeMessage )
	{
		super( message, localeMessage );
	}
}
