package com.example.demo.board.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//단건조회
		UserDTO userDTO = userMapper.getUser(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException("id check");
		}
		System.out.println("userDTO:" + userDTO);
		//List<GrantedAuthority> role = new ArrayList<>();
		//userDTO.getRoles().forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())));
		//return new User(userDTO.getLoginId(), userDTO.getPassword(), role );
		return new CustomUser(userDTO);
	}

}
