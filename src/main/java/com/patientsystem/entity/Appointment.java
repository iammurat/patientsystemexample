package com.patientsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment
{
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn( name = "patient_id" )
	@JsonIgnore
	private Patient patient;
	private String date;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public Patient getPatient()
	{
		return patient;
	}

	public void setPatient( Patient patient )
	{
		this.patient = patient;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate( String date )
	{
		this.date = date;
	}
}
