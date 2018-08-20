package com.ch11;

import java.util.Stack;
import java.util.Vector;
/*
 * Stack�� ó���� ���� ������ [��������] ���´�
 * Stack�� ����ִ� ������ ������ ��� ������ [����������] �ȴ�
 * Stack�� Vector�� �ڽ� Ŭ���� ������, [����]�� �ٸ���
 * Stack�� ������ �������� ������ [����]�� �ٸ���
 * Stack�� ��� ������ ������ Vector�ʹ� �޸� [Ű]�� ����� �ʿ䰡 ����.
 * 
 */
public class StackTest {

	public void testJL() {
		Vector vst = new Stack();
		vst.addElement("����");
		vst.addElement("����");
		vst.addElement("�丶��");
		
		System.out.println(vst.firstElement());
		System.out.println(vst.lastElement());
		System.out.println("______________________________");
		
		for(int i=0;i<vst.size();i++) {
			System.out.println(vst.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push("ȣ����");//Pushes an item onto the top of this stack.
		st.push("��繮");
		st.push("�����ϰ�");
		System.out.println("st.size() = "+st.size());
		
		System.out.println(st.firstElement());
		System.out.println(st.lastElement());
		System.out.println("______________________________");
		
		for(int i=0;i<3;i++) {
			System.out.println(st.pop());
		}//First In Last Out
/*		
		for(int i=0;i<st.size();i++) {//������ ����� �پ����⶧���� "ȣ����"�� ������ ����
			System.out.println(st.pop());
		}//First In Last Out
		
		//Tests if this stack is empty.
		System.out.println(st.empty());

		//Removes the object at the top of this stack and returns that object as the value of this function.
		System.out.println(st.pop());
		
		//Tests if this stack is empty.
		System.out.println(st.empty());
	*/	
		System.out.println("______________________________");
		System.out.println("______________________________");
		StackTest st2 = new StackTest();
		st2.testJL();
	}
	
}
