package com.ch7;

public abstract class Duck {

	int leg = 2;
	int eye = 2;
	final int wings = 2;
	
	//인터페이스를 적용할 때 null이 맞을까? 인스턴스화를 해야할까?
	//날수있다 없다는 일반클래스(구현체클래스)에서 결정될 문제이므로, 선언만  해두고 구현체클래스에서 결정하자
/*	FlyBehavior flyBehavior = new FlyBehavior();
	FlyBehavior flyBehavior = new FlyNoWay();*/
	FlyBehavior flyBehavior = null;
	QuaekBehavior queakBehavior = null;
	
	public Duck() {//추상클래스는 생성자를 가질 수 있다.
		
	}
	public abstract void display();//추상클래스는 추상메소드를 가질 수 있다.
	
	public void swimming() {//추상클래스는 일반메소드를 가질 수 있다.
		System.out.println("모든 오리는 물 위에 뜬다.");
	}
	public void performFly() {
		flyBehavior.fly();
	}
	public void performGuaek() {
		queakBehavior.guaek();
	}
}
