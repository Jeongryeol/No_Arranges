package com.ch7;
public class Inher_07_Triangle extends Inher_07_Figure {
	@Override
	public float area(int a,int b) {
		System.out.printf("Triangle area(%d,%d) �������̵� �޼ҵ� ȣ�⼺��%n",a,b);
		area = a*b/2;
		System.out.println("������� : "+area);		
		System.out.println("==========================================");	
		return area;
	}
}
