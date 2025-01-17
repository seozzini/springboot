package com.example.demo.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/replies/*")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService service;

	/*
	 * 
	 * //등록페이지로 이동
	 * 
	 * @GetMapping("/register") public void register(ReplyDTO reply) {}
	 * 
	 * //등록처리
	 * 
	 * @PostMapping("/register") //등록처리: 등록요청 호출(파라미터 가지고) public String
	 * register(@Validated ReplyDTO reply, BindingResult bindingResult,
	 * RedirectAttributes rttr) { if(bindingResult.hasErrors()) { //유효성체크값에 하나라도 에러가
	 * 있으면 return "reply/register"; // 폴더명/파일명 } log.info("register: " + reply);
	 * service.register(reply);
	 * 
	 * rttr.addFlashAttribute("result", true); rttr.addFlashAttribute("message","등록"
	 * ); return "redirect:/reply/list"; //위에 다 처리하고, redirect 만나면 재요청하라는 302와 주소를
	 * 보냄. client는 board/list 재요청 }
	 * 
	 * //수정처리
	 * 
	 * @PutMapping({"/{rno}"}) public String modify(@RequestBody ReplyDTO replyDTO,
	 * 
	 * @PathVariable(name="rno") Long rno) { replyDTO.setRno(rno); return "success";
	 * }
	 * 
	 * @PostMapping("/modify") //수정요청 호출(파라미터 가지고) public String modify(Long rno,
	 * ReplyDTO reply, RedirectAttributes rttr) { log.info("modify: " + reply);
	 * service.modify(reply);
	 * 
	 * rttr.addFlashAttribute("result", true); rttr.addFlashAttribute("message","수정"
	 * ); return "redirect:/reply/list"; //위에 다 처리하고, redirect 만나면 재요청하라는 302와 주소를
	 * 보냄. client는 board/list 재요청 }
	 */

	// 등록처리
	@PostMapping({ "/new" })
	public ReplyDTO regiter(@RequestBody ReplyDTO dto) {
		service.register(dto);
		return dto;
	}

	// 수정처리
	@PutMapping("/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyDTO dto, @PathVariable(name = "rno") Long rno) {
		dto.setRno(rno);
		return service.modify(dto) == true
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 삭제처리 localhost:81/replies/5
	@DeleteMapping({ "/{rno}" })
	public String remove(@PathVariable(name = "rno") Long rno) {
		service.remove(rno);
		return "success";
	}

	// 단건조회
	@GetMapping({ "/{rno}" })
	public ReplyDTO get(@PathVariable("rno") Long rno) {
		return service.get(rno);
	}

	// 댓글 목록 조회
	// localhost:81/replies/pages/2(게시글번호)/1(페이지번호)
	@GetMapping("/pages/{bno}/{page}")
	public ReplyPageDTO getList(@PathVariable(name = "page") int page, @PathVariable(name = "bno") Long bno) {
		ReplySearchDTO replySearchDTO = new ReplySearchDTO(page, 3);

		return service.getList(replySearchDTO, bno);
	}

}
