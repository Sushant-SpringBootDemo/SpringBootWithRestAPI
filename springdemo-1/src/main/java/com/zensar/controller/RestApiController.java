package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Value;
import com.zensar.service.JsonService;

@RestController
public class RestApiController {

	@Autowired(required=true)
	private JsonService jsonService;

	@RequestMapping(value = "/getJsonDummyData", method = RequestMethod.GET)
	public Value[] getJsonData() {

		return jsonService.getJsonDummyData();

	}

	@RequestMapping(value = "/countendpoint", method = RequestMethod.GET)
	public int countendpoint() {
		int count = jsonService.getCountOfEndpoint();

		return count;

	}

	@RequestMapping(value = "/tallyUniqueUserId", method = RequestMethod.GET)
	public Value[] tallyUniqueUserId() {

		return jsonService.getTallyOfUniqueUserId();

	}

	@RequestMapping(value = "/modifyJSON/{index}", method = RequestMethod.GET)
	public Value[] modifyJSON(@PathVariable("index") int index) {

		return jsonService.modifyJSONElement(index);
		

	}

}
