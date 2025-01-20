package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.EmployeesMapper;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;
import com.example.demo.insa.service.JobsDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

	private final EmployeesMapper employeesMapper;

	@Override
	public List<EmployeesDTO> getList() {
		return employeesMapper.getList();
	}

	@Override
	public void register(EmployeesDTO employees) {
		employeesMapper.insert(employees);
	}

	@Override
	public List<JobsDTO> getJobList() {
		return employeesMapper.getJobList();
	}

	@Override
	public boolean remove(Long employeeId) {
		return employeesMapper.delete(employeeId)==1 ? true : false;
	}

	@Override
	public EmployeesDTO getOne(Long employeeId) {
		return employeesMapper.getOne(employeeId);
	}

}
