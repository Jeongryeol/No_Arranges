package com.ch7;

import javax.swing.JFrame;

public class Inher_02_JFrameTest extends JFrame{
	//�����
	
	//������
	public Inher_02_JFrameTest() {
		initDisplay();
	}

	//��������Ǹ޼ҵ�
	//ȭ��ó����
	public void initDisplay() {
		//this :Inheritance_JFrameTest(�ڱ��ڽ�) ��Ī  | this() : ����Ʈ������ȣ��
		//super : JFrame | super() : JFrame() : ����Ʈ������ ȣ��
		this.setSize(500,300);
		this.setVisible(true);
	}
		
	public static void main(String[] args) {
		Inher_02_JFrameTest jft = new Inher_02_JFrameTest();//����Ʈ������ ȣ�� 

	}

}
