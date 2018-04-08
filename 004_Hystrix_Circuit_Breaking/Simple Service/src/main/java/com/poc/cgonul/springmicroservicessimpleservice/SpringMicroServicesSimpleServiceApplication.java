package com.poc.cgonul.springmicroservicessimpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringMicroServicesSimpleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroServicesSimpleServiceApplication.class, args);
	}

	@RequestMapping ("/service")
	public String[] execute() {
		return new String[]{"Value 1", "Value 2"};
	}
}
