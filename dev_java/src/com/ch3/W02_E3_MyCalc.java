package com.ch3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class W02_E3_MyCalc {

	public static void main(String[] args) {
		//북쪽(north)에 JTextField를 추가하고 싶어요. 어떡하지? 인스턴스화
		JTextField jtf_display = new JTextField();
		boolean isView = false;
		//[반응형 만들기] 화면을 보여줄지 여부를 사용자로부터 입력 받아서 처리하기
		String userView = JOptionPane.showInputDialog("화면을 출력할 지 여부를 true 혹은  false로 입력하세요.");
		//윈도우 창에 화면을 띄우고 싶어요 - 누가 해줄까요? JFrame
		//어떻게 사용하면 되죠? - 인스턴스 화
		JFrame jf_calc = new JFrame();
		//창의 크기를 어떻게 반영할 수 있죠 ? - 메소드 - 메소드 이름이 뭐지? setSize (가로-int, 세로-int);
		jf_calc.setSize(500,(int)300.67);
		//창을 화면에 보여주고 싶어요 또는 창을 화면에 안보이게 하고 싶어요. 이럴땐 어떡하지? setVisible(boolean);
		//화면에 보여주고 싶어요.
		//나는 메소드를 호출할 수 있다. - 파라미터와 리턴타입을 고려할 수 있다.
		isView = Boolean.parseBoolean(userView);
		//insert here - 내가 만든 계산기 라고 출력하고 싶어요. 어떡하지? - setTitle(String title);
		String title = "내가 만든 계산기 Ver1.0";
		//JFrame 창 북쪽에 JText Field를 보여줄래?
		jf_calc.add("North",jtf_display);//입력창(JTextFiedl)를 "North"(북쪽)에 추가하는 메소드 add
		//버튼에 사용될 문자열을 변수로 선언해 보세요.
		String first = "1";
		String sec	 = "2";
		String plus	 = "+";
		String equal = "=";	
		String ac	 = "AC";
		String close = "닫기";
		//insert here - 숫자1버튼, 숫자2버튼, +연산자버튼, =대입연산자버튼, AC버튼, 닫기버튼 추가 -> 인스턴스화
		JButton jbtn_one = new JButton(first);//문자타입을 선언한 객체를 담아주어야 버튼으로 만들수있음.
		JButton jbtn_two = new JButton(sec);
		JButton jbtn_plus = new JButton(plus);
		JButton jbtn_ac = new JButton(ac);
		JButton jbtn_close = new JButton(close);
		JButton jbtn_equal = new JButton(equal);
		Font f = new Font("돋움체",Font.BOLD,40);
		jbtn_plus.setFont(f);
		jbtn_plus.setForeground(Color.BLUE);
		jbtn_equal.setFont(f);
		jbtn_equal.setForeground(Color.BLACK);
		jbtn_close.setFont(new Font("돋움체",Font.ITALIC,20));
		jbtn_close.setForeground(Color.RED);
		//속지(JPanel)을 center자리에 위치시키고, 만들어낸 버튼을 차례대로 넣되, 균등하게 분배하고 싶다. ->
		JPanel jp_center = new JPanel();//속지만들기
		jp_center.setLayout(new GridLayout(1,6));//속지에 레이아웃을 잡아주기, 1줄에 6등분
		jp_center.add(jbtn_one);//6개의 객체 순서대로 생성
		jp_center.add(jbtn_two);
		jp_center.add(jbtn_plus);
		jp_center.add(jbtn_equal);
		jp_center.add(jbtn_ac);
		jp_center.add(jbtn_close);
		//만들어준 속지(JPanel)를 JFrame의 중앙에 붙여주기
		jf_calc.setTitle(title);
		jf_calc.add("Center", jp_center);//위치를 의미하는 문자스트링은 첫글자가 대문자여야 인식함 "center" 미인식
		jf_calc.setVisible(isView);
		//true : 보여준다.   false : 안보여준다(그러나 메모리에는 남아있다.)
		//버튼은 어떻게 사용하지? - 인스턴스화 -> 누가 그 일을 해주지? JButton

		//버튼의 라벨은 어떻게 붙여줄까? - 메소드 - setText( ) ?

	}

}
