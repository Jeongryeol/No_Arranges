package com.ch13;

//�丮�簡 3���� �Ĵ��� �ֹ� ������ �����ϴ� �丮�� �����غ���
public class Chef extends Thread{
	
	public Chef() {
		start();
	}
	
	public void run() {
		String food = null;
		System.out.println("run�޼ҵ� ȣ��");
		System.out.println("--------------");
		for(int i=0;i<5;i++) {
			food = getFood();//������ ������ ��ƺ�
			System.out.println("Chef "+i+" ���� :"+food);
			try {
				this.sleep(i*500);//mili-sec ����
			}catch (InterruptedException e) {//�����忡 ���� ����
				 System.out.println("�� ������ ��!!!! (���ͼ�Ʈ�� �Ͼ��)");
			}
		}
		System.out.println("--------------");
	}
	
	//������ �����ϴ� �޼ҵ�
	public String getFood() {
		String food = null;
		//������ �ֹ��� �� �𸣴� ������ �߻����Ѻ���
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
