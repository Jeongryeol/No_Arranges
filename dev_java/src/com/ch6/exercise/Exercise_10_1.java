package com.ch6.exercise;

public class Exercise_10_1 {

	public static void main(String[] args) {
		
		int i = 5;
		Integer ig = new Integer(5);
		String s = new String("5");
		String u_id = "test";
	
		if(i==5) {
			System.out.println("같다");
		}

//		if(i==s) { 원시형 타입과 클래스 타입은 같이 비교불가함.
		if(i==ig) {
			
		}
		if(u_id.equals("test")) {//equals 각 주소번지가 가르키는 값을 나타냄
			System.out.println("아이디가 일치해요");
		}
	
	}
}
