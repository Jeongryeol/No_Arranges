package com.ch7;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new RubberDuck();//������ - FlyNoWay�ε�
		myDuck.performFly();
		myDuck.display();
		Duck herDuck = new MallardDuck();//������ - FlyWithWing�ε�
		herDuck.performFly();
		herDuck.display();
	}
}
