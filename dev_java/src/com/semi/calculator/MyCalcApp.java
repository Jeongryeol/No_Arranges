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
	//선언부
	String title = null;
	//계산결과를 보여주는 화면 추가하기 - JTextField로 처리해봐요
	JTextField jtf_display = new JTextField("0");
	//버튼들은 JFrame에 배치할 수가 없데요.
	//왜냐하면 버튼이 20개 이고 이것들을 균일하게 생성할거니까 GridLayout이필요하죠
	//GridLayout은 JPanel에 설정할 거예요. JFrame은 BorderLayout를 유지해야 하죠
	JPanel jp_center = new JPanel();//레이아웃설정은 선언부에서 할수 없어요.메소드호출불가
	//왜냐하면 북쪽에 JTextField를 배치하고 중앙에 JPanel를 배치할거예요.
	//숫자버튼과 연산자 버튼 그리고 AC, Backspace, equal버튼들이 필요해요.
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
	JButton jbtn_bs  	= new JButton("←");	
	JButton jbtn_sam1  	= new JButton("");	
	JButton jbtn_sam2  	= new JButton("");	
	JButton jbtn_sam3  	= new JButton("");	
	Font    f			= new Font("돋움체",Font.BOLD,20);
	//생성자 - 생성자도 여러개 정의할 수 있다. - 메소드 오버로딩 준수
	public MyCalcApp() {
		initDisplay();
	}
	public MyCalcApp(String title) {
		this.title = title;
		initDisplay();
	}
	//화면처리부
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
	//메인메소드 - 메인 스레드 기억
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyCalcApp myCalc = new MyCalcApp("전자 계산기 ver1.0");
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_1) {
			jtf_display.setText
			(Long.parseLong(jtf_display.getText()+"1")+"");
		}
	}
}
