package com.ch13;

public class ThreadCntrl_Chef extends Thread{
	
	//���� run�޼ҵ忡 ������ �ڵ��� ���� �˰� �ִ�|����.
	public void run() {
		String food = null;
		System.out.println("run�޼ҵ� ȣ��");
		for(int i=0;i<5;i++) {
			food=getFood();
			System.out.println("Chef("+Thread.currentThread().getName()+")===>"+food);
			try {
				this.sleep(2000);//�и���ũ ����
			} catch (InterruptedException ie) {
				System.out.println("��~~~~ ������!! ��....");
			}
		}
	}
	//������ �����ϴ� �޼ҵ�
	public String getFood() {
		String food = null;
		switch((int)(Math.random()*3)) {
		case 0:
			food = "����";
			break;
		case 1:
			food = "���Ϳ���";
			break;
		case 2:
			food = "��ȸ";
			break;
		}
		return food;
	}
	
}
