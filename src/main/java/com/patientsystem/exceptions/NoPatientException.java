package com.patientsystem.exceptions;

public class NoPatientException extends BusinessException
{
	public NoPatientException()
	{
		super( "No patient has found!" );
	}
}
