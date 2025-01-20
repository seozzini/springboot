package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//전체조회
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", employeesService.getList());
	}
	
	//단건조회
	@GetMapping("/read")
	public void read(@RequestParam(name="employeeId") Long employeeId, Model model) {
		model.addAttribute("employees", employeesService.getOne(employeeId));
	}
	
	//job
	@GetMapping("/register")
	public void register(Model model, EmployeesDTO employees) {
		model.addAttribute("jobList", employeesService.getJobList());
	}
	
	//등록
	@PostMapping("/register")
	public String register(@Validated EmployeesDTO employees,
						   BindingResult bindingResult,
			               RedirectAttributes rttr) {
		
		 if(bindingResult.hasErrors()) { return "emp/register"; }
		
		
		log.info("register" + employees);
		
		employeesService.register(employees);
		
		//rttr.addAttribute("result", true); //파라미터 붙어서 나오는거
		rttr.addFlashAttribute("result", true); //휘발성
		return "redirect:/emp/list";
	}
	
//삭제
@GetMapping("/delete")
public String remove(@RequestParam(name="employeeId") Long employeeId,
				   RedirectAttributes rttr) {
	employeesService.remove(employeeId);
	rttr.addFlashAttribute("result", true);
	
	return "redirect:/emp/list";
}

}
