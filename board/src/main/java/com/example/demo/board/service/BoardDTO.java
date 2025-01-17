package com.example.demo.board.service;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	 private Long bno;
	 @NotBlank(message = "이름을 입력하세요")
	 private String title;
	 @NotBlank(message = "제목을 입력하세요")
	 private String content;
	 @NotBlank(message = "내용을 입력하세요")
	 private String writer;
	 private Date regdate;
	 
	 private int replyCnt;
	 
	 //@Pattern("0\\d{3,4}-") 정규표현식 패턴검사 가능
}
