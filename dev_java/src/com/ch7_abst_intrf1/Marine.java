package com.ch7_abst_intrf1;

public class Marine implements MoveHavior {

	MoveHavior mHavior =null;
	int x,y;
	public Marine() {
		mHavior = new Movable();
	}
	public Marine(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean move(int x, int y) {
		boolean isMove = false;
		System.out.println("������ "+x+", "+y+"��ǥ�� �̵��Ͽ����ϴ�.");
		if(x>0||y>0) {
			isMove = true;
		}
		return isMove;
	}

}
