package com.patientsystem.controller;

import com.patientsystem.entity.Patient;
import com.patientsystem.exceptions.NoPatientException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
public class PatientControllerTest
{
	@Autowired
	private PatientController patientController;

	@Test
	public void get_ShouldPass() throws NoPatientException
	{
		Patient patient = patientController.getById( 12L );
		Assert.assertEquals( "Names don't match!", "Sibel", patient.getName() );
	}
}
