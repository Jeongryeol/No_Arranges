package com.base;
//클래스 선언 - 울타리설정 [기호좌중괄호,우중괄호 { }]
//클래스 선언 후 좌중괄호 우중괄호 안에 코드를 추가할 수 있다.
//코드의 다른말은 변수 혹은 메소드라고 할 수 있음.
public class W01_A1_Sonata {

	public static void main(String[] args) {
		//진혁이 친구가 타는 자동차의 바퀴스는 몇개니? 4개
		//바퀴수 4개를 기억해 두고 싶다 - 변수 ㅡㅡㅡ소프트웨어 제작할때 사용되는 도구(수단)인 변수
		int wheelNum = 4;
		//값 4가 변수안에 들어있는지 확인하고 싶어요. 어떡하지? ㅡㅡㅡ직관적인 이름을 명명하고 호출하여 사용
		System.out.println(4);
		System.out.println("바퀴수 : "+wheelNum);
		//실행할땐 Ctrl+S
		//위 버튼을 클릭하면 저장과 동시에 고급언어를 저급언어로 바꾸어 줌.
		//이 과정을 컴파일 이라고 함.
		//고급언어는 dev_java->src->com->base 아래에 저장되고
		//저급언어는 dev_java->bin->com->base 아래에 저장됨
		//eclipse 툴이 컴파일을 대신 처리해줌
		//만일 메모장을 작성하면 자동 컴파일은 지원되지 않음
		/*
		 * 모든 클래스를 구현하고 실행할 때마다
		 * 명령 프롬프트 창을 열어서
		 * javac Sonata.java
		 * 하고 실행할때
		 * java Sonata 해야됨.
		 * 
		 * 연습문제
		 * 내 여친의 자동차를 선언하고 그 자동차의 바퀴수와 자동사 색깔을 출력하는 클래스를 구현해 보세요.
		 * 
		 * 문자열을 저장할때는 아래과 같이 구성
		 * String carColor = "핑크";
		 * 서로 같은 타입만 담을 수 있으므로 숫자를 담을때와 문자를 담을때의 타입은 다르다
		 */
		String carColor = "핑크";
		System.out.println(carColor);
		
	}

}
