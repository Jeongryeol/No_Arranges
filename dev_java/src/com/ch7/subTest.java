package com.ch7;

public class subTest extends test {

	public subTest() {
		System.out.println("subTest의 디펄트생성자가 호출되었습니다.");
	}
	
	public subTest(subTest sb) {
		if(sb instanceof test) {
			System.out.println("True :: suTest형 sb는 test클래스의 instance로, 형변환이 가능합니다.");
		} else {
			System.out.println("False :: suTest형 sb는 test클래스의 instance가 안 됩니다.");
		}
	}
	
	public static void main(String[] args) {
		test t = new subTest();
		t.toString();
		subTest sb = new subTest();
		t = new subTest(sb);
		
	}
}
