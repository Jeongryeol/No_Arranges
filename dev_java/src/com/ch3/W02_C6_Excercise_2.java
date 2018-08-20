package com.ch3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class W02_C6_Excercise_2 {

	public static void main(String[] args) {
		/*
		 * 도전문제
		 * 사용자로부터 아이디와 비번을 입력받아서 아이디와 비번이 일치하면 이순신님 환영합니다 라고 출력하고
		 * 아이디가 존재하지 않으면 아이디가 존재하지 않습니다.라고 출력하고
		 * 아이디는 맞는데 비번이 틀리면 비번을 잘못 입력 하였습니다. 라고 출력하는 프로그램을 작성하시오 
		 */
		JFrame winLog = new JFrame();
		String userId = JOptionPane.showInputDialog(winLog,"사용자 아이디를 입력해주세요");
		int chanUserId = Integer.parseInt(userId);
		if(chanUserId == 15450428) {
			String userPw = JOptionPane.showInputDialog(winLog,"사용자 비밀번호를 입력해주세요");
			int chanUserPw = Integer.parseInt(userPw);
			if(chanUserPw == 2102103) {
			JOptionPane.showMessageDialog(null,"이순신님 환영합니다.");
			}
			else {
			JOptionPane.showMessageDialog(null,"비밀번호를 잘못 입력하였습니다.");	
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"아이디를 확인해 주십시오.");				
		}
		
		
	}

}
