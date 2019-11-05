package com.patientsystem.controller;

import com.patientsystem.entity.Patient;
import com.patientsystem.exceptions.InvalidPatientAgeException;
import com.patientsystem.exceptions.NoPatientException;
import com.patientsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.patientsystem.controller.config.Paths.PATH_ID;
import static com.patientsystem.controller.config.Paths.PATIENTS;

@RestController
@RequestMapping( PATIENTS )
public class PatientController
{
	@Autowired
	private PatientService patientService;

	@GetMapping( PATH_ID )
	public Patient getById( @PathVariable Long id ) throws NoPatientException
	{
		return patientService.getById( id );
	}

	@GetMapping
	public Page<Patient> getPage( @RequestParam Integer page, @RequestParam Integer size,
								  @RequestParam( required = false ) String sortby,
								  @RequestParam( required = false ) String name)
	{
		return patientService.getPage( page, size, sortby );
	}

	@RequestMapping( method = { RequestMethod.POST, RequestMethod.PUT } )
	public Patient save( @RequestBody Patient patient ) throws InvalidPatientAgeException
	{
		return patientService.save( patient );
	}

	@DeleteMapping( PATH_ID )
	public void deleteById( @PathVariable Long id )
	{
		patientService.deleteById( id );
	}
}