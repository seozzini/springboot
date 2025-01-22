package com.example.demo.posts.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.posts.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//뷰페이지로 넘겨주는 메소드 모여있음
@RequiredArgsConstructor
@Controller
public class IndexController {

	//서비스 추가(인젝션)
	final PostService postService;
	
	@GetMapping("/") //조회페이지
	public String index(Model model) {
		//목록조회
		model.addAttribute("posts", postService.findAll());
		return "index";
	}
	
	@GetMapping("/save")
	public String save() {
		return "posts-insert";
	}
	
	@GetMapping("/update/{id}") //수정페이지
	public String update(Model model,
						 @PathVariable(name="id") Long id) {
		//단건조회(모델에 담아야함)
		log.info("id:::::::: "+id);
		model.addAttribute("post", postService.findById(id));
		return "posts-update";
	}
}
