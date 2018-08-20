package com.semi.chat0706;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PictureMessage extends JDialog implements ActionListener{
	JPanel jp_emoticon = new JPanel();
	JButton jbtn_emo1 = new JButton();
	JButton jbtn_emo2 = new JButton();
	JButton jbtn_emo3 = new JButton();
	JButton jbtn_emo4 = new JButton();
	ImageIcon imgs[] = new ImageIcon[4];
	JButton jbtns[] = {jbtn_emo1,jbtn_emo2,jbtn_emo3,jbtn_emo4};
	String[] imgsFile = {"Æ¼Ã¿»Ð»Ð.gif", "Æ¼Ã¿½½ÇÄ.gif", "Æ¼Ã¿²¦²¦.gif","Æ¼Ã¿ÀÕÈþ.gif"};
	String imgChoice = "default";
	String imgPath = "src\\com\\images\\emoticon\\";
	public PictureMessage() {
		initDisplay();	
	}
	public void initDisplay() {
		for(int i=0;i<imgs.length;i++) {
			imgs[i] = new ImageIcon(imgPath+imgsFile[i]);
			jbtns[i].setIcon(imgs[i]);
			jbtns[i].setBorder(null);
			jbtns[i].addActionListener(this);
		}
		jp_emoticon.setLayout(new GridLayout(1,4,2,2));
		for(int i=0;i<imgs.length;i++) {
			jp_emoticon.add(jbtns[i]);
		}
		this.add("Center", jp_emoticon);
		this.setResizable(false);
		this.setSize(300,150);
		this.setVisible(false);
	}
/*	public static void main(String args[]) {
		new PictureMessage();
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_emo1) {
			imgChoice = "Æ¼Ã¿»Ð»Ð.gif";
			dispose();
		}
		else if(obj==jbtn_emo2) {
			imgChoice = "Æ¼Ã¿½½ÇÄ.gif";
			dispose();
		}
		else if(obj==jbtn_emo3) {
			imgChoice = "Æ¼Ã¿²¦²¦.gif";
			dispose();
		}
		else if(obj==jbtn_emo4) {
			imgChoice = "Æ¼Ã¿ÀÕÈþ.gif";
			dispose();
		}
	}
}













