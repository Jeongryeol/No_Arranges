package com.ch7;

public class Inher_07_Figure {

	public int a;
	public int b; 
	public float area;
	
	public float area() {
		return area;//바디가 없음. 자녀의 메소드에서 기능을 쓰겠다.
	}
	public float area(int a, int b) {
		return area;
	}
}
