package com.ch13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/* 이미지를 처리하는 클래스..
 * 이미지가 순서대로 나와야 영상처럼 보인다. >> 배열
 * paint()메소드 어떨까? 메소드 별로 따로 쏜다? 전역에 두자
 * 1초에 몇번씩 이미지를 쏴야한다 >> run메소드로 Thread를 써야한다.
 */
public class DukeAnimation extends JFrame implements Runnable{
/*선언부*/
	int frame;
	Image[] img_arr = null;
	String img_path = "src//com//dukeImages//";
	Thread animator = null;
	Graphics offGraphics = null;//그래픽객체 선언하기 - 이전 이미지를 지우는데 사용
	Dimension offDimension = null;
	Image offImage = null;
	
/*생성자*/
	//생성자의 역할 1) 멤버변수(전역변수,글로벌변수) 초기화
	public DukeAnimation() {
		initDisplay();
		img_arr = new Image[10];//Duke의 gif파일이 10장
		for(int i=1;i<11;i++) {//10장의 사진을 배열에 담아봅시다
							//구현체클래스					//추상메소드	//파일경로String
			img_arr[i-1] = Toolkit.getDefaultToolkit().getImage(img_path+"FRAME"+i+".gif");
		}
	}
	
/*사용자정의메소드*/
	//듀크를 보여주는 메소드
	public void showDuke() {
			//아래와 같이 Runnable인터페이스를 구현할 수 있지만, 이 방법으로는 생성자가 다시 호출되므로 피해야함
		//Runnable r = new DukeAnimation();
			//아래와 같이, 쓰레드를 선언해서 이 클래스의 주소번지를 넘겨서 이 클래스의 쓰레드로 만들어줌
		animator = new Thread(this);
		animator.start();
		
	}
	//듀크이미지를 그리는 메소드 ( callback method : repaint()호출 > update()> paint()메소드 호출 )
	//이미지의 부분에 대한 처리를 update()기능으로 버퍼링을 추가하여 이미지가 끊기지 않도록 자연스럽게 만들어 개선시키는데 도움
	@Override
	public void paint(Graphics g) {
		g.drawImage(img_arr[frame%10], 0, 50, null);
	}
	/**
	 * [문제제기] 현재 이미지의 잔상이 남아서 손을 흔드는 듀크의 이미지들이 겹치는 현상이 발생함
	 * 이 문제를 해결하기 위해 update메소드를 구현할 것임
	 * 여기서 이전 이미지를 지우고 새로 페인팅처리해야함
	 */
	//듀크이미지를 갱신하는 메소드
	public void update(Graphics g) {
		//윈도우의 화면크기 정보를 얻고 싶을때, 이것을 가능하게 해주는 메소드가 getSize()임
		//이 메소드의 소유주가 Dememsion클래스
		Dimension d = getSize();
		if( (offGraphics==null)
				||(d.width != offDimension.width)
				||(d.height != offDimension.width) )
		{
			offDimension = d;
			offImage = createImage(d.width,d.height);
			offGraphics = offImage.getGraphics();
		}
		//이전 이미지를 지운다
		offGraphics.setColor(getBackground());
		offGraphics.fillRect(0, 0, d.width, d.height);
		offGraphics.setColor(Color.BLACK);
		//스크린에 이미지 페인팅하기
		paint(g);
	}
	//화면을 띄우는 메소드
	public void initDisplay() {
		this.setSize(200, 200);
		this.setVisible(true);
		showDuke();
	}
	
/*메인메소드*/
	public static void main(String[] args) {
		DukeAnimation dkAni = new DukeAnimation(); //인스턴스화(바로 화면호출)
		//소켓통신할때, 화면보다 앞에 선언해야할까, 뒤에 선언해야할까?
		//소켓은 대기하면서 try-catch에 interruptException에 걸려서 화면이 안 뜰것...
		//그러므로 화면을 먼저 띄워야하고, 소켓이 그 다음이다
	}
	
/*Runnable 인터페이스를 구현하는 오버라이드 run()메소드*/
	@Override
	public void run() {
		while(true) {
			repaint();//이미지 뿌리기 >> paint() 호출
			try{
				Thread.sleep(100);
			}catch (InterruptedException ite) {
				ite.printStackTrace();
				break;
			}
			frame++;
		}
	}
}
