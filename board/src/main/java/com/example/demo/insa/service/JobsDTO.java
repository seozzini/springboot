package com.example.demo.insa.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class JobsDTO {
	private String jobId;
	private String jobTitle;
	private Long minSalary;
	private Long maxSalary;

}
