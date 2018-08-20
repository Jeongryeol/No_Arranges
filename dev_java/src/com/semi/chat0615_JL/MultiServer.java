package com.semi.chat0615_JL;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/* �������� ������ �����ϸ鼭 �� �αױ���Ȯ���ϴ� ����+ui
 * ������ �����ϱ����� �����尡 �ʿ��ϴ�~*/
public class MultiServer extends JFrame {

	ServerSocket	server = null;
	Socket			client = null;
	
	JTextArea		jta_log = new JTextArea();
	JScrollPane		jsp_log = new JScrollPane(jta_log);
	
	ArrayList<MultiServerThread> chatList = null;//��Ƽ�����带 ���� ��̸���Ʈ
	MultiServerThread msthread = null;//������ ������ �����带 ��� ��Ƽ������
	
	public MultiServer() {
		//�����ڵ��� ��Ƽ�����带 ArrayList�� ��������
		//ArrayList�� ����������, �����ڵ��� ������ ���ư��� ���� ������ ����� ������ ���Եȴ�.
		chatList = new ArrayList<MultiServerThread>();
		
		this.add("Center",jsp_log);
		this.setTitle("Server log ���");
		this.setSize(500, 400);
		this.setVisible(true);
		jta_log.append("Server has ready.....\n");
		boolean isStop = false;
		
		try {
			//������ ���ſ� ���ϻ��� (��Ʈ��ȣ �Է�)
			server = new ServerSocket(5000);
			while(!isStop) {//���̸� ���ѹݺ��ϰԵǴ� while�� :: ������ ��� ����ϰ� �ȴ�.
				client = server.accept();//�������� ������ �ߴ�!!
				msthread = new MultiServerThread(this);//��Ƽ���������� Ŭ������ �����ڿ� ��Ƽ����Ŭ���� �ּҹ����� ����
				msthread.start();//run�޼ҵ� ȣ��
			}
		}catch (Exception e) {

		}
	}
	
	public static void main(String[] args) {
		new MultiServer();
	}

}
