package com.ch7;
import javax.swing.JDialog;
import javax.swing.JFrame;
public class Inher_05_ZipCodeSearch extends Inher_05_PopUp {
	JDialog jd_id = new JDialog();
	public Inher_05_ZipCodeSearch() {
		diaLogView(200,100,"���̵��ߺ�üũ",true);
	}
	@Override
	public void diaLogView(int w, int h, String title, boolean vs) {
		System.out.println("ZipCodeSearch diaLogView ȣ�⼺��");
		jd_id.setSize(w,h);
		jd_id.setTitle(title);
		jd_id.setVisible(vs);
	}
}