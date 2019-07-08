package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.zensar.*")
public class Springdemo1Application {

	private static final Logger log = LoggerFactory.getLogger(Springdemo1Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Springdemo1Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	/*
	 * @Bean public CommandLineRunner run(RestTemplate restTemplate) throws
	 * Exception { return args -> { Value[] val = restTemplate.getForObject(
	 * "http://jsonplaceholder.typicode.com/posts", Value[].class);
	 * //List<Object> searchList= Arrays.asList(obj);
	 * 
	 * for(Value v: val ) { System.out.println("Id:"+v.getId());
	 * System.out.println("UserId:"+v.getUserId());
	 * System.out.println("Title:"+v.getTitle());
	 * System.out.println("Body:"+v.getBody()); System.out.println();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * //log.info(quote.toString()); //System.out.println(quote.toString());
	 * //System.out.println(quote.getValue());
	 * System.out.println(quote.getValue().getId());
	 * System.out.println(quote.getValue().getQuote());
	 * 
	 * 
	 * 
	 * 
	 * }; }
	 */

}
