package com.example.demo.posts.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//수정은 제목, 내용 변경가능
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	private String title;
	private String content;

	@Builder // 값 초기화시켜주는 빌더
	public PostsUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
