package com.example.demo.dept;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/dept") //모든 경로 앞 dept붙이려면
@Controller //필수
public class DeptController {
	@GetMapping("/list")  //list 없으니까 만들어서 넘겨보자
	public void list(Model model) {
		ArrayList<DepartmentsDto> list = new ArrayList<>();
		list.add(DepartmentsDto.builder().departmentId("10").departmentName("기획").build());
		list.add(DepartmentsDto.builder().departmentId("20").departmentName("개발").build());
		model.addAttribute("list", list);
	}
	
	@GetMapping("/info")
	public void info() {
	}
	
	@GetMapping("/update")
	public void update() {
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "dept/insert"; // 폴더명/페이지명 (같으면 void 후 생략)
	}
	
	@PostMapping("/insert")
	public String insertProc(DepartmentsDto dto) {
		log.debug("dto:" + dto);
		return "redirect:/dept/list"; 
	}

}
