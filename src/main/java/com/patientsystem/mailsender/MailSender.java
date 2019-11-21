package com.patientsystem.mailsender;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class MailSender
{
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat( "HH:mm:ss" );

	//@Scheduled( fixedDelay = 5000 )
	public void sendScheduledEmail()
	{
		sendEmail();
	}

	//@Async( "mailThreadPool" )
	public void sendEmail()
	{
		System.out.println( SIMPLE_DATE_FORMAT.format( Calendar.getInstance()
															   .getTime() ) );
	}

	@Async
	public void simpleAsync1()
	{
		System.out.println("I am  also async!");
	}

	public void simpleAsync2()
	{
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.execute( () ->
							  {
								  System.out.println("I am  also async!");
							  } );
	}
}
