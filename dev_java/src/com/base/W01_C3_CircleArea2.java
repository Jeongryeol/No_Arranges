package com.base;

public class W01_C3_CircleArea2 {

	public static void main(String[] args) {//입력은 같은 타입이 되어야함 /args : 변수이름
		System.out.println(args[0]);//입력된 값을 변경
		int r;//지역변수
		//r = args[0];// int(숫자)와 문자열(args::string)이 서로 달라서 문.에 발생
		r = Integer.parseInt(args[0]);//숫자 혹은 "숫자"로 입력된 String을 Int로 바꾸어줌
		System.out.println(r);
		}

}
