package com.patientsystem.configuration.http;

import com.patientsystem.controller.interceptor.LogInterceptor;
import com.patientsystem.controller.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfiguration implements WebMvcConfigurer
{
	@Autowired
	private RequestInterceptor requestInterceptor;

	@Autowired
	private LogInterceptor logInterceptor;

	@Override
	public void addInterceptors( InterceptorRegistry registry )
	{
		registry.addInterceptor( requestInterceptor );
		registry.addInterceptor( logInterceptor );
	}
}
