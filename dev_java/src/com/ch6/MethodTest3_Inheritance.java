package com.ch6;

class NoteBook {
	String usb = "usb";
	public void usbRead() { System.out.println("�θ�/usbReadȣ�⼺��"); }
	public void usbWrite() { System.out.println("�θ�/usbWriteȣ�⼺��"); }	
}

public class MethodTest3_Inheritance extends NoteBook {

	@Override
	public void usbRead() { System.out.println("�ڳ�/Override/usbReadȣ�⼺��"); }
	@Override
	public void usbWrite() { System.out.println("�ڳ�/Override/usbWriteȣ�⼺��"); }
/**	@Override
	public int usbWrite() { return 0; } //����Ÿ���� ��Ű�� ������ ������ �߻���. ���� ����� �״�� ����ؾ��Ѵ�!!	 */
	
	public static void main(String[] args) {	
		//
		NoteBook instParent = new NoteBook();
		instParent.usb = "�ٸ�usb";
		instParent.usbRead();
		instParent.usbWrite();
		
		MethodTest3_Inheritance intChild = new MethodTest3_Inheritance(); 
		
	}

}
