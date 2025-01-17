package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service //bean 등록, 그래야 컨트롤러가 꺼내쓸 수 있음
//@AllArgsConstructor  //모든 필드를 초기화해주는 생성자
@RequiredArgsConstructor  //final 붙은 아이만 초기화해줌
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper mapper;
	private final BoardMapper boardMapper;

	@Transactional
	@Override
	public boolean register(ReplyDTO vo) {
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo) == 1 ? true : false;
	}

	@Override
	public boolean modify(ReplyDTO vo) {
		return mapper.update(vo) == 1 ? true : false;
	}

	@Transactional
	@Override
	public boolean remove(Long rno) {
		ReplyDTO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public ReplyDTO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch,Long bno) {
		Paging paging = new Paging();
		int cnt = mapper.getCountByBno(bno);
		
		//paging - 전체건수, pageUnit, page
		paging.setPage(replySearch.getPage());
		paging.setPageUnit(replySearch.getAmount());
		paging.setTotalRecord(cnt);
		
		return new ReplyPageDTO(
				cnt,
				paging,
				mapper.getList(replySearch, bno));
				
	}

}
