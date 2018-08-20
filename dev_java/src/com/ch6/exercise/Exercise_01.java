package com.ch6.exercise;

class Super{
    public float getNum(){return 3.0f;}
}

public class Exercise_01 extends Super{

//	a.
	public float getNum(){return 4.f;}
	//오버라이딩 : 부모클래스의 메소드를, 같은 이름의 메소드로, 속성과 파라미터를 변화시키지 않은채, 리턴값을 새로 정의하는것

//	b.
	//public void getNum(){return 4.0f;}//메소드의 리턴타입을 void로 변경했으므로 에러가 남

//	c.
	public void getNum(double d){};
	//오버로딩 : 부모클래스의 메소드를, 같은 이름의 메소드로, 속성을 변화시키기거나 추가하여, 이용하는 것

//	d.
	public double getNum(float d){return 4.0d;}
	//오버로딩 : 부모클래스의 메소드를, 같은 이름의 메소드로, 속성을 변화시키기거나 추가하여, 이용하는 것
	
}
