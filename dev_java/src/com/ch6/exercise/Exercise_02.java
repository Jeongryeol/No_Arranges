package com.ch6.exercise;

public class Exercise_02 {
    
	public int aMethod(){
//      static int i=0;// ���� : compile will fail
					   // �������������� static�� ���� �� ����. ( �������������� ���� )
		int i=0;//�ùٸ��� ��ģ��.
        i++;
        return i;
	}
    
	public static void main(String[] args){
		Exercise_02 test = new Exercise_02();
        test.aMethod();//�ùٸ��� ��ģ ���, �޼ҵ� 1��ȣ�� i=1
        int j = test.aMethod();//�޼ҵ� 2��ȣ�� i=1, ��? ��������i�� �޼ҵ忡�� �ٽ� �ʱ�ȭ�Ǿ ����. �׷��Ƿ� j=i=1
        System.out.println(j);//�׷��Ƿ� 1 ���
	}
	
}
