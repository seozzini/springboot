package com.example.demo.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/list")
	public void list(Model model, 
			         BoardSearchDTO searchDTO,
			         Paging paging) {
		
		log.info("list");
		
		//페이징처리
		paging.setTotalRecord(service.getCount(searchDTO));
		
		//목록 조회
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		model.addAttribute("list", service.getList(searchDTO));
	}
	
	//등록페이지로 이동
	@GetMapping("/register")
	public void register(BoardDTO board) {}
	
	//등록처리
	@PostMapping("/register") //등록처리: 등록요청 호출(파라미터 가지고)
	public String register(@Validated BoardDTO board,
			               BindingResult bindingResult,
			               RedirectAttributes rttr) {
		if(bindingResult.hasErrors()) { //유효성체크값에 하나라도 에러가 있으면
			return "board/register"; // 폴더명/파일명
		}
		log.info("register: " + board);
		service.register(board);
		
		//rttr.addAttribute("result", true); //파라미터 붙어서 나오는거
		rttr.addFlashAttribute("result", true); //휘발성
		rttr.addFlashAttribute("message","등록" );
		return "redirect:/board/list"; //위에 다 처리하고, redirect 만나면 재요청하라는 302와 주소를 보냄. client는 board/list 재요청 
	}
	
	@GetMapping({"/modify","/get"})
	public void modify(@RequestParam Long bno, Model model) {
		BoardDTO board = service.get(bno);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/modify") //수정요청 호출(파라미터 가지고)
	public String modify(Long bno, BoardDTO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		service.modify(board);
		
		rttr.addFlashAttribute("result", true);
		rttr.addFlashAttribute("message","수정" );
		return "redirect:/board/list"; //위에 다 처리하고, redirect 만나면 재요청하라는 302와 주소를 보냄. client는 board/list 재요청 
	}
	
	@GetMapping("/remove") //삭제요청 호출(파라미터 가지고)
	public String remove(@RequestParam Long bno, RedirectAttributes rttr) {
		log.info("remove: " + bno);
		service.remove(bno);
		
		//rttr.addAttribute("result", true); = 사라지지않고 계속 남아있음
		rttr.addFlashAttribute("result", true); // 휘발성으로 한번만 출력되고 새로고침되면 사라짐
		rttr.addFlashAttribute("message","삭제" );
		return "redirect:/board/list"; //위에 다 처리하고, redirect 만나면 재요청하라는 302와 주소를 보냄. client는 board/list 재요청 
	}
	
	@GetMapping("/home")
	public void home() {
		
	}
	
	@GetMapping("/login")
	public void login() {
		
	}

}
