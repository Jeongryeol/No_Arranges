package com.semi.chat0615;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener{
	Socket socket = null;
	ObjectInputStream ois = null;//���
	ObjectOutputStream oos = null;//���ϱ�
	//��ȭ���� �޾Ƽ� ���
	String nickName = null;
	JPanel 			jp_first	= new JPanel();
	JTextArea       jta_display = new JTextArea();
	JScrollPane     jsp_display = 
			new JScrollPane(jta_display
					       ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					       ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField 		jtf_msg		= new JTextField();
	public MultiClient() {
		nickName = JOptionPane.showInputDialog("����� ��ȭ���� �Է��ϼ���.");
		jtf_msg.addActionListener(this);
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_display);
		jp_first.add("South",jtf_msg);
		this.add("Center",jp_first);
		this.setTitle(nickName+"���� ��ȭâ");
		this.setSize(500, 400);
		this.setVisible(true);
		try {
			socket = new Socket("192.168.0.17",5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//�� ������ �����߾��
			oos.writeObject(Protocol.ROOM_IN+"|"+nickName);
			MultiClientThread mct = new MultiClientThread(this);
			mct.start();//run()ȣ��
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		new MultiClient();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//���ϱ� - ���ó��
		if(obj == jtf_msg) {
			try {
				oos.writeObject(Protocol.MESSAGE+"|"+nickName+"|"+msg);
				jtf_msg.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();//stack����� �����޽����� ���-�̷°���(�ٹ�ȣ)
			}
		}
	}

}







