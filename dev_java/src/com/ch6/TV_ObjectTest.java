package com.ch6;

public class TV_ObjectTest {

	//TV �Ӽ��� ���� ���� ����
	int width 	 	= 0; 	 //TVȭ���� �ʱ� ���ΰ�
	int height	 	= 0;	 //TVȭ���� �ʱ� ���ΰ�	
	String color 	= null;  //TV�� �ʱ� ����
	int volume	 	= 0;	 //TV�� �ʱ� �Ҹ���
	int channel	 	= 0;	 //TV�� �ʱ� ä�ΰ�
	boolean isPower = false; //TV�� �ʱ� ������

	//TV ���� �̸��� ���� �ִ� �����ڸ� ������ ������ �� �ִ�.
	public TV_ObjectTest() {
		//width = 0,height = 0,color = null,channel = 0,volume = 0
	}
	public TV_ObjectTest(int width,int height) {//�ν��Ͻ�ȭ�� ���� ��������� �ʱ�ȭ ������
		this.width   = width;
		this.height  = height;
	}
	public TV_ObjectTest(int channel,int volume,int width,int height) {
		this.width   = width;
		this.height  = height;
		this.channel = volume;
		this.volume  = volume;
	}
	public TV_ObjectTest(boolean isPower) {
		this.isPower = isPower;
	}
	//������ ������ �����
	public TV_ObjectTest(int channel,int volume,boolean isPower) {
		this.channel = volume;
		this.volume  = volume;
		this.isPower = isPower;
	}	
	public TV_ObjectTest(boolean isPower, int channel, int volume) {
		this.isPower = isPower;
		this.channel = volume;
		this.volume  = volume;
	}
	//TV ����� ���� �ż��� �߰�
	public int ChannelUp() {
		channel++; //ä���� 1�� ������Ŵ
		return channel;
	}
	public int Channeldown() {
		channel--; //ä���� 1�� ������Ŵ
		return channel;
	}
	public boolean powerOn() {
		isPower = true;
		return true;
	}
	public boolean powerOff() {
		isPower = false;
		return false;
	}

}
