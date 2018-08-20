package com.ch6;

public class MethodTest4_P251 {

	int showMenu() { int choice=0; return choice; };
	void inputRecord() {}
	void changeRecord() {}
	void searchRecord() {}
	void deleteRecord() {}
	String[][] showRecordList() { String[][] a = new String[5][8]; return a; }
	
	MethodTest4_P251(String constructorInjection) {}
	
	public static void main(String[] args) {
		
		String constructorInjection = "생성자 주입을 위한 파라메터변수";
		MethodTest4_P251 instance = new MethodTest4_P251(constructorInjection);
		
		switch(instance.showMenu()) {
			case 1: instance.inputRecord(); break;
			case 2: instance.changeRecord(); break;
			case 3: instance.searchRecord(); break;
			case 4: instance.deleteRecord(); break;
			default: instance.showRecordList();
			
		}

	}

}
