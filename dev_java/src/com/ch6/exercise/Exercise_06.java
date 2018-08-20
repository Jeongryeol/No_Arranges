package com.ch6.exercise;

public class Exercise_06 {

	public static void main(String[] args){
		
		//continue break for문은 앞으로 프로젝트 중 메신저제작에 중요한 요소가 될 것
	    
		int i=0, j=5;
	tp://반복문을 지정한 라벨
	    for(;;i++)//초기값과 조건식이 없으므로 무한루프       
	       for(;;--j)//초기값과 조건식이 없으므로 무한루프
	           if(i>j) break tp;
	    System.out.println("i = "+i+"j = "+j);
	    
	    //아래와 같다
	    i=0; j=5;
	tp:
	    for(;;i++) {       
	       for(;;--j) {
	           if(i>j) break tp;
	       }
	    }
		System.out.println("상기와 동일 ~ i = "+i+"j = "+j);
 
	}
	
}
