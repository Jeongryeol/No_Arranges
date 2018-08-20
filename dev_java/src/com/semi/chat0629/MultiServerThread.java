package com.semi.chat0629;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

public class MultiServerThread extends Thread {
	MultiServer multiServer = null;
	ObjectInputStream ois = null;//���
	ObjectOutputStream oos = null;//���ϱ�
	//������ ���� ��ȭ���� �޶���.
	//����� �����尡 ���� ��ȭ��� ���������� �о���� �޽������� ������ ��ȭ���� �ٸ� �� �ִ�.
	String chatName = null;
	public MultiServerThread(MultiServer multiServer) {
		this.multiServer = multiServer;
		try {
			oos = new ObjectOutputStream
					(multiServer.client.getOutputStream());
			ois = new ObjectInputStream
					(multiServer.client.getInputStream());
			// 100#�����
			String message = (String)ois.readObject();
			//Ŭ���̾�Ʈ���� ������ �޽��� �б�
			StringTokenizer st = null;
			if(message!=null) {
				st = new StringTokenizer(message,"|");
			}
			st.nextToken();
			chatName = st.nextToken();
			multiServer.jta_log.append(message+"\n");
			//���� �α׿� �޽��� ����� �� ��ũ�ѹ� �̵���Ű��
			multiServer.jta_log.setCaretPosition
			(multiServer.jta_log.getDocument().getLength());
			//���� ������ ���� ��ȭ���� �˷��ֱ�
			for(MultiServerThread mst:multiServer.chatList) {
				String currentName = mst.chatName;
				this.send(Protocol.ROOM_IN+"|"+currentName);
			}
			//��ȭ�� �����ϰ� �ִ� �ٸ� Ŭ���̾�Ʈ���Ե� ������ ����� �˷��� ��.
			multiServer.chatList.add(this);
			this.broadCasting(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public synchronized void run() {
		//multiServer.jta_log.append("��������� �����Ͽ����ϴ�.\n");
		boolean isStop = false;
		try {
			run_start://������ ��, ��ȭ���� �� -break run_start
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
				case Protocol.MESSAGE:{//200|����|���ý��͵��ұ�|�÷�|��ƮŸ��|��Ʈ ������
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
	//��ȭ�濡 �����ϰ� �ִ� ��� ģ���鿡�� �޽����� ������ �Ѵ�.
	public void broadCasting(String message) {
		for(MultiServerThread mst:multiServer.chatList) {
			mst.send(message);
		}
	}
	//���� ���ϱ� ����� �޼ҵ�� �и��� �д�.
	//�ֳ��ϸ� 1:1��ȭ�� �ӼӸ��� ��ɿ��� �����Ϸ���......������δ°� ���� ������?
	public void send(String message) {
		try {
			oos.writeObject(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}



