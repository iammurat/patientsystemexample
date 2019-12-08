package com.patientsystem.controller.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Order( Ordered.LOWEST_PRECEDENCE - LogRequestFilter.NUMBER_OF_FILTERS )
public class LogRequestFilter extends OncePerRequestFilter implements Ordered
{
	private final Log logger = LogFactory.getLog( getClass() );
	public static final int NUMBER_OF_FILTERS = 8;

	@Override
	public int getOrder()
	{
		return Ordered.LOWEST_PRECEDENCE - LogRequestFilter.NUMBER_OF_FILTERS;
	}

	@Override
	protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain )
			throws ServletException, IOException
	{
		ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper( request );

		filterChain.doFilter( wrappedRequest, response );
		Map<String, Object> trace = getTrace( wrappedRequest, response.getStatus() );
		getBody( wrappedRequest, trace );
		logTrace( trace );
	}

	private void getBody( ContentCachingRequestWrapper request, Map<String, Object> trace )
	{
		ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest( request, ContentCachingRequestWrapper.class );
		if ( wrapper != null )
		{
			byte[] buf = wrapper.getContentAsByteArray();
			if ( buf.length > 0 )
			{
				String payload;
				try
				{
					payload = new String( buf, 0, buf.length, wrapper.getCharacterEncoding() );
				}
				catch ( UnsupportedEncodingException ex )
				{
					payload = "[unknown]";
				}

				trace.put( "body", payload );
			}
		}
	}

	private void logTrace( Map<String, Object> trace )
	{
		Object method = trace.get( "method" );
		Object path = trace.get( "path" );
		Object statusCode = trace.get( "statusCode" );
		logger.info( String.format( "%s %s '%s'. Trace: '%s'", method, path, statusCode, trace ) );
	}

	protected Map<String, Object> getTrace( HttpServletRequest request, int status )
	{
		Principal principal = request.getUserPrincipal();
		Map<String, Object> trace = new LinkedHashMap<String, Object>();
		trace.put( "method", request.getMethod() );
		trace.put( "path", request.getRequestURI() );
		trace.put( "principal", principal != null ? principal.getName() : principal );
		trace.put( "query", request.getQueryString() );
		trace.put( "statusCode", status );
		return trace;
	}
}