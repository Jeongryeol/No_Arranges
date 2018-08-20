package com.ch6;

public class Sonata {

	public String carColor = null;
	public int speed = 0;
	public int wheelNum = 0;
	
	public Sonata() {}
	
	public Sonata(String carColor, int speed, int wheelNum) {
		this.carColor = carColor;
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	
	public static void main(String[] args) {
		Sonata myCar = new Sonata("white",0,4);
		System.out.println(myCar.carColor+", "+myCar.speed+", "+myCar.wheelNum);
	}
}
