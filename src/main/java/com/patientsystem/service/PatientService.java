package com.patientsystem.service;

import com.patientsystem.entity.Patient;
import com.patientsystem.exceptions.NoPatientException;
import com.patientsystem.repository.PatientRepository;
import com.patientsystem.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PatientService
{
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PaginationUtil paginationUtil;

	public Patient getById( Long id ) throws NoPatientException
	{
		return patientRepository.findById( id )
								.orElseThrow( NoPatientException::new );
	}

	public Page<Patient> getPage( int page, int size, String sortby )
	{
		return patientRepository.findAll( paginationUtil.createPageable( page, size, sortby ) );
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
