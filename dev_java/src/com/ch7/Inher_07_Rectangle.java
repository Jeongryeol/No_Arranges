package com.ch7;
public class Inher_07_Rectangle extends Inher_07_Figure {
	public float area(int a) {//�����ε�
		area = a*b;
		return area;
	}
	@Override
	public float area(int a,int b) {//�������̵�
		System.out.printf("Rectangle area(%d,%d) �������̵� �޼ҵ� ȣ�⼺��%n",a,b);
		area = a*b;
		System.out.println("������� : "+area);
		System.out.println("==========================================");
		return area;
	}
}
