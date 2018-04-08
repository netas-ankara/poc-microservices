package com.netas.poc.simpleservice2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@Value("${server.port}")
	public String port;

	@RequestMapping("/execute")
	private String execute() {
		return String.format("Hello from the port -> %s", port);
	}

	@RequestMapping("/")
	public String status() {
		return "Up";
	}
}
