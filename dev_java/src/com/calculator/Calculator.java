package com.calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator extends JFrame implements ActionListener {//3 상속
	//선언부
	String title = null;

	//계산결과를 보여주는 화면 추가하기 - JTextField로 처리해봐요
	JTextField jtf_display = new JTextField("0");//계산기값의 가장 첫 값

	Font f = new Font("Bauhaus 93",Font.PLAIN,50);
	Font f2 = new Font("Bahnschrift SemiBold",Font.ROMAN_BASELINE,35);
	//숫자버튼과 연산자 버튼 그리고 AC,Backspace, equal버튼들이 필요해요.
	//배열등 추상적인 것으로 작성하면, 이후에 다시 코드를 변경하러 왔을때 직관적이지 못해 불편해짐
	//직관적으로 선언하는 것이 유리한 이유 : 업무담당자의 변심과 계획변경으로 인해, 형태가 달라지는 경우가 다반사
	JButton jbtn_1 	= new JButton("1");
	JButton jbtn_2 	= new JButton("2");
	JButton jbtn_3 	= new JButton("3");
	JButton jbtn_4 	= new JButton("4");
	JButton jbtn_5 	= new JButton("5");
	JButton jbtn_6	= new JButton("6");
	JButton jbtn_7	= new JButton("7");
	JButton jbtn_8	= new JButton("8");
	JButton jbtn_9 	= new JButton("9");
	JButton jbtn_0	= new JButton("0");
	JButton jbtn_plus	= new JButton("+");
	JButton jbtn_minus	= new JButton("-");
	JButton jbtn_mul	= new JButton("*");
	JButton jbtn_div	= new JButton("/");
	JButton jbtn_ac		= new JButton("AC");
	JButton jbtn_bs		= new JButton("←");
	JButton jbtn_equal	= new JButton("=");
	JButton jbtn_sam1	= new JButton("");
	JButton jbtn_sam2	= new JButton("");
	JButton jbtn_sam3	= new JButton("");
	
	float bv = 0;
	float rs = 0;
	float count = 0;
	String opr = null;
	
	//BorderLayout과 GridLayout은 함게 쓸수없기때문에, JPanel이 필요하다??
	/*	버튼들은 JFrame에 배치할 수가 없데요
	 *	왜냐하면, 버튼이 20개이고 이것들을 균일하게 생성할 거니까, GridLayout에 배치해야해요.
	 *	GridLayout을 JPanel에 설정해서 버튼을 배치할거에요. */
	JPanel jp_center = new JPanel();
	//그러나, 레이아웃설정은 선언부에서 할 수 없다. (선언부에서는 메소드 호출불가하기 때문)
	
	/*	JFrame은 BorderLayout을 유지해야하죠.
 	 *	왜냐하면 북쪽에 JTextField를 배치하고 중앙에 JPanel을 배치할 거에요.	*/
	
	//생성자-1 :: 디펄트생성자
	public Calculator() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initDisplay();//2 생성자호출시 메소드실행
	}
	//생성자-2 :: String생성자 -메소드 오버로딩 준수한 추가 생성자
	public Calculator(String title) {
		this.title = title;//6 전역변수와 생성자의 파라미터와 함께 구성
		initDisplay();
	}
	
	//사용자정의메소드-1 :: 화면처리부
	public void initDisplay() {//4 JFrame을 상속했기때문에 this가능
		//상단에 결과처리부 만들기
		jtf_display.setHorizontalAlignment(SwingConstants.RIGHT);//글자를 오른쪽 정렬
		this.add("North",jtf_display);//
		
		//이벤트처리하기
		jbtn_1.addActionListener(this);
		jbtn_2.addActionListener(this);
		jbtn_3.addActionListener(this);
		jbtn_4.addActionListener(this);
		jbtn_5.addActionListener(this);
		jbtn_6.addActionListener(this);
		jbtn_7.addActionListener(this);
		jbtn_8.addActionListener(this);
		jbtn_9.addActionListener(this);
		jbtn_0.addActionListener(this);
		jbtn_bs.addActionListener(this);
		jbtn_ac.addActionListener(this);
		jbtn_plus.addActionListener(this);
		jbtn_minus.addActionListener(this);
		jbtn_mul.addActionListener(this);
		jbtn_div.addActionListener(this);
		jbtn_equal.addActionListener(this);
		
		//이벤트처리하는 숫자를 위한 선언
		String temp = jtf_display.getText().substring(1);
		
		//버튼을 설정함
		jp_center.setLayout(new GridLayout(5,4,2,2));//로우,컬럼,로우여백,컬럼여백
		
		jp_center.setBackground(Color.ORANGE);
		jbtn_sam1.setBackground(Color.ORANGE);
		jp_center.add(jbtn_sam1);
		jbtn_sam2.setBackground(Color.ORANGE);
		jp_center.add(jbtn_sam2);
		jbtn_sam3.setBackground(Color.ORANGE);
		jp_center.add(jbtn_sam3);
		jbtn_bs.setBackground(Color.PINK);
		jbtn_bs.setForeground(Color.WHITE);
		jbtn_bs.setFont(f2);
		jp_center.add(jbtn_bs);
		
		jbtn_7.setFont(f);
		jp_center.add(jbtn_7);
		jbtn_8.setFont(f);
		jp_center.add(jbtn_8);
		jbtn_9.setFont(f);
		jp_center.add(jbtn_9);
		jbtn_plus.setBackground(Color.RED);
		jbtn_plus.setForeground(Color.WHITE);
		jbtn_plus.setFont(f2);
		jp_center.add(jbtn_plus);
		
		jbtn_4.setFont(f);
		jp_center.add(jbtn_4);
		jbtn_5.setFont(f);
		jp_center.add(jbtn_5);
		jbtn_6.setFont(f);
		jp_center.add(jbtn_6);
		jbtn_minus.setBackground(Color.RED);
		jbtn_minus.setForeground(Color.WHITE);
		jbtn_minus.setFont(f2);
		jp_center.add(jbtn_minus);
		
		jbtn_1.setFont(f);
		jp_center.add(jbtn_1);
		jbtn_2.setFont(f);
		jp_center.add(jbtn_2);
		jbtn_3.setFont(f);
		jp_center.add(jbtn_3);
		jbtn_mul.setBackground(Color.RED);
		jbtn_mul.setForeground(Color.WHITE);
		jbtn_mul.setFont(f2);
		jp_center.add(jbtn_mul);
				
		jbtn_0.setFont(f);
		jp_center.add(jbtn_0);		
		jbtn_equal.setFont(f2);
		jp_center.add(jbtn_equal);
		jbtn_ac.setFont(f2);
		jp_center.add(jbtn_ac);
		jbtn_div.setBackground(Color.RED);
		jbtn_div.setForeground(Color.WHITE);
		jbtn_div.setFont(f2);
		jp_center.add(jbtn_div);
		this.add("Center",jp_center);//속지붙임
		
		this.setTitle(title);
		this.pack();//setSize와 비슷하지만, default값에 따라 크기를 제어하여 만들어줌
		this.setVisible(true);
	}
	//사용자정의메소드-2 :: 계산하기
		public float calc(float bv, String opr) {
			switch(opr) {
				case "+": rs = rs + bv;	break;
				case "-": rs = rs - bv;	break;
				case "*": rs = rs * bv;	break;
				case "/": rs = rs / bv;	break;
			}
			return rs;
		}
	
	
	//메인메소드 :: 메인 스레드 기억
	public static void main(String args[]) {
	//	MyCalcApp myCalc = new MyCalcApp();//1 인스턴스화
		Calculator myCalc = new Calculator("전자 계산기 ver1.0");//5생성자의 파라미터 추가해보기
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj==jbtn_plus) {
			bv = Integer.parseInt(jtf_display.getText());
			opr = "+";
			rs = calc(bv,opr);
			count++;
			jtf_display.setText(String.valueOf(rs));
		}
		
		if (count!=0)  
		
		if (obj==jbtn_1) jtf_display.setText(Long.parseLong(jtf_display.getText()+"1")+"");
		else if (obj==jbtn_2) jtf_display.setText(Long.parseLong(jtf_display.getText()+"2")+"");
		else if (obj==jbtn_3) jtf_display.setText(Long.parseLong(jtf_display.getText()+"3")+"");
		else if (obj==jbtn_4) jtf_display.setText(Long.parseLong(jtf_display.getText()+"4")+"");
		else if (obj==jbtn_5) jtf_display.setText(Long.parseLong(jtf_display.getText()+"5")+"");
		else if (obj==jbtn_6) jtf_display.setText(Long.parseLong(jtf_display.getText()+"6")+"");
		else if (obj==jbtn_7) jtf_display.setText(Long.parseLong(jtf_display.getText()+"7")+"");
		else if (obj==jbtn_8) jtf_display.setText(Long.parseLong(jtf_display.getText()+"8")+"");
		else if (obj==jbtn_9) jtf_display.setText(Long.parseLong(jtf_display.getText()+"9")+"");
		
		if (obj==jbtn_0) {if("0".equals(jtf_display.getText())) jtf_display.setText("0");
					           else jtf_display.setText(Long.parseLong(jtf_display.getText()+"0")+"");}
			// 처음 온 숫자는 값을 저장만
			// +*등의 부호가 들어오면 부호도 저장
			// 2번째 숫자가 들어온것 기준 
			
			// 2번쨰 숫자가 들어온 후 부호가 들어오면 구문이 실행 되도록하기 
			
			// 필요한것 1, 첫번쨰 숫자저장, 1번째 부호 저장, 2번쨰 숫자 입력후 2번쨰 부호가 들어올시 진행
			// 진행시 첫번쨰 저장숫자, 1번쨰 저장부호, 2번쨰 입력 숫자 를 넘겨서 값을 받는 메서드를 진행
			// 위 진행후 2번쨰 부호는 1번쨰 부호에 저장이 되고 첫번쨰 숫자 저장에 위에 값이 저장
			// 다시 입력시에 위가 반복 되도록 설

		
	/*	else if (obj==jbtn_plus)
		else if (obj==jbtn_minus)
		else if (obj==jbtn_mul)
		else if (obj==jbtn_div)*/
		
	}
	
	
	// 숫자를 눌러야지 +가 나오도록
	// +가 누르면 숫자는 다른곳에 저장 다시 숫자가 오도록
	
	
}
