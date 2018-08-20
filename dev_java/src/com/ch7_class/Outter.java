package com.ch7_class;

public class Outter {

	int i = 10;
	public void go() {
		System.out.println("Outter go 메소드 호출성공");
	}
	
	class Inner{
		Inner(){//내부클래스의 생성자 선언 가능
			System.out.println("Inner생성자 호출성공");
		}
		public void come() {
			System.out.println("Inner come 메소드 호출성공");
		}
	}
}
