package com.ch6.exercise;

public class Exercise_08 {

	public static void main(String[] args) {

		int i = 1;
		int j = 0;
		switch(i){
		  case 2 : j+=6;
		  case 4 : j+=1;
		  default : j+=2;
		  //조건식인 i의 값이 대응하는 case가 없으므로 default부터 시작
		  case 0 : j+=4;//그 다음 아래 문장 실행
		}
		//point x
		//point x 이부분에서의 j값은?
		System.out.println(j);//정답은 j값 6으로 출력
		
	}

}
