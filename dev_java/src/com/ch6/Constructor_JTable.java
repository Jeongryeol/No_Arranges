package com.ch6;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//JTable, DefaultTableModel, JScrollPane
public class Constructor_JTable {

	//�����
	JFrame jf = new JFrame("JTable �����ϱ�");
	String[][] datas = new String[2][1];
	String[] cols = {"��ȭ��"};
	DefaultTableModel dtm = new DefaultTableModel(datas,cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	
	//������
	public Constructor_JTable() {
		jf.add("Center",jsp);
		jf.setSize(300, 500);
		jf.setVisible(true);
	}
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		Constructor_JTable jtTest = new Constructor_JTable();
	}
	
}
