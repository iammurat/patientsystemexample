package com.patientsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Patient
{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String surname;
	private Integer age;

	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname( String surname )
	{
		this.surname = surname;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge( Integer age )
	{
		this.age = age;
	}

	public List<Appointment> getAppointments()
	{
		return appointments;
	}

	public void setAppointments( List<Appointment> appointments )
	{
		this.appointments = appointments;
	}
}
