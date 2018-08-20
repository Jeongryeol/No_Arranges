package com.ch5;
/*
 * 배열의 선언과 초기화를 구분하여 하는것도 좋음
 */
public class ArrayTest2 {
	String names[] = null;//전역변수
	void namesInit() {
		names = new String[3];
		names[0] = "이길한";
		names[1] = "박의";
		names[2] = "유재덕";//현재 대화방에 들어와있는 사람의 이름들로 초기화 시킬 수 있음
	}
	/* 문제
	 * 이길한, 박의, 유재덕 세 친구의 이름을 출력하는 메소드를 구현해보세요.
	 * insert here 1
	 */
	//answer here 1/2
	void nameList() {
	//전역변수 names배열에 대한 선언만 되어있고
	//배열의 초기화는 namsInit() 메소드 안에서 이루어 져있으니, 호출을 먼저 해야겠어요.
		namesInit();//내 안에 있는 메소드를 불러서 호출하기
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
		}
		//개선된 for문으로 바꾸어 출력해볼게요. - 전체를 출력하는 결과이기때문에, 결과는 동일하겠죠?
		System.out.println("=====[외부호출 메소드 내/아래/개선된 for문으로 처리한 경우]=====");
		for(String name:names) {//첫번째는 배열안에 타입을 작성하고 변수이름을 : 두번째는 배열의 주소번지만 있으면 되죠.
			System.out.println(name);
		}
	}
	//public은 접근제한자(access modifier) public > protected > friendly > private
	//접근제한자가 없으면 friendy 상태이고, 같은 패키지 안의 클래스끼리 호출할 수있다.
	//그러나 다른 패키지에 있는 클래스에서는 호출할 수 없다.
	public static void main(String[] args) {
		int is[] = null;//선언 //지역변수
		is = new int[3];//초기화
		//non-static 변수 names를 static영역안에서 사용할 수 있다. (왜? 전역변수이기 때문에 가능하다.)
		//how? 어떻게? - 인스턴스화!!!
		ArrayTest2 at2 = new ArrayTest2();//인스턴스화
		//answer here 2/2 - nameList()메소드 호출하기
		System.out.println("=====[아래/static main 메소드 밖의 메소드를 호출하여 처리하기]=====");
		at2.nameList();
		System.out.println("=====[아래/메소드밖의 전역변수를 static main메소드 안에 인스턴스화로 불러서 처리한 경우]=====");
		at2.names = new String[3];//복제본에 실제로 방배열 생성
		at2.names[0] = "노은비";
		at2.names[1] = "이정렬";
		at2.names[2] = "원영식";
		for(int i=0;i<3;i++) {
			System.out.println(at2.names[i]);	
		}
		
	}

}
