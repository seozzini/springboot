package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;

public interface BoardMapper {
	int insert(BoardDTO boardDto); //int (리턴타입,parameterType 건수가져옴) //boardDto 결과,resultType 
	int update(BoardDTO boardDto);
	int delete(Long bno);
	BoardDTO read(Long bno);
	List<BoardDTO> getList(BoardSearchDTO searchDTO);
	int getCount(BoardSearchDTO searchDTO);
	void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
