package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service //bean 등록, 그래야 컨트롤러가 꺼내쓸 수 있음
//@AllArgsConstructor  //모든 필드를 초기화해주는 생성자
@RequiredArgsConstructor  //final 붙은 아이만 초기화해줌
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;
	private final ReplyMapper replyMapper;

	@Override
	public void register(BoardDTO board) {
		boardMapper.insert(board);
		
	}

	@Override
	public boolean modify(BoardDTO board) {
		return boardMapper.update(board) == 1 ? true : false;
	}

	@Override
	@Transactional //하나라도 에러나면 rollback 모두 실행되면 commit
	public boolean remove(Long bno) {
		//댓글 삭제
		replyMapper.deleteByBno(bno);

		//게시글 삭제
		return boardMapper.delete(bno) == 1 ? true : false;
	}

	@Override
	public BoardDTO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public List<BoardDTO> getList(BoardSearchDTO searchDTO) {
		return boardMapper.getList(searchDTO);
	}
	
	@Override
	public int getCount(BoardSearchDTO searchDTO) {
		return boardMapper.getCount(searchDTO);
	}

}
