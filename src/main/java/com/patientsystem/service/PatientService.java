package com.patientsystem.service;

import com.patientsystem.configuration.BusinessConfiguration;
import com.patientsystem.entity.Patient;
import com.patientsystem.exceptions.InvalidPatientAgeException;
import com.patientsystem.exceptions.NoPatientException;
import com.patientsystem.repository.PatientRepository;
import com.patientsystem.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService
{
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PaginationUtil paginationUtil;

	@Autowired
	private BusinessConfiguration businessConfiguration;

	private void validatePatient( Patient patient ) throws InvalidPatientAgeException
	{
		/*Optional.ofNullable( patient.getAge() )
				.filter( age -> age >= businessConfiguration.getMinAge() )
				.orElseThrow( InvalidPatientAgeException::new );*/

		if ( patient.getAge() < businessConfiguration.getMinAge() )
		{
			throw new InvalidPatientAgeException();
		}
	}

	public Patient getById( Long id ) throws NoPatientException
	{
		return patientRepository.findById( id )
								.orElseThrow( NoPatientException::new );
	}

	public Page<Patient> getPage( int page, int size, String sortby )
	{
		return patientRepository.findAll( paginationUtil.createPageable( page, size, sortby ) );
	}

	public Patient save( Patient patient ) throws InvalidPatientAgeException
	{
		validatePatient( patient );
		return patientRepository.save( patient );
	}

	public void deleteById( Long id )
	{
		patientRepository.deleteById( id );
	}
}
