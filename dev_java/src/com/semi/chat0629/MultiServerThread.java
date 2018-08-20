package com.semi.chat0629;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class MultiServerThread extends Thread {
	MultiServer multiServer = null;
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos = null;//말하기
	//쓰레드 마다 대화명이 달라짐.
	//사용자 쓰레드가 갖는 대화명과 서버측에서 읽어들인 메시지에서 가져온 대화명이 다를 수 있다.
	String chatName = null;
	public MultiServerThread(MultiServer multiServer) {
		this.multiServer = multiServer;
		try {
			oos = new ObjectOutputStream
					(multiServer.client.getOutputStream());
			ois = new ObjectInputStream
					(multiServer.client.getInputStream());
			// 100#유재덕
			String message = (String)ois.readObject();
			//클라이언트에서 보내온 메시지 읽기
			StringTokenizer st = null;
			if(message!=null) {
				st = new StringTokenizer(message,"|");
			}
			st.nextToken();
			chatName = st.nextToken();
			multiServer.jta_log.append(message+"\n");
			//서버 로그에 메시지 출력할 때 스크롤바 이동시키기
			multiServer.jta_log.setCaretPosition
			(multiServer.jta_log.getDocument().getLength());
			//이전 참가자 에게 대화명을 알려주기
			for(MultiServerThread mst:multiServer.chatList) {
				String currentName = mst.chatName;
				this.send(Protocol.ROOM_IN+"|"+currentName);
			}
			//대화에 참여하고 있는 다른 클라이언트에게도 입장한 사실을 알려야 함.
			multiServer.chatList.add(this);
			this.broadCasting(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public synchronized void run() {
		//multiServer.jta_log.append("유재덕님이 입장하였습니다.\n");
		boolean isStop = false;
		try {
			run_start://종료할 때, 대화끝낼 때 -break run_start
			while(!isStop) {
				String message = (String)ois.readObject();
				multiServer.jta_log.append(message+"\n");
				multiServer.jta_log.setCaretPosition(multiServer.jta_log.getDocument().getLength());
				StringTokenizer st = null;
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
				case Protocol.MESSAGE:{//200|박의|오늘스터디할까|컬러|폰트타입|폰트 사이즈
					String chatName = st.nextToken();
					String msg = st.nextToken();
					String fontColor = st.nextToken();
					String fontType  = st.nextToken();
					String fontSize  = st.nextToken();
					String imgChoice = "";
					while(st.hasMoreTokens()) {
						imgChoice = st.nextToken();
					}
					broadCasting(Protocol.MESSAGE
						    +"|"+chatName
						    +"|"+msg
						    +"|"+fontColor
						    +"|"+fontType
						    +"|"+fontSize
						    +"|"+imgChoice
						    );
				}break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//대화방에 참여하고 있는 모든 친구들에게 메시지를 보내야 한다.
	public void broadCasting(String message) {
		for(MultiServerThread mst:multiServer.chatList) {
			mst.send(message);
		}
	}
	//실제 말하기 기능은 메소드로 분리해 둔다.
	//왜냐하면 1:1대화나 귓속말등 기능에서 재사용하려면......나누어두는게 좋지 않을까?
	public void send(String message) {
		try {
			oos.writeObject(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}



