package com.ch13;

//Thread�� ��ӹ޾����Ƿ� T1 �޼ҵ� 1�� / ��2��
public class T1 extends Thread{
	int i = 0;
	//����ߴ� run()�޼ҵ尡 �۵��Ѵ�
	public void run() {
		System.out.println("run");
	}
	//main Thread 1�� / ��2��
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();//run()�޼ҵ尡 ����Ѵ�
		System.out.println(t1.i);//����Ѵ�
	}
}      