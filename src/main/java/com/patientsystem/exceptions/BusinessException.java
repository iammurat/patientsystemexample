package com.patientsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "Bad request!!!" )
public class BusinessException extends Exception
{
	public BusinessException( String message )
	{
		super( message );
	}
}
