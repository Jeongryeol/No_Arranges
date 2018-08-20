package com.ch6;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//JTable, DefaultTableModel, JScrollPane
public class Constructor_JTable {

	//선언부
	JFrame jf = new JFrame("JTable 연습하기");
	String[][] datas = new String[2][1];
	String[] cols = {"대화명"};
	DefaultTableModel dtm = new DefaultTableModel(datas,cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	
	//생성자
	public Constructor_JTable() {
		jf.add("Center",jsp);
		jf.setSize(300, 500);
		jf.setVisible(true);
	}
	
	//메인메소드
	public static void main(String[] args) {
		Constructor_JTable jtTest = new Constructor_JTable();
	}
	
}
