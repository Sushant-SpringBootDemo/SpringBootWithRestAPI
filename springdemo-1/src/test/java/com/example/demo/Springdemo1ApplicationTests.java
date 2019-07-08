package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zensar.controller.RestApiController;
import com.zensar.service.JsonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springdemo1ApplicationTests {

	/*
	 * private MockMvc mockMvc;
	 * 
	 * @Autowired private WebApplicationContext context;
	 * 
	 * ObjectMapper om = new ObjectMapper();
	 */

	/*
	 * @Before public void setUp() { mockMvc =
	 * MockMvcBuilders.webAppContextSetup(context).build(); }
	 */

	/*
	 * @Test public void getEndpointCountTest() throws Exception { MvcResult
	 * result = mockMvc.perform(get("/countendpoint").contentType(MediaType.
	 * APPLICATION_JSON_VALUE)) .andExpect(status().isOk()).andReturn(); String
	 * resultContent = result.getResponse().getContentAsString();
	 * 
	 * }
	 */

	@Mock
	private JsonService jsonService;

	@InjectMocks
	private RestApiController restApiController;
	public Value[] val;
	
	int index =4;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		Value v1 = new Value();
		v1.setId(1);
		v1.setUserId(1);
		v1.setTitle("1800Flowers");
		v1.setBody("1800Flowers");
		
		

		Value v2 = new Value();
		v2.setId(2);
		v2.setUserId(2);
		v2.setTitle("1800Flowers");
		v2.setBody("1600Flowers");
		
		
		 val = new Value[2];
		val[0] = v1;
		val[1] = v2;
		System.out.println("val length*************:"+val.length);

	}

	@Test
	final public void modifyJSONElementTest() throws Exception {

		System.out.println("val length:"+val.length);

		when(jsonService.modifyJSONElement(index)).thenReturn(val);
		Value[] value = restApiController.modifyJSON(index);
		for(Value v: value)
		{
			System.out.println("title:"+v.getTitle());
			System.out.println("title:"+v.getBody());

		}
		System.out.println("value length:"+value.length);
		assertEquals(2, value.length);
		assertEquals("1800Flowers", value[1].getTitle());
		
		

		/*
		 * mockMvc.perform(get("/helloworld")).andExpect(status().isOk());
		 */
	}

}
