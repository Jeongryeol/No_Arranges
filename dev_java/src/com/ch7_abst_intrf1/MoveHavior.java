package com.ch7_abst_intrf1;

public interface MoveHavior {

	public MoveHavior mHavior = null;
//	public abstract boolean move();
	public boolean move(int x, int y);
	//interface�ȿ��� �߻�޼ҵ�(abstarct method)�� �� �� �����Ƿ� abstract�� ���������ϴ�
}
