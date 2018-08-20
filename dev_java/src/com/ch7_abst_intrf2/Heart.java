package com.ch7_abst_intrf2;

public interface Heart {

	//인터페이스의 변수는 상수로 자동변환된다.
	//(final이 생략되도 자동기입)
	public double temperature = 36.5;
	
	//인터페이스는 생성자를 가질수 없다
	//구현체를 통해 사용될 수 있기 때문이다.
//	public Heart();
	
	//인터페이스의 메소드는 추상메소드로 자동 변환된다.
	//(final이 생략되도 자동기입)
	public void give();
}
