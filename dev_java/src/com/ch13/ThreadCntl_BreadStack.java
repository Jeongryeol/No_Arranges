package com.ch13;

import java.util.Vector;

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
public class ThreadCntl_BreadStack {//�ڿ�����, Baker�� Customer�� �����ϹǷ�, ������ ����� Ŭ����

	//�����뿡 �ø� ���� ĭ 10�� Ȯ��
	private Vector<String> vec = new Vector<String>(10);
	
	//���� �������� �޼ҵ� ����
	//��Ƽ�������϶� �����ϰ� �ϱ�����  synchrinized
	public synchronized String pop(String cBread) {//���� ���ϴ� ���� ������
		String bread = null;
		//���� ������ - 
		if(vec.size()>0) {
			vec.remove(bread);//���Ϳ��� ���� ������
		}
		//���� ������ - ��ٷ�...wait(), sleep(), suspend()...
		else if(vec.size()==0) {
			try {
				System.out.println("���� �����ϴ�. ��ø� ��ٷ��ּ���.");
				//����ȭ�ڵ�(Synchonized-code)���� DeadLock���¸� �����ϴ� wait
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return bread;
	}
	//���� �����ϴ� �޼ҵ�
	public void push(String bBread) {//�����簡 ���� ���� ������
		//���� �������� �˷��� ���ڴ� �����带 ������... interrupt(), notify(), notifyAll()
		this.notify();
		//Vec�� ���� �߰�����(add)
		vec.add(bBread);
	}
}
