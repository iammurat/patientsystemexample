package com.patientsystem.service.idvalidation;

import org.springframework.stereotype.Component;

public class TurkeyIdNoValidator implements IdNoValidator
{
	@Override
	public void validate( String idNo )
	{
		System.out.println("Turkey");
	}
}
