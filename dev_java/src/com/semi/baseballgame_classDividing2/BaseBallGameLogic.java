package com.semi.baseballgame_classDividing2;

import java.util.Random;

public class BaseBallGameLogic {

	//컴터가 채번한 값을 담을 배열
	int com[] =new int[3];
	//사용자가 입력한 값을 담을 배열
	int user[] =new int[3];

	Random r =new Random();
		
    BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this);
	
	//랜덤 숫자 채번 메소드 : 정답이 될 숫자가 나옴
	public void ranCom() {
		// Do-while문은 한번은 찍고 나서(실행시키고) while문 안에 있는 조건을 검색하고,
	      //그 조건을 충족할 경우엔 끝낸다! 충족하지 않을 경우엔 다시 do {}로 가서 반복 
	      com[0] = r.nextInt(10);
	      do {
	         com[1] = r.nextInt(10);
	      }while(com[0]==com[1]);
	      do {
	         com[2] = r.nextInt(10);
	      }while(com[0]==com[2] || com[1]==com[2]);
	}
	
	//판정 메소드 :: 힌트를 통해 정답을 맞추는 판정하는 과정
	public String result(String userInPut) {
	
		//힌트에 사용될 스트라이크 갯수를 담을 변수
	    int strike = 0;
	    //힌트에 사용될 볼 갯수를 담을 변수
	    int ball = 0;//지역변수
	    //입력받은 무자열을 정수타입으로 바꾸어 담을 변수선언
	    int temp = 0;
	    temp =Integer.parseInt(userInPut);
	    user[0] =temp/100;
	    user[1] = (temp%100)/10;
	    user[2] = temp%10; 
	    for (int i=0;i<3;i++) {
	       for(int j=0;j<3;j++) {
	          if(user[i]==com[j]) {
	             if(i==j) {
	                strike++;
	             }
	             else {
	                ball++;
	             }
	          }////////////////////////end of if
	       }///////////////////////////end of inner for
	    }//////////////////////////////end of outter for
	    if(strike==3) {
	    return "정답입니다";   
	    }
	    
	    return +strike+"스"+ball+ "볼";//지역변수
	    
	}
	
}
