package com.semi.calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyCalcTest extends JFrame implements ActionListener {
	JTextField 	jtf_display = new JTextField(20);
	JButton 	jbtn_1 		= new JButton("1");
	JButton 	jbtn_2 		= new JButton("2");
	JButton	 	jbtn_plus 	= new JButton("+");
	JButton 	jbtn_equal 	= new JButton("=");
	JButton 	jbtn_ac 	= new JButton("AC");
	//ù��° ���ڸ� ���� ���� ����
	long firstNum = 0;
	//�ι�° ����(�����ڸ� ��������)�� ���� ���� ����
	long secondNum = 0;
	//�����ڸ� ���� ���� ����
	String op = null;
	MyCalcTest(){
		initDisplay();
	}
	public void initDisplay() {
		jbtn_1.addActionListener(this);
		jbtn_2.addActionListener(this);
		jbtn_plus.addActionListener(this);
		jbtn_ac.addActionListener(this);
		jbtn_equal.addActionListener(this);
		this.setLayout(new FlowLayout());
		//���� 1��ư �߰�
		this.add(jbtn_1);
		//+������ �߰�
		this.add(jbtn_plus);
		//���� 2��ư �߰�
		this.add(jbtn_2);
		//=��ư �߰�
		this.add(jbtn_equal);
		//����� ���â �߰�
		this.add(jtf_display);
		//����� �߰�
		this.add(jbtn_ac);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyCalcTest myCal = new MyCalcTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtn_1==obj) {//���� 1��ư�� �����ž�? ��
			jtf_display.setText(jtf_display.getText()+"1");
		}
		else if(jbtn_2==obj) {//���� 1��ư�� �����ž�? ��
			jtf_display.setText(jtf_display.getText()+"2");
		}	
		else if(jbtn_ac==obj) {//�ʱ�ȭ��ư�� �����ž�? ��
			jtf_display.setText("");
		}	
		else if(jbtn_plus==obj) {//���ϱ� ��ư�� �����ž�? ��
			op = "+";
			//���ϱ� �����ڸ� ������ �� ù��° ���ڸ� ��� �濡 ���ڸ� ������.
			firstNum = Long.parseLong(jtf_display.getText());
			//�׶� ���� ��µ� ���� �����
			jtf_display.setText("");
		}		
		else if(jbtn_equal==obj) {//equal��ư�� �����ž�? ��
			secondNum = Long.parseLong(jtf_display.getText());
			//System.out.println(firstNum+", "+op+", "+secondNum);
			if("+".equals(op)) {//���ϱ� �����ڰ� �����ǰ�?
				jtf_display.setText(new Long(firstNum+secondNum).toString());
			}
		}/////////////////end of equals			
	}/////////////////////end of actionPerformed
}/////////////////////////end of MyCalcTest
