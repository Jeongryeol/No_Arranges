package com.semi.chat0615_JL;

import java.util.StringTokenizer;

public class MultiClientThread extends Thread{

	MultiClient multiClient = null;
	
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;//run()에서 주소번지를 처리하기 위해서 초기화함
	}

	@Override//Thread클래스의 run메소드를 오버라이드
	public void run() {//듣기 : run - 스레드에서 / 말하기 : actionPerformed-MultiClient
		
		String message = "";//100|대화명 형식을 담을 빈 문자열
		boolean isStop = false;
		
		while(!isStop) {
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;//문자열을 썰어줄 공간
				int protocol = 0;//프로토콜을 담을 숫자열
				if(message != null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());//프로토콜 잘라담음
				}//end of if
				switch(protocol) {
					case Protocol.ROOM_IN: {
						String chatName = st.nextToken();
						//insert here::테이블에 넣고싶다??? DefaultTableModel.addRow(Vector)
						multiClient.jta_display.append("서버에서 읽어들인 대화명 : "+chatName+"\n");
						
					}break;
				}
				
			}catch (Exception e) {

			}
		}
	}
}
