package com.zensar.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.ExceptionHandler.InvalidIndexFoundException;
import com.zensar.ExceptionHandler.InvalidInputException;
import com.zensar.ExceptionHandler.InvalidUserException;
import com.zensar.model.User;
import com.zensar.repository.JsonRepository;

@Service
public class JsonService {

	@Autowired
	private JsonRepository jsonRepository;

	/* Get Json dummy data */

	public List<User> getJsonDummyData() throws Exception {

		return jsonRepository.restTemplate();

	}

	/* Get count of Endpoints */

	public int getCountOfEndpoint() {

		System.out
				.println("###########################Checkpoint 2 inside  service countendpoint#####################");
		System.out.println("jsonRepository:::" + jsonRepository);

		List<User> userList = jsonRepository.restTemplate();

		return (userList.size() > 0 && userList != null) ? userList.size() : 0;

	}

	/* get tally of unique user ids */

	public List<User> getTallyOfUniqueUserId() {

		HashSet<User> userSet = new HashSet<User>(jsonRepository.restTemplate());

		System.out.println(
				"###############################count of unique userid=########################################"
						+ userSet.size());

		List<User> userList = new ArrayList<User>(userSet);
		return userList;

	}

	public List<User> modifyJSONElement(int index) {
		List<User> userList = jsonRepository.restTemplate();
		if(index <= userList.size()&& index >= 0)
		{
		User user = userList.get(index - 1);
		user.setTitle("1800Flowers");
		user.setBody("1800Flowers");
		}
		else
		{
			throw new InvalidIndexFoundException("Enter Valid index to modify Element");
		}
		return userList;

	}

	public List<User> updateUserList(User user, int id) {
		List<User> userList = jsonRepository.restTemplate();
		if (user!= null && id <=userList.size())
		{
		for (User user1 : userList) {
			
			if (user1.getId() == id) {
				user1.setId(user.getId());
				user1.setUserId(user.getUserId());
				user1.setTitle(user.getTitle());
				user1.setBody(user.getBody());
			}
		}
		}
		else
		{
			throw new InvalidInputException("Enter UserID within limit");
		}

		return userList;

	}
	
	public List<User> AddUser(User user) {
		List<User> userList = jsonRepository.restTemplate();
		if(user != null)
		{
		userList.add(user);
		}
		else
		{
			throw new InvalidUserException("User is Null");
		}

		return userList;

	}

}
