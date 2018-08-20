package com.ch03;
/*
 * jsp에서 java code를 인스턴스화할 때 java와는 차이가 있고,
 * 그 때 scope에 대한 이해를 가 필요합니다.
 */
public class Sonata {
	//선언부
	int speed;
	//디펄트 생성자
	public Sonata() {
		System.out.println("Sonata 디폴트 생성자 호출 성공");
	}
	//메소드
	public int speedUp() {
		speed += 1;
		return speed;
	}
}
