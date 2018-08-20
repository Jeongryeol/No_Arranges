package com.ch6.exercise;

public class Exercise_04 {
    
	private static int a;
    public static void main(String[] args){
        
    	modify(a);//메소드의 지역변수 a=1, 전역변수 a는 여전히 0
        System.out.println(a);//그러므로  출력0
        
        //만약 아래와 같다면?
        modify2(a);//메소드의 지역변수 a=0, 전역변수 a++이므로 1
        System.out.println(a);//그러므로  출력1
        
    }
    
    public static void modify(int a){
        a++;
    }
    
    //만약 아래와 같다면?
    public static void modify2(int a){
    	Exercise_04.a++;//static 변수이므로 인스턴스화없이 주소번지.변수명 으로 호출가능
    }
    
}
