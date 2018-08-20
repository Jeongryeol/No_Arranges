package com.ch7_abst_intrf1;

public interface MoveHavior {

	public MoveHavior mHavior = null;
//	public abstract boolean move();
	public boolean move(int x, int y);
	//interface안에는 추상메소드(abstarct method)만 올 수 있으므로 abstract는 생략가능하다
}
