package com.zensar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zensar.model.Value;

@Service
public class JsonService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Value> restTemplate() {

		Value[] value = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class);
		List<Value> list = new ArrayList<Value>(Arrays.asList(value));
		return list;

	}

	/* get Json dummy data */

	public List<Value> getJsonDummyData() throws Exception {

		return restTemplate();

	}

	/* get count of Endpoints */

	public int getCountOfEndpoint() {

		List<Value> list = restTemplate();
		return list != null && list.size() > 0 ? list.size() : 0;

	}

	/* get tally of unique user ids */

	public List<Value> getTallyOfUniqueUserId() {

		HashSet<Value> set = new HashSet<Value>(restTemplate());

		System.out.println(" count of unique userid=" + set.size());

		List<Value> list = new ArrayList<Value>(set);
		return list;

	}

	public List<Value> modifyJSONElement(int index) {
		List<Value> list = restTemplate();
		Value v = list.get(index);
		v.setTitle("1800Flowers");
		v.setBody("1800Flowers");

		return list;

	}

}
