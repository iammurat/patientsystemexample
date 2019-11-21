package com.patientsystem.configuration.starter;

import com.patientsystem.job.CronJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class ApplicationRunnerStartup implements ApplicationRunner
{
	@Autowired
	private CronJobs cronJobs;

	@Override
	public void run( ApplicationArguments args ) throws Exception
	{
		cronJobs.printTimePerSecondAll();
		System.out.println( "ApplicationRunnerStartup" );
	}
}
