package com.ch13;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer extends Thread {
	
	Socket client = null;//서버에 접속해 온 클라이언트 소켓정보 담기
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
		System.out.println("run 호출 성공");
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
	//현재 시간 정보 가져오기
	public String getTime() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min  = cal.get(Calendar.MINUTE);
		int sec  = cal.get(Calendar.SECOND);
		//return "11:58:40";
		
		//삼항연산자 ( A ? B : C ) : A조건이 참이면 B, 아니면 C
		return (hour<10 ? "0"+hour:""+hour)+":"+
		       (min<10 ? "0"+min:""+min)+":"+
		       (sec<10 ? "0"+sec:""+sec);
	}
	
	public static void main(String[] args) {
		ServerSocket tserver = null;//클라이언트의 접속 기다림
		Socket client = null;//서버에 접속해 온 클라이언트 소켓정보 담기
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		int port = 2008;
		boolean isStop = false;
		try {
			tserver = new ServerSocket(port);
			System.out.println("서버 개통");
			while(!isStop) {
				client = tserver.accept();
				oos = new ObjectOutputStream(client.getOutputStream());
				ois = new ObjectInputStream(client.getInputStream());
				System.out.println("New Client connected...");
				TimeServer ts = new TimeServer(client,oos,ois);//전역변수에 맞추기
				ts.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}





