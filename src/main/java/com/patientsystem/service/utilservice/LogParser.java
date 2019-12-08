package com.patientsystem.service.utilservice;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
public class LogParser
{
	private String parseRequestHeaders( HttpServletRequest request )
	{
		List<String> headers = new ArrayList<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while ( headerNames.hasMoreElements() )
		{
			String headerName = headerNames.nextElement();
			headers.add( "{ " + headerName + ": " + request.getHeader( headerName ) + " }" );
		}
		return "[" + String.join( ", ", headers ) + "]";
	}

	public String parseHttpServletRequest( HttpServletRequest request )
	{
		List<String> parts = new ArrayList<>();
		parts.add( "Scheme: " + request.getScheme() );
		parts.add( "Protocol: " + request.getProtocol() );
		parts.add( "PathInfo: " + request.getPathInfo() );
		parts.add( "PathTranslated: " + request.getPathTranslated() );
		parts.add( "ServerPort: " + request.getServerPort() );
		parts.add( "URI: " + request.getRequestURI() );
		parts.add( "Method: " + request.getMethod() );
		parts.add( "Locale: " + request.getLocale() );
		parts.add( "CharacterEncoding: " + request.getCharacterEncoding() );
		parts.add( "Secure: " + request.isSecure() );
		parts.add( "AuthType: " + request.getAuthType() );
		parts.add( "Headers: " + parseRequestHeaders( request ) );
		parts.add( "RequestedSessionId: " + request.getRequestedSessionId() );
		parts.add( "RequestedSessionIdValid: " + request.isRequestedSessionIdValid() );
		parts.add( "ContextPath: " + request.getContextPath() );
		parts.add( "ServletPath: " + request.getServletPath() );
		parts.add( "ServletName: " + request.getHttpServletMapping()
											.getServletName() );
		parts.add( "RemoteHost: " + request.getRemoteHost() );
		parts.add( "RemoteAddress: " + request.getRemoteAddr() );
		parts.add( "RemotePort: " + request.getRemotePort() );
		parts.add( "RemoteUser: " + request.getRemoteUser() );
		parts.add( "LocalAddress: " + request.getLocalAddr() );
		parts.add( "LocalPort: " + request.getLocalPort() );
		parts.add( "LocalName: " + request.getLocalName() );
		return "{" + String.join( ", ", parts ) + "}";
	}

	public String parseHttpServletResponse( HttpServletResponse response )
	{
		List<String> parts = new ArrayList<>();
		response.getStatus();
		response.getContentType();
		response.getCharacterEncoding();
		return "{" + String.join( ", ", parts ) + "}";
	}
}
