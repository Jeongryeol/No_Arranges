package com.ch6.exercise;

public class Exercise_11 {

    private static int j = 0;
    
    public static boolean methodB(int k){
        j += k;
        return true;
    }
    
    public static void methodA(int i){
        boolean b;				 //���������� ���� �� ����
        b = i < 10 | methodB(4); //���������� �ʱ�ȭ��
        	//[��] A|B�� A�� ���̴��� B�� ������ ���� ������.
        	//��, methodB(4);ȣ���� �����
        b = i < 10 || methodB(4);//���������� �� �ʱ�ȭ�� / ��
        	//[��] A||B�� A�� ���̸� B�� ������ ���� ������ �ʴ´�.
        	//��, methodB(4);ȣ���� ������� ����
    }
    
    public static void main(String[] args){
        methodA(0);
        System.out.println(j);
    }

}
