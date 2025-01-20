package com.example.demo.securingweb;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.board.service.CustomUser;
import com.example.demo.board.service.UserDTO;



public class SecuUtil {
	public static UserDTO getUser() {
		Object obj= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO userDetails = null;
		System.out.println(obj);
		//if (! obj instanceof anony) {
		 userDetails = ((CustomUser)obj).getUserDTO();
		//}
		//else {
		//	userDetails = new UserDTO();}
		return userDetails;
		
	}
}
