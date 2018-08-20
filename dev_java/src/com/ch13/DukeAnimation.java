package com.ch13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/* �̹����� ó���ϴ� Ŭ����..
 * �̹����� ������� ���;� ����ó�� ���δ�. >> �迭
 * paint()�޼ҵ� ���? �޼ҵ� ���� ���� ���? ������ ����
 * 1�ʿ� ����� �̹����� �����Ѵ� >> run�޼ҵ�� Thread�� ����Ѵ�.
 */
public class DukeAnimation extends JFrame implements Runnable{
/*�����*/
	int frame;
	Image[] img_arr = null;
	String img_path = "src//com//dukeImages//";
	Thread animator = null;
	Graphics offGraphics = null;//�׷��Ȱ�ü �����ϱ� - ���� �̹����� ����µ� ���
	Dimension offDimension = null;
	Image offImage = null;
	
/*������*/
	//�������� ���� 1) �������(��������,�۷ι�����) �ʱ�ȭ
	public DukeAnimation() {
		initDisplay();
		img_arr = new Image[10];//Duke�� gif������ 10��
		for(int i=1;i<11;i++) {//10���� ������ �迭�� ��ƺ��ô�
							//����üŬ����					//�߻�޼ҵ�	//���ϰ��String
			img_arr[i-1] = Toolkit.getDefaultToolkit().getImage(img_path+"FRAME"+i+".gif");
		}
	}
	
/*��������Ǹ޼ҵ�*/
	//��ũ�� �����ִ� �޼ҵ�
	public void showDuke() {
			//�Ʒ��� ���� Runnable�������̽��� ������ �� ������, �� ������δ� �����ڰ� �ٽ� ȣ��ǹǷ� ���ؾ���
		//Runnable r = new DukeAnimation();
			//�Ʒ��� ����, �����带 �����ؼ� �� Ŭ������ �ּҹ����� �Ѱܼ� �� Ŭ������ ������� �������
		animator = new Thread(this);
		animator.start();
		
	}
	//��ũ�̹����� �׸��� �޼ҵ� ( callback method : repaint()ȣ�� > update()> paint()�޼ҵ� ȣ�� )
	//�̹����� �κп� ���� ó���� update()������� ���۸��� �߰��Ͽ� �̹����� ������ �ʵ��� �ڿ������� ����� ������Ű�µ� ����
	@Override
	public void paint(Graphics g) {
		g.drawImage(img_arr[frame%10], 0, 50, null);
	}
	/**
	 * [��������] ���� �̹����� �ܻ��� ���Ƽ� ���� ���� ��ũ�� �̹������� ��ġ�� ������ �߻���
	 * �� ������ �ذ��ϱ� ���� update�޼ҵ带 ������ ����
	 * ���⼭ ���� �̹����� ����� ���� ������ó���ؾ���
	 */
	//��ũ�̹����� �����ϴ� �޼ҵ�
	public void update(Graphics g) {
		//�������� ȭ��ũ�� ������ ��� ������, �̰��� �����ϰ� ���ִ� �޼ҵ尡 getSize()��
		//�� �޼ҵ��� �����ְ� DememsionŬ����
		Dimension d = getSize();
		if( (offGraphics==null)
				||(d.width != offDimension.width)
				||(d.height != offDimension.width) )
		{
			offDimension = d;
			offImage = createImage(d.width,d.height);
			offGraphics = offImage.getGraphics();
		}
		//���� �̹����� �����
		offGraphics.setColor(getBackground());
		offGraphics.fillRect(0, 0, d.width, d.height);
		offGraphics.setColor(Color.BLACK);
		//��ũ���� �̹��� �������ϱ�
		paint(g);
	}
	//ȭ���� ���� �޼ҵ�
	public void initDisplay() {
		this.setSize(200, 200);
		this.setVisible(true);
		showDuke();
	}
	
/*���θ޼ҵ�*/
	public static void main(String[] args) {
		DukeAnimation dkAni = new DukeAnimation(); //�ν��Ͻ�ȭ(�ٷ� ȭ��ȣ��)
		//��������Ҷ�, ȭ�麸�� �տ� �����ؾ��ұ�, �ڿ� �����ؾ��ұ�?
		//������ ����ϸ鼭 try-catch�� interruptException�� �ɷ��� ȭ���� �� ���...
		//�׷��Ƿ� ȭ���� ���� ������ϰ�, ������ �� �����̴�
	}
	
/*Runnable �������̽��� �����ϴ� �������̵� run()�޼ҵ�*/
	@Override
	public void run() {
		while(true) {
			repaint();//�̹��� �Ѹ��� >> paint() ȣ��
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
