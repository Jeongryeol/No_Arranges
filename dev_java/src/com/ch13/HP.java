package com.ch13;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HP extends JFrame {
	JLabel jlb_time = new JLabel("����ð�",JLabel.CENTER);
	public HP() {
		Runnable r = new TimeClient(jlb_time);
		Thread t = new Thread(r);
		t.start();		
		this.add("North",jlb_time);
		this.setTitle("�޴���");
		this.setSize(400, 350);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new HP();
	}

}
