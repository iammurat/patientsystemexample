package com.patientsystem.exceptions;

public class LocalizedException extends Exception
{
	private String localizedMessage;

	public LocalizedException( String message, String localizedMessage )
	{
		super( message );
		this.localizedMessage = localizedMessage;
	}

	@Override
	public String getLocalizedMessage()
	{
		return localizedMessage;
	}
}
