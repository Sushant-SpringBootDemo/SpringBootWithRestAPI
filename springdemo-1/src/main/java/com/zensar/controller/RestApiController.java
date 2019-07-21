package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.User;
import com.zensar.service.JsonService;

@RestController
public class RestApiController {

	@Autowired(required = true)
	public JsonService jsonService;

	@RequestMapping(value = "/getJsonDummyData", method = RequestMethod.GET)
	public List<User> getJsonData() throws Exception {
		List<User> list = jsonService.getJsonDummyData();

		return list;

	}

	@RequestMapping(value = "/countendpoint", method = RequestMethod.GET)
	public Integer countendpoint() {
		System.out.println("###########################Checkpoint 1 inside countendpoint#####################");
		System.out.println("json object:::::" + jsonService);
		int count = jsonService.getCountOfEndpoint();
		System.out.println("Count in controller************=" + count);

		return count;

	}

	@RequestMapping(value = "/tallyUniqueUserId", method = RequestMethod.GET)
	public List<User> tallyUniqueUserId() {

		return jsonService.getTallyOfUniqueUserId();

	}

	@RequestMapping(value = "/modifyJSON/{index}", method = RequestMethod.GET)
	public List<User> modifyJSON(@PathVariable("index") int index) {

		return jsonService.modifyJSONElement(index);

	}
	
	@RequestMapping(value = "/updateUserList/{id}", method = RequestMethod.PUT)
	public List<User> UpdateUserList(@RequestBody User user, @PathVariable("id") int id) {

		
		return jsonService.updateUserList(user, id);

	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public List<User> AddUser(@RequestBody User user) {

		
		return jsonService.AddUser(user);

	}

}
