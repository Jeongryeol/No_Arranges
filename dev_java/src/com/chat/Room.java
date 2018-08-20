package com.chat;

import java.util.Vector;

public class Room {

	//학습목표 :: 그 대화방에 참여하고 있는 사람들에 대한 정보를 담을 수 있는가?
	//여러명인 인원이 늘었다 줄었다 왔다갔다하는 [참여자의 정보 관리하기]
	//멀티스레드로 인해 다중접속으로, 경합이 벌어진다.▶▶▶ Vector가 선택된다.
	Vector<String> userVt = new Vector<String>();
	//멀티스레드에서 안전한 자료구조 : Vector
	//싱글스레드에서 안전한 자료구조 : ArrayList
	
	String	title	= null; //방제목
	String	status	= null; //그사람의 상태정보 : 대기실|대화방|...
	boolean isOpen	= false;//공개|비공개
	int		max		= 0;	//입장가능 정원수
	int		current	= 0;	//현재 인원수
	
	//생성자가 필요할까??
	//필요하지! 인스턴스화할때 파라미터로 this로 원본클래스를 보내고, 값들을 초기화시킨다.
	//생성자의 제1역할은 멤버변수의 초기화
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
