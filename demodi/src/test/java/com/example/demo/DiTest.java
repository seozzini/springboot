package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;

import com.example.demo.di.TV;

@SpringBootTest
public class DiTest {
	
	@Autowired TV tv;
	//@Autowired ApplicationContext context; //스프링 IoC컨테이너(Beans를 담고있는)
	
	@Test
	@DisplayName("DI test")
	public void test1() {
		//TV tv = context.getBean(TV.class);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
