package com.poc.cgonul.microserviceseurekaclientfailover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroServicesEurekaClientFailoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesEurekaClientFailoverApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

@RestController
class ServiceInstanceRestController {

	private final EurekaClient eurekaClient;

	@Autowired
	public ServiceInstanceRestController(@Qualifier ("eurekaClient") EurekaClient eurekaClient) {
		this.eurekaClient = eurekaClient;
	}

	@RequestMapping ("/service-info-my-client-01")
	public String serviceInstancesByApplicationName() {
		InstanceInfo myClient01 = eurekaClient.getNextServerFromEureka("myClient01", false);
		return myClient01.getHomePageUrl();
	}
}