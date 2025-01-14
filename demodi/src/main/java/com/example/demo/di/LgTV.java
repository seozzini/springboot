package com.example.demo.di;

import lombok.Data;

@Data
//@Component
public class LgTV implements TV {

	//1. 필드 주입 방법
	final Speaker speaker; //autowired할거면 final 넣으삼
	int price;
	
	/*
	//3. 생성자 주입 방법 : 권장
	//@Autowired(생성자 주입 시 생략 가능)
	public LgTV(Speaker speaker) {
		System.out.println("construction injection");
		this.speaker = speaker;
	}
	
	//2. setter 방법
	public void setSpeaker(Speaker speaker) {
		System.out.println("setter injection");
		this.speaker = speaker;
	}
	
	*/


	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}
	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		//System.out.println("LG TV--볼륨 up");
		speaker.volumeUp();
	}
	public void volumeDown() {
		//System.out.println("LG TV--볼륨 down");
		speaker.volumeDown();
	}
}
