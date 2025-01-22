package com.example.demo.posts.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsAPIController {
	
	final PostService postService;
	
	//등록
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto dto) {
		
		postService.Save(dto);
		return dto;
	}
	
	//수정
	@PutMapping("/api/v1/posts/${id}")
	public PostsUpdateRequestDto update(@PathVariable(name="id") Long id, 
			           @RequestBody PostsUpdateRequestDto dto) {
		postService.update(id, dto);
		return dto;
	}
	
	//삭제
	//@DeleteMapping("/api/v1/posts/${id}")
	//public 
}
