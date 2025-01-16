package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardServiceTest {
	@Autowired //알아서 인터페이스 구현클래스 찾아서 주입해줌
	BoardService boardService;

    @Test
    @DisplayName("게시글 수정")
    void update() {
		//given
		//실행전 존재하는 번호인지 확인할 것
		BoardDTO board = BoardDTO.builder()
							     .bno(5L)
				                 .title("서비스수정1")
				                 .content("수정된 내용1")
				                 .writer("user01")
				                 .build();
		//when
		boolean result = boardService.modify(board);
		//then
		log.info("UPDATE COUNT: " + result);
		assertThat(result).isEqualTo(true);
	}
}
