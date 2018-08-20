package com.semi.baseballgame_classDividing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.semi.BaseBallGame;

public class BaseBallGameView {

	    //선언부 -선언부에는 절대로 메소드를 호출하지 않는다.
	    JFrame jf_ball = new JFrame();//전역변수
	    JPanel jp_east = new JPanel();//동쪽에 붙일 속지
	    JPanel jp_center = new JPanel();//JFrame
	   
	    //버튼 4개 추가해봐요 - 버튼에 대해서는 이벤트 처리도 해야되니까 전역변수로 하자
	    JButton jbtn_new =new JButton("새게임");
	    JButton jbtn_dap =new JButton("정답");
	    JButton jbtn_clear =new JButton("지우기");
	    JButton jbtn_exit =new JButton("종료");
	   
	    JTextArea jta_display  = new JTextArea();//센터에 배치
	    JScrollPane jsp_display =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	                                    //세로 스크롤바는 쓰고 가로 스크롤바는 쓰지 않음.
	    JTextField jtf_input =new JTextField();
	    Font f = new Font("Thoma",Font.BOLD,16);
	
	    /*
	     *디폴트생성자는 생략할 수 있다. - 파라미터가 없으니까 개발자 대신 해줄 수 있다.
	     *파라미터를 가진 생성자가 하나라도 있으면, 디폴트생성자는 제공안된다.
	     */										//마우스오버 후 콘트롤키 누르면 주소가 보임
	    BaseBallGameLogic bbgLogic = new BaseBallGameLogic( );
	    BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this,bbgLogic);
	    //[추가됨]클래스를 찢었기때문에, (아래 참조) addActionListener가 에러가 났기때문에, 전역에서 인스턴스화 해서 호출한다
	    //파라메터를 view클래스의 주소번지를 넣어서 Event클래스로 넘김(생성자 사용)

	    
	//화면처리 메소드
	public void initDisplay() {
		//이벤트 처리대상 콤퍼넌트와 이벤트 처리 클래스를 매핑하기
		//implements ActionListener 가 있는 클래스는 BaseBallGameEvent로 분리되어서 
		//그 클래스 내부에서 이벤트 처리를 담당하는 actionPerformed메소드를 구현하고 있기 때문에..
		//기존에 입력했던 this는 BaseBallGame를 가리키는 예약어라서 사용할시 에러가 난다.

		//그래서 아래 메소드의 호출의 파라메터에 주소번지의 bbgEvent를 설정하면
		//이벤트처리소스인 버튼(jtf_input)과 이벤트처리를 담당하는 클래스와 연결하도록 코드가 작성된다.
		//(actionPerformed메소드를 연결하도록 메소드를 호출함)
		jtf_input.addActionListener(bbgEvent); 
		jbtn_new.addActionListener(bbgEvent);
		jbtn_clear.addActionListener(bbgEvent);
		jbtn_exit.addActionListener(bbgEvent);
		jbtn_dap.addActionListener(bbgEvent);
		
		jbtn_new.setBackground(new Color(115,9,9));
		jbtn_new.setForeground(new Color(255,9,9));
		jbtn_dap.setBackground(new Color(45,50,3));
		jbtn_dap.setForeground(new Color(255,9,9));
		
		jbtn_clear.setBackground(new Color(46,6,2));
		jbtn_clear.setForeground(new Color(255,9,9));
		
		jbtn_exit.setBackground(new Color(8,73,85));
		jbtn_exit.setForeground(new Color(255,9,9));
		
		jta_display.setLineWrap(true);
		//jp_center속지는 중앙에 JTextArea, 남쪽에 JTextField를 붙일거니까
		//레이아웃은 BorderLayout으로 지정함.
		jp_center.setLayout(new BorderLayout());
		jp_center.setBackground(Color.MAGENTA);
		//버튼 4개를 jp_east속지에 붙이기 위해서는 먼저 레이아웃(배치) 지정해야함.
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.setBackground(Color.blue);
		
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit );
		//Center 속지에 jta_display와 jtf_input붙임 
		//jp_center속지의 중앙에 배치.
		//아직 화면에 속지가 보이지 않아요- 메모리는 로딩되어 있지만 jf_ball에  아직 붙이지 않음.
		jf_ball.add("East",jp_east);
		//jp_center속지를 JFrame붙이기
		
		jp_center.add("Center",jsp_display);
		jp_center.add("Center",jta_display);
		jp_center.add("South",jtf_input);
		jf_ball.add("Center",jp_center);
		
		jf_ball.setTitle("야구숫자게임  ver2.0");
		jf_ball.setSize(300,400);//창의 가로와 세로 길이 지정
		jf_ball.setVisible(true);//창 활성화/비활성화   
		
	}
	
	//메인 메소드
	public static void main(String[] args) {
	      
		BaseBallGame bbgame = new BaseBallGame();
	    bbgame.initDisplay();
	    //bbgame.ranCom();//채번하기
	      
	}

}
