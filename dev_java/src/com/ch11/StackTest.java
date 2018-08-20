package com.ch11;

import java.util.Stack;
import java.util.Vector;
/*
 * Stack은 처음에 담은 정보가 [마지막에] 나온다
 * Stack에 들어있는 정보를 꺼내면 담긴 정보는 [빠져나오게] 된다
 * Stack은 Vector의 자식 클래스 이지만, [순서]가 다르다
 * Stack에 정보를 담을때와 꺼낼때 [순서]가 다르다
 * Stack에 담긴 정보를 꺼낼때 Vector와는 달리 [키]를 사용할 필요가 없다.
 * 
 */
public class StackTest {

	public void testJL() {
		Vector vst = new Stack();
		vst.addElement("감자");
		vst.addElement("고구마");
		vst.addElement("토마토");
		
		System.out.println(vst.firstElement());
		System.out.println(vst.lastElement());
		System.out.println("______________________________");
		
		for(int i=0;i<vst.size();i++) {
			System.out.println(vst.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push("호가든");//Pushes an item onto the top of this stack.
		st.push("블루문");
		st.push("에펜하겐");
		System.out.println("st.size() = "+st.size());
		
		System.out.println(st.firstElement());
		System.out.println(st.lastElement());
		System.out.println("______________________________");
		
		for(int i=0;i<3;i++) {
			System.out.println(st.pop());
		}//First In Last Out
/*		
		for(int i=0;i<st.size();i++) {//뽑혀서 사이즈가 줄어들었기때문에 "호가든"은 뽑히지 않음
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
