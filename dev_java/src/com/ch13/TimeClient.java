package com.ch13;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeClient extends JFrame implements Runnable{
	JLabel jlb_time = null;
	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}
	public void initDisplay() {
		this.add("North",jlb_time);
		this.setTitle("´Ü¸»±â");
		this.setSize(400, 350);
		this.setVisible(true);
	}
/*	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.initDisplay();
	}*/

	@Override
	public void run() {
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		boolean isStop = false;
		try {
			socket = new Socket("localhost",2008);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			while(!isStop) {
				if(ois.readObject()!=null) {
					String time = (String)ois.readObject();
					System.out.println(time);
					jlb_time.setText(time);
					this.pack();
					try {
						Thread.sleep(500);
					} catch (InterruptedException ie) {
						System.out.println(ie.toString());
					}
				}///////////end of if
			}///////////////end of while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}














