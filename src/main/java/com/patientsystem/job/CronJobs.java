package com.patientsystem.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class CronJobs
{
	public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat( "HH:mm:ss" );

	private synchronized String getDate()
	{
		return SIMPLE_DATE_FORMAT.format( Calendar.getInstance()
												  .getTime() );
	}

	/*@Scheduled( cron = "13,23,43 * * * * *" )
	public void printTimeAtSeconds13And23And43()
	{
		System.out.println( getDate() + " -- at 13,23,43" );
	}

	@Scheduled( cron = "5/10 * * * * *" )
	public void printTimePer10SecondStartingFrom5()
	{
		System.out.println( getDate() + " -- per 10 second 10 starting from 5" );
	}

	@Scheduled( cron = "10-50 * * * * TUE-WED" )
	public void printTimePerSecond10To50TueWed()
	{
		System.out.println( getDate() + " -- per second with cron 10-50, TUE-WED" );
	}*/

	//@Scheduled( cron = "* * * * * *" )
	public void printTimePerSecondAll()
	{
		try
		{
			Thread.sleep( 20000 );
		}
		catch ( InterruptedException e )
		{
			e.printStackTrace();
		}
		System.out.println( getDate() + " -- per second All" );
	}

	//@Scheduled( cron = "*/1 * * * * *" )
	public void printTimePerSecond()
	{
		System.out.println( getDate() + " -- per second with cron" );
	}

	//@Scheduled( fixedDelay = 2000 )
	public void printTimePer2Seconds()
	{
		System.out.println( getDate() + " -- per 2 seconds fixed delay" );
	}
}
