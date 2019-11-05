package com.patientsystem.rest;

import com.patientsystem.controller.config.Paths;
import com.patientsystem.entity.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import javax.annotation.PostConstruct;

@RunWith( SpringRunner.class )
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
//@AutoConfigureMockMvc
public class PatientRestTest
{
	@LocalServerPort
	private int port;

	public static final String PROTOCOL = "http://";
	public static final String URL = "localhost:";
	public static final String RESOURCE = Paths.PATIENTS;
	private String path;

	@PostConstruct
	public void init()
	{
		path = PROTOCOL + URL + port + "/" + RESOURCE;
	}

	@Autowired
	private TestRestTemplate testRestTemplate;

	/*@Autowired
	private MockMvc mockMvc;*/

	@Test
	public void post_ShouldPass()
	{
		Patient patient = new Patient();
		patient.setName( "Can" );
		patient.setSurname( "Ibrahimoglu" );
		patient.setAge( 28 );
		Patient responsePatient = testRestTemplate.postForObject( path, patient, Patient.class );
		Assert.assertEquals( "Names don't match!", patient.getName(), responsePatient.getName() );
	}
}
