package com.ch7;
/*
 * 클래스 앞에 final이 올 수 있다. (static은 안됨)
 * 의미 : 자손클래스를 가질 수 없다. 
 * 언제쓰지?
 * 제품에 대한 생각(고집)을 유지하기 위해 --변종이 생기는 것을 막겠다.--
 */
//public final class Modifier_02_final_Duck {//자식클래스에 에러발생함
public class Modifier_02_final_Duck {

	int leg = 2;
	int eye = 2;
	final int wings = 2;//final을 붙이면 상수화. 변경불가!!!
	
	public void flying() {
		leg = 6;
		//wings = 9;//final로 된 상수는 변경불가!!
	}
	public void display() {
		
	}
	public final void swimming() {//final을 붙이면 재정의불가!!! override불가
		
	}
}
