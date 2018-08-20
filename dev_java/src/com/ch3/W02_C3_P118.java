package com.ch3;

public class W02_C3_P118 {

	public static void main(String[] args) {
		int i = 2;
		int j = 1;
		if((++i>j++)&&(i--<=++j)) {
			System.out.println("여기는 출력된다|아니다 출력 안된다");
		}
		//insert here
		//i는 얼마니?, j는 얼마야? 맞춰봐//i=2, j3 예
		//비교연산자 &&는
		//앞이 참일때 뒤가 참인지 연산하고, ( 비교연산자 &과 동일함 )
		//앞이 거짓일땐 결과가 무조건 거짓이므로 뒤를 연산하지 않음 ( 비교연산자 &은 앞이 거짓이어도 뒤를 연산함 : 비효율 )
		
		//선언된 상태와 동일한조건으로 시작하기 위해서는 다시 초기화해야해요
		i=2;
		j=1;
		//or연산자 일때는 어떻게 달라지는지 생각해 봐요
		//if((++i>j++)||(i--<=++j)) {
		//if문을 변수의 값을 적용한 식으로 바꾸어 보면 다음과 같아요
		if((3>1)||(3<=3)) {//or연산자가 두 개 이면 앞에 조건에 true일때 뒤에 조건을 따지지 않아도 실행문은 실행되어야 함
			//아래 출력문은 출력되는데 이때 i값은 3 j값은 2임.
			System.out.println("i : "+i+", j : "+j);
			System.out.println("여기는 출력된다|아니다 출력 안된다.");
		}
		//insert here
		//i는 얼마니?, j는 얼마야? 맞춰봐
		//i=2, j=3
		
		//& 하나일때와 두개일때의 차이는 무엇인지 생각해 보고 옆 사람과 이야기 해봐요...
		if((++i>j++)|i--<=++j) {
			System.out.println("여기는 출력된다|아니다 출력안된다.");
		}

	}///////end of main

}/////end of W02_C3_P118
