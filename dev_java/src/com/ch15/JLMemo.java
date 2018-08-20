package com.ch15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * @author	Jeongryeol
 * @aim		메모장 클래스 구현해보기
 * 
 *	메뉴바추가
 *	JMenuBar	jmb
 *	JMenu		jm_file | jm_edit
 *	JMenuItem
 *		File -	new		jmi_new
 *				open	jmi_open
 *				save	jmi_save
 *				exit	jmi_exit
 *		Edit -	copy	jmi_copy
 *				cut		jmi_cut
 *				paste	jmi_paste
 *
 */
public class JLMemo extends JFrame implements ActionListener{
	/*선언부*/
	//────────────────────[메뉴바 시작]────────────────────
	JMenuBar	jmb			= new JMenuBar();
	//파일메뉴와 아이템목록
	JMenu		jm_file		= new JMenu("File");
	JMenuItem	jmi_new		= new JMenuItem("새 메모");
	JMenuItem	jmi_open	= new JMenuItem("불러오기");
	JMenuItem	jmi_save	= new JMenuItem("저장하기");
	JMenuItem	jmi_edit	= new JMenuItem("수정하기");
	JMenuItem	jmi_exit	= new JMenuItem("종료");
	//수정메뉴와 아이템 목록
	JMenu		jm_edit		= new JMenu("Edit");
	JMenuItem	jmi_copy	= new JMenuItem("복사하기");
	JMenuItem	jmi_cut		= new JMenuItem("잘라내기");
	JMenuItem	jmi_paste	= new JMenuItem("붙여넣기");
	//────────────────────[메뉴바 끝]────────────────────
	
	/*생성자*/
	//디펄트 생성자
	public JLMemo() {
		initDisplay();//화면실행
	}
	
	/*사용자정의 메소드*/
	//화면처리부
	public void initDisplay() {
		//아이팀에 액션감지부여
		jmi_new		.addActionListener(this);
		jmi_open	.addActionListener(this);
		jmi_save	.addActionListener(this);
		jmi_edit	.addActionListener(this);
		jmi_exit	.addActionListener(this);
		jmi_copy	.addActionListener(this);
		jmi_cut		.addActionListener(this);
		jmi_paste	.addActionListener(this);
		
		//메뉴바 설치
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_edit);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_cut);
		jm_edit.add(jmi_paste);
		jmb.add(jm_edit);
		//this.add("North",jmb);
		this.setJMenuBar(jmb);
		
		//화면띄우기
		this.setTitle("JL-Memo ver.1");
		this.setSize(450, 650);
		this.setVisible(true);
	}
	
	/*메인 메소드*/
	public static void main(String[] args) {
		JLMemo mm = new JLMemo();
	}
	
	/*오버라이드 메소드*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		//액션에서 얻은 소스를 객체로 담음
		Object obj = ae.getSource();
		
		if (obj == jmi_new) {//메뉴바-File탭-새 메모
			
		}
		else if (obj == jmi_open) {//메뉴바-File탭-불러오기
			
		}
		else if (obj == jmi_save) {//메뉴바-File탭-저장하기
			
		}
		else if (obj == jmi_edit) {//메뉴바-File탭-수정하기
			
		}
		else if (obj == jmi_exit) {//메뉴바-File탭-나가기
			dispose();
			setVisible(false);
			System.exit(0);
		}
		else if (obj == jmi_copy) {//메뉴바-Edit탭-복사하기
			
		}
		else if (obj == jmi_cut) {//메뉴바-Edit탭-잘라내기
			
		}
		else if (obj == jmi_paste) {//메뉴바-Edit탭-붙여넣기
			
		}
			
	}       
            
}           
            
            
            
            