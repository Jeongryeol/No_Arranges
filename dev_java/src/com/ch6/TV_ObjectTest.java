package com.ch6;

public class TV_ObjectTest {

	//TV 속성을 담을 변수 선언
	int width 	 	= 0; 	 //TV화면의 초기 가로값
	int height	 	= 0;	 //TV화면의 초기 세로값	
	String color 	= null;  //TV의 초기 색상
	int volume	 	= 0;	 //TV의 초기 소리값
	int channel	 	= 0;	 //TV의 초기 채널값
	boolean isPower = false; //TV의 초기 전원값

	//TV 같은 이름을 갖고 있는 생성자를 여러개 정의할 수 있다.
	public TV_ObjectTest() {
		//width = 0,height = 0,color = null,channel = 0,volume = 0
	}
	public TV_ObjectTest(int width,int height) {//인스턴스화에 따라 멤버변수의 초기화 결정됨
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
	//적절한 생성자 만들기
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
	//TV 기능을 위한 매서드 추가
	public int ChannelUp() {
		channel++; //채널을 1씩 증가시킴
		return channel;
	}
	public int Channeldown() {
		channel--; //채널을 1씩 증가시킴
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
