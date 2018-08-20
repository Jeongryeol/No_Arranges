package com.semi.chat0615_JL;

import java.util.StringTokenizer;

public class MultiClientThread extends Thread{

	MultiClient multiClient = null;
	
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;//run()���� �ּҹ����� ó���ϱ� ���ؼ� �ʱ�ȭ��
	}

	@Override//ThreadŬ������ run�޼ҵ带 �������̵�
	public void run() {//��� : run - �����忡�� / ���ϱ� : actionPerformed-MultiClient
		
		String message = "";//100|��ȭ�� ������ ���� �� ���ڿ�
		boolean isStop = false;
		
		while(!isStop) {
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;//���ڿ��� ����� ����
				int protocol = 0;//���������� ���� ���ڿ�
				if(message != null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());//�������� �߶����
				}//end of if
				switch(protocol) {
					case Protocol.ROOM_IN: {
						String chatName = st.nextToken();
						//insert here::���̺� �ְ�ʹ�??? DefaultTableModel.addRow(Vector)
						multiClient.jta_display.append("�������� �о���� ��ȭ�� : "+chatName+"\n");
						
					}break;
				}
				
			}catch (Exception e) {

			}
		}
	}
}
