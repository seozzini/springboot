package com.example.demo.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.book.mapper.BooksMapper;
import com.example.demo.book.service.BooksDTO;
import com.example.demo.book.service.BooksService;
import com.example.demo.book.service.RentsDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
	
	private final BooksMapper booksMapper;
	
	@Override
	public List<BooksDTO> getList() {
		return booksMapper.getList();
	}

	@Override
	public BooksDTO getOne(Long bookNo) {
		return booksMapper.getOne(bookNo);
	}

	@Override
	public void register(BooksDTO books) {
		booksMapper.insert(books);
	}

	@Override
	public List<RentsDTO> getRentList() {
		return booksMapper.getRentList();
	}

	@Override
	public boolean remove(Long bookNo) {
		return booksMapper.delete(bookNo) == 1 ? true : false;
	}

	@Override
	public boolean modify(BooksDTO books) {
		return booksMapper.update(books) == 1 ? true : false;
	}

//	@Override
//	public BooksDTO getNo() {
//		return booksMapper.getNo();
//	}


}
