package com.ch7;

public class Inher_06_Sonata2018 extends Inher_06_Sonata {
	//�����
	public String carName  = null;
	public String carColor = null;
	//������
	public Inher_06_Sonata2018() {
		System.out.println("Sonata() ȣ�⼺��");		
	}
	public Inher_06_Sonata2018(int speed) {
		super(50);//����Ŭ������ �����ڸ� ȣ���ϴ� ���, �ݵ�� ���� �����
		System.out.println("Sonata(int speed) ȣ�⼺��");
		this.speed = speed;
		int speed2 = super.speed;
	}
	//����ڸ޼ҵ�
	public void cruise() {
		
	}
	@Override
	public void speedUp() {
		
	}
	@Override
	public void speedDown() {
		
	}
}
