package com.semi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame_ArrayTest implements ActionListener{//-클래스안에서만 쓸수 있음
	   //선언부 -선언부에는 절대로 메소드를 호출하지 않는다.
	   JFrame jf_ball = new JFrame();//전역변수
	   JPanel jp_east = new JPanel();//동쪽에 붙일 속지
	   JPanel jp_center = new JPanel();//JFrame
	   
	   //버튼 4개 추가해봐요 - 버튼에 대해서는 이벤트 처리도 해야되니까 전역변수로 하자
	   //이벤트 처리는 따로 메소드를 꺼내서 처리한다. -전역변수
/*	   JButton jbtn_new =new JButton("새게임");
	   JButton jbtn_dap =new JButton("정답");
	   JButton jbtn_clear =new JButton("지우기");
	   JButton jbtn_exit =new JButton("종료");*/
	   
	   JButton jbtns[] = new JButton[4];//JButton을 배열로 하기위해서 배열선언!! jbtns의 방을 만들었고, 각 방에는 주소번지가 들어있다.
	   String jbtns_label[] = {"새게임","정답","지우기","종료"};//버튼의 라벨글자를 배열로 만들어둠
	   Color colors[] = new Color[jbtns.length];//색상도 배열로 지정하고, 기 정의된 배열의 길이를 이용하여 배열개수 설정
//	   colors[0] = new Color(45,50,3); //전역위치에서는 변수는 선언만 가능하고, 초기화는 불가능하다.
//	      단, static color로 지정해서 초기화할 수 있지만, 문제가 되므로 지양해야할 방법이다.
	   JTextArea jta_display  = new JTextArea();//센터에 배치
	   JScrollPane jsp_display =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	                                    //세로 스크롤바는 쓰고 가로 스크롤바는 쓰지 않음.
	   JTextField jtf_input =new JTextField();
	   Font f = new Font("Thoma",Font.BOLD,16);
	   //컴터가 채번한 값을 담을 배열
	   int com[] =new int[3];
	   //사용자가 입력한 값을 담을 배열
	   int user[] =new int[3];
	   //힌트에 사용될 스트라이크 갯수를 담을 변수
	   int strike = 0;
	   //힌트에 사용될 볼 갯수를 담을 변수
	   int ball = 0;
	   //회차를 출력하는 변수 선언
	   int cnt =1;
	   Random r =new Random();
	   //컴터가 채번한 값을 결정하는 메소드 구현
	   public void ranCom() {
	      // Do-while문은 한번은 찍고 나서(실행시키고) while문 안에 있는 조건을 검색하고,
	      //그 조건을 충족할 경우엔 끝낸다! 충족하지 않을 경우엔 다시 do {}로 가서 반복 
	      com[0] = r.nextInt(10);
	      do {
	         com[1] = r.nextInt(10);
	      }while(com[0]==com[1]);
	      do {
	         com[2] = r.nextInt(10);
	      }while(com[0]==com[2] || com[1]==com[2]);
	   }
	   //화면처리부
	   public void initDisplay() {
		   for(int i=0;i<jbtns.length;i++) {//배열로 정의한 내용을 for문으로 구현
			   jbtns[i] = new JButton(jbtns_label[i]);
			   jbtns[i].addActionListener(this);
			   jbtns[i].setForeground(new Color(255,9,9));
			   if(i==0) {//if문을 이용하여 컬러값을 개별로 넣어줌
				   colors[i] = new Color(115,9,9);
				   jbtns[i].setBackground(colors[i]);
			   }
			   else if(i==1) {
				   colors[i] = new Color(45,50,3);
				   jbtns[i].setBackground(colors[i]);			   
			   }
			   else if(i==2) {
				   colors[i] = new Color(46,6,2);
				   jbtns[i].setBackground(colors[i]);			   
			   }
			   else if(i==3) {
				   colors[i] = new Color(8,73,85);
				   jbtns[i].setBackground(colors[i]);			   
			   }
		   }
		   //이벤트 처리대상 콤퍼넌트와 이벤트 처리 클래스를 매핑하기
	       //여기서 this는 BaseBallGame를 가리키는 예약어 인데
	       //이벤트 처리를 담당하는 actionPerformed메소드를 구현하고 있기 때문에..
	       jtf_input.addActionListener(this);
/*	       jbtn_new.addActionListener(this);
	       jbtn_clear.addActionListener(this);
	       jbtn_exit.addActionListener(this);
	       jbtn_dap.addActionListener(this);*/
//	       jbtns[0].setBackground(new Color(115,9,9));
	//     colors[0] = new Color(115,9,9);
	//     jbtns[0].setBackground(colors[0]);
//	       jbtn_new.setForeground(new Color(255,9,9));
	//     jbtns[1].setBackground(new Color(45,50,3));       
//	       jbtn_dap.setForeground(new Color(255,9,9));
	//     jbtns[2].setBackground(new Color(46,6,2));
//	       jbtn_clear.setForeground(new Color(255,9,9));
	//     jbtns[3].setBackground(new Color(8,73,85));
//	       jbtn_exit.setForeground(new Color(255,9,9));
	       jta_display.setLineWrap(true);
	       //jp_center속지는 중앙에 JTextArea, 남쪽에 JTextField를 붙일거니까
	       //레이아웃은 BorderLayout으로 지정함.
	       jp_center.setLayout(new BorderLayout());
	       jp_center.setBackground(Color.MAGENTA);
	       //버튼 4개를 jp_east속지에 붙이기 위해서는 먼저 레이아웃(배치) 지정해야함.
	       jp_east.setLayout(new GridLayout(4,1));
	       jp_east.setBackground(Color.blue);
	      
/*	      jp_east.add(jbtn_new);
	      jp_east.add(jbtn_dap);
	      jp_east.add(jbtn_clear);
	      jp_east.add(jbtn_exit );*/
		  for(int i=0;i<jbtns.length;i++) {//배열로 정의한 내용을 for문으로 구현
			   jp_east.add(jbtns[i]);
		  }
	      //Center 속지에 jta_display와 jtf_input붙임 
	      //jp_center속지의 중앙에 배치.
	      //아직 화면에 속지가 보이지 않아요- 메모리는 로딩되어 있지만 jf_ball에  아직 붙이지 않음.
	      jf_ball.add("East",jp_east);
	      //jp_center속지를 JFrame붙이기
	      
	      jp_center.add("Center",jsp_display);
	      jp_center.add("Center",jta_display);
	      jp_center.add("South",jtf_input);
	      jf_ball.add("Center",jp_center);
	      
	      jf_ball.setTitle("야구숫자게임");
	      jf_ball.setSize(300,400);//창의 가로와 세로 길이 지정
	      jf_ball.setVisible(true);//창 활성화/비활성화   
	      
	   }
	   
	   //게임 로직 처리하는 메소드
	   public String result(String userInPut) {
	      //힌트에 사용될 스트라이크 갯수를 담을 변수
	      int strike = 0;
	      //힌트에 사용될 볼 갯수를 담을 변수
	      int ball = 0;//지역변수
	      //입력받은 무자열을 정수타입으로 바꾸어 담을 변수선언
	      int temp = 0;
	      temp =Integer.parseInt(userInPut);
	      user[0] =temp/100;
	      user[1] = (temp%100)/10;
	      user[2] = temp%10; 
	      for (int i=0;i<3;i++) {
	         for(int j=0;j<3;j++) {
	            if(user[i]==com[j]) {
	               if(i==j) {
	                  strike++;
	               }
	               else {
	                  ball++;
	               }
	            }////////////////////////end of if
	         }///////////////////////////end of inner for
	      }//////////////////////////////end of outter for
	      if(strike==3) {
	      return "정답입니다";   
	      }
	      
	      return +strike+"스"+ball+ "볼";//지역변수
	   }/////////////////////////////////end of result
	   

	   //메인메소드
	   public static void main(String[] args) {
	      //insert here - initDisplay()호출하기
	      //내안에 있는 메소드는 인스턴스화 없이 사용할 수 있지, 그런데 non-static은 static영역에서 사용불가니까
	      //인스턴스화 해야함.
	      BaseBallGame bbgame = new BaseBallGame();
	      bbgame.initDisplay();
	      bbgame.ranCom();//채번하기
	      
	   }
	   @Override
	   public void actionPerformed(ActionEvent e) {
	      
	      Object obj = e.getSource();//이벤트가 발생한 클래스의 주소번지
	      String label = e.getActionCommand();//버튼의 라벨 -새게임, 정답,지우기, 종료
	      System.out.println(obj);
	      System.out.println(label);
	      
	      
	      if(obj==jtf_input){
	         //jta_display.append(jtf_input.getText()+"\n");//append 덧붙이다
	         //사용자가 3자리 숫자를 입력하고 enter쳤을 때 아래처럼 출력해 주세요
	         //1회 257 : 0스 1볼
	         //2회 526 : 1스 0
	         jta_display.append((cnt++)+"회."+jtf_input.getText()+":"+result(jtf_input.getText())+"\n");
	         jtf_input.setText("");
	         
	         }
	      //너 새게임버튼 클릭한거야?
	      //else if(obj==jbtn_new) {//주소번지가 같아?
	      else if("새게임".equals(label)) {//너가 클릭한 버튼의 문자열이 새게임이야? 주소번지(who? jbtn_new)가 가진 문자열을 비교
	         ranCom();
	      }
	      //너 지우기 버튼 누른거야?
	      else if("지우기".equals(label)) {
	         jta_display.setText("");
	      }
	      else if("종료".equals(label)) {
	         System.exit(0);
	      }
	       else if("정답".equals(label)) {
	          jtf_input.setText("");   
	     }
	      
	      }

	   
	}