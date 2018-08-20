package com.ch6.exercise;

public class Exercise_09 {

	public static void main(String[] args) {
		
		int i = 1;
		int j = 10;
		do {
		    if( i>j )
		    break;
		     j--;
		}
		while( ++i < 5 );
		
		System.out.println(i&j);
		
		//&, |, ^ 는 비트연산자 ( p. 121 )
		//좌우 값을 2진수로 바꾸어 각 자리수를 비교할때,
		//	& : 좌우 모두 참(1)이되는 자리만 1, 아닌경우 0이 됨
		//	| : 둘 중 하나가 참(1)이되면  1, 모두 거짓(0)인 경우 0이 됨
		//	^ : 좌우 서로의 값이 다를때만 1, 같으면 0이 됨
		
		//값과 값 사이에 위치한 &,|,^는 비트연산자이므로 결과가 값이 나오게 된다.
		//즉, 논리연산자 &&,||과는 결과값이 달라서(true/false), if문에 사용될 수 없다.
	}
	
}
