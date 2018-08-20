package com.semi.chat0615_JL;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/* 서버에서 접속을 중재하면서 그 로그까지확인하는 서버+ui
 * 접속을 관리하기위해 스레드가 필요하다~*/
public class MultiServer extends JFrame {

	ServerSocket	server = null;
	Socket			client = null;
	
	JTextArea		jta_log = new JTextArea();
	JScrollPane		jsp_log = new JScrollPane(jta_log);
	
	ArrayList<MultiServerThread> chatList = null;//멀티쓰레드를 담을 어레이리스트
	MultiServerThread msthread = null;//접속자 각각의 쓰레드를 담는 멀티쓰레드
	
	public MultiServer() {
		//접속자들의 멀티쓰레드를 ArrayList로 관리하자
		//ArrayList로 하지않으면, 접속자들의 정보가 날아가고 제일 마지막 사람의 정보만 남게된다.
		chatList = new ArrayList<MultiServerThread>();
		
		this.add("Center",jsp_log);
		this.setTitle("Server log 출력");
		this.setSize(500, 400);
		this.setVisible(true);
		jta_log.append("Server has ready.....\n");
		boolean isStop = false;
		
		try {
			//서버의 수신용 소켓생성 (포트번호 입력)
			server = new ServerSocket(5000);
			while(!isStop) {//참이면 무한반복하게되는 while문 :: 서버가 계속 대기하게 된다.
				client = server.accept();//누군가가 입장을 했다!!
				msthread = new MultiServerThread(this);//멀티서버스레드 클래스의 생성자에 멀티서버클래스 주소번지를 보냄
				msthread.start();//run메소드 호출
			}
		}catch (Exception e) {

		}
	}
	
	public static void main(String[] args) {
		new MultiServer();
	}

}
