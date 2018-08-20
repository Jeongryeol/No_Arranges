package com.base;

public class W01_B4_Tivoli {
	//단 static영역안에서는 불가
	//다른 메소드 내에서도 그 변수를 사용할 수 있다.
	static int speed = 0;//전역변수 : 클래스 전역에서 사용할 수 있다.
	static void methodB(int wheelNum) {//지역변수 : 사용자가 입력한 값, { } 안에서만 사용가능 
		System.out.println(wheelNum);//6
	}
	static void speedUp() {//static과 동급으로 만들어주어서 전역변수도 같도록!
		int wheelNum = 4;//지역변수
		speed = speed + 1;
		System.out.println(speed); //★★★ 출력하라는 호출을 넣어둠
		}

	void speedDown() {
		speed = speed - 1;
		//지역변수 를 벗어나 다른 구역에서는 사용불가로 에러발생
		//System.out.println("바퀴수는 "+wheelNum);
	}
	/* 실행 순서를 적어보면 main메소드가 가장 먼저 호출되므로
	 * 22-23-7-8(여기서 6이 출력됨)-9-24 끝 speedUp과 sppedDown은 호출하지 않았으므로 실행기회를 못가짐.
	 */
	public static void main(String[] args) {
		methodB(6);
		speedUp();//★★★출력이 안됨?????
	}

}
