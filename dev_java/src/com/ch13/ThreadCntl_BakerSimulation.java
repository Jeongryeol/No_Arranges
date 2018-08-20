package com.ch13;

/**************************************************************
 * [�����ι�]
 ***������(ThreadCntl_Baker.java) 
 *  �����翡 �����带 �����ߴٸ�, run()�޼ҵ忡���� ������ ó���ؾ��ұ�?
 ***������(ThreadCntl_BreadStack.java)
 * 	�����뿡�� ���� �߰��ϰų� ���� ������ ������ ���� �޼ҵ带 �����ؼ���.
 * 	������ ���� �����ϴµ� �ʿ��� Ŭ������ ���� ������?
 ***��	(ThreadCntl_Customer.java)
 * 	���� ���� �����带 �����ߴٸ�, run��()�޼ҵ忡���� � ���� ó���ؾ��ұ�?
 **************************************************************
 * [�׽�Ʈ]
 * -�׽�ƮŬ����(ThreadCntl_Simulation.java)
 *  �� �׽�Ʈ �ó������� ���� �ùķ��̼�Ŭ�������� �׽�Ʈ�� �ʿ��� ������ ������ ���غ��ÿ�.
 *  �� �׽�Ʈ �ó��������� ����ȭ�� �ʿ��� �κ��� �ִ��� �����غ���, �ʿ��ϴٸ� �����غ�����.
 **************************************************************
 * �������� String�� ���� �Ѵ�.
 * ������ 3������ �����غ���
 * �����簡 ����� ���� �����ϰ� �����غ���
 * 
 * � Ŭ������ Thread�� �ؾ����� ������ ����.
 **************************************************************/
public class ThreadCntl_BakerSimulation {//�׽�Ʈ�� �ùķ��̼� Ŭ����

	public static void main(String[] args) {
		ThreadCntl_BreadStack bs = new  ThreadCntl_BreadStack();
		ThreadCntl_Baker ba1 = new ThreadCntl_Baker(bs);
		ba1.start();
		ThreadCntl_Baker ba2 = new ThreadCntl_Baker(bs);
		ba2.start();
		ThreadCntl_Baker ba3 = new ThreadCntl_Baker(bs);
		ba3.start();
		ThreadCntl_Customer cus1 = new ThreadCntl_Customer(bs,"Ƽ��̽�");
		cus1.start();
		ThreadCntl_Customer cus2 = new ThreadCntl_Customer(bs,"���Ϳ���");
		cus2.start();
		ThreadCntl_Customer cus3 = new ThreadCntl_Customer(bs,"������");
		cus3.start();		
	}
	
}
