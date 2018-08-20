package com.ch5;

import java.util.Random;

/*
 * 연습문제
 * 0부터 9사이의 임의의 수를 100개 채번하여 한줄에 10개씩 출력하고
 * 그 숫자의 빈도수를 계산하여 출력하시오.
 * 
 * 출력결과
 * 2 4 9 0 5 2 1 8 3 3 
 * 5
 * 1
 * 0
 * 8
 * 5
 * 8
 * 7
 * 8
 * 3
 * 
 * 숫자 :  0 1 2 3 4 5 6 7 8 9
 * 빈도 : 10 5 7 6 7 9 4 3 1 6
 * 
 */
public class AttayTest7_ObjectArray2D_quiz2 {

	//배열의 초기화 - 100개 방에 채번한 숫자 담기
						   //채번한 숫자를 담을 100개 배열의 주소번지와 배열의 사이즈를 담음
	public void initArray(int nums[], int size) {
		//랜덤채번
		Random r = new Random();
		//100개짜리의 배열에 채번한 숫자 담기
		for(int i=0;i<size;i++) {
			nums[i] = r.nextInt(10);//채번한 숫자를 i번째 배열방에 담음
		}
	}
	
	
	//빈도를 계산해서 배열에 담기
/**************************************************************************************
 * @param nums[]-채번한 숫자 100개(재료), fres[]-100개 숫자에 대한 빈도수, 재료수
 **************************************************************************************/
//	public void numberCount(채번한 숫자의 배열, 빈도를 계산해서 담을 변수선언-배열, 빈도를 계산할 값) {
	public void numberCount(int nums[], int fres[], int size) {
		//변수가 몇개 필요하지? - 2개
		//반복문에 사용할 변수 선언
		int i;//0부터 99까지의 숫자를 셀때 사용.
		//배열의 인덱스 정보를 담을 변수 선언
		int index; //100개의 숫자중 그 숫자가 몇 번 나왔을때 1차 배열의 인덱스가 같은 곳에 1증가 시킨다.	

		//반복문을 사용하여 100개에 대한 빈도를 계산해서 담을 변수에 증가 시키기
		for(i=0;i<size;i++) {
			index = nums[i];//채번한 숫자-nums배열 , 빈도수-fres배열
			fres[index]++;//fres[index] = fres[index]+1;
		}
	}
	

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * 파라미터에는 원시형 타입이나 참조형 타입을 넘길 수 있다.
 * 원시형 타입의 경우, (ex. 배열의 개수 등) 그 값이 복사되는 것이고 - 원본이 아니라 복제본이 만들어 진다
 * 참조형 타입의 경우, (ex. 배열의 주소번지 등) 원본의 주소번지를 넘기는 것이다. - 복제본이 아니라 원본이라는 것
 * 
 * 파라미터에는 한번에 여러 개의 원시형 타입의 값 그리고 여러 개의 주소번지를 넘길 수 있다.
 * 
 * 파라미터에 넘겨지는 값들은 호출할때 넘어온다.
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 		*/
	
	
	//배열출력 - 한줄에 10개씩 출력하고 줄바꿈하기
//	public void Print10perLine(100개 배열의 주소번지, 주소번지 개수) {
	public void Print10perLine(int nums[], int size) {
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",nums[i]);// %3d :: 하나의 숫자가 3개의 자리를 차리함
			if(i%10==9)	System.out.printf("%n");// %n :: 줄바꿈
		}
	}
	
	
	//빈도출력 - 빈도 배열과 인덱스를 함께 출력
//	public void PrintResult(출력할 배열, 배열의 개수) {
	public void PrintResult(int fres[], int size) {
		System.out.print("숫자 : ");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",i);
		}
		
		System.out.println();
		System.out.print("빈도수 : ");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d",fres[i]);
		}	
		
	}
	
	
	//100개짜리 배열 만들어 보자
	public static void main(String[] args) { 
		int nums[] = new int[100];//채번할 숫자를 담을 새로운 배열 선언
		AttayTest7_ObjectArray2D_quiz2 nf = new AttayTest7_ObjectArray2D_quiz2();//클래스 호출
		nf.initArray(nums,nums.length);//초기화
		nf.Print10perLine(nums,nums.length);//출력하기
		
		int fres[] = new int[10];//빈도를 담을 새로운 배열 선언
		nf.numberCount(nums,fres,nums.length);	//빈도수를 카운트하는 메소드
		nf.PrintResult(fres,fres.length);		//빈도수를 출력하는 메소드 호출
	}

}
