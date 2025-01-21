package com.example.demo.book.service;

import java.util.List;

public interface BooksService {
	
	// 전체조회
	public List<BooksDTO> getList();
	
	// 단건조회
	public BooksDTO getOne(Long bookNo);
	
	public void register(BooksDTO books);
	
	public List<RentsDTO> getRentList();
	
	public boolean remove(Long bookNo);
	
	public boolean modify(BooksDTO books);
	
//	public BooksDTO getNo();
}
