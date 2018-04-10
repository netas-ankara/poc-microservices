# poc-microservices
This project includes various parts of the micro-services architecture. 

Microservices is a software development technique—a variant of the service-oriented architecture 
(SOA) architectural style that structures an application as a collection of loosely coupled services. 

In a microservices architecture, services are fine-grained and the protocols are lightweight. 

The benefit of decomposing an application into different smaller services is that it improves modularity and makes the application easier to understand, 
develop, test, and more resilient to architecture erosion. 

It also parallelizes development by enabling small autonomous teams to develop, deploy and scale their respective services independently.

It also allows the architecture of an individual service to emerge through continuous refactoring.

Microservices-based architectures enable continuous delivery and deployment.

## 001_Microservices_Basics

This part of the project include two sup projects.

1. A catalog service
2. Library service

The catalog service  stores a list of books mainly two books. Library service consumes the catalog service by calling its rest endpoint namely __findByTitle__.
A list of books is returned from these service call. The library service shows the data in an html page.

The library service consumes the catalog service as follows:

````java
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book/search")
public class BookController {

	@RequestMapping("/title")
	public String findByTitle(@Param("title") String title) throws URISyntaxException{
		RestTemplate template = new RestTemplate();
		URI uri = new URI("http://localhost:9999/book/search/title?title=" + title);
		return template.getForObject(uri, String.class);
	}
}
````

Note: You can fetch a strongly typed response from an endpoint using the following code :

````
ResponseEntity<List<Rate>> rateResponse =
        restTemplate.exchange("https://bitpay.com/api/rates",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Rate>>() {
            });
List<Rate> rates = rateResponse.getBody();
````

## 002_Spring_Config_Server

The project consists of two sub-projects. The first one is spring configuration client and the second one is spring configuration server.

The client configuration can be refreshed from the following endpoint:
````
POST http://localhost:9999/actuator/refresh
````

After posting to the endpoint we can see that the edited configuration can be fetched.

 
