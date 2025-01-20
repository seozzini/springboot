package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.RoleDTO;
import com.example.demo.board.service.UserDTO;



public interface UserMapper {
	UserDTO getUser(String loginId);
	List<RoleDTO> getRole(Long id);
}
