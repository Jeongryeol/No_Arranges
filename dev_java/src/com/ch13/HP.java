package com.ch13;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HP extends JFrame {
	JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
	public HP() {
		Runnable r = new TimeClient(jlb_time);
		Thread t = new Thread(r);
		t.start();		
		this.add("North",jlb_time);
		this.setTitle("휴대폰");
		this.setSize(400, 350);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new HP();
	}

}
