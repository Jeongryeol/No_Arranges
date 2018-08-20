package com.ch7;
public class Inher_07_Rectangle extends Inher_07_Figure {
	public float area(int a) {//오버로딩
		area = a*b;
		return area;
	}
	@Override
	public float area(int a,int b) {//오버라이딩
		System.out.printf("Rectangle area(%d,%d) 오버라이딩 메소드 호출성공%n",a,b);
		area = a*b;
		System.out.println("결과면적 : "+area);
		System.out.println("==========================================");
		return area;
	}
}
