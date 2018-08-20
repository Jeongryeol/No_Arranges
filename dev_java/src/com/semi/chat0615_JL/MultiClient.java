package com.semi.chat0615_JL;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener {

	//Ŭ���̾�Ʈ���� ������ �����ϱ����ؼ� ���ϻ���
	Socket socket = null;
	//��ü����ȭ�� �������ִ� inputStream�� OutputStream�� �ʿ��ϴ�
	ObjectInputStream ois = null;//���
	ObjectOutputStream oos = null;//���ϱ�
	//��ȭ�� �޾Ƽ� �ѱ� ���ڿ�
	String nickname = null;
	//ȭ�鱸��
	JPanel		jp_first	= new JPanel();
	JTextArea	jta_display = new JTextArea();
	JScrollPane	jsp_display = new JScrollPane(jta_display
											 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField	jtf_msg		= new JTextField();
	
	public MultiClient() {
		nickname = JOptionPane.showInputDialog("����� ��ȭ���� �Է����ּ���.");
		
		jtf_msg.addActionListener(this);
		
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_display);
		jp_first.add("South",jtf_msg);
		this.add("Center",jp_first);
		
		this.setTitle(nickname+"�԰��� ��ȭâ");
		this.setSize(500, 400);
		this.setVisible(true);
		
		try {
			socket = new Socket("192.168.0.20",8000);
			//���� ���ϱ� â�� ����
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//100#�г��� [�������� ������ ���] : �� ������ �����߾��.
			oos.writeObject(Protocol.ROOM_IN+"|"+nickname);
			//���ڰ� ��ȭ�� ���� �ʿ��� ����
			MultiClientThread mct = new MultiClientThread(this);
			mct.start();//run()ȣ��
			
		}catch (Exception e) {

		}
	}
	
	public static void main(String[] args) {
		new MultiClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//���ϱ�ó�� (�޼��� �Է��ϰ� ������������ ó������)
		if(obj==jtf_msg) {
			try {
				oos.writeObject(Protocol.MESSAGE+"|"+nickname+"|"+msg);
				jtf_msg.setText("");//����α�
			}catch (Exception e2) {
				e2.printStackTrace();//stack�� ����� ���� �޽�����  ���-�̷°���(�ٹ�ȣ)
			}
		}
	}
	
}
