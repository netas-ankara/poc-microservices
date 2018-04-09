package com.netas.poc.simpleservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@RequestMapping ("/execute")
	public String execute() {
		return "Executed...";
	}
}
