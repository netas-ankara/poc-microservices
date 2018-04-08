package com.poc.cgonul.microserviceseurekaclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
public class MicroServicesEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesEurekaClientApplication.class, args);
	}
}

@RestController
class ServiceInstanceRestController {

	private final DiscoveryClient discoveryClient;

	@Autowired
	public ServiceInstanceRestController(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@RequestMapping ("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}
