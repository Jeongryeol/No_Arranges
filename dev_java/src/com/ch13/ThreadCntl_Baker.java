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
public class ThreadCntl_Baker extends Thread {

	private ThreadCntl_BreadStack bs = null;
	
	public ThreadCntl_Baker(ThreadCntl_BreadStack bs) {
		this.bs = bs;
	}

	public void run() {
		String bread = null;
		for(int i=0;i<5;i++) {//���� 5�� ����� ����մϴ�...
			bread = getBread();
			bs.push(bread);
			
			try {//���� �����ϴµ� �ð��� �ɸ��Ƿ�, sleep���� ������Ű��.
				this.sleep(1000);
			}catch (InterruptedException ie) {
				System.out.println("���ϴ°ž�!! ��ġ����������!!");
			}
		}
	}
	
	public String getBread() {
		String bread = null;
		
		switch((int)Math.random()*3) {//�����߻����� ������ �������غ���
		case 0:
			bread = "Ƽ��̽�";
			break;
		case 1:
			bread = "������";
			break;
		case 2:
			bread = "��";
			break;
		}////end of switch
		
		return bread;
	}
}
