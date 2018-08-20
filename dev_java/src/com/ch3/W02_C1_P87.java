package com.ch3;

public class W02_C1_P87 {

	public static void main(String[] args) {
		//연산자
		System.out.println(4<<2);//4=00000100 -> 16=00010000
		System.out.println(4>>2);//4=00000100 -> 1=00000001
		//나머지연산자(%)
		System.out.println(5%2);
		int x = 5;
		int y = 2;
		System.out.println(x%y);
		//비교연산자
		//비교연산의 결과는 boolean이다 (true or false)
		//만약 오늘 하루 매출이 100만원을 넘으면 가게문 닫고 클럽가자
		int account = 0;
		//장사를 했더니, 매출이 102만원을 찍었다면?
		account = 1020000; 
		if(account>1000000) {
			System.out.println("클럽가서 놀기");
		}
		else {
			System.out.println("그냥 퇴근하기");
		}
		//부정문
		if(1!=2) {//1과 2는 달라?
			System.out.println("다름");			
		}//if문 괄호 안의 조건식이 참이면 실행
		else {
			System.out.println("같음");
		}//거짓이면 실행
		//논리연산자		
		double himHei = 0;
		int himCash = 0;
		himHei = 183.5;
		himCash = 315000000;
		boolean herAns = true;
		if(himHei>=180 & himCash>=300000000) {
			herAns=true;
			System.out.println("나는 소개팅에 나갈거야...");
		}
		else {
			herAns=false;
			System.out.println("그 소개팅 안갈래...");
		}
		himHei = 170;
		himCash = 300;
		if(himHei>=180 | himCash>=300000000) {			
			herAns=true;
			System.out.println("나는 소개팅에 나갈거야...");
		}
		else {
			herAns=false;
			System.out.println("그 소개팅 안갈래..");
		}
		
	}

}
