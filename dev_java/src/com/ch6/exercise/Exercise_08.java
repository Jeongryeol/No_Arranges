package com.ch6.exercise;

public class Exercise_08 {

	public static void main(String[] args) {

		int i = 1;
		int j = 0;
		switch(i){
		  case 2 : j+=6;
		  case 4 : j+=1;
		  default : j+=2;
		  //���ǽ��� i�� ���� �����ϴ� case�� �����Ƿ� default���� ����
		  case 0 : j+=4;//�� ���� �Ʒ� ���� ����
		}
		//point x
		//point x �̺κп����� j����?
		System.out.println(j);//������ j�� 6���� ���
		
	}

}
