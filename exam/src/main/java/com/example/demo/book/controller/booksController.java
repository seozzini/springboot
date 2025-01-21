package com.example.demo.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.book.service.BooksDTO;
import com.example.demo.book.service.BooksService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/book/*")
public class booksController {
	
	private final BooksService booksService;
	
	//전체조회
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	
	//전체조회
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", booksService.getList());
	}
	
	//단건조회
	@GetMapping("/read")
	public void read(@RequestParam(name="bookNo") Long bookNo, Model model) {
		model.addAttribute("books", booksService.getOne(bookNo));
	}
	
	// 대여현황조회
	@GetMapping("/rentList")
	public void rentList (Model model) {
		model.addAttribute("list", booksService.rentList());
	}
	
	//수정페이지
	@GetMapping("/modify")
	public void modify(@RequestParam(name="bookNo") Long bookNo, Model model) {
		BooksDTO books = booksService.getOne(bookNo);
		model.addAttribute("books", books);
	}
	
	//수정처리
	@PostMapping("/modify") //수정요청 호출(파라미터 가지고)
	public String modify(@RequestParam(name="bookNo") Long bookNo, BooksDTO books, RedirectAttributes rttr) {
		log.info("modify: " + books);
		booksService.modify(books);
		
		rttr.addFlashAttribute("result", true);
		rttr.addFlashAttribute("message","수정" );
		return "redirect:/book/list"; //위에 다 처리하고, redirect 만나면 재요청하라는 302와 주소를 보냄. client는 board/list 재요청 
	}
	
	//job
	@GetMapping("/register")
	public void register(Model model, BooksDTO books) {
		//model.addAttribute("bookNo", booksService.getNo());
		//books = booksService.getNo();
		//System.out.println("books : "+books.toString());
	}
	
	//등록처리
	@PostMapping("/register")
	public String register(@Validated BooksDTO books,
	                       BindingResult bindingResult,
	                       RedirectAttributes rttr,
	                       Model model) {

	    if (bindingResult.hasErrors()) {
	        model.addAttribute("booksDTO", books);
	        return "book/register";
	    }

	    booksService.register(books);

	    rttr.addFlashAttribute("result", true);
	    rttr.addFlashAttribute("message", "등록 성공");
	    return "redirect:/book/list";
	}
	
//삭제
@GetMapping("/delete")
public String remove(@RequestParam(name="bookNo") Long bookNo,
				   RedirectAttributes rttr) {
	booksService.remove(bookNo);
	rttr.addFlashAttribute("result", true);
	
	return "redirect:/book/list";
}

}
