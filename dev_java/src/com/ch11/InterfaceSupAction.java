package com.ch11;

public class InterfaceSupAction implements InterfaceSup{

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
		// �������̽��� �ܵ����� �ν��Ͻ�ȭ �� �� ����.
		// Interface Sup ifs = new InterfaceSup();
		
		// �������̽��� ����ü Ŭ������ �ν��Ͻ�ȭ �� �� �ִ�.
		InterfaceSup ifs = new InterfaceSupAction();
	}

}
