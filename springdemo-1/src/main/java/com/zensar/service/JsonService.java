package com.zensar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Value;
import com.zensar.repository.JsonRepository;

@Service
public class JsonService {

	@Autowired
	private JsonRepository jsonRepository;

	/* Get Json dummy data */

	public List<Value> getJsonDummyData() throws Exception {

		return jsonRepository.restTemplate();

	}

	/* Get count of Endpoints */

	public int getCountOfEndpoint() {

		System.out.println("###########################Checkpoint 2 inside  service countendpoint#####################");
		System.out.println("jsonRepository:::" + jsonRepository);

		List<Value> list = jsonRepository.restTemplate();

		return (list.size() > 0 && list != null) ? list.size() : 0;

	}

	/* get tally of unique user ids */

	public List<Value> getTallyOfUniqueUserId() {

		HashSet<Value> set = new HashSet<Value>(jsonRepository.restTemplate());

		System.out.println("###############################count of unique userid=########################################" + set.size());

		List<Value> list = new ArrayList<Value>(set);
		return list;

	}

	public List<Value> modifyJSONElement(int index) {
		List<Value> list = jsonRepository.restTemplate();
		Value v = list.get(index);
		v.setTitle("1800Flowers");
		v.setBody("1800Flowers");

		return list;

	}

}
