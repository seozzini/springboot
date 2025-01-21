package com.example.demo.book.mapper;

import java.util.List;

import com.example.demo.book.service.BooksDTO;


public interface BooksMapper {
	//전체 조회
	List<BooksDTO> getList();
	
	//번호조회
	//public BooksDTO getNo();
	
	//단건 조회
	public BooksDTO getOne(Long bookNo);
	
	// 대여현황조회
	public List<BooksDTO> rentList();
	
	//등록
	int insert(BooksDTO booksDTO);

	
	//삭제
	public int delete(Long bookNo);
	
	//수정
	int update(BooksDTO booksDTO);
	
	
}
