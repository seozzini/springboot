package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesSearchDTO;


public interface EmployeesMapper {
	EmployeesDTO read(int employeeId);
	List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO);
	int getCount(EmployeesSearchDTO searchDTO);
}
