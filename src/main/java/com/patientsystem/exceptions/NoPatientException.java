package com.patientsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND, reason = "Bad request!" )
public class NoPatientException extends BusinessException
{
	public NoPatientException( String message, String localeMessage )
	{
		super( message, localeMessage );
	}
}
