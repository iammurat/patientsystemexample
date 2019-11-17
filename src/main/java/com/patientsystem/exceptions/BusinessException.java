package com.patientsystem.exceptions;

public class BusinessException extends LocalizedException
{
	public BusinessException( String message, String localeMessage )
	{
		super( message, localeMessage );
	}
}
