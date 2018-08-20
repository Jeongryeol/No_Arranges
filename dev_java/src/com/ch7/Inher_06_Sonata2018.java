package com.ch7;

public class Inher_06_Sonata2018 extends Inher_06_Sonata {
	//선언부
	public String carName  = null;
	public String carColor = null;
	//생성자
	public Inher_06_Sonata2018() {
		System.out.println("Sonata() 호출성공");		
	}
	public Inher_06_Sonata2018(int speed) {
		super(50);//조상클래스의 생성자를 호출하는 경우, 반드시 먼저 써야함
		System.out.println("Sonata(int speed) 호출성공");
		this.speed = speed;
		int speed2 = super.speed;
	}
	//사용자메소드
	public void cruise() {
		
	}
	@Override
	public void speedUp() {
		
	}
	@Override
	public void speedDown() {
		
	}
}
