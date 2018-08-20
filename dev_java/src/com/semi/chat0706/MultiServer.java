package com.semi.chat0706;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
class Service extends Thread{
	Socket client = null;
	MultiServer mServer = null;
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos = null;//말하기
	public Service(Socket client, MultiServer mServer) {
		this.client = client;
		this.mServer = mServer;
		try {
			oos = new ObjectOutputStream
					(client.getOutputStream());
			ois = new ObjectInputStream
					(client.getInputStream());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void run() {
		
	}
}
public class MultiServer extends JFrame implements Runnable {
	JTextArea       jta_log = new JTextArea();
	JScrollPane     jsp_log = new JScrollPane(jta_log);
	public MultiServer() {
		this.add("Center",jsp_log);
		this.setTitle("Server log출력하기");
		this.setSize(500, 400);
		this.setVisible(true);
		jta_log.append("Server Ready......\n");
	}
	@Override
	public void run() {
		ServerSocket ss = null;
		boolean isStop = false;
		try {
			ss = new ServerSocket(3100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		while(!isStop) {
			try {
				Socket client = ss.accept();//서버에 접속한 클라이언트 소켓
				System.out.println(client);
				Service sv = new Service(client,this);
				sv.start();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}////////////////end of run
	public static void main(String[] args) {
		MultiServer ms = new MultiServer();
/*		Thread th = new Thread(ms);
		th.start();*/
		new Thread(ms).start();
	}	

}





