package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LambdaTest {

	@Test
	public void sort() {
		List<SampleVO> list = Arrays.asList(
				new SampleVO("홍길동",10),
				new SampleVO("김유신",20),
				new SampleVO("최기자",15));
		//Collections.sort(list, new SampleCompare());
		
		//익명클래스 (객체생성, 선언 동시에)
		Collections.sort(list, new Comparator<SampleVO>() {

			@Override
			public int compare(SampleVO o1, SampleVO o2) {
				return o1.age - o2.age;
			}});
		System.out.println(list);
		
		//익명클래스를 람다식으로
		Collections.sort(list, (SampleVO o1, SampleVO o2) -> {
				return o1.age - o2.age;
			});
		System.out.println(list);
		
	}
}

class SampleCompare implements Comparator<SampleVO> {

	@Override
	public int compare(SampleVO o1, SampleVO o2) {
		//나이
		//return o1.age - o2.age; //오름차순
		//return o2.age - o1.age; //내림차순
		
		//이름
		//return o1.getName().compareTo(o2.getName()); //오름차순
		return o2.getName().compareTo(o1.getName()); //내림차순
	}
	
}