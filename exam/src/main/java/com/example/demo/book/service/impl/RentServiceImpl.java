package com.example.demo.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.book.mapper.RentsMapper;
import com.example.demo.book.service.RentService;
import com.example.demo.book.service.RentsDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService{

	private final RentsMapper rentsMapper;
	
	@Override
	public List<RentsDTO> getList() {
		return rentsMapper.getList();
	}

}
