package com.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.app.service.SomeBusinessServiceImpl;

public class TestServiceJUnit {

	@Test
	public void test() {
		SomeBusinessServiceImpl service=new SomeBusinessServiceImpl();
		assertEquals(service.calcSum(2,3,4,5,6), 20);
	}
	@Test
	public void testSignedNUmbers()
	{
		
	}

}
