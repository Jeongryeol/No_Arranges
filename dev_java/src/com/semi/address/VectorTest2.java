package com.semi.address;

import java.util.Vector;

import javax.swing.JButton;

import com.ch6.Sonata;

public class VectorTest2 {
	public static void buttonTest() {
		JButton jbtn_new = new JButton("새게임");
		JButton jbtn_dap = new JButton("정답");
		JButton jbtn_exit = new JButton("종료");
		Vector<JButton> vButton = new Vector<JButton>();
		vButton.add(jbtn_new);
		vButton.add(jbtn_dap);
		vButton.add(jbtn_exit);
		for(JButton jbtn:vButton) {
			System.out.println(jbtn.getText());//새게임,정답,종료
		}
	}
	public static void sonataTest() {
		Sonata myCar 	= new Sonata("검정",30,4);
		Sonata herCar 	= new Sonata("핑크",0,4);
		Sonata gnomCar 	= new Sonata("파랑",100,4);
		Vector vCar = new Vector();
		vCar.add(myCar);
		vCar.add(1,herCar);
		vCar.add(2,gnomCar);
		for(int i=0;i<vCar.size();i++) {
			Sonata car = (Sonata)vCar.get(i);
			//insert here
			if("핑크".equals(car.carColor)) {
				System.out.println(car.carColor);
			}
		}
		
	}
	public static void main(String[] args) {
		VectorTest2.sonataTest();
		String f1 = "사과";
		String f2 = "수박";
		String f3 = "바나나";
		Vector v = new Vector();
		System.out.println(v.size());//0
		v.add(0,f1);
		v.add(1, f2);
		v.add(f3);//몇 번째 방에 담겼을까?
		for(int i=0;i<v.size();i++) {
			String f = (String)v.get(i);
			System.out.println(f);
		}
	}

}
