package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;


public interface EmpMapper {
	EmpDTO read(int employeeId);
	List<EmpDTO> getList(EmpSearchDTO searchDTO);
	int getCount(EmpSearchDTO searchDTO);
}
