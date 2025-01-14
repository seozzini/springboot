package com.example.demo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
	private Date dueDate;

}
