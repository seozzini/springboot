package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputStreamTest {
	
	//@Test
	public void test1() throws IOException {
		
		//키보드 입력을 파일로 저장(outputStream)
		FileOutputStream fw = new FileOutputStream("c:/Temp/a.txt");
		int readByte;
		while((readByte = System.in.read()) != -1) {  //콘솔 입력 후 종료 : ctrl+z
			fw.write(readByte);
		}
		fw.close();
	}
	
	//@Test
	@DisplayName("파일입력") //파일내용 콘솔에 출력
	public void test2() throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/a.txt");
		int readByte;
		while((readByte = fi.read()) != -1) {
			System.out.print((char)(readByte));
		}
		fi.close();
	}
	
	@Test
	@DisplayName("파일복사")
	public void test3() throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/a.txt");
		FileOutputStream fo = new FileOutputStream("c:/Temp/a2.txt");
		int readByte;
		while((readByte = fi.read()) != -1) {
			fo.write(readByte);
		}
		fi.close();
		fo.close();
	}

}
