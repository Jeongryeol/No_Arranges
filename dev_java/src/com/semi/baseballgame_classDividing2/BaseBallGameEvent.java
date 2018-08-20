package com.semi.baseballgame_classDividing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseBallGameEvent implements ActionListener{

	int cnt = 0;
	
/*	JTextArea jta_display  = new JTextArea();//센터에 배치
	JScrollPane jsp_display =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	                                    //세로 스크롤바는 쓰고 가로 스크롤바는 쓰지 않음.
	JTextField jtf_input =new JTextField();*/
	
	BaseBallGameLogic bbgl = null;
	public BaseBallGameEvent(BaseBallGameLogic bbgl) {
		this.bbgl = bbgl;
	}
	
	BaseBallGameView bbgv  = null;					 
	//상기 bbgv를 인스턴스화 하지 않아도
	//View클래스에서 인스턴스화할때 파라미터에 view클래스의 주소번지(this)를 넘겨서 보내왔기 때문에
	//아래 생성자의 파라미터로 Event클래스의 전역변수로 선언된 bbgv를 집어넣었고
	public BaseBallGameEvent(BaseBallGameView bbgv,BaseBallGameLogic bbgl) {
		this.bbgv = bbgv;//전역변수의 bbgv와 파라메터로 들어온 bbgv를 같게 초기화해준다.
		this.bbgl = bbgl;//전역변수의 bbgl와 파라메터로 들어온 bbgl를 같게 초기화해준다.
		//이 코드에는 전역변수의 값에 지역변수의 주소번지가 입력되어있기 때문에
		//아래 actionPerformed 메소드는  변수들을 누릴 수 있게 되기때문에
		//인스턴스변수 bbgv만을 변수앞에 입력하는 것 만으로, 상기 행간주석부분의 변수선언은 필요없어진다.
	}
	
	public BaseBallGameEvent(BaseBallGameView bbgv) {
		this.bbgv = bbgv;
	}//여러 생성자를 만들수 있음
	
	//이벤트 판정하는 ???	
	@Override
	public void actionPerformed(ActionEvent e) {

	      
	   Object obj = e.getSource();//이벤트가 발생한 클래스의 주소번지
	   String label = e.getActionCommand();//버튼의 라벨 -새게임, 정답,지우기, 종료
	   System.out.println(obj);
	   System.out.println(label);
	   
	   
	   if(obj==bbgv.jtf_input){
	      //jta_display.append(jtf_input.getText()+"\n");//append 덧붙이다
	      //사용자가 3자리 숫자를 입력하고 enter쳤을 때 아래처럼 출력해 주세요
	      //1회 257 : 0스 1볼
	      //2회 526 : 1스 0
		   bbgv. jta_display.append((cnt++)+"회."+bbgv.jtf_input.getText()+":"+bbgl.result(bbgv.jtf_input.getText())+"\n");
		   bbgv.jtf_input.setText("");
	      
	      }
	   //너 새게임버튼 클릭한거야?
	   //else if(obj==jbtn_new) {//주소번지가 같아?
	   else if("새게임".equals(label)) {//너가 클릭한 버튼의 문자열이 새게임이야? 주소번지(who? jbtn_new)가 가진 문자열을 비교
	      bbgl.ranCom();
	   }
	   //너 지우기 버튼 누른거야?
	   else if("지우기".equals(label)) {
	      bbgv.jta_display.setText("");
	   }
	   else if("종료".equals(label)) {
	      System.exit(0);
	   }
	    else if("정답".equals(label)) {
	      bbgv.jtf_input.setText("");   
	  }
	   
	}
	
}
