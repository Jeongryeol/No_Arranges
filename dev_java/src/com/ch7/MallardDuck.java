package com.ch7;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new FlyWithWing();
	}//날아가는 기능이 구현하기위해 구현체클래스를 갈아탐
	@Override
	public void display() {
		System.out.println("나는 청둥오리입니다.");
	}

}
