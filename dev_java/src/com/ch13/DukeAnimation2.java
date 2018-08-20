package com.ch13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DukeAnimation2 extends Frame implements Runnable{
	int frame = 0;//Image�迭�� ���� �ε����� ���� ����
	String imgPath = "src//com//dukeImages//";
	Image[] imgs = new Image[10];
	Thread animator = null;
	//�׷��� ��ü ���� �ϱ� - ���� �̹����� ����µ� ���
	Graphics offGraphics = null;
	Dimension offDimension = null;
	Image offImage;
	//������� �ʱ�ȭ
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
	//��������
	//���� �̹����� �ܻ��� ���Ƽ� ���� ���� ��ũ�� �̹������� �������� ������ �߻���.
	//�� ������ �ذ��ϱ� ���� update�޼ҵ带 ������ ����.
	//���⼭ ���� �̹����� ����� ���� ������ ó���ؾ� ��.
	public void update(Graphics g) {
		//������ ȭ���� ũ�� ������ ��� ���� �� �̰��� �����ϰ� ���ִ� �޼ҵ尡 getSize()��.
		//�� �޼ҵ��� �����ְ� DimensionŬ���� ��.
		Dimension d = getSize();
		if(offGraphics == null 
		||(d.width != offDimension.width)
		||(d.height != offDimension.height))
		{
			offDimension = d;
			offImage = createImage(d.width,d.height);
			offGraphics = offImage.getGraphics();
		}
		//���� �̹����� �����.
		offGraphics.setColor(getBackground());
		offGraphics.fillRect(0, 0, d.width, d.height);
		offGraphics.setColor(Color.BLACK);
		paintFrame(offGraphics);
		//��ũ���� �̹��� �������ϱ�
		paint(g);
	}
	public void paintFrame(Graphics g) {
		g.drawImage(imgs[frame%10], 0, 0, null);
	}
	//�̹����� ȭ�鿡 �׸��� ���� - callback method   repaint()-update()-paint()
	public void paint(Graphics g) {
		if(offImage!=null) {
			g.drawImage(offImage, 0, 50, null);
		}
	}
	public static void main(String[] args) {
		DukeAnimation2 duke = new DukeAnimation2();
		//�������
		duke.initDisplay();
	}
	@Override
	public void run() {
		while(true) {
			repaint();//paint()ȣ��
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				break;
			}
			frame++;
		}////////////end of while
	}////////////////end of run

}












