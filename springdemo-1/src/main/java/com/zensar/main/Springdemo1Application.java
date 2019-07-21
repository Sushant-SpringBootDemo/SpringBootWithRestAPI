package com.zensar.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.zensar.*")
public class Springdemo1Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Springdemo1Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/*
	 * @Bean public CommandLineRunner run(RestTemplate restTemplate) throws
	 * Exception { return args -> { User[] val = restTemplate.getForObject(
	 * "http://jsonplaceholder.typicode.com/posts", User[].class);
	 * //List<Object> searchList= Arrays.asList(obj);
	 * 
	 * }; }
	 */

}
