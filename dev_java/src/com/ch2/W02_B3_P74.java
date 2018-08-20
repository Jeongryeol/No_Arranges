package com.ch2;

import java.util.Scanner;

public class W02_B3_P74 {

	public static void main(String[] args) {
		//연습문제
/*			달의 중력은 지구 중력의 17%에 불과합니다.
			지구에서 몸무게가 100kg인 사람은 달에가면 17kg밖에 안됩니다.
			당신의 몸무게는 달에서 얼마입니까?
		
			출력결과
			지구몸무게 : 100kg
			달 몸무게 : 17kg*/
		double grvMoon = 17;
		int manWeight = 100;
		int manMoonWeight = manWeight*(int)grvMoon/100;
		System.out.println("지구몸무게가 "+manWeight+"kg인 사람은");
		System.out.println("달에서의 몸무게는 "+manMoonWeight+"kg이 된다.");

		//모범답안
		//Scanner 클래스를 이용한 화면에서 사용자로부터 값 입력받기 (p.40~41)
		System.out.println("당신의 몸무게를 입력하세요");
		//괄호안에 System은 본인이 사용하는 컴퓨터에 해당
		//변수 in은 입력장치로부터 값을 읽어올 때 사용하는 변수
		Scanner answer = new Scanner(System.in);//Scanner를 입력하고나면 자바API 모듈을 추가하기 쉽게 도와줌(마우스오버)
		//콘솔에서 입력받은 값은 모두 Sting타입으로 String변수에 담음
		//사용자가 입력한 값을 한줄 씩 읽어올때  nextLine메소드를 사용하여  호출
		//메소드를 선언할 땐 {}로 끝나고
		//메소드를 호출할 땐 세미콜론(;)으로 끝남.
		//입력받은 내용을 input에 저장
		String input = answer.nextLine();
		//몸무게가 소숫점이 있는 경우를 생각하여 double로 선언하고
		//콘솔에서 입력받은 값을 연산처리 하기위해 double로 변경함.
		//parseDouble메소드는 static타입의 메소드 이므로
		//Double db = new Double()로 객체를 로딩하지 않고도 바로 호출할 수 있음.		
		double num = Double.parseDouble(input);//input에 저장된 입력받은 내용을 int타입 값으로 저장
		System.out.println("지구의 몸무게 : "+num+"kg");
		//달의 몸무게를 담을 변수 선언
		double m_weight = 0.0;
		m_weight = (num*17)/100;
		System.out.println("달의 몸무게 : "+m_weight+"kg");
	}

}
