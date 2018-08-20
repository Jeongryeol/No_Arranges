package com.ch6.exercise;

public class Exercise_11 {

    private static int j = 0;
    
    public static boolean methodB(int k){
        j += k;
        return true;
    }
    
    public static void methodA(int i){
        boolean b;				 //지역변수의 선언만 된 상태
        b = i < 10 | methodB(4); //지역변수를 초기화함
        	//[참] A|B는 A가 참이더라도 B가 참인지 논리를 따진다.
        	//즉, methodB(4);호출이 실행됨
        b = i < 10 || methodB(4);//지역변수를 또 초기화함 / 참
        	//[참] A||B는 A가 참이면 B가 참인지 논리를 따지지 않는다.
        	//즉, methodB(4);호출은 실행되지 않음
    }
    
    public static void main(String[] args){
        methodA(0);
        System.out.println(j);
    }

}
