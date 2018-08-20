package com.ch13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DukeAnimation2 extends Frame implements Runnable{
	int frame = 0;//Image배열에 대한 인덱스를 담을 변수
	String imgPath = "src//com//dukeImages//";
	Image[] imgs = new Image[10];
	Thread animator = null;
	//그래픽 객체 선언 하기 - 이전 이미지를 지우는데 사용
	Graphics offGraphics = null;
	Dimension offDimension = null;
	Image offImage;
	//멤버변수 초기화
	public DukeAnimation2() {
		for(int i=1;i<11;i++) {
			imgs[i-1]=
			Toolkit.getDefaultToolkit(
					).getImage(imgPath+"FRAME"+i+".GIF");
		}
	}
	public void showDuke() {
		animator = new Thread(this);
		animator.start();
	}
	public void initDisplay() {
		setBackground(Color.RED);
		this.setSize(200,200);
		this.setVisible(true);
		showDuke();
	}
	//문제제기
	//현재 이미지의 잔상이 남아서 손을 흔드는 듀크의 이미지들이 겹쳐지는 현상이 발생함.
	//이 문제를 해결하기 위해 update메소드를 구현할 것임.
	//여기서 이전 이미지를 지우고 새로 페인팅 처리해야 됨.
	public void update(Graphics g) {
		//윈도우 화면의 크기 정보를 얻고 싶을 때 이것을 가능하게 해주는 메소드가 getSize()임.
		//이 메소드의 소유주가 Dimension클래스 임.
		Dimension d = getSize();
		if(offGraphics == null 
		||(d.width != offDimension.width)
		||(d.height != offDimension.height))
		{
			offDimension = d;
			offImage = createImage(d.width,d.height);
			offGraphics = offImage.getGraphics();
		}
		//이전 이미지를 지운다.
		offGraphics.setColor(getBackground());
		offGraphics.fillRect(0, 0, d.width, d.height);
		offGraphics.setColor(Color.BLACK);
		paintFrame(offGraphics);
		//스크린에 이미지 페인팅하기
		paint(g);
	}
	public void paintFrame(Graphics g) {
		g.drawImage(imgs[frame%10], 0, 0, null);
	}
	//이미지를 화면에 그리기 구현 - callback method   repaint()-update()-paint()
	public void paint(Graphics g) {
		if(offImage!=null) {
			g.drawImage(offImage, 0, 50, null);
		}
	}
	public static void main(String[] args) {
		DukeAnimation2 duke = new DukeAnimation2();
		//소켓통신
		duke.initDisplay();
	}
	@Override
	public void run() {
		while(true) {
			repaint();//paint()호출
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				break;
			}
			frame++;
		}////////////end of while
	}////////////////end of run

}












