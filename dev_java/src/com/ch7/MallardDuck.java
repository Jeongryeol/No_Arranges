package com.ch7;

public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new FlyWithWing();
	}//���ư��� ����� �����ϱ����� ����üŬ������ ����Ž
	@Override
	public void display() {
		System.out.println("���� û�տ����Դϴ�.");
	}

}
