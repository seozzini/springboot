package com.example.demo.board.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReplyDTO {
	
	private Long rno;        //댓글번호
	private Long bno;        //게시글번호
	private String reply;      //댓글내용
	private String replyer;    //댓글작성자
	private Date replydate;  //작성일자

}
