package com.Joytishcharya.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
		exclude = {
				org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration.class
		}
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
