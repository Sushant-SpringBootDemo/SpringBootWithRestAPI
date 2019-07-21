package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.controller.RestApiController;
import com.zensar.main.Springdemo1Application;
import com.zensar.model.User;

@SpringBootTest(classes = Springdemo1Application.class)
@RunWith(SpringRunner.class)
public class Springdemo1ApplicationTests {

	@MockBean
	public RestTemplate restTemplate;

	@Autowired
	public RestApiController restApiController;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	public User[] userArray, userArray1;
	ObjectMapper objectMapper;

	@Before
	public void setUp() {

		mvc = MockMvcBuilders.webAppContextSetup(context).build();

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader(ResourceUtils.getFile("classpath:test.json"))) {

			JSONArray jsonArray = (JSONArray) parser.parse(reader);

			objectMapper = new ObjectMapper();

			userArray = objectMapper.readValue(jsonArray.toString(), User[].class);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void countendpointTest() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", User[].class))
				.thenReturn(userArray);

		this.mvc.perform(get("/countendpoint")).andExpect(status().isOk()).andExpect(jsonPath("$", is(notNullValue())))
				.andExpect(jsonPath("$", is(98)));

	}

	@Test
	public void modifyJsonArrayTest() throws Exception {
		int index = 2;
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", User[].class))
				.thenReturn(userArray);

		this.mvc.perform(get("/modifyJSON/{id}", index)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", is(notNullValue()))).andExpect(jsonPath("$[1].title", is("1800Flowers")))
				.andExpect(jsonPath("$[1].body", is("1800Flowers")));

	}

	@Test
	public void tallyUniqueUserIdTest1() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", User[].class))
				.thenReturn(userArray);

		this.mvc.perform(get("/tallyUniqueUserId"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk())
				.andExpect(jsonPath("$", is(notNullValue()))).andExpect(jsonPath("$.length()", is(10)));
	}

	@Test
	public void getJsonDummyDataTest() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", User[].class))
				.thenReturn(userArray);

		this.mvc.perform(get("/getJsonDummyData")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", is(notNullValue()))).andExpect(jsonPath("$").isArray());

	}
	
	
	@Test
	public void updateUserListTest() throws Exception {
		User user = new User(4, 1, "Welcome to Zensar", "How are you");

		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", User[].class))
				.thenReturn(userArray);

		this.mvc.perform(put("/updateUserList/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(objectMapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))				
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", is(notNullValue())))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].userId", is(4)))
				.andExpect(jsonPath("$[0].title", is("Welcome to Zensar")))
				.andExpect(jsonPath("$[0].body", is("How are you")));
				
	}

	

}
