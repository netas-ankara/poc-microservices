package com.netas.poc.ribbonservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
	private final RestTemplate restTemplate;

	@Autowired
	public RibbonController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/startClient")
	public String startClient() {
		return restTemplate.getForObject("http://simple-service-2/execute",String.class);
	}
}
