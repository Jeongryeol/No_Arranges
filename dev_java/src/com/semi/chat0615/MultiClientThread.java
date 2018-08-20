package com.semi.chat0615;

import java.util.StringTokenizer;

public class MultiClientThread extends Thread {
	MultiClient multiClient = null;
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;
	}

	@Override
	public void run() {//���:run-�����忡��, ���ϱ�:actionPerformed-MultiClient
		String message = "";//100|��ȭ��
		boolean isStop = false;
		while(!isStop) {
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;//���������̴ϱ� �ʱ�ȭ
				if(message !=null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case Protocol.ROOM_IN:{
					String chatName = st.nextToken();
					//insert here - DefaultTableModel.addRow(Vector)
					multiClient.jta_display.append(chatName+"���� �����Ͽ����ϴ�.\n");
				}break;
				case Protocol.MESSAGE:{
					String chatName = st.nextToken();
					String msg = st.nextToken();
					//�о�� ��ȭ������ ����ϱ�
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







