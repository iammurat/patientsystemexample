package com.patientsystem.configuration.starter;

import com.patientsystem.mailsender.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerStartup implements CommandLineRunner
{
	@Autowired
	private MailSender mailSender;

	@Override
	public void run( String... args ) throws Exception
	{
		System.out.println( "CommandLineRunnerStartup" );
		mailSender.sendScheduledEmail();
	}
}
