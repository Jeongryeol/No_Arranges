package dev_java_exprience;

import java.util.Random;//자바API에서 제공하는 Random을 불러오는 선언


public class Practice_0423___Random_nextInt {
	
	public static void main(String[] args) {
		//변수r이라는 이름에 불러온  Random 클래스(API 적용됨)로 랜덤한 숫자를 담도록 설정
		Random bigR = new Random();//r은 주소번지 역할을 함 (@abcd1234), 참조형 변수
		//컴퓨터가 채번한 숫자를 담는 변수 dap
		//0부터 파라미터(10)미만의 난수를 랜덤하게 가져오는 메소드
		int smallR = bigR.nextInt(10);//참조형 변수 r을 call 해서 nextInt를 콜
		System.out.println("Random메소드를 통한 출력 : "+smallR);
		System.out.println(" ");			
		
		int i = 1;
		int att = 0;
		for(i=1;i<11;i=i+1) {
				att=att+i+i*i;
				System.out.println(i+"회차 출력");
				System.out.println("▶출력값 : "+att);
				System.out.println(" ");			
		}
		System.out.println("최종출력값 "+att+" 출력 완료");
		System.out.println(" ");			
	}

}
