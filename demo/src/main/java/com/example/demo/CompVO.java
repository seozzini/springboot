package com.example.demo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompVO {
	List<Ticket> list;
	SampleVO sample;
	int cnt;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul" )
	Date regdate;
	
}

