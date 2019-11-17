package com.patientsystem.constants;

import java.util.Locale;

public enum AppLocale
{
	TR( new Locale( "TR" ) ),
	EN( Locale.getDefault() ),
	SP( new Locale( "SP" ) );

	private Locale locale;

	AppLocale( Locale locale )
	{
		this.locale = locale;
	}

	public Locale getLocale()
	{
		return locale;
	}
}