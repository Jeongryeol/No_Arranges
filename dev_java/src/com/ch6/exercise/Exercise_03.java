package com.ch6.exercise;

public class Exercise_03 {

/*	��, ������������ ���� ������쿡�� �����Ͽ��� �̹߻�
	�ֳ��ϸ�, �������������� ���� �� �ʱ�ȭ���� ���� ������ JVM�� default���� �ڵ����� �����Ѵ�.
	String s; �� ���, null������ �����Ǿ�����.	*/
	
    public static void main(String args[]){
        String s;
        //�������� �������� �ʱ�ȭ���� ���� ����
        	//�ùٸ� �ڵ�� ����� ���ؼ� �߰��ؾ��ϴ� ���� : �ʱ�ȭ
        	s = "Hello!";
        System.out.println("s = " + s);
        //�ʱ�ȭ�������� ���·� ��������Ƿ� �����Ͽ��� �߻�
        //code does not compile because String s is not initialized
    }
}
