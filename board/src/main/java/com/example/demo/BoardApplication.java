package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.**.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true) 
public class BoardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
