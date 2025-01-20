package com.example.demo.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/home")
	public void home() {
		
		//log.info("userDetail: " + userDetails.getUserDTO().getDeptName());
		log.info("session : " + session.getAttribute("deptName"));
	}
}
