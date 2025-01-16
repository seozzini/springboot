package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Service //bean 등록, 그래야 컨트롤러가 꺼내쓸 수 있음
//@AllArgsConstructor  //모든 필드를 초기화해주는 생성자
@RequiredArgsConstructor  //final 붙은 아이만 초기화해줌
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper mapper;

	@Override
	public boolean register(ReplyDTO vo) {
		// TODO Auto-generated method stub
		return false;
	}
	


	@Override
	public boolean modify(ReplyDTO reply) {
		return mapper.update(reply) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long rno) {
		return mapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public ReplyDTO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch,Long bno) {
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getList(replySearch, bno)
				);
				
	}




}
