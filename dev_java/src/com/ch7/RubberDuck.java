package com.ch7;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
	}
	public void swimming(int x) {	
	}
	@Override
	public void display() {
		System.out.println("���� �������Դϴ�.");
	}

}