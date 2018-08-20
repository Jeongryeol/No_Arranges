package com.ch7_abst_intrf2;

public abstract class The_Gift {//선물상자에 관한 추상클래스

	//변수선언
	public	int 	contain	= 0;	//담은 선물의 개수
	public	int 	boxEdge	= 0;	//상자의 꼭지점 수
	public	boolean	isRibon	= false;//리본장착여부
	private	double	sizeW;	//박스 너비값
	private	double	sizeD;	//박스 깊이값
	private	double	sizeH;	//박스 높이값

	//일반메소드
	//박스의 사이즈(너비,깊이,높이)를 받아 저장할 getter/setter메소드
	public double getSizeW() {return sizeW;}
	public void setSizeW(double sizeW) {this.sizeW = sizeW;}
	public double getSizeD() {return sizeD;}
	public void setSizeD(double sizeD) {this.sizeD = sizeD;}
	public double getSizeH() {return sizeH;}
	public void setSizeH(double sizeH) {this.sizeH = sizeH;}
	
	//추상메소드
	public abstract void include(int contain);//선물상자에 담는 기능의 밑그림인 추상메소드
	public abstract boolean wrapPattern(String pattern);//선물상자의 포장지와 패턴을 담는 기능의 밑그림인 추상메소드
}
