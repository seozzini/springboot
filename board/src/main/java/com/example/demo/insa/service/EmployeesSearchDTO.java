package com.example.demo.insa.service;

import lombok.Data;

@Data
public class EmployeesSearchDTO {
	int start;
	int end;
	
	int pageUnit;
	String type;
	String keyword;
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
