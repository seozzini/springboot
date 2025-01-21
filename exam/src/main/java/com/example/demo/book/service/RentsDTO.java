package com.example.demo.book.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentsDTO {
	private Long rentNo;
	private Long bookNo;
	private Long rentPrice;
	private Date rentDate;
	private int rentStatus;
}
