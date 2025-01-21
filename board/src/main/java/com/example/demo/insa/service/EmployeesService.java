package com.example.demo.insa.service;

import java.util.List;

public interface EmployeesService {
	
	// 전체조회
	public List<EmployeesDTO> getList();
	
	// 단건조회
	public EmployeesDTO getOne(Long employeeId);
	
	public void register(EmployeesDTO employees);
	
	public List<JobsDTO> getJobList();
	
	public boolean remove(Long employeeId);
	
	public boolean modify(EmployeesDTO employees);
	
}
