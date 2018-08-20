package com.semi.chat0615_JL;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class MultiServerThread extends Thread {

	MultiServer multiServer = null;
	
	//��ü����ȭ�� �������ִ� inputStream�� OutputStream�� �ʿ��ϴ�
	ObjectInputStream ois = null;//���
	ObjectOutputStream oos = null;//���ϱ�
	
	//�����帶�� ��ȭ���� �޶���.(����ڿ� ���� �޶�����. �� Ŭ���̾�Ʈ�� ������)
	//����� �����尡 ���� ��ȭ��� ���������� �о���� �޽������� ������ ��ȭ���� �ٸ� �� �ִ�.
	String chatName = null;
	
	/*��Ƽ�����带 �����Ҷ�, �޽����� ��� ���� â���� ���� �޽�����ü�� ������ ���Ѵ�.*/
	public MultiServerThread(MultiServer multiServer) {
		this.multiServer = multiServer;
		try {
			//���� ���ϱ� â�� ����
			oos = new ObjectOutputStream
					(multiServer.client.getOutputStream());
			ois = new ObjectInputStream
					(multiServer.client.getInputStream());
			//�޼������� �а� ������ ���ϱ�
			String message = (String)ois.readObject();
			multiServer.jta_log.append("100#JLBot");
			//���� �α׿� �޽���  ����Ҷ� ��ũ�ѹ� �̵���Ű��
			multiServer.jta_log.setCaretPosition
			(multiServer.jta_log.getDocument().getLength());
			//���� �����ڿ��� ��ȭ���� �˷��ֱ�
			for(MultiServerThread mst : multiServer.chatList) {
				String currentName = mst.chatName;
				this.send(Protocol.ROOM_IN+"|"+currentName);
				//this.send("");//���� �����ִ� ������(����)
				//mst.send("");//���� ������� ������(�纻)
			}
			
		}catch (Exception e) {

		}
	}

	@Override//ThreadŬ������ run�޼ҵ带 �������̵�
	/*�� �޼ҵ尡 ��� ���ϱ⸦ �Ѵ�*/
	public synchronized void run() {
		//multiServer.jta_log.append("������ �����Ͽ����ϴ�...\n");//������ ȭ�鿡 ����˸��� ���
		boolean isStop = false;
		try {
			run_start://������ ��, ��ȭ�� ������, -break run_start
			
			while(!isStop) {
				String message = (String)ois.readObject();
				multiServer.jta_log.append(message+"\n");
				//���� �α׿� �޽��� ����� �� ��ũ�� �� �̵���Ű��
				multiServer.jta_log.setCaretPosition(multiServer.jta_log.getDocument().getLength());
				StringTokenizer st = null;//���ڿ��� ����ִ� �޼ҵ�
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

	/*��ȭ�濡 �����ϰ� �ִ� ��� ģ���鿡�� �޽����� ������ �Ѵ�.*/
	public void broadCasting(String message) {
		//������ for�� [ ���ʿ� ��ü : �������� �迭������ ] 
		for(MultiServerThread mst:multiServer.chatList) {
			mst.send(message);
		}
	}

	public void send(String message) {
		// TODO Auto-generated method stub
		
	}
	
	//���� ���ϱ� ����� �޼ҵ�� �и��� �д�.
	//�ֳ��ϸ� 1:1��ȭ�� �ӼӸ� �� ��ɿ��� �����Ϸ���..... ������ �δ°� ���� ������?
	
}
