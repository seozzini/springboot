package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로그용
@Controller //빈등록. 서블릿 커맨드
@RequestMapping("/sample")	
public class SampleController {
	
	//Logger log = LoggerFactory.getLogger(getClass());
	
	@ModelAttribute("dept")
	public List<String> deptList(){
		return Arrays.asList("기획","개발","인사");
	}
	
	//
	@GetMapping("/ex04")
	public ModelAndView ex04(@ModelAttribute(name="todo") TodoDTO dto) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());
		log.debug("todoDTO" + dto);
		return mv;
	}
	
	//DateTimeFormat
	@GetMapping("/ex03")
	public String ex03(@ModelAttribute(name="todo") TodoDTO dto, Model model) {
		model.addAttribute("serverTime", new Date());
		log.debug("todoDTO" + dto);
		return "sample"; //포워드 기능: request가 view 페이지에 전달
	}
	
	//객체 리스트
	@PostMapping("/ex02Bean")
	public String ex02Bean(SampleDtoList dtoList){
		log.debug("dtoList: " + dtoList);
		return "sample";
	}
	
	//리스트, 배열처리
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam List<String> hobby){
		log.debug("hobby:" + hobby);
		return "sample";
	}
	
	
	//파라미터 값 따로따로받기
	@GetMapping("/ex02")
	public String ex02(@RequestParam(name="username") String name,
			           @RequestParam(required = false, defaultValue = "5") int age){
		//String name = request.getParameter("username")
		//if null ==> 초기값지정 (이것도 어노테이션 안에서 가능)
		log.info("name:" + name);
		log.info("age:" + age);
		return "sample";
	}
	
	//커맨드 객체로 받기
	@GetMapping("/ex01")
	public String ex01(SampleDto dto) {
		log.debug(dto.toString());
		return "sample";
	}

	
	@GetMapping("a")
	//@RequestMapping(value =  "a", method = { RequestMethod.GET,RequestMethod.POST })
	public String main() {
		log.info("sample a");
		return "sample";
	}
	@GetMapping("b")
	public String basicb() {
		log.info("sample b");
		return "sample";
	}
	

}
