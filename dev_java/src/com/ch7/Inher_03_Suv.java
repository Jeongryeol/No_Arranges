package com.ch7;

public class Inher_03_Suv {
	//�����
	int speed 	 = 0;
	int wheelNum = 0;	
	//�޼ҵ�
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
