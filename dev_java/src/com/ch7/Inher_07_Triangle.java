package com.ch7;
public class Inher_07_Triangle extends Inher_07_Figure {
	@Override
	public float area(int a,int b) {
		System.out.printf("Triangle area(%d,%d) 오버라이딩 메소드 호출성공%n",a,b);
		area = a*b/2;
		System.out.println("결과면적 : "+area);		
		System.out.println("==========================================");	
		return area;
	}
}
