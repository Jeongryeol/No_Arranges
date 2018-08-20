package com.semi.chat0706;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.StyledDocument;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;

public class MultiClient extends JFrame{
	//�����
	JTabbedPane tp = new JTabbedPane();
	MessageRoom mr = new MessageRoom(this);
	WaitRoom    wr = new WaitRoom(this);
	//������
	public MultiClient() {
		initDisplay();
	}
	//ȭ��ó����
	public void initDisplay() {
		tp.addTab("����", wr);
		tp.addTab("��ȭ��", mr);
		this.add(tp);
		this.setSize(650, 570);
		this.setVisible(false);
	}
	
}







