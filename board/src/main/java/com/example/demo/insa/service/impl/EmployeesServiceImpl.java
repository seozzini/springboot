package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.EmployeesMapper;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesSearchDTO;
import com.example.demo.insa.service.EmployeesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

	private final EmployeesMapper employeeMapper;

	@Override
	public EmployeesDTO get(int employeeId) {
		return employeeMapper.read(employeeId);

	}

	@Override
	public List<EmployeesDTO> getList(EmployeesSearchDTO searchDTO) {
		return employeeMapper.getList(searchDTO);
	}

}
