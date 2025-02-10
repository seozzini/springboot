package com.example.demo;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	public void fileTest() {
		//File file = new File("c:/Temp/a.txt");
		//file.delete();
		//System.out.println(file.length()); 
		
		//File folder = new File("c:/Temp/txt");
		//folder.mkdir();
		
		//폴더 목록 읽기
		File file = new File("c:/Users");
		String [] list = file.list();
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
}
