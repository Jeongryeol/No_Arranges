package com.semi.calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyCalcApp extends JFrame implements ActionListener {
	//�����
	String title = null;
	//������� �����ִ� ȭ�� �߰��ϱ� - JTextField�� ó���غ���
	JTextField jtf_display = new JTextField("0");
	//��ư���� JFrame�� ��ġ�� ���� ������.
	//�ֳ��ϸ� ��ư�� 20�� �̰� �̰͵��� �����ϰ� �����ҰŴϱ� GridLayout���ʿ�����
	//GridLayout�� JPanel�� ������ �ſ���. JFrame�� BorderLayout�� �����ؾ� ����
	JPanel jp_center = new JPanel();//���̾ƿ������� ����ο��� �Ҽ� �����.�޼ҵ�ȣ��Ұ�
	//�ֳ��ϸ� ���ʿ� JTextField�� ��ġ�ϰ� �߾ӿ� JPanel�� ��ġ�Ұſ���.
	//���ڹ�ư�� ������ ��ư �׸��� AC, Backspace, equal��ư���� �ʿ��ؿ�.
	JButton jbtn_1 = new JButton("1");
	JButton jbtn_2 = new JButton("2");
	JButton jbtn_3 = new JButton("3");
	JButton jbtn_4 = new JButton("4");
	JButton jbtn_5 = new JButton("5");
	JButton jbtn_6 = new JButton("6");
	JButton jbtn_7 = new JButton("7");
	JButton jbtn_8 = new JButton("8");
	JButton jbtn_9 = new JButton("9");
	JButton jbtn_0 = new JButton("0");
	JButton jbtn_plus 	= new JButton("+");
	JButton jbtn_min  	= new JButton("-");
	JButton jbtn_mul  	= new JButton("*");
	JButton jbtn_div  	= new JButton("/");
	JButton jbtn_ac  	= new JButton("AC");
	JButton jbtn_equal  = new JButton("=");
	JButton jbtn_bs  	= new JButton("��");	
	JButton jbtn_sam1  	= new JButton("");	
	JButton jbtn_sam2  	= new JButton("");	
	JButton jbtn_sam3  	= new JButton("");	
	Font    f			= new Font("����ü",Font.BOLD,20);
	//������ - �����ڵ� ������ ������ �� �ִ�. - �޼ҵ� �����ε� �ؼ�
	public MyCalcApp() {
		initDisplay();
	}
	public MyCalcApp(String title) {
		this.title = title;
		initDisplay();
	}
	//ȭ��ó����
	public void initDisplay() {
		jbtn_1.addActionListener(this);
		jp_center.setLayout(new GridLayout(5,4,2,2));
		this.add("North",jtf_display);
		jp_center.setBackground(Color.ORANGE);
		jp_center.add(jbtn_sam1);
		jp_center.add(jbtn_sam2);
		jp_center.add(jbtn_sam3);
		jp_center.add(jbtn_bs);
		jp_center.add(jbtn_7);
		jp_center.add(jbtn_8);
		jp_center.add(jbtn_9);
		jp_center.add(jbtn_plus);
		jbtn_plus.setForeground(Color .RED);
		jbtn_plus.setFont(f);
		jp_center.add(jbtn_4);
		jp_center.add(jbtn_5);
		jp_center.add(jbtn_6);
		jp_center.add(jbtn_min);
		jbtn_min.setForeground(Color .RED);
		jbtn_min.setFont(f);
		jp_center.add(jbtn_1);
		jp_center.add(jbtn_2);
		jp_center.add(jbtn_3);
		jp_center.add(jbtn_mul);
		jbtn_mul.setForeground(Color .RED);
		jbtn_mul.setFont(f);
		jp_center.add(jbtn_0);
		jp_center.add(jbtn_equal);
		jbtn_equal.setForeground(Color .RED);
		jbtn_equal.setFont(f);
		jp_center.add(jbtn_ac);
		jp_center.add(jbtn_div);
		jbtn_div.setForeground(Color .RED);
		jbtn_div.setFont(f);
		jtf_display.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add("Center", jp_center);
		this.setTitle(title);
		this.pack();
		this.setVisible(true);
	}
	//���θ޼ҵ� - ���� ������ ���
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyCalcApp myCalc = new MyCalcApp("���� ���� ver1.0");
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_1) {
			jtf_display.setText
			(Long.parseLong(jtf_display.getText()+"1")+"");
		}
	}
}
