package com.patientsystem.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource( "business.properties" )
public class BusinessConfiguration
{
	public static final String MIN_AGE_PARAM = "${patient.minAge}";

	@Value( MIN_AGE_PARAM )
	private int minAge;

	public int getMinAge()
	{
		return minAge;
	}
}
