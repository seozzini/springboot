package com.example.demo.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooksDTO {
	private Long bookNo;        	//도서번호
	@NotBlank(message = "도서명이 입력되지 않았습니다.")
	private String bookName;        //도서명
	private String bookCoverimg;    //이미지경로
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookDate;			//날짜
	private Long bookPrice;  		//가격
	private String bookPublisher;   //출판사
	private String bookInfo;		//책정보
	
	private int totalPrice;			// 대여총계
	private int rentCount;			// 대여횟수
}
