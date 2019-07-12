package com.zensar.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.zensar.model.Value;

@Repository
public class JsonRepository {

	@Autowired
	private RestTemplate restTemplate;

	public List<Value> restTemplate() {

		System.out.println("INSIIDE REST TEMPLATE METHOD");
		Value[] value = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class);
		System.out.println("restTemplate :: " + restTemplate.getClass());
		System.out.println("value :: " + value);
		List<Value> list = new ArrayList<Value>(Arrays.asList(value));
		System.out.println("###############End of All Methods" + list.size());
		return list;

	}

}
