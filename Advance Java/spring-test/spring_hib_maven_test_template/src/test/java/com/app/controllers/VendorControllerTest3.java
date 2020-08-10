package com.app.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.config.WebConfig;
import com.app.service.VendorServiceIntf;

import pojos.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
// @ContextConfiguration(locations = "classpath:**/spring-servlet.xml")
@ContextConfiguration(classes = WebConfig.class)
public class VendorControllerTest3 {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	/*
	 * @Mock private VendorServiceIntf service;
	 * 
	 * @InjectMocks private VendorController controller;
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void giventUrl_whenGetRequest_thenFindGetResponse() throws Exception {
		mockMvc.perform(get("/get")).
		andExpect(status().isOk()).andExpect(content().string("GET Response"));
	}

	/*
	 * @Test public final void testListVendors() throws Exception { List<Vendor>
	 * vendors = Arrays.asList(new Vendor("a", "a@gmail", "pune", "1234", 500,
	 * new Date()), new Vendor("a2", "a2@gmail", "pune123", "1236", 1500, new
	 * Date())); when(service.listVendors()).thenReturn(vendors);
	 * mockMvc.perform(get("/vendor/list")).andExpect(status().isOk())
	 * .andExpect(model().attribute("vendor_list", vendors)); verify(service,
	 * times(1)).listVendors(); }
	 */
}
