package com.patientsystem.service.idvalidation;

import org.springframework.stereotype.Component;

public class USAIdNoValidator implements IdNoValidator
{
	@Override
	public void validate( String idNo )
	{
		System.out.println("USA");
	}
}
