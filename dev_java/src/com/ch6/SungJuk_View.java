package com.ch6;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SungJuk_View {

	//����� (�ν��Ͻ���������) :: �޼ҵ峪 ������ ������ ����Ѵ�
	JFrame jf_sungjuk = new JFrame();
	String header[] = {"����", "�̸�","JAVA","ORACLE","HTML","����","���","����","���"};
	String datas[][] = new String[5][9];
  //�����ڸ�����
	DefaultTableModel dtm_sungjuk = new DefaultTableModel(datas,header);
  //JTable�� ��ĸ� ���� �� �ְ�, �����ʹ� ���� �� ����.
	JTable jtb_sungjuk = new JTable(dtm_sungjuk);
	
	
	//�޼ҵ弱���ϱ�
	//ȭ��ó����
	public void initDisplay() {

			jf_sungjuk.add("Center",jtb_sungjuk);

		int sizeW = 600;
		int sizeH = 400;
			jf_sungjuk.setSize(sizeW, sizeH);//�ν��Ͻ������� �ּҹ����� �̸�
						
		Boolean popUp = true;
			jf_sungjuk.setVisible(popUp);
		
	}
	
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		
	  //�� �ȿ� �ִ� �޼ҵ带 ȣ���Ҷ�
	  //static�� main�޼ҵ� �ȿ����� ����Ŭ������ �ν��Ͻ�ȭ�� �ʿ���
		SungJuk_View sjView = new SungJuk_View();
	  //����Ŭ������ �ν��Ͻ�ȭ�� �̸�.�޼ҵ��̸�(); 
		sjView.initDisplay();


	}

}
