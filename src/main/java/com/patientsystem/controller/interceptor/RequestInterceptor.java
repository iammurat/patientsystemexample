package com.patientsystem.controller.interceptor;

import com.patientsystem.service.utilservice.LogParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter
{
	public static final Logger LOGGER = LogManager.getLogger( RequestInterceptor.class );

	@Autowired
	private LogParser logParser;

	@Override
	public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler )
			throws Exception
	{

		return super.preHandle( request, response, handler );
	}

	@Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler,
							ModelAndView modelAndView ) throws Exception
	{
		super.postHandle( request, response, handler, modelAndView );
	}

	@Override
	public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler,
								 Exception ex ) throws Exception
	{
		LOGGER.trace( logParser.parseHttpServletRequest( request ) );
		LOGGER.trace( logParser.parseHttpServletResponse( response ) );
		super.afterCompletion( request, response, handler, ex );
	}
}
