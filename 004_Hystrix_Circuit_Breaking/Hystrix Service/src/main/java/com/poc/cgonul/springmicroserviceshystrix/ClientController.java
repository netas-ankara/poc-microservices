package com.poc.cgonul.springmicroserviceshystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class ClientController {

	private final RestTemplate restTemplate;

	@Autowired
	public ClientController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	//The hystrix stream is http://localhost:8080/actuator/hystrix.stream
	@RequestMapping ("/startClient")
	//@formatter:off
	@HystrixCommand (fallbackMethod = "failover", commandProperties = {
			@HystrixProperty (name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
	})
	//@formatter:on
	public String[] startClient(@RequestParam long time) throws InterruptedException {
		Thread.sleep(time);
		return restTemplate.getForObject("http://localhost:8888/service", String[].class);
	}

	public String[] failover(long time) {
		return new String[]{"Default1", "Default2"};
	}
}
