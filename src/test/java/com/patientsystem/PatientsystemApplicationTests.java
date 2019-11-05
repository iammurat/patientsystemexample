package com.patientsystem;

import com.patientsystem.controller.PatientController;
import com.patientsystem.repository.PatientRepository;
import com.patientsystem.service.PatientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
public class PatientsystemApplicationTests
{
	@Autowired
	private PatientController patientController;

	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientRepository patientRepository;

	@Test
	public void contextLoads_smokeTest()
	{
		Assert.assertNotNull( "patientController should not be null!", patientController );
		Assert.assertNotNull( "patientService should not be null!", patientService );
		Assert.assertNotNull( "patientRepository should not be null!", patientRepository );
	}
}
