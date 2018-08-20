package com.ch6;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Constructor_JTextArea {

	//[선언부]
	JFrame jf = new JFrame();
	JTextArea jta = new JTextArea("초기값을 주어서 텍스트영역을 만들수 있어요",5,3);
//	▲JFrame 내부에 속지로 JTextArea를 넣도록 선언함
	JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
										 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//	▲JTextArea의 속지에 스크롤속지를 붙임.                                                                                                           	
	Constructor_JTextArea jta_test = null;
	/*	위와같이 전역변수로 선언할때 반드시 null로 해야하는 이유?
	 	비어있는 상태일때는 인스턴스변수로 원본을 복제하여 주소번지를 입력하면, 원본의 주소번지를 가질 수 있음	*/
//	Construction_JTextArea jta_test2 = new Construction_JTextArea();
	/*	전역변수의 초기화 값을 를 new로 했을때의 차이?
 		만일 위와 같이 new를 사용해서 인스턴스화 하면, 원본을 사용한 것이 아니라 복제본을 사용하게 됨.	*/
	
	//[생성자]
	public Constructor_JTextArea() {
		System.out.println("Construction_JTextArea 디폴트 생성자 호출 성공");
		//initDisplay();//클래스 안에 있는 메소드를 생성자에서 호출함
	}
	
	//[메소드부]
	//화면 처리 메소드
	public void initDisplay() {
		System.out.println("initDisplay 호출성공");
		jf.add("Center",jsp);//중앙에 jsp스크롤바를 넣음
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	//메소드A
	public void methodA(Constructor_JTextArea jta_test) {
		System.out.println("파라미터로 넘겨져온 주소번지 : "+jta_test);
		this.jta_test = jta_test;//전역변수의 비어있던(null) 참조형타입 jta_test에 파라메터로 넘어온 지역변수를 입력하여 초기화시킴
		jta_test.initDisplay();//주소번지에 따라 해당 클래스 안의 메소드를 호출함
	}
	
	//[메인메소드부]
	public static void main(String[] args) {
/*		아래의 경우 인스턴스의 주소번지를 가지고 있으므로, 파라미러로 넘겨 다른 메소드에서 그 주소번지를 누릴 수 있다.
		이때, 전역변수로 선언하고 파라미터로 초기화 시켜 주기만 하면,
		전역변수가 그 주소번지를 갖게되어 파라미터 변수임에도 불구하고 전역에서 사용가능해진다.*/
		Constructor_JTextArea jta_test = new Constructor_JTextArea();
		jta_test.methodA(jta_test);
		
		new Constructor_JTextArea();//클래스 안에있는 메소드를 메인메소드에 복제함
	}

}
