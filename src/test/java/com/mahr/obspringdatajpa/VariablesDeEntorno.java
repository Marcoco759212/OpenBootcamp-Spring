package com.mahr.obspringdatajpa;

import org.junit.jupiter.api.Test;

//@SpringBootTest
public class VariablesDeEntorno {

	@Test
	void contextLoads() {
		System.getenv().forEach((key, value) -> System.out.println(key + " " + value) );
	}
	
}
