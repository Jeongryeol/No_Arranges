package com.ch15;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ScannerURL {

	public static void main(String[] args) {
		URLConnection urlCon = null;
		URLConnection urlCon2 = null;
		Scanner scan = null;
		try {
			//지정한 URL로의 연결을 생성
			//urlCon	= new URL("http://192.168.0.230:9000/datagrid/datagridEmp.jsp")
			//				.openConnection();
			urlCon2	= new URL("http://www.10X10.co.kr")
					.openConnection();
			
			//URL연결객체로 입력스트림 객체를 읽어서 담음
			scan = new Scanner(urlCon2.getInputStream());
			
			//담은 객체의 문자를 끝까지 읽으라는 정규표현식
			scan.useDelimiter("\\Z");
			
			//읽은 객체의 완료된 토큰을 String타입으로 담음
			String text = scan.next();
			//출력
			System.out.println(text);
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}

}
