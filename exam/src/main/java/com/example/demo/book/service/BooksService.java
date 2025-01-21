package com.example.demo.book.service;

import java.util.List;

public interface BooksService {
	
	// 전체조회
	public List<BooksDTO> getList();
	
	// 단건조회
	public BooksDTO getOne(Long bookNo);

	// 대여현황조회
	public List<BooksDTO> rentList();
	
	//등록
	public void register(BooksDTO books);
	
	//삭제
	public boolean remove(Long bookNo);
	
	//수정
	public boolean modify(BooksDTO books);
	
//	public BooksDTO getNo();
}
