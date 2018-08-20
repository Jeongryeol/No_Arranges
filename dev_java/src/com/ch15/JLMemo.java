package com.ch15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * @author	Jeongryeol
 * @aim		�޸��� Ŭ���� �����غ���
 * 
 *	�޴����߰�
 *	JMenuBar	jmb
 *	JMenu		jm_file | jm_edit
 *	JMenuItem
 *		File -	new		jmi_new
 *				open	jmi_open
 *				save	jmi_save
 *				exit	jmi_exit
 *		Edit -	copy	jmi_copy
 *				cut		jmi_cut
 *				paste	jmi_paste
 *
 */
public class JLMemo extends JFrame implements ActionListener{
	/*�����*/
	//����������������������������������������[�޴��� ����]����������������������������������������
	JMenuBar	jmb			= new JMenuBar();
	//���ϸ޴��� �����۸��
	JMenu		jm_file		= new JMenu("File");
	JMenuItem	jmi_new		= new JMenuItem("�� �޸�");
	JMenuItem	jmi_open	= new JMenuItem("�ҷ�����");
	JMenuItem	jmi_save	= new JMenuItem("�����ϱ�");
	JMenuItem	jmi_edit	= new JMenuItem("�����ϱ�");
	JMenuItem	jmi_exit	= new JMenuItem("����");
	//�����޴��� ������ ���
	JMenu		jm_edit		= new JMenu("Edit");
	JMenuItem	jmi_copy	= new JMenuItem("�����ϱ�");
	JMenuItem	jmi_cut		= new JMenuItem("�߶󳻱�");
	JMenuItem	jmi_paste	= new JMenuItem("�ٿ��ֱ�");
	//����������������������������������������[�޴��� ��]����������������������������������������
	
	/*������*/
	//����Ʈ ������
	public JLMemo() {
		initDisplay();//ȭ�����
	}
	
	/*��������� �޼ҵ�*/
	//ȭ��ó����
	public void initDisplay() {
		//�������� �׼ǰ����ο�
		jmi_new		.addActionListener(this);
		jmi_open	.addActionListener(this);
		jmi_save	.addActionListener(this);
		jmi_edit	.addActionListener(this);
		jmi_exit	.addActionListener(this);
		jmi_copy	.addActionListener(this);
		jmi_cut		.addActionListener(this);
		jmi_paste	.addActionListener(this);
		
		//�޴��� ��ġ
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_edit);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_cut);
		jm_edit.add(jmi_paste);
		jmb.add(jm_edit);
		//this.add("North",jmb);
		this.setJMenuBar(jmb);
		
		//ȭ�����
		this.setTitle("JL-Memo ver.1");
		this.setSize(450, 650);
		this.setVisible(true);
	}
	
	/*���� �޼ҵ�*/
	public static void main(String[] args) {
		JLMemo mm = new JLMemo();
	}
	
	/*�������̵� �޼ҵ�*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�׼ǿ��� ���� �ҽ��� ��ü�� ����
		Object obj = ae.getSource();
		
		if (obj == jmi_new) {//�޴���-File��-�� �޸�
			
		}
		else if (obj == jmi_open) {//�޴���-File��-�ҷ�����
			
		}
		else if (obj == jmi_save) {//�޴���-File��-�����ϱ�
			
		}
		else if (obj == jmi_edit) {//�޴���-File��-�����ϱ�
			
		}
		else if (obj == jmi_exit) {//�޴���-File��-������
			dispose();
			setVisible(false);
			System.exit(0);
		}
		else if (obj == jmi_copy) {//�޴���-Edit��-�����ϱ�
			
		}
		else if (obj == jmi_cut) {//�޴���-Edit��-�߶󳻱�
			
		}
		else if (obj == jmi_paste) {//�޴���-Edit��-�ٿ��ֱ�
			
		}
			
	}       
            
}           
            
            
            
            