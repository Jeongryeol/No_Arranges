package com.semi.chat0615;

import java.util.StringTokenizer;

public class MultiClientThread extends Thread {
	MultiClient multiClient = null;
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;
	}

	@Override
	public void run() {//듣기:run-스레드에서, 말하기:actionPerformed-MultiClient
		String message = "";//100|대화명
		boolean isStop = false;
		while(!isStop) {
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;//지역변수이니까 초기화
				if(message !=null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case Protocol.ROOM_IN:{
					String chatName = st.nextToken();
					//insert here - DefaultTableModel.addRow(Vector)
					multiClient.jta_display.append(chatName+"님이 입장하였습니다.\n");
				}break;
				case Protocol.MESSAGE:{
					String chatName = st.nextToken();
					String msg = st.nextToken();
					//읽어온 대화내용을 출력하기
					multiClient.jta_display.append("["+chatName+"]"+msg+"\n");
					multiClient.jta_display.setCaretPosition(
					multiClient.jta_display.getDocument().getLength());
				}break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}








