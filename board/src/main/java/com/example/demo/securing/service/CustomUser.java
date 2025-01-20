package com.example.demo.securing.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomUser implements UserDetails {

	UserDTO userDTO;
	
	@Override
	public boolean isAccountNonExpired() {
		// 패스워드 사용불가 => 패스워드 변경해야함
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 로그인 시도회수 초과되어서 계정 잠금
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 휴면계정, 블랙리스트 경우 로그인 불가
		return true;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userDTO.getRoles()
				      .stream()
				      .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
				      .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return userDTO.getPassword();
	}

	@Override
	public String getUsername() {
		return userDTO.getLoginId();
	}

}
