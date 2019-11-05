package com.patientsystem.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@ContextConfiguration( classes = BusinessConfiguration.class )
@TestPropertySource( "/business.properties" )
public class BusinessConfigurationTest
{
	@Autowired
	private BusinessConfiguration businessConfiguration;

	@Test
	public void testMinAge()
	{
		Assert.assertEquals( "MinAge values are not equal!", 18, businessConfiguration.getMinAge() );
	}
}
