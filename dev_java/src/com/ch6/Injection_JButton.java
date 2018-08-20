package com.ch6;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Injection_JButton {

	JFrame jf = new JFrame();
	JButton jbtn[] = new JButton[5];//JButton 배열 생성 및 이름설정
	
	public void initDisplay() {
		//객체 배열 안에는 값이 아니라 주소번지가 담기죠
		//JButton배열의 경우, JButton객체가 담기는 공간이므로 default는 null이됩니다.
		for(int i=0;i<jbtn.length;i++) {
			System.out.println(jbtn[i]);//null null null null null이 출력됩니다.
		}		
		System.out.println(" ");
		for(int i=0;i<jbtn.length;i++) {
			jbtn[i] = new JButton();//배열의 주소번지에 API JButton의 주소번지를 담음
			System.out.println(jbtn[i]);//위에서 버튼의 주소번지를 담았으므로 null이 아니라 toString() 결과가 담김.
		}
		System.out.println(" ");
		//버튼에 라벨을 출력해봐요 - 새게임 지우기 저장하기 불러오기 종료
		String jbtn_label[] = {"새게임","지우기","저장하기","불러오기","종료"};//String 배열 생성 및 이름설정
		for(int i=0;i<jbtn.length;i++) {
			jbtn[i].setText(jbtn_label[i]);//JButton배열주소번지에 toString()배열주소번지로 초기화시킴.
			System.out.println(jbtn[i]);//toString() 결과 주소번지가 배열되어 출력됨
		}
		System.out.println(" ");
		//화면에 버튼을 배치해봐요
		jf.add("North",jbtn[0]);
		jf.add("Center",jbtn[1]);
		jf.add("Center",jbtn[2]);
		jf.add("West",jbtn[3]);
		jf.add("East",jbtn[4]);
		
		jf.setTitle("주소번지 두 번 접근하기");
		jf.setSize(500,300);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		Injection_JButton ij = new Injection_JButton();
		ij.initDisplay();
		
	}
	
}
