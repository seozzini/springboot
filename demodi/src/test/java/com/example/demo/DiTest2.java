package com.example.demo;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.restaurant.Restaurant;

@SpringBootTest
public class DiTest2 {
	
	@Autowired Restaurant restaurant;
	
	@Test
	@DisplayName("DI test2")
	public void test2() {
		//TV tv = context.getBean(TV.class);
		restaurant.getChef().getName();

	}

}
