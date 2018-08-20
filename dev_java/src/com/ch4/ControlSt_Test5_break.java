package com.ch4;

public class ControlSt_Test5_break {

	public static void main(String[] args) {
		int i;
		for(i=0;i<10;i++) {
			System.out.println(i);
/*			if(i==5) {
				break;//가장 가까운 반복문을 벗어남
				//i=5가 되면 break가 발동되어 for문을 벗어남
			}*/
		}//(break와 가장 가까운 반복문)
		System.out.println("여기-for문 밖");
		//반복문사용시
		//무한루프 방지코드를 꼭 추가합시다. -break문 사용하기
		//while(i>5) {
		System.out.println(i);
		while(i<5) {//이시점에서 i는 얼마니?
			System.out.println("while문 안이요!!");
			break;
		}
		System.out.println("여긴-while문 밖");
	}

}
