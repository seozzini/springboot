package com.example.demo.insa.service;

import java.util.List;

public interface EmployeesService {

	public EmployeesDTO get(int employeeId);
	
	public List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO);
}
