package com.ch6;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MethodTest2_Overloading {//�޼ҵ� �����ε� ����

	JFrame jf = new JFrame();
	
	int 	sizeW;
	int 	sizeH;
	Boolean popUp;
	String 	result;
	String 	userID 	= null;
	int 	address = 0;
	String title;
	
	//���̵� �ߺ��˻�â : ����ũ��, ����ũ�� ����
	public String windowOpen(int userID) {
		title = "���̵��ߺ��˻�";		jf.setTitle(title);
		sizeW = 300; sizeH = 150;			jf.setSize(sizeW,sizeH);
		popUp = true;						jf.setVisible(popUp);
		System.out.println("���̵��ߺ��˻� �޼ҵ� �����ε� ���� userID : "+userID);
		return result;
	}
	//�����ȣ �˻� : ����ũ��, ����ũ�� ����
	public String windowOpen(String address) {
		title = "�����ȣ�˻�";					jf.setTitle(title);
		sizeW = 500; sizeH = 850;			jf.setSize(sizeW,sizeH);
		popUp = true;						jf.setVisible(popUp);
		System.out.println("�����ȣ�˻� �޼ҵ� �����ε� ���� address : "+address);
		return result;
	}
	//���� �˻� : ����ũ��, ����ũ������
	public String windowOpen(String bookName,int writtenTime) {
		title = "�����˻�";					jf.setTitle(title);
		sizeW = 800; sizeH = 1200;			jf.setSize(sizeW,sizeH);
		popUp = true;						jf.setVisible(popUp);
		System.out.println("�����˻� �޼ҵ� �����ε� ���� ������ : "+bookName);
		return result;
	}
	
	
	void windowOpen(int sizeW, int sizeH, String title, boolean popUp) {
		jf.setTitle(title);  jf.setSize(sizeW, sizeH);	jf.setVisible(popUp);
		System.out.println("windowOpen �����ε� Ÿ��2-1 ȣ�⼺��");
	}
	void windowOpen(String title,int sizeW, int sizeH, boolean popUp) {
		jf.setTitle(title);  jf.setSize(sizeW, sizeH);	jf.setVisible(popUp);
		System.out.println("windowOpen �����ε� Ÿ��2-2 ȣ�⼺��");
	}
	void windowOpen(int sizeW, int sizeH, boolean popUp, String title) {
		jf.setTitle(title);  jf.setSize(sizeW, sizeH);	jf.setVisible(popUp);
		System.out.println("windowOpen �����ε� Ÿ��2-3 ȣ�⼺��");
	}
	
	
	public static void main(String[] args) {
		MethodTest2_Overloading winTest = new MethodTest2_Overloading();
		String insertID = JOptionPane.showInputDialog(winTest.jf,"�ߺ��˻��� ���̵� �Է����ּ���.");
		int userID = Integer.parseInt(insertID);
		winTest.windowOpen(userID);
		
		String address = JOptionPane.showInputDialog(winTest.jf,"�˻��� �ּҸ� �Է����ּ���.");
		winTest.windowOpen(address);
		
		String bookName = JOptionPane.showInputDialog(winTest.jf,"�˻��� å�̸��� �Է����ּ���.");
		String insertWrittenTime = JOptionPane.showInputDialog(winTest.jf,"�˻��� å�� �������ڸ� �Է����ּ���.");
		int writtenTime = Integer.parseInt(insertWrittenTime);
		winTest.windowOpen(bookName,writtenTime);
		
		winTest.sizeW = 400; winTest.sizeH = 500; winTest.title="�����ε� Ÿ��1"; winTest.popUp = true;
		winTest.windowOpen(winTest.sizeW,winTest.sizeH,winTest.title,winTest.popUp);//�޼ҵ� �����ε� Ÿ��2-1
		winTest.windowOpen(winTest.title,winTest.sizeW,winTest.sizeH,winTest.popUp);//�޼ҵ� �����ε� Ÿ��2-2
		winTest.windowOpen(winTest.sizeW,winTest.sizeH,winTest.popUp,winTest.title);//�޼ҵ� �����ε� Ÿ��2-3
		//�����̸��� �޼ҵ尡 �Ķ���Ϳ� ���� �Ӽ�,����,������ ���� �����ε��Ǿ� ���������� �����ϴ�. 
		
	}
}