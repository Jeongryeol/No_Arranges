package com.ch6.exercise;

public class Exercise_13 {

    private int x,y;
    private float z;
    public void setVar(int a, int b, float c){
        x=a;
        y=b;
        z=c;
    }
    
//  which two overload the setVar method?(choose two)

    //a. [오답] 메소드 오버로딩은 그대로 가져와야함 (메소드형태, 타입, 파라미터) 
/*    void setVar(int a, int b, float c){
        x=a;
        y=b;
        z=c;
    }*/

    //b. [정답]
    public void setVar(int a, float c, int b){  
    	setVar(a,b,c);
    }
    
    //c. [오답] 메소드 오버로딩은 그대로 가져와야함 (메소드형태, 타입, [파라미터])
/*    public void setVar(int a, float c, int b){
    	this(a,b,c);
    	//상기 코드의 에러사유 3가지
    	//첫번째 : 파라미터가 있는 생성자는 제공되지 않는다.( 디폴트생성자만 지원됨 )
    	//두번째 : this()생성자 호출구문은 반드시 생성자가 맨 처음에 와야한다.
    	//세번째 : 자기자신에 대한 생성자 호출(재귀호출)은 불가함
    }*/
  
    
    //d. [정답]
    public void setVar(int a, float b){
    	x=a;
    	//y=b;//값은 같으나 타입이 다르기 때문에 에러
    }
    		
    //e. [오답] 메소드 오버로딩은 그대로 가져와야함 (메소드형태, 타입, [파라미터]) 
/*	  public void setVar(int ax, int by, float cz){
    	x=ax;
    	y=by;
    	z=cz;
    }*/

}
