package com.ch3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class W02_E3_MyCalc {

	public static void main(String[] args) {
		//����(north)�� JTextField�� �߰��ϰ� �;��. �����? �ν��Ͻ�ȭ
		JTextField jtf_display = new JTextField();
		boolean isView = false;
		//[������ �����] ȭ���� �������� ���θ� ����ڷκ��� �Է� �޾Ƽ� ó���ϱ�
		String userView = JOptionPane.showInputDialog("ȭ���� ����� �� ���θ� true Ȥ��  false�� �Է��ϼ���.");
		//������ â�� ȭ���� ���� �;�� - ���� ���ٱ��? JFrame
		//��� ����ϸ� ����? - �ν��Ͻ� ȭ
		JFrame jf_calc = new JFrame();
		//â�� ũ�⸦ ��� �ݿ��� �� ���� ? - �޼ҵ� - �޼ҵ� �̸��� ����? setSize (����-int, ����-int);
		jf_calc.setSize(500,(int)300.67);
		//â�� ȭ�鿡 �����ְ� �;�� �Ǵ� â�� ȭ�鿡 �Ⱥ��̰� �ϰ� �;��. �̷��� �����? setVisible(boolean);
		//ȭ�鿡 �����ְ� �;��.
		//���� �޼ҵ带 ȣ���� �� �ִ�. - �Ķ���Ϳ� ����Ÿ���� ����� �� �ִ�.
		isView = Boolean.parseBoolean(userView);
		//insert here - ���� ���� ���� ��� ����ϰ� �;��. �����? - setTitle(String title);
		String title = "���� ���� ���� Ver1.0";
		//JFrame â ���ʿ� JText Field�� �����ٷ�?
		jf_calc.add("North",jtf_display);//�Է�â(JTextFiedl)�� "North"(����)�� �߰��ϴ� �޼ҵ� add
		//��ư�� ���� ���ڿ��� ������ ������ ������.
		String first = "1";
		String sec	 = "2";
		String plus	 = "+";
		String equal = "=";	
		String ac	 = "AC";
		String close = "�ݱ�";
		//insert here - ����1��ư, ����2��ư, +�����ڹ�ư, =���Կ����ڹ�ư, AC��ư, �ݱ��ư �߰� -> �ν��Ͻ�ȭ
		JButton jbtn_one = new JButton(first);//����Ÿ���� ������ ��ü�� ����־�� ��ư���� ���������.
		JButton jbtn_two = new JButton(sec);
		JButton jbtn_plus = new JButton(plus);
		JButton jbtn_ac = new JButton(ac);
		JButton jbtn_close = new JButton(close);
		JButton jbtn_equal = new JButton(equal);
		Font f = new Font("����ü",Font.BOLD,40);
		jbtn_plus.setFont(f);
		jbtn_plus.setForeground(Color.BLUE);
		jbtn_equal.setFont(f);
		jbtn_equal.setForeground(Color.BLACK);
		jbtn_close.setFont(new Font("����ü",Font.ITALIC,20));
		jbtn_close.setForeground(Color.RED);
		//����(JPanel)�� center�ڸ��� ��ġ��Ű��, ���� ��ư�� ���ʴ�� �ֵ�, �յ��ϰ� �й��ϰ� �ʹ�. ->
		JPanel jp_center = new JPanel();//���������
		jp_center.setLayout(new GridLayout(1,6));//������ ���̾ƿ��� ����ֱ�, 1�ٿ� 6���
		jp_center.add(jbtn_one);//6���� ��ü ������� ����
		jp_center.add(jbtn_two);
		jp_center.add(jbtn_plus);
		jp_center.add(jbtn_equal);
		jp_center.add(jbtn_ac);
		jp_center.add(jbtn_close);
		//������� ����(JPanel)�� JFrame�� �߾ӿ� �ٿ��ֱ�
		jf_calc.setTitle(title);
		jf_calc.add("Center", jp_center);//��ġ�� �ǹ��ϴ� ���ڽ�Ʈ���� ù���ڰ� �빮�ڿ��� �ν��� "center" ���ν�
		jf_calc.setVisible(isView);
		//true : �����ش�.   false : �Ⱥ����ش�(�׷��� �޸𸮿��� �����ִ�.)
		//��ư�� ��� �������? - �ν��Ͻ�ȭ -> ���� �� ���� ������? JButton

		//��ư�� ���� ��� �ٿ��ٱ�? - �޼ҵ� - setText( ) ?

	}

}
