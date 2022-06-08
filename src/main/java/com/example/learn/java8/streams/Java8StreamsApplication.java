package com.example.learn.java8.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Java8StreamsApplication implements CommandLineRunner {

	@Autowired
	Tutorial1 tutorial1;

	@Autowired
	Tutorial2 tutorial2;

	private static Logger LOG = LoggerFactory.getLogger(Java8StreamsApplication.class);

	public static void main(String[] args) {

		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(Java8StreamsApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception, IOException {

		LOG.info("EXECUTING : command line runner");

//		tutorial1.run();

		tutorial2.run();

	}
}
