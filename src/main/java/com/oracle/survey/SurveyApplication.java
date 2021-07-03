package com.oracle.survey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SurveyApplication extends SpringBootServletInitializer implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(SurveyApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}

	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SurveyApplication.class);
	}

	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("BootStartup complete....");
	}

	

	

}
