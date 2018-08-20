package com.ch7_abst_intrf1;

public class Movable implements MoveHavior {

	boolean isMove = false;
	@Override
	public boolean move(int x, int y) {
		System.out.println("당신의 유닛은 "+x+","+y+" 좌표로 이동되었습니다.");
		isMove = true;
		return isMove;
	}

}
