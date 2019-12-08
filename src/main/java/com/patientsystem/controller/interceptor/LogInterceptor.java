package com.patientsystem.controller.interceptor;

import com.patientsystem.service.utilservice.LogParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor
{
	private static final Logger LOGGER = LogManager.getLogger( LogInterceptor.class );
	private static final String ALLOWED_METHODS = HttpMethod.GET.name() + ";" + //
												  HttpMethod.POST.name() + ";" + //
												  HttpMethod.PUT.name() + ";" + //
												  HttpMethod.DELETE.name();

	public static final String REQUEST = org.springframework.boot.web.servlet.DispatcherType.REQUEST.name();

	@Autowired
	private LogParser logParser;

	private boolean isRequestMethodLoggable( String method )
	{
		return ALLOWED_METHODS.contains( method.toUpperCase() );
	}

	private boolean isRequestType( DispatcherType dispatcherType )
	{
		return REQUEST.equals( dispatcherType.name() );
	}

	@Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler )
	{

		if ( isRequestType( request.getDispatcherType() ) && isRequestMethodLoggable( request.getMethod() ) )
		{
			LOGGER.trace( logParser.parseHttpServletRequest( request ) );
		}

		return true;
	}
}