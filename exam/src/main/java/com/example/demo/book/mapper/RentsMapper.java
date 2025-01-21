package com.example.demo.book.mapper;

import java.util.List;

import com.example.demo.book.service.BooksDTO;
import com.example.demo.book.service.RentsDTO;


public interface RentsMapper {
	//전체 조회
	List<RentsDTO> getList();
}
