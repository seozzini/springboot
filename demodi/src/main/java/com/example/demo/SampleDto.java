package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //생성자를 대신함(빌더쓸거면 아래 2개 같이 넣어주삼)
@NoArgsConstructor //기본 생성자(필요하면 아래꺼랑 세트임)
@AllArgsConstructor //모든 필드 초기화 생성자
public class SampleDto {
	
	private String name;
	private int age;
	private String tel;

}
