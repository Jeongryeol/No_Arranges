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

    //a. [����] �޼ҵ� �����ε��� �״�� �����;��� (�޼ҵ�����, Ÿ��, �Ķ����) 
/*    void setVar(int a, int b, float c){
        x=a;
        y=b;
        z=c;
    }*/

    //b. [����]
    public void setVar(int a, float c, int b){  
    	setVar(a,b,c);
    }
    
    //c. [����] �޼ҵ� �����ε��� �״�� �����;��� (�޼ҵ�����, Ÿ��, [�Ķ����])
/*    public void setVar(int a, float c, int b){
    	this(a,b,c);
    	//��� �ڵ��� �������� 3����
    	//ù��° : �Ķ���Ͱ� �ִ� �����ڴ� �������� �ʴ´�.( ����Ʈ�����ڸ� ������ )
    	//�ι�° : this()������ ȣ�ⱸ���� �ݵ�� �����ڰ� �� ó���� �;��Ѵ�.
    	//����° : �ڱ��ڽſ� ���� ������ ȣ��(���ȣ��)�� �Ұ���
    }*/
  
    
    //d. [����]
    public void setVar(int a, float b){
    	x=a;
    	//y=b;//���� ������ Ÿ���� �ٸ��� ������ ����
    }
    		
    //e. [����] �޼ҵ� �����ε��� �״�� �����;��� (�޼ҵ�����, Ÿ��, [�Ķ����]) 
/*	  public void setVar(int ax, int by, float cz){
    	x=ax;
    	y=by;
    	z=cz;
    }*/

}
