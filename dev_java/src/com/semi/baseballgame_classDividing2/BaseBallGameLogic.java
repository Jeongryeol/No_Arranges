package com.semi.baseballgame_classDividing2;

import java.util.Random;

public class BaseBallGameLogic {

	//���Ͱ� ä���� ���� ���� �迭
	int com[] =new int[3];
	//����ڰ� �Է��� ���� ���� �迭
	int user[] =new int[3];

	Random r =new Random();
		
    BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this);
	
	//���� ���� ä�� �޼ҵ� : ������ �� ���ڰ� ����
	public void ranCom() {
		// Do-while���� �ѹ��� ��� ����(�����Ű��) while�� �ȿ� �ִ� ������ �˻��ϰ�,
	      //�� ������ ������ ��쿣 ������! �������� ���� ��쿣 �ٽ� do {}�� ���� �ݺ� 
	      com[0] = r.nextInt(10);
	      do {
	         com[1] = r.nextInt(10);
	      }while(com[0]==com[1]);
	      do {
	         com[2] = r.nextInt(10);
	      }while(com[0]==com[2] || com[1]==com[2]);
	}
	
	//���� �޼ҵ� :: ��Ʈ�� ���� ������ ���ߴ� �����ϴ� ����
	public String result(String userInPut) {
	
		//��Ʈ�� ���� ��Ʈ����ũ ������ ���� ����
	    int strike = 0;
	    //��Ʈ�� ���� �� ������ ���� ����
	    int ball = 0;//��������
	    //�Է¹��� ���ڿ��� ����Ÿ������ �ٲپ� ���� ��������
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
	    return "�����Դϴ�";   
	    }
	    
	    return +strike+"��"+ball+ "��";//��������
	    
	}
	
}
