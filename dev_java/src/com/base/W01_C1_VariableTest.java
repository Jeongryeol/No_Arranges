package com.base;

public class W01_C1_VariableTest {
	//선언부(변수와 메소드를 선언할 수 있어요)
	//tot선언은 파랑색, methodA도 파랑색
	//그러니까 methodA에서는 tot 변수 사용 가능
	static int tot = 0;//CYAN
	static double avg = 0.0;//빨강색 메소드
	void methodA() {//파랑색 메소드
		System.out.println(tot);
		//빨강은 파랑에서도 사용가능함.
		System.out.println(W01_C1_VariableTest.avg);		
	}
	//파랑색은  빨강색에서는 사용 불가하므로 16번 라인 에러임
	static void methodB() {//빨강색 메소드
		System.out.println(tot);
		}
	static void methodC() {//빨강색 메소드
		//같은 빨강이라 avg변수 사용 가능함
	}
	public static void main(String args[]) {
	
	}
}
