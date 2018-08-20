package com.ch7_class;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingClient extends JFrame {
	JTextField	jtf_log 	= new JTextField();
	JTextArea	jta_user	= new JTextArea();
	JButton		jbtn_send	= new JButton("전송");
	JPanel		jp_input	= new JPanel();

	public void display() {
		jbtn_send.addActionListener(new ActionListener() {
			@Override //인터페이스의 추상메소드의 몸통을 오버라이드로 구현해주면 인스턴스화할수있다.
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jbtn_send) {
					jtf_log.add(jta_user, jta_user.getText());//\n은 줄바꾸기 / HTML에선 <BR>
					jta_user.setText("");//\n은 줄바꾸기 / HTML에선 <BR>
				}
			}
		});
		jtf_log.setEnabled(false);
		jp_input.setLayout(new GridLayout(1,2));
		jp_input.add("Center",jta_user);
		jp_input.add("East",jbtn_send);
		this.setTitle("클라이언트......");
		this.add("Center",jtf_log);
		this.add("South",jp_input);
		this.setSize(300, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ChattingClient cClient = new ChattingClient();
		cClient.display();
	}

}
