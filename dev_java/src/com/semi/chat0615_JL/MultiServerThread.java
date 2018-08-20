package com.semi.chat0615_JL;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class MultiServerThread extends Thread {

	MultiServer multiServer = null;
	
	//개체직렬화를 일으켜주는 inputStream과 OutputStream이 필요하다
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos = null;//말하기
	
	//쓰레드마다 대화명이 달라짐.(사용자에 따라 달라진다. 즉 클라이언트의 쓰레드)
	//사용자 쓰레드가 갖는 대화명과 서버측에서 읽어들인 메시지에서 가져온 대화명이 다를 수 있다.
	String chatName = null;
	
	/*멀티쓰레드를 관리할때, 메시지를 듣고 말할 창구로 들어온 메시지객체를 서버로 전한다.*/
	public MultiServerThread(MultiServer multiServer) {
		this.multiServer = multiServer;
		try {
			//듣기와 말하기 창구 설정
			oos = new ObjectOutputStream
					(multiServer.client.getOutputStream());
			ois = new ObjectInputStream
					(multiServer.client.getInputStream());
			//메세지내용 읽고 서버에 전하기
			String message = (String)ois.readObject();
			multiServer.jta_log.append("100#JLBot");
			//서버 로그에 메시지  출력할때 스크롤바 이동시키기
			multiServer.jta_log.setCaretPosition
			(multiServer.jta_log.getDocument().getLength());
			//이전 참가자에게 대화명을 알려주기
			for(MultiServerThread mst : multiServer.chatList) {
				String currentName = mst.chatName;
				this.send(Protocol.ROOM_IN+"|"+currentName);
				//this.send("");//현재 들어와있는 쓰레드(원본)
				//mst.send("");//새로 만들어진 쓰레드(사본)
			}
			
		}catch (Exception e) {

		}
	}

	@Override//Thread클래스의 run메소드를 오버라이드
	/*런 메소드가 듣고 말하기를 한다*/
	public synchronized void run() {
		//multiServer.jta_log.append("누군가 입장하였습니다...\n");//서버의 화면에 입장알림을 띄움
		boolean isStop = false;
		try {
			run_start://종료할 때, 대화를 끝낼때, -break run_start
			
			while(!isStop) {
				String message = (String)ois.readObject();
				multiServer.jta_log.append(message+"\n");
				//서버 로그에 메시지 출력할 때 스크롤 바 이동시키기
				multiServer.jta_log.setCaretPosition(multiServer.jta_log.getDocument().getLength());
				StringTokenizer st = null;//문자열을 썰어주는 메소드
				int protocol = 0;
				
				if(message!=null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				
				switch(protocol) {
					case Protocol.ROOM_IN:{
						String chatName = st.nextToken();
						broadCasting(Protocol.ROOM_IN+"|"+chatName);
					}break;
					
					case Protocol.MESSAGE:{
						String chatName = st.nextToken();
						String msg = st.nextToken();
						broadCasting(Protocol.MESSAGE+"|"+chatName+"|"+msg);
					}break;
					
				}
			}
			
		}catch (Exception e) {

		}
	}

	/*대화방에 참여하고 있는 모든 친구들에게 메시지를 보내야 한다.*/
	public void broadCasting(String message) {
		//개선된 for문 [ 왼쪽엔 객체 : 오른쪽은 배열데이터 ] 
		for(MultiServerThread mst:multiServer.chatList) {
			mst.send(message);
		}
	}

	public void send(String message) {
		// TODO Auto-generated method stub
		
	}
	
	//실제 말하기 기능은 메소드로 분리해 둔다.
	//왜냐하면 1:1대화나 귓속말 등 기능에서 재사용하려면..... 나누어 두는게 좋지 않을까?
	
}
