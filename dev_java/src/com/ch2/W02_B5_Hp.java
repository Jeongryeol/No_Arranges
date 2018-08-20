package com.ch2;

public class W02_B5_Hp {
	//해결방법1. String 앞에 static을 붙인다.
	String hpColor = "black";
	public static void main(String[] args) {
		//System.out.println(hpColor);//문법에러 발생
		//내 클래스 안에서 선언된 변수라 하더라도 non-ststic변수(hp)는 static에서 접근 불가함.
		W02_B5_Hp hp = new W02_B5_Hp();
		//해결방법2. 비록 내 안에 있는 변수라 하더라도 new를 이용해서 객체를 생성하면
		//주소번지를 이용해서 접근 가능함. (그러나 매번 new로 새로운 객체를 생성하면 서버에  자원을 낭비하게됨)
		System.out.println(hp.hpColor);
		W02_B5_Hp herHp = new W02_B5_Hp();
		herHp.hpColor = "red";
		System.out.println("hp의 색 :"+hp.hpColor);
		System.out.println("herHp의 색 : "+herHp.hpColor);
	}

}
