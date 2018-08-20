package com.ch6.exercise;

public class Exercise_03 {

/*	단, 전역변수에서 선언만 했을경우에는 컴파일에러 미발생
	왜냐하면, 전역변수에서는 선언 후 초기화하지 않은 선언은 JVM은 default값을 자동으로 설정한다.
	String s; 인 경우, null값으로 설정되어있음.	*/
	
    public static void main(String args[]){
        String s;
        //지역변수 선언이후 초기화하지 않은 상태
        	//올바른 코드로 만들기 위해서 추가해야하는 과정 : 초기화
        	s = "Hello!";
        System.out.println("s = " + s);
        //초기화되지않은 상태로 사용했으므로 컴파일에러 발생
        //code does not compile because String s is not initialized
    }
}
