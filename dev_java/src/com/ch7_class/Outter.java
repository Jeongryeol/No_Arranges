package com.ch7_class;

public class Outter {

	int i = 10;
	public void go() {
		System.out.println("Outter go �޼ҵ� ȣ�⼺��");
	}
	
	class Inner{
		Inner(){//����Ŭ������ ������ ���� ����
			System.out.println("Inner������ ȣ�⼺��");
		}
		public void come() {
			System.out.println("Inner come �޼ҵ� ȣ�⼺��");
		}
	}
}
