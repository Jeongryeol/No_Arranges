package com.ch7;
import javax.swing.JDialog;
public class Inher_05_IDCheck extends Inher_05_PopUp {
	JDialog jd_id = new JDialog();
	public Inher_05_IDCheck() {
		diaLogView(200,100,"���̵��ߺ�üũ",true);
	}
	public Inher_05_IDCheck(String str) {
		System.out.println
		("IDCheck(String str) ������ ȣ��� :: initDisplay()�� ȣ���������");	}
	@Override
	public void diaLogView(int w, int h, String title, boolean vs) {
		System.out.println("IDCheck diaLogView ȣ�⼺��");
		jd_id.setSize(w,h);
		jd_id.setTitle(title);
		jd_id.setVisible(vs);
	}
}