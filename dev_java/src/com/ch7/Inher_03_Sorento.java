package com.ch7;

public class Inher_03_Sorento extends Inher_03_Suv{
	//�����
	String carColor = "Matt-Black";
	//�޼ҵ�
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
