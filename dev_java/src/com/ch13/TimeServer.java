package com.ch13;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer extends Thread {
	
	Socket client = null;//������ ������ �� Ŭ���̾�Ʈ �������� ���
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public TimeServer(Socket client
			         ,ObjectOutputStream oos
			         ,ObjectInputStream ois) {
		this.client = client;
		this.oos = oos;
		this.ois = ois;
	}
	
	public void run() {
		System.out.println("run ȣ�� ����");
		try {
			while(true) {
				oos.writeObject(getTime());
				oos.flush();
				try {
					this.sleep(500);
				} catch (InterruptedException ie) {
					System.out.println(ie.toString());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}
	//���� �ð� ���� ��������
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min  = cal.get(Calendar.MINUTE);
		int sec  = cal.get(Calendar.SECOND);
		//return "11:58:40";
		
		//���׿����� ( A ? B : C ) : A������ ���̸� B, �ƴϸ� C
		return (hour<10 ? "0"+hour:""+hour)+":"+
		       (min<10 ? "0"+min:""+min)+":"+
		       (sec<10 ? "0"+sec:""+sec);
	}
	
	public static void main(String[] args) {
		ServerSocket tserver = null;//Ŭ���̾�Ʈ�� ���� ��ٸ�
		Socket client = null;//������ ������ �� Ŭ���̾�Ʈ �������� ���
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int port = 2008;
		boolean isStop = false;
		try {
			tserver = new ServerSocket(port);
			System.out.println("���� ����");
			while(!isStop) {
				client = tserver.accept();
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				System.out.println("New Client connected...");
				TimeServer ts = new TimeServer(client,oos,ois);//���������� ���߱�
				ts.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}





