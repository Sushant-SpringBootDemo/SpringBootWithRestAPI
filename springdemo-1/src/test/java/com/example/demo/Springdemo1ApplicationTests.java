package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.controller.RestApiController;
import com.zensar.model.Value;
import com.zensar.service.JsonService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Springdemo1ApplicationTests {

	@Mock
	/* @InjectMocks */
	public JsonService jsonService;

	@Mock
	public RestTemplate restTemplate;

	@Autowired
	@InjectMocks
	public RestApiController restApiController;

	public List<Value> list, uniquelist, datalist;
	public Set<Value> set;
	public Value[] value;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		/*
		 * Value v1 = new Value(); v1.setId(1); v1.setUserId(1);
		 * v1.setTitle("1800Flowers"); v1.setBody("1800Flowers");
		 * 
		 * 
		 * 
		 * Value v2 = new Value(); v2.setId(2); v2.setUserId(2);
		 * v2.setTitle("1800Flowers"); v2.setBody("1600Flowers");
		 * 
		 * 
		 * val = new Value[2]; val[0] = v1; val[1] = v2;
		 * System.out.println("val length*************:"+val.length);
		 */

		JSONParser parser = new JSONParser();

		try (Reader reader = new FileReader("D:\\test.json")) {

			JSONArray jsonArray = (JSONArray) parser.parse(reader);

			ObjectMapper objectMapper = new ObjectMapper();

			value = objectMapper.readValue(jsonArray.toString(), Value[].class);

			list = new ArrayList<Value>(Arrays.asList(value));

			set = new HashSet<>(Arrays.asList(value));
			uniquelist = new ArrayList<Value>(set);

			System.out.println("**********************for Testing mock data************************************");

			for (int i = 0; i < 5; i++) {

				System.out.println("id=" + list.get(i).getId());
				System.out.println("userid=" + list.get(i).getUserId());
				System.out.println("title=" + list.get(i).getTitle());
				System.out.println("body=" + list.get(i).getBody());

			}
			System.out.println(
					"**********************for Testing mock data completed************************************");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void countendpointTest() {
		when(jsonService.getCountOfEndpoint()).thenReturn(list.size());
		when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class)).thenReturn(value);

		int count = restApiController.countendpoint();
		assertEquals(100, count);

	}

	@Test
	public void dummydataTest() throws Exception {
		when(jsonService.getJsonDummyData()).thenReturn(list);
		when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class)).thenReturn(value);

		datalist = restApiController.getJsonData();

		assertEquals(100, datalist.size());

	}

	@Test
	public void TallyOfUniqueUserIdTest() {
		when(jsonService.getTallyOfUniqueUserId()).thenReturn(uniquelist);
		when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Value[].class)).thenReturn(value);

		datalist = restApiController.tallyUniqueUserId();
		assertNotNull(datalist);
		assertEquals(10, datalist.size());

	}

	@Test
	public void modifyJSONElementTest() throws Exception {

		// when(restTemplate.getForObject("", Value[].class)).thenReturn(value);
		/*
		 * System.out.println("val length:"+val.length);
		 * 
		 * when(jsonService.modifyJSONElement(index)).thenReturn(val); Value[]
		 * value = restApiController.modifyJSON(index);
		 * 
		 * System.out.println("value length:"+value.length); assertEquals(2,
		 * value.length); assertEquals("1800Flowers",
		 * value[index-1].getTitle());
		 */

		/*
		 * mockMvc.perform(get("/helloworld")).andExpect(status().isOk());
		 */
	}

}
