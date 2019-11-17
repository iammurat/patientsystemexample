package com.patientsystem.configuration;

import com.patientsystem.service.idvalidation.IdNoValidator;
import com.patientsystem.service.idvalidation.TurkeyIdNoValidator;
import com.patientsystem.service.idvalidation.USAIdNoValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource( "business.properties" )
public class BusinessConfiguration
{
	public static final String MIN_AGE_PARAM = "${patient.minAge}";
	public static final String COUNTRY_PARAM = "${patientsystem.country}";

	@Value( MIN_AGE_PARAM )
	private int minAge;

	@Value( COUNTRY_PARAM )
	private String country;

	public int getMinAge()
	{
		return minAge;
	}

	private enum Country
	{
		USA
				{
					@Override
					public IdNoValidator getIdNoValidator()
					{
						return new USAIdNoValidator();
					}
				},
		TURKEY
				{
					@Override
					public IdNoValidator getIdNoValidator()
					{
						return new TurkeyIdNoValidator();
					}
				};

		public abstract IdNoValidator getIdNoValidator();
	}

	@Bean
	public IdNoValidator getIdNoValidator()
	{
		return Country.valueOf( country.toUpperCase() )
					  .getIdNoValidator();
	}
}
