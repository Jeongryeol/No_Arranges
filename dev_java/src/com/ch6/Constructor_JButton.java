package com.ch6;

import javax.swing.JButton;

public class Constructor_JButton {

	Constructor_JButton() {//������ ����
		initDisplay();//non-staitc�� �ڱ��ڽ��� �żҵ� ȣ�� (this�� �� �ʿ�� ����)
	}
	
	public void initDisplay() {//non-static �޼ҵ� ����
		System.out.println("initDisplayȣ�� ����");//�޼ҵ� ȣ�� ������ �� ��¹� �ۼ�
	}
	
	public static void main(String[] args) {
		
		Constructor_JButton cj = new Constructor_JButton();//�ڱ��ڽ��� �ν��Ͻ�ȭ
		
		JButton jbtn_new = new JButton();//import�� API�� �ν��Ͻ�ȭ
		jbtn_new.setText("������");//������ ȣ��
		
		JButton jbtn_exit = new JButton("����");//����

	}

}
