package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.common.Paging;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmployeesController {
	
	private final EmployeesService employeesService;
	
	@GetMapping("/list")
	public List<EmployeesDTO> list(Model model,
								   BoardSearchDTO searchDTO,
								   Paging paging) {
		return employeesService.getList(null);
	}
	
	//등록페이지로 이동
	@GetMapping("/register")
	public void register(EmployeesDTO emp) {}

}
