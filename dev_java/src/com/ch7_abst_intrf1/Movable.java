package com.ch7_abst_intrf1;

public class Movable implements MoveHavior {

	boolean isMove = false;
	@Override
	public boolean move(int x, int y) {
		System.out.println("����� ������ "+x+","+y+" ��ǥ�� �̵��Ǿ����ϴ�.");
		isMove = true;
		return isMove;
	}

}
