package com.ch7;

public abstract class Duck {

	int leg = 2;
	int eye = 2;
	final int wings = 2;
	
	//�������̽��� ������ �� null�� ������? �ν��Ͻ�ȭ�� �ؾ��ұ�?
	//�����ִ� ���ٴ� �Ϲ�Ŭ����(����üŬ����)���� ������ �����̹Ƿ�, ����  �صΰ� ����üŬ�������� ��������
/*	FlyBehavior flyBehavior = new FlyBehavior();
	FlyBehavior flyBehavior = new FlyNoWay();*/
	FlyBehavior flyBehavior = null;
	QuaekBehavior queakBehavior = null;
	
	public Duck() {//�߻�Ŭ������ �����ڸ� ���� �� �ִ�.
		
	}
	public abstract void display();//�߻�Ŭ������ �߻�޼ҵ带 ���� �� �ִ�.
	
	public void swimming() {//�߻�Ŭ������ �Ϲݸ޼ҵ带 ���� �� �ִ�.
		System.out.println("��� ������ �� ���� ���.");
	}
	public void performFly() {
		flyBehavior.fly();
	}
	public void performGuaek() {
		queakBehavior.guaek();
	}
}
