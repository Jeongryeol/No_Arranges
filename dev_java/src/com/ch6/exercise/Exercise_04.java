package com.ch6.exercise;

public class Exercise_04 {
    
	private static int a;
    public static void main(String[] args){
        
    	modify(a);//�޼ҵ��� �������� a=1, �������� a�� ������ 0
        System.out.println(a);//�׷��Ƿ�  ���0
        
        //���� �Ʒ��� ���ٸ�?
        modify2(a);//�޼ҵ��� �������� a=0, �������� a++�̹Ƿ� 1
        System.out.println(a);//�׷��Ƿ�  ���1
        
    }
    
    public static void modify(int a){
        a++;
    }
    
    //���� �Ʒ��� ���ٸ�?
    public static void modify2(int a){
    	Exercise_04.a++;//static �����̹Ƿ� �ν��Ͻ�ȭ���� �ּҹ���.������ ���� ȣ�Ⱑ��
    }
    
}
