package com.patientsystem.repository;

import com.patientsystem.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends PagingAndSortingRepository<Patient, Long>
{
	Page<Patient> findByName( String name, Pageable pageable );

	@Query( "SELECT P FROM Patient P WHERE LOWER(P.name) = LOWER(:name)" )
	Page<Patient> findByNameCI( @Param( "name" ) String name, Pageable pageable );

	@Query( "SELECT P FROM Patient P WHERE P.age >= 18" )
	Page<Patient> findAdults( Pageable pageable );
}
