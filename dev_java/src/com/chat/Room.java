package com.chat;

import java.util.Vector;

public class Room {

	//�н���ǥ :: �� ��ȭ�濡 �����ϰ� �ִ� ����鿡 ���� ������ ���� �� �ִ°�?
	//�������� �ο��� �þ��� �پ��� �Դٰ����ϴ� [�������� ���� �����ϱ�]
	//��Ƽ������� ���� ������������, ������ ��������.������ Vector�� ���õȴ�.
	Vector<String> userVt = new Vector<String>();
	//��Ƽ�����忡�� ������ �ڷᱸ�� : Vector
	//�̱۽����忡�� ������ �ڷᱸ�� : ArrayList
	
	String	title	= null; //������
	String	status	= null; //�׻���� �������� : ����|��ȭ��|...
	boolean isOpen	= false;//����|�����
	int		max		= 0;	//���尡�� ������
	int		current	= 0;	//���� �ο���
	
	//�����ڰ� �ʿ��ұ�??
	//�ʿ�����! �ν��Ͻ�ȭ�Ҷ� �Ķ���ͷ� this�� ����Ŭ������ ������, ������ �ʱ�ȭ��Ų��.
	//�������� ��1������ ��������� �ʱ�ȭ
	public Room() {
		
	}
	public Room(String title, String status, int max) {
		this.title = title;
		this.status = status;
		this.max = max;
	}
	
	//Getter,Setter
	public Vector<String> getUserVt() {
		return userVt;
	}
	public void setUserVt(Vector<String> userVt) {
		this.userVt = userVt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	
}
