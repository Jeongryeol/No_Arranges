package com.ch6;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SungJuk_View {

	//선언부 (인스턴스전역변수) :: 메소드나 변수를 누릴때 사용한다
	JFrame jf_sungjuk = new JFrame();
	String header[] = {"순번", "이름","JAVA","ORACLE","HTML","총점","평균","석차","비고"};
	String datas[][] = new String[5][9];
  //생성자맛보기
	DefaultTableModel dtm_sungjuk = new DefaultTableModel(datas,header);
  //JTable은 양식만 가질 수 있고, 데이터는 가질 수 없다.
	JTable jtb_sungjuk = new JTable(dtm_sungjuk);
	
	
	//메소드선언하기
	//화면처리부
	public void initDisplay() {

			jf_sungjuk.add("Center",jtb_sungjuk);

		int sizeW = 600;
		int sizeH = 400;
			jf_sungjuk.setSize(sizeW, sizeH);//인스턴스변수의 주소번지인 이름
						
		Boolean popUp = true;
			jf_sungjuk.setVisible(popUp);
		
	}
	
	
	//메인메소드
	public static void main(String[] args) {
		
	  //내 안에 있는 메소드를 호출할때
	  //static인 main메소드 안에서는 본인클래스의 인스턴스화가 필요함
		SungJuk_View sjView = new SungJuk_View();
	  //본인클래스의 인스턴스화한 이름.메소드이름(); 
		sjView.initDisplay();


	}

}
