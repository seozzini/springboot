package com.example.demo.posts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//뷰페이지로 넘겨주는 메소드 모여있음
@Controller
public class IndexController {

	@GetMapping("/") //조회페이지
	public String index() {
		//목록조회
		return "index";
	}
	
	@GetMapping("/save")
	public String save() {
		return "posts-insert";
	}
	
	@GetMapping("/update") //수정페이지
	public String update() {
		//단건조회(모델에 담아야함)
		return "posts-update";
	}
}
