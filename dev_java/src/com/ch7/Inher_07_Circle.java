package com.ch7;
public class Inher_07_Circle extends Inher_07_Figure {
	@Override
	public float area(int a,int b) {
		System.out.printf("Circle area(%d,%d) �������̵� �޼ҵ� ȣ�⼺��%n",a,b);
		area = (float)(a*a*3.14);
		System.out.println("������� : "+area);
		System.out.println("==========================================");
		return area;
	}
}
