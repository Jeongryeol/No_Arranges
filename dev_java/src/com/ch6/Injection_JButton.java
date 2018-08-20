package com.ch6;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Injection_JButton {

	JFrame jf = new JFrame();
	JButton jbtn[] = new JButton[5];//JButton �迭 ���� �� �̸�����
	
	public void initDisplay() {
		//��ü �迭 �ȿ��� ���� �ƴ϶� �ּҹ����� �����
		//JButton�迭�� ���, JButton��ü�� ���� �����̹Ƿ� default�� null�̵˴ϴ�.
		for(int i=0;i<jbtn.length;i++) {
			System.out.println(jbtn[i]);//null null null null null�� ��µ˴ϴ�.
		}		
		System.out.println(" ");
		for(int i=0;i<jbtn.length;i++) {
			jbtn[i] = new JButton();//�迭�� �ּҹ����� API JButton�� �ּҹ����� ����
			System.out.println(jbtn[i]);//������ ��ư�� �ּҹ����� ������Ƿ� null�� �ƴ϶� toString() ����� ���.
		}
		System.out.println(" ");
		//��ư�� ���� ����غ��� - ������ ����� �����ϱ� �ҷ����� ����
		String jbtn_label[] = {"������","�����","�����ϱ�","�ҷ�����","����"};//String �迭 ���� �� �̸�����
		for(int i=0;i<jbtn.length;i++) {
			jbtn[i].setText(jbtn_label[i]);//JButton�迭�ּҹ����� toString()�迭�ּҹ����� �ʱ�ȭ��Ŵ.
			System.out.println(jbtn[i]);//toString() ��� �ּҹ����� �迭�Ǿ� ��µ�
		}
		System.out.println(" ");
		//ȭ�鿡 ��ư�� ��ġ�غ���
		jf.add("North",jbtn[0]);
		jf.add("Center",jbtn[1]);
		jf.add("Center",jbtn[2]);
		jf.add("West",jbtn[3]);
		jf.add("East",jbtn[4]);
		
		jf.setTitle("�ּҹ��� �� �� �����ϱ�");
		jf.setSize(500,300);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		Injection_JButton ij = new Injection_JButton();
		ij.initDisplay();
		
	}
	
}
