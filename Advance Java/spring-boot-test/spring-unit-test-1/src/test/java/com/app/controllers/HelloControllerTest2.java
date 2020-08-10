package com.app.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.TestContextConfiguration;

@RunWith(SpringRunner.class) //MANDATORY
@SpringBootTest(classes=TestContextConfiguration.class)
//@WebMvcTest(HelloController.class)
@AutoConfigureMockMvc
//@TestPropertySource(locations="classpath:/application.properties")
/*
 * @RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
 */
public class HelloControllerTest2 {
	@Autowired
	private MockMvc mockMvc;
	@Value("${server.port}")
    private String port;
	@Value("${spring.datasource.url}")
    private String url;
	@Value("${server.servlet.context-path}")
    private String path;
	
	@Test
	public void testSimpleHelloWorld() throws Exception {
		System.out.println("port "+port+" "+url+" "+path);
		// create mock http servlet request
		RequestBuilder builder = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result.getResponse().getStatus());
		assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
