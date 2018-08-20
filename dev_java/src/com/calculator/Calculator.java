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

public class Calculator extends JFrame implements ActionListener {//3 ���
	//�����
	String title = null;

	//������� �����ִ� ȭ�� �߰��ϱ� - JTextField�� ó���غ���
	JTextField jtf_display = new JTextField("0");//���Ⱚ�� ���� ù ��

	Font f = new Font("Bauhaus 93",Font.PLAIN,50);
	Font f2 = new Font("Bahnschrift SemiBold",Font.ROMAN_BASELINE,35);
	//���ڹ�ư�� ������ ��ư �׸��� AC,Backspace, equal��ư���� �ʿ��ؿ�.
	//�迭�� �߻����� ������ �ۼ��ϸ�, ���Ŀ� �ٽ� �ڵ带 �����Ϸ� ������ ���������� ���� ��������
	//���������� �����ϴ� ���� ������ ���� : ����������� ���ɰ� ��ȹ�������� ����, ���°� �޶����� ��찡 �ٹݻ�
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
	JButton jbtn_bs		= new JButton("��");
	JButton jbtn_equal	= new JButton("=");
	JButton jbtn_sam1	= new JButton("");
	JButton jbtn_sam2	= new JButton("");
	JButton jbtn_sam3	= new JButton("");
	
	float bv = 0;
	float rs = 0;
	float count = 0;
	String opr = null;
	
	//BorderLayout�� GridLayout�� �԰� �������⶧����, JPanel�� �ʿ��ϴ�??
	/*	��ư���� JFrame�� ��ġ�� ���� ������
	 *	�ֳ��ϸ�, ��ư�� 20���̰� �̰͵��� �����ϰ� ������ �Ŵϱ�, GridLayout�� ��ġ�ؾ��ؿ�.
	 *	GridLayout�� JPanel�� �����ؼ� ��ư�� ��ġ�Ұſ���. */
	JPanel jp_center = new JPanel();
	//�׷���, ���̾ƿ������� ����ο��� �� �� ����. (����ο����� �޼ҵ� ȣ��Ұ��ϱ� ����)
	
	/*	JFrame�� BorderLayout�� �����ؾ�����.
 	 *	�ֳ��ϸ� ���ʿ� JTextField�� ��ġ�ϰ� �߾ӿ� JPanel�� ��ġ�� �ſ���.	*/
	
	//������-1 :: ����Ʈ������
	public Calculator() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initDisplay();//2 ������ȣ��� �޼ҵ����
	}
	//������-2 :: String������ -�޼ҵ� �����ε� �ؼ��� �߰� ������
	public Calculator(String title) {
		this.title = title;//6 ���������� �������� �Ķ���Ϳ� �Բ� ����
		initDisplay();
	}
	
	//��������Ǹ޼ҵ�-1 :: ȭ��ó����
	public void initDisplay() {//4 JFrame�� ����߱⶧���� this����
		//��ܿ� ���ó���� �����
		jtf_display.setHorizontalAlignment(SwingConstants.RIGHT);//���ڸ� ������ ����
		this.add("North",jtf_display);//
		
		//�̺�Ʈó���ϱ�
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
		
		//�̺�Ʈó���ϴ� ���ڸ� ���� ����
		String temp = jtf_display.getText().substring(1);
		
		//��ư�� ������
		jp_center.setLayout(new GridLayout(5,4,2,2));//�ο�,�÷�,�ο쿩��,�÷�����
		
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
		this.add("Center",jp_center);//��������
		
		this.setTitle(title);
		this.pack();//setSize�� ���������, default���� ���� ũ�⸦ �����Ͽ� �������
		this.setVisible(true);
	}
	//��������Ǹ޼ҵ�-2 :: ����ϱ�
		public float calc(float bv, String opr) {
			switch(opr) {
				case "+": rs = rs + bv;	break;
				case "-": rs = rs - bv;	break;
				case "*": rs = rs * bv;	break;
				case "/": rs = rs / bv;	break;
			}
			return rs;
		}
	
	
	//���θ޼ҵ� :: ���� ������ ���
	public static void main(String args[]) {
	//	MyCalcApp myCalc = new MyCalcApp();//1 �ν��Ͻ�ȭ
		Calculator myCalc = new Calculator("���� ���� ver1.0");//5�������� �Ķ���� �߰��غ���
		
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
			// ó�� �� ���ڴ� ���� ���常
			// +*���� ��ȣ�� ������ ��ȣ�� ����
			// 2��° ���ڰ� ���°� ���� 
			
			// 2���� ���ڰ� ���� �� ��ȣ�� ������ ������ ���� �ǵ����ϱ� 
			
			// �ʿ��Ѱ� 1, ù���� ��������, 1��° ��ȣ ����, 2���� ���� �Է��� 2���� ��ȣ�� ���ý� ����
			// ����� ù���� �������, 1���� �����ȣ, 2���� �Է� ���� �� �Ѱܼ� ���� �޴� �޼��带 ����
			// �� ������ 2���� ��ȣ�� 1���� ��ȣ�� ������ �ǰ� ù���� ���� ���忡 ���� ���� ����
			// �ٽ� �Է½ÿ� ���� �ݺ� �ǵ��� ��

		
	/*	else if (obj==jbtn_plus)
		else if (obj==jbtn_minus)
		else if (obj==jbtn_mul)
		else if (obj==jbtn_div)*/
		
	}
	
	
	// ���ڸ� �������� +�� ��������
	// +�� ������ ���ڴ� �ٸ����� ���� �ٽ� ���ڰ� ������
	
	
}
