package com.ch7;

public class Inher_01_Parent {

	int i = 10;
	
	public Inher_01_Parent() {
		System.out.println("부모클래스의 디펄트생성자가 호출되었습니다.");				
	}
	
	public void methodA() {
		System.out.println("부모클래스의 methodA가 호출되었습니다.");		
	}
	
	public void methodC() {
		System.out.println("부모클래스의 methodB가 호출되었습니다.");				
	}
	
}
