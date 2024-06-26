package com.loginform.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ReactLoginRegistrationFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactLoginRegistrationFormApplication.class, args);
		System.out.println("Application is Running...");
	}

}
