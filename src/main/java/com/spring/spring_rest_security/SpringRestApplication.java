package com.spring.spring_rest_security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * SpringRestApplication
 * <p>
 * Main entry point for the Spring REST application.
 * Bootstraps the Spring application context, enables auto-configuration,
 * and scans for components within the {@code com.spring.spring_rest} package.
 * </p>
 *
 * @author Felisa Bascug
 */
@SpringBootApplication
public class SpringRestApplication {

	/**
	 * Launches the Spring Boot application.
	 *
	 * @param args command-line arguments passed during application startup
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
