package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.zensar.model.Value;

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

	public Value[] value, value2;
	ObjectMapper objectMapper;

	@Before
	public void setUp() {

		mvc = MockMvcBuilders.webAppContextSetup(context).build();

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader(ResourceUtils.getFile("classpath:test.json"))) {

			JSONArray jsonArray = (JSONArray) parser.parse(reader);

			objectMapper = new ObjectMapper();

			value = objectMapper.readValue(jsonArray.toString(), Value[].class);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void countendpointTest() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class))
				.thenReturn(value);
		this.mvc.perform(get("/countendpoint")).andExpect(status().isOk());

		String contentAsString = this.mvc.perform(get("/countendpoint")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		System.out.println("contentAsString value" + contentAsString);

		assertEquals("97", contentAsString);

	}

	@Test
	public void modifyJsonArrayTest() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class))
				.thenReturn(value);

		this.mvc.perform(get("/modifyJSON/4")).andExpect(status().isOk());
		String responsedata = this.mvc.perform(get("/modifyJSON/4"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn().getResponse()
				.getContentAsString();
		value2 = objectMapper.readValue(responsedata, Value[].class);
		assertNotNull(value2);
		assertEquals("1800Flowers", value2[4].getTitle());
		assertEquals("1800Flowers", value2[4].getBody());

	}
	@Test
	public void getJsonDummyDataTest() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class))
				.thenReturn(value);

		this.mvc.perform(get("/getJsonDummyData")).andExpect(status().isOk());
		String dummydata = this.mvc.perform(get("/getJsonDummyData"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn().getResponse()
				.getContentAsString();
		assertNotNull(dummydata);

	}
	
	@Test
	public void tallyUniqueUserIdTest() throws Exception {
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class))
				.thenReturn(value);

		this.mvc.perform(get("/tallyUniqueUserId")).andExpect(status().isOk());
		String uniqueIdcount = this.mvc.perform(get("/tallyUniqueUserId"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn().getResponse()
				.getContentAsString();
		value2 = objectMapper.readValue(uniqueIdcount, Value[].class);
		assertEquals(10, value2.length);

	}

	/*
	 * @Test public void countendpointTest() {
	 * //Mockito.when(jsonRepository.restTemplate()).thenReturn(list);
	 * 
	 * //Mockito.when(jsonRepository.restTemplate()).thenReturn(list);
	 * System.out.println( "INSIDE CONT END POINT TEST"+value.length);
	 * //Mockito.when(restTemplate.getForObject("",
	 * Value[].class)).thenReturn(value);
	 * 
	 * System.out.println("restApicontroller:::::"+restApiController); int count
	 * = restApiController.countendpoint(); System.out.println(
	 * "INSIDE CONT END POINT TEST  count value"+count);
	 * 
	 * assertEquals(97, count);
	 * 
	 * }
	 */

	/*
	 * @Test public void TallyOfUniqueUserIdTest() { //
	 * Mockito.when(jsonService.getTallyOfUniqueUserId()).thenReturn(uniquelist)
	 * ; // when(restTemplate.getForObject("",
	 * Value[].class)).thenReturn(value);
	 * 
	 * datalist = restApiController.tallyUniqueUserId();
	 * assertNotNull(datalist); assertEquals(11, datalist.size());
	 * 
	 * }
	 */

}
