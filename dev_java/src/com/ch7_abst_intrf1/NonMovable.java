package com.ch7_abst_intrf1;

public class NonMovable implements MoveHavior {

	boolean isMove = false;//��ӹ޾Ҵٸ� ������ �ʿ��������, ���� ���ϱ⶧���� �缱���.
	@Override
	public boolean move(int x, int y) {
		System.out.println("����� ������ "+x+","+y+" ��ǥ�� �̵��� �Ұ����մϴ�.");
		return isMove;
	}

}
