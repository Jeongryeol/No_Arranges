package com.ch11;

public class InterfaceSupAction implements InterfaceSup{

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
		// 인터페이스는 단독으로 인스턴스화 할 수 없다.
		// Interface Sup ifs = new InterfaceSup();
		
		// 인터페이스는 구현체 클래스로 인스턴스화 할 수 있다.
		InterfaceSup ifs = new InterfaceSupAction();
	}

}
