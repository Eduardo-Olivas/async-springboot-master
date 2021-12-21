package com.async;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class AsyncSpringBootApplication {

	@SuppressWarnings("unused")
	private static Logger logJava = Logger.getLogger(AsyncSpringBootApplication.class);	
	
    public static void main(String[] args) {
    	logJava.info("main ::");
        SpringApplication.run(AsyncSpringBootApplication.class, args);
    }

}
