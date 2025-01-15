package com.example.demo.board.service;

import lombok.Data;

@Data
public class BoardSearchDTO {
	int start;      // 시작 페이지
	int end;        // 끝 페이지
	
	int pageUnit;   // 한페이지 보여줄 게시물수
	String type;    // 검색타입
	String keyword; // 검색 키워드
	
	public String[] getTypeArr() { //읽을때 typeArr 필드로
		return type == null ?  new String[] {} : type.split("");
	}
}
