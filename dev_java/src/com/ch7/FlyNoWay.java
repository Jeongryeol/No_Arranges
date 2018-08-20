package com.ch7;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("나는 날 수 없어요 ㅠㅠ");
	}

}
