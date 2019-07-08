package com.zensar.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Value;

@Service
public class JsonService {

	@Autowired
	private RestTemplate restTemplate;

	public Value[] restTemplate() {
		return restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class);

	}

	/*get Json dummy data*/
	
	public Value[] getJsonDummyData() {

		return restTemplate();

	}

	/*get count of Endpoints*/
	
	public int getCountOfEndpoint() {
		Value[] val = restTemplate();
		System.out.println("Count************=" + val.length);

		return val != null && val.length > 0 ? val.length : 0;

	}

	/*get tally of unique user ids*/
	
	public Value[] getTallyOfUniqueUserId() {

		HashSet<Value> set = new HashSet<Value>();
		Value[] val = restTemplate();
		for (Value v : val) {
			set.add(v);
		}

		System.out.println(" count of unique userid=" + set.size());
		Value[] uniqueVal = new Value[set.size()];
		for (Value v : set.toArray(uniqueVal)) {
			System.out.println("inside array");

			System.out.println("userid:" + v.getUserId());
			System.out.println("id:" + v.getId());
			System.out.println("Title:" + v.getTitle());
			System.out.println("Body:" + v.getBody());
			System.out.println();

		}

		return uniqueVal;

	}
	
	
	public Value[] modifyJSONElement(int index) {
		Value[] val = restTemplate();
		Value forthval = val[index-1];
		forthval.setTitle("1800Flowers");
		forthval.setBody("1800Flowers");
		val[index-1] = forthval;
		return val;

	}
	

}
