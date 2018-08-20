package com.ch6;

class NoteBook {
	String usb = "usb";
	public void usbRead() { System.out.println("부모/usbRead호출성공"); }
	public void usbWrite() { System.out.println("부모/usbWrite호출성공"); }	
}

public class MethodTest3_Inheritance extends NoteBook {

	@Override
	public void usbRead() { System.out.println("자녀/Override/usbRead호출성공"); }
	@Override
	public void usbWrite() { System.out.println("자녀/Override/usbWrite호출성공"); }
/**	@Override
	public int usbWrite() { return 0; } //리턴타입을 지키지 않으면 에러가 발생함. 기존 양식을 그대로 사용해야한다!!	 */
	
	public static void main(String[] args) {	
		//
		NoteBook instParent = new NoteBook();
		instParent.usb = "다른usb";
		instParent.usbRead();
		instParent.usbWrite();
		
		MethodTest3_Inheritance intChild = new MethodTest3_Inheritance(); 
		
	}

}
