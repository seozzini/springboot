package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.BoardDto;

public interface BoardMapper {
	int insert(BoardDto boardDto); //int (리턴타입,parameterType 건수가져옴) //boardDto 결과,resultType 
	int update(BoardDto boardDto);
	int delete(Long bno);
	BoardDto read(Long bno);
	List<BoardDto> getList();
}
