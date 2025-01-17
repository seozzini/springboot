package com.example.demo.board.service;

import java.util.List;

import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCnt;
	Paging paging;
	private List<ReplyDTO> list;

}