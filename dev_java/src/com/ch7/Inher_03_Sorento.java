package com.ch7;

public class Inher_03_Sorento extends Inher_03_Suv{
	//선언부
	String carColor = "Matt-Black";
	//메소드
	public void speedUp() {
		speed++;
		System.out.println("car.speed = "+speed);
		System.out.println("Sorento ++");
	}
	public void speedDown() {
		speed--;
		System.out.println("car.speed = "+speed);
		System.out.println("Sorento --");
	}
}
