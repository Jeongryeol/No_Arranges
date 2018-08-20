package com.ch6.exercise;

public class Exercise_02 {
    
	public int aMethod(){
//      static int i=0;// 정답 : compile will fail
					   // 지역변수에서는 static을 붙일 수 없다. ( 전역변수에서만 가능 )
		int i=0;//올바르게 고친것.
        i++;
        return i;
	}
    
	public static void main(String[] args){
		Exercise_02 test = new Exercise_02();
        test.aMethod();//올바르게 고친 경우, 메소드 1차호출 i=1
        int j = test.aMethod();//메소드 2차호출 i=1, 왜? 지역변수i가 메소드에서 다시 초기화되어서 사용됨. 그러므로 j=i=1
        System.out.println(j);//그러므로 1 출력
	}
	
}
