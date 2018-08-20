package com.ch6.exercise;

public class Exercise_14 {

    public static void main(String args[]){
    	
        String a = new String("true");
        Boolean b = new Boolean(true);
        
        if(a.equals(b))
            System.out.println("true");
        //변수 a는 String타입의 "true"값을 담고있고,
        //변수 b는 boolean타입의 true값을 담고있기때문에,
        //if문에 들어간 equals 메소드 호출의 결과값은 거짓이 된다.
        //그러므로 if문이 참일때 실행하는 실행문 Sysout은 실행되지않는다.
    
    }

}
