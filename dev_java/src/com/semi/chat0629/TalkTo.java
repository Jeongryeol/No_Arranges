package com.semi.chat0629;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
class ChatImg extends JPanel {
	String imgPath = "src\\com\\images\\";
	ImageIcon img_back = new ImageIcon(imgPath+"talk.jpg");
	MultiClient mClient = null;
	public ChatImg() {}
	public void paintComponent(Graphics g) {
		setLayout(null);
		g.drawImage(img_back.getImage(), 0,0,null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
public class TalkTo extends JFrame {
	public TalkTo() {
		setContentPane(new ChatImg());
		initDisplay();
	}
	
	public void initDisplay() {
		this.setSize(1000,700);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TalkTo();
	}

}
