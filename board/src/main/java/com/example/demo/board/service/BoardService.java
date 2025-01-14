package com.example.demo.board.service;

import java.util.List;

public interface BoardService {

	public void register(BoardDto board);
	
	public boolean modify(BoardDto board);
	
	public boolean remove(Long bno);
	
	public BoardDto get(Long bno);
	
	public List<BoardDto> getList();

}
