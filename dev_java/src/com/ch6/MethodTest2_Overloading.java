package com.ch6;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MethodTest2_Overloading {//메소드 오버로딩 연습

	JFrame jf = new JFrame();
	
	int 	sizeW;
	int 	sizeH;
	Boolean popUp;
	String 	result;
	String 	userID 	= null;
	int 	address = 0;
	String title;
	
	//아이디 중복검사창 : 가로크기, 세로크기 정의
	public String windowOpen(int userID) {
		title = "아이디중복검사";		jf.setTitle(title);
		sizeW = 300; sizeH = 150;			jf.setSize(sizeW,sizeH);
		popUp = true;						jf.setVisible(popUp);
		System.out.println("아이디중복검사 메소드 오버로딩 성공 userID : "+userID);
		return result;
	}
	//우편번호 검색 : 가로크기, 세로크기 정의
	public String windowOpen(String address) {
		title = "우편번호검색";					jf.setTitle(title);
		sizeW = 500; sizeH = 850;			jf.setSize(sizeW,sizeH);
		popUp = true;						jf.setVisible(popUp);
		System.out.println("우편번호검색 메소드 오버로딩 성공 address : "+address);
		return result;
	}
	//도서 검색 : 가로크기, 세로크기정의
	public String windowOpen(String bookName,int writtenTime) {
		title = "도서검색";					jf.setTitle(title);
		sizeW = 800; sizeH = 1200;			jf.setSize(sizeW,sizeH);
		popUp = true;						jf.setVisible(popUp);
		System.out.println("도서검색 메소드 오버로딩 성공 도서명 : "+bookName);
		return result;
	}
	
	
	void windowOpen(int sizeW, int sizeH, String title, boolean popUp) {
		jf.setTitle(title);  jf.setSize(sizeW, sizeH);	jf.setVisible(popUp);
		System.out.println("windowOpen 오버로딩 타입2-1 호출성공");
	}
	void windowOpen(String title,int sizeW, int sizeH, boolean popUp) {
		jf.setTitle(title);  jf.setSize(sizeW, sizeH);	jf.setVisible(popUp);
		System.out.println("windowOpen 오버로딩 타입2-2 호출성공");
	}
	void windowOpen(int sizeW, int sizeH, boolean popUp, String title) {
		jf.setTitle(title);  jf.setSize(sizeW, sizeH);	jf.setVisible(popUp);
		System.out.println("windowOpen 오버로딩 타입2-3 호출성공");
	}
	
	
	public static void main(String[] args) {
		MethodTest2_Overloading winTest = new MethodTest2_Overloading();
		String insertID = JOptionPane.showInputDialog(winTest.jf,"중복검사할 아이디를 입력해주세요.");
		int userID = Integer.parseInt(insertID);
		winTest.windowOpen(userID);
		
		String address = JOptionPane.showInputDialog(winTest.jf,"검색할 주소를 입력해주세요.");
		winTest.windowOpen(address);
		
		String bookName = JOptionPane.showInputDialog(winTest.jf,"검색할 책이름을 입력해주세요.");
		String insertWrittenTime = JOptionPane.showInputDialog(winTest.jf,"검색할 책의 출판일자를 입력해주세요.");
		int writtenTime = Integer.parseInt(insertWrittenTime);
		winTest.windowOpen(bookName,writtenTime);
		
		winTest.sizeW = 400; winTest.sizeH = 500; winTest.title="오버로딩 타입1"; winTest.popUp = true;
		winTest.windowOpen(winTest.sizeW,winTest.sizeH,winTest.title,winTest.popUp);//메소드 오버로딩 타입2-1
		winTest.windowOpen(winTest.title,winTest.sizeW,winTest.sizeH,winTest.popUp);//메소드 오버로딩 타입2-2
		winTest.windowOpen(winTest.sizeW,winTest.sizeH,winTest.popUp,winTest.title);//메소드 오버로딩 타입2-3
		//같은이름의 메소드가 파라미터에 의해 속성,순서,개수에 의해 오버로딩되어 개별구분이 가능하다. 
		
	}
}