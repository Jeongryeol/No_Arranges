package com.ch2;

public class W02_B4_ConversionTest {

	public static void main(String[] args) {
		//int i = (int)"hello";//문법에러임
		int j = (int)3.14;
		//boolean isFlag = (boolean)"안녕";//문법에러임
		//boolean isFlag2 = (boolean)"false";//문법에러임	
		
		boolean isFlag4 = Boolean.parseBoolean("false");//static일때 직접 불러와서 할수있음
		
		Boolean bool = new Boolean(false);//혹은 같은 타입의 객체를 여러곳에서 부르기 쉽게 변수화하여
		boolean isFlag3 = bool.parseBoolean("false");//변수화된 클래스를  불러와서 사용할 수 있음
		
		System.out.println(bool);
		
		W02_B3_P74 hi = new W02_B3_P74();//(^오^)
				
	}

}