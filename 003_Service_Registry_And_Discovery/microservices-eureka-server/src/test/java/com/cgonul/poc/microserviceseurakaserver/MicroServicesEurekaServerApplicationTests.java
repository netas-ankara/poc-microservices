package com.cgonul.poc.microserviceseurakaserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("peer1")
public class MicroServicesEurekaServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
