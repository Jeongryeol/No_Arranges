package com.ch7_abst_intrf1;

public class NonMovable implements MoveHavior {

	boolean isMove = false;//상속받았다면 선언할 필요없겠지만, 재사용 못하기때문에 재선언됨.
	@Override
	public boolean move(int x, int y) {
		System.out.println("당신의 유닛은 "+x+","+y+" 좌표로 이동이 불가능합니다.");
		return isMove;
	}

}
