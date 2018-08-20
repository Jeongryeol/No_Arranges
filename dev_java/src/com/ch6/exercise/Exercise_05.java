package com.ch6.exercise;

public class Exercise_05 {
	
	public static void main(String[] args) {
		int i=1, j=10;//같은 타입으로 여러변수 선언 및 초기화 가능
		//do ~ while 문은 조건식이 뒤에 있기 때문에 무조건 실행하고 진행
		do{
		   if(i++ > --j) continue;//if문에 좌우중괄호가 없으면 한문장까지만 반복
		}while(i<5);
		   System.out.println("i : "+i+", j : "+j);	
	}

	// 북마크하고 디버깅 아래와 같이 실행되는 것을 확인가능

	/* 최초  i=1, j=10으로 초기화됨
	 * do문으로 시작 ( 조건식이 뒤에 있기때문에 최초동작은 자동 시작 )
	 * i는1, j는9로 변경해서 9를 비교하고 거짓으로 판별되었으므로 continue는 실행되지않음
	 * do문을 나온뒤 while의 조건식에 따라 i가 1증가하여 2가 됨
	 */

}
