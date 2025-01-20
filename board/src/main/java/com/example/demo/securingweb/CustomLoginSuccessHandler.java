package com.example.demo.securingweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.securing.service.CustomUser;
import com.example.demo.securing.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			                            HttpServletResponse response,
			                            Authentication auth) throws IOException, ServletException {
		
		//단건조회(auth 에서 꺼내쓰면 됨)
		UserDTO dto = ((CustomUser)auth.getPrincipal()).getUserDTO();
		
		//session 에 직접 값 담기
		request.getSession().setAttribute("userId", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		request.getSession().setAttribute("fullName", dto.getFullName());
		
		//username, role 정보 받을 수 있음.
		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("roleName:" + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/emp/list");
			return;
		} else if (roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/board/list");
			return;
		} 
		response.sendRedirect("/");
		
	}

}
