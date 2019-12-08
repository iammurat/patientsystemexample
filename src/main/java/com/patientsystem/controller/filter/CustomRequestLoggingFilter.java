package com.patientsystem.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomRequestLoggingFilter extends GenericFilterBean
{
	private static final Logger LOGGER = LogManager.getLogger( CustomRequestLoggingFilter.class );

	@Override
	public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain )
			throws IOException, ServletException
	{
		final HttpServletRequest currentRequest = ( HttpServletRequest ) servletRequest;
		final HttpServletResponse currentResponse = ( HttpServletResponse ) servletResponse;

		StringBuffer requestURL = currentRequest.getRequestURL();
		LOGGER.info( "Request URL: {}", requestURL );
		try
		{
			chain.doFilter( currentRequest, servletResponse );
		}
		finally
		{
			int status = currentResponse.getStatus();
			LOGGER.info( "Response status: {}", status );
		}
	}
}