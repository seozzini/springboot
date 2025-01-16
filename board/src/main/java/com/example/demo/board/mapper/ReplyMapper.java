package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplySearchDTO;

public interface ReplyMapper {
	public int insert(ReplyDTO reply); //int (리턴타입,parameterType 건수가져옴) //boardDto 결과,resultType 
	public int update(ReplyDTO reply);
	public int delete(Long rno);
	public ReplyDTO read(Long rno);
	public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri, 
								  @Param("bno") Long bno);
	int getCountByBno(Long bno);
}
