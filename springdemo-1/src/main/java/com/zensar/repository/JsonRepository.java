package com.zensar.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.zensar.model.User;

@Repository
public class JsonRepository {

	@Autowired
	private RestTemplate restTemplate;

	public List<User> restTemplate() {

		System.out.println("INSIIDE REST TEMPLATE METHOD");
		User[] userArray = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", User[].class);
		System.out.println("restTemplate :: " + restTemplate.getClass());
		System.out.println("user :: " + userArray);
		List<User> userList = new ArrayList<User>(Arrays.asList(userArray));
		System.out.println("###############End of All Methods" + userList.size());
		return userList;

	}

}
