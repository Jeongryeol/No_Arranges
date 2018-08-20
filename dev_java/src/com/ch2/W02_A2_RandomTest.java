package com.ch2;

import java.util.Random;//자바API에서 제공하는 Random을 불러오는 선언

public class W02_A2_RandomTest {

	public static void main(String[] args) {
		//변수r이라는 이름에 불러온  Random 클래스(API 적용됨)로 랜덤한 숫자를 담도록 설정
		Random r = new Random();//r은 주소번지 역할을 함 (@abcd1234), 참조형 변수
		//컴퓨터가 채번한 숫자를 담는 변수 dap
		//0부터 파라미터(10)미만의 난수를 랜덤하게 가져오는 메소드
		int dap = r.nextInt(10);//참조형 변수 r을 call 해서 nextInt를 콜
		System.out.println("컴퓨터가 채번한 숫자 : "+dap);
		//채번한 숫잘를 여러번 테스트 해보고 싶을 땐 어떡하지?
		for(int i=0;i<10;i=i+1) {
			dap = r.nextInt(10);
			System.out.println("컴퓨터가 채번한 숫자 :"+dap);
		}
		//도전문제
		//위 for문 에서 컴터가 채번한 숫자를 출력내보낼때 1회차, 2회차, 3회차 라고 출력하기를 윈할때
		//필요한 변수를 추가하고 적용해 보세요.
		for(int i=1;i<10;i=i+1) {
			dap = r.nextInt(10);
			System.out.println("컴퓨터가 채번한 숫자 :"+dap);
			if(i<4) {
			System.out.println("ㄴ컴퓨터가 시도한 차수 :"+i+"회차");
			}
			else {
				
			}			
		//선생님답안
		//먼저 회차를 출력할 변수를 선언해봐요
		int cnt = 0;
		//다음은 박복문 안에서 회차를 제외한 앞에 숫자가 1씩 증가하면서 변해야 하므로
		//cnt변수를 더한 값을 cnt변수에 다시 담아준 다음
		//for문 안에서 10번 반복적으로 print문장이 실행되므로 회차라는 문자열앞에 cnt변수에 1을 더해보기
		//그런데 cnt변수의 현재 값은 0이므로 1을 출력하기 위해서는 1을 먼저 더해줘야 되겠지
		for(int ii=0;ii<10;ii=ii+1) {
			dap =r.nextInt(10);
			cnt = cnt +1;
			System.out.println(cnt+"회차"+dap);
		}
		}
		
	}

}
