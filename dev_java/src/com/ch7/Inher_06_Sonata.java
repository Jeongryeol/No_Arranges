package com.ch7;

public class Inher_06_Sonata {
	//선언부
	public int speed	= 0;
	public int wheelNum = 0;
	//생성자
	public Inher_06_Sonata() {
		System.out.println("Sonata() 호출성공");		
	}
	public Inher_06_Sonata(int speed) {
		System.out.println("Sonata(int speed) 호출성공");
		this.speed = speed;
	}
	//사용자메소드
	public void speedUp() {
		
	}
	public void speedDown() {
		
	}
}
