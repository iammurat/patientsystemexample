package com.patientsystem.service;

import com.patientsystem.entity.Patient;
import com.patientsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService
{
	@Autowired
	private PatientRepository patientRepository;

	public Patient getById( Long id )
	{
		return patientRepository.findById( id )
								.get();
	}

	public List<Patient> getAll()
	{
		return null; //TODO
	}

	public Patient save( Patient patient )
	{
		return patientRepository.save( patient );
	}

	public void deleteById( Long id )
	{
		patientRepository.deleteById( id );
	}
}
