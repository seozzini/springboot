package com.example.demo.dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsDto {

	private String departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;
}
