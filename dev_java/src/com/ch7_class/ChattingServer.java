package com.ch7_class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChattingServer extends JFrame 
	implements ActionListener, KeyListener, WindowListener{
	JTextArea	jtf_log 	= new JTextArea();
	JScrollPane	jsp_log		= new JScrollPane(jtf_log
											,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JButton		jbtn_start	= new JButton("���� START");
	public ChattingServer() {
		//�͸�Ŭ������ ó���ϱ� ���ؼ��� �̺�Ʈ�ҽ��� �ʿ���
	}
	public void display() {
		jbtn_start.addActionListener(new ActionListener() {
			@Override //�������̽��� �߻�޼ҵ��� ������ �������̵�� �������ָ� �ν��Ͻ�ȭ�Ҽ��ִ�.
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jbtn_start) {
					jtf_log.append("ä�ü����� �⵿�Ǿ����ϴ�...\n");//\n�� �ٹٲٱ� / HTML���� <BR>
				}
			}
		});
		jtf_log.setEnabled(false);
		this.setTitle("����log......");
		this.add("Center",jsp_log);
		this.add("South",jbtn_start);
		this.setSize(300, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ChattingServer cServer = new ChattingServer();
		cServer.display();

	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
