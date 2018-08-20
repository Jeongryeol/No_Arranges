package com.ch7;

public class Inher_03_Suv {
	//선언부
	int speed 	 = 0;
	int wheelNum = 0;	
	//메소드
	public void speedUp() {
		speed++;
		System.out.println("car.speed = "+speed);
		System.out.println("SUV ++");
	}
	public void speedDown() {
		speed--;
		System.out.println("car.speed = "+speed);
		System.out.println("SUV --");
	}
}
