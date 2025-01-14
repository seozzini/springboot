package com.example.demo.di;

import org.springframework.context.annotation.Bean;

//@Configuration
public class JavaConfig {
	
	@Bean
	public Speaker speaker() {
		System.out.println("speaker 등록");
		return new SonySpeaker();
	}
	
	@Bean
	public TV tv() {
		System.out.println("TV 등록");
		return new SamsungTV(speaker());
	}
	
}
