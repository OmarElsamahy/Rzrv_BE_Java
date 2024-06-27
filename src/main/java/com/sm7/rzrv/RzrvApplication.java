package com.sm7.rzrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class RzrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(RzrvApplication.class, args);
	}

}
