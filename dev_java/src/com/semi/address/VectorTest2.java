package com.semi.address;

import java.util.Vector;

import javax.swing.JButton;

import com.ch6.Sonata;

public class VectorTest2 {
	public static void buttonTest() {
		JButton jbtn_new = new JButton("������");
		JButton jbtn_dap = new JButton("����");
		JButton jbtn_exit = new JButton("����");
		Vector<JButton> vButton = new Vector<JButton>();
		vButton.add(jbtn_new);
		vButton.add(jbtn_dap);
		vButton.add(jbtn_exit);
		for(JButton jbtn:vButton) {
			System.out.println(jbtn.getText());//������,����,����
		}
	}
	public static void sonataTest() {
		Sonata myCar 	= new Sonata("����",30,4);
		Sonata herCar 	= new Sonata("��ũ",0,4);
		Sonata gnomCar 	= new Sonata("�Ķ�",100,4);
		Vector vCar = new Vector();
		vCar.add(myCar);
		vCar.add(1,herCar);
		vCar.add(2,gnomCar);
		for(int i=0;i<vCar.size();i++) {
			Sonata car = (Sonata)vCar.get(i);
			//insert here
			if("��ũ".equals(car.carColor)) {
				System.out.println(car.carColor);
			}
		}
		
	}
	public static void main(String[] args) {
		VectorTest2.sonataTest();
		String f1 = "���";
		String f2 = "����";
		String f3 = "�ٳ���";
		Vector v = new Vector();
		System.out.println(v.size());//0
		v.add(0,f1);
		v.add(1, f2);
		v.add(f3);//�� ��° �濡 �������?
		for(int i=0;i<v.size();i++) {
			String f = (String)v.get(i);
			System.out.println(f);
		}
	}

}
