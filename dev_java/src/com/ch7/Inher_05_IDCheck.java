package com.ch7;
import javax.swing.JDialog;
public class Inher_05_IDCheck extends Inher_05_PopUp {
	JDialog jd_id = new JDialog();
	public Inher_05_IDCheck() {
		diaLogView(200,100,"아이디중복체크",true);
	}
	public Inher_05_IDCheck(String str) {
		System.out.println
		("IDCheck(String str) 생성자 호출됨 :: initDisplay()가 호출되지않음");	}
	@Override
	public void diaLogView(int w, int h, String title, boolean vs) {
		System.out.println("IDCheck diaLogView 호출성공");
		jd_id.setSize(w,h);
		jd_id.setTitle(title);
		jd_id.setVisible(vs);
	}
}