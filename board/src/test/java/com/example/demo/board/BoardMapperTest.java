package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardMapperTest {
	
	@Autowired BoardMapper boardMapper;
	
	//@Test
	@DisplayName("게시글 등록")
	public void testRegister() {
		//given (변수선언)
		BoardDTO board = BoardDTO.builder()
	   						   	 .title("등록")
								 .content("내용")
								 .writer("작성자")
							   	 .build();
		//when (매퍼서비스 부르기)
		int cnt = boardMapper.insert(board);
		//then (assert 테스트 통과여부)
		log.info("INSERT COUNT: " + cnt);
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 수정")
	public void testModify() {
		//given
		//실행전 존재하는 번호인지 확인할 것
		BoardDTO board = BoardDTO.builder()
							     .bno(27L)
				                 .title("등록했당")
				                 .content("내용이당")
				                 .writer("작성자당")
				                 .build();
		//when
		int cnt = boardMapper.update(board);
		//then
		log.info("UPDATE COUNT: " + cnt);
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 삭제")
	public void testRemove() {
		//given
		//실행전 존재하는 번호인지 확인할 것
		Long bno = 27L; 
		//when
		int cnt = boardMapper.delete(bno);
		//then
		log.info("DELETE COUNT: " + cnt);
		assertThat(cnt).isEqualTo(cnt);
	}
	
	//@Test
	@DisplayName("게시글 단건조회")
	public void testGet() {
		//given
		Long bno = 1L;
		//when
		BoardDTO board = boardMapper.read(bno);
		//then
		log.info(board.toString());
		assertThat(bno).isEqualTo(board.getBno());
		assertThat(board).isNotNull();
	}
	
	@Test
	@DisplayName("게시글 전체조회")
	public void testGetList() {
		//given
		BoardSearchDTO search = new BoardSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		//when
		List<BoardDTO> list = boardMapper.getList(search);
		//then
		list.forEach(board -> log.info(board.toString()));
		assertThat(list).isNotNull();
		
	}
	
}
