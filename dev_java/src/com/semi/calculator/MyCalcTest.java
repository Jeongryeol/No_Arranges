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
	//첫번째 숫자를 담을 변수 선언
	long firstNum = 0;
	//두번째 숫자(연산자를 누른다음)를 담을 변수 선언
	long secondNum = 0;
	//연산자를 담을 변수 선언
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
		//숫자 1버튼 추가
		this.add(jbtn_1);
		//+연산자 추가
		this.add(jbtn_plus);
		//숫자 2버튼 추가
		this.add(jbtn_2);
		//=버튼 추가
		this.add(jbtn_equal);
		//계산결과 출력창 추가
		this.add(jtf_display);
		//지우기 추가
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
		if(jbtn_1==obj) {//숫자 1버튼을 누른거야? 응
			jtf_display.setText(jtf_display.getText()+"1");
		}
		else if(jbtn_2==obj) {//숫자 1버튼을 누른거야? 응
			jtf_display.setText(jtf_display.getText()+"2");
		}	
		else if(jbtn_ac==obj) {//초기화버튼을 누른거야? 응
			jtf_display.setText("");
		}	
		else if(jbtn_plus==obj) {//더하기 버튼을 누른거야? 응
			op = "+";
			//더하기 연산자를 눌렀을 때 첫번째 숫자를 담는 방에 숫자를 저장함.
			firstNum = Long.parseLong(jtf_display.getText());
			//그때 까지 출력된 내용 지우기
			jtf_display.setText("");
		}		
		else if(jbtn_equal==obj) {//equal버튼을 누른거야? 응
			secondNum = Long.parseLong(jtf_display.getText());
			//System.out.println(firstNum+", "+op+", "+secondNum);
			if("+".equals(op)) {//더하기 연산자가 눌린건가?
				jtf_display.setText(new Long(firstNum+secondNum).toString());
			}
		}/////////////////end of equals			
	}/////////////////////end of actionPerformed
}/////////////////////////end of MyCalcTest
