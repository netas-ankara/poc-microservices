package com.poc.cgonul.microserviceseurekaclientfailover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {

	private final RestTemplate restTemplate;

	@Autowired
	public ExampleController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping ("/execute")
	public String execute() {
		return restTemplate.getForObject("http://myClient02/service-info-my-client-01", String.class);
	}

}
