package com.ch6.exercise;

public class Exercise_06 {

	public static void main(String[] args){
		
		//continue break for���� ������ ������Ʈ �� �޽������ۿ� �߿��� ��Ұ� �� ��
	    
		int i=0, j=5;
	tp://�ݺ����� ������ ��
	    for(;;i++)//�ʱⰪ�� ���ǽ��� �����Ƿ� ���ѷ���       
	       for(;;--j)//�ʱⰪ�� ���ǽ��� �����Ƿ� ���ѷ���
	           if(i>j) break tp;
	    System.out.println("i = "+i+"j = "+j);
	    
	    //�Ʒ��� ����
	    i=0; j=5;
	tp:
	    for(;;i++) {       
	       for(;;--j) {
	           if(i>j) break tp;
	       }
	    }
		System.out.println("���� ���� ~ i = "+i+"j = "+j);
 
	}
	
}
