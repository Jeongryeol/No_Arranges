package com.semi.chat0629;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MultiServer extends JFrame {
	ServerSocket 	server = null;
	Socket 			client = null;
	JTextArea       jta_log = new JTextArea();
	JScrollPane     jsp_log = new JScrollPane(jta_log);
	ArrayList<MultiServerThread> chatList = null;
	MultiServerThread msthread = null;
	public MultiServer() {
		chatList = new ArrayList<MultiServerThread>();
		this.add("Center",jsp_log);
		this.setTitle("Server log출력하기");
		this.setSize(500, 400);
		this.setVisible(true);
		jta_log.append("Server Ready......\n");
		boolean isStop = false;
		try {
			server = new ServerSocket(5000);
			while(!isStop) {
				//여기를 진입했다면 재덕이가 입장을 했다.
				client = server.accept();
				msthread = new MultiServerThread(this);
				msthread.start();//run메소드 호출
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		new MultiServer();
	}

}
