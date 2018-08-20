package com.ch7;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new RubberDuck();//생성자 - FlyNoWay로딩
		myDuck.performFly();
		myDuck.display();
		Duck herDuck = new MallardDuck();//생성자 - FlyWithWing로딩
		herDuck.performFly();
		herDuck.display();
	}
}
