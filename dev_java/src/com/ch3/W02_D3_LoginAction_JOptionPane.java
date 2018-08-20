package com.ch3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class W02_D3_LoginAction_JOptionPane {

	public static void main(String[] args) {
		String db_id = "test";
		String db_pw = "123";
		String db_name = "이순신";
		//사용자로부터 id와 pw를 입력받아서
		//id와 pw이 모두 일치하면 이순신님 환영합니다. 라고 출력하고
		//id가 존재하지 않으면 아이디가 존재하지 않습니다. 라고 출력하고
		//id는 존재하지만 pw가 맞지 않으면 비밀번호가 틀렸습니다. 라고 출력해보자.
		
		//사용자로부터 값받기. (쌤의 방식)
		String user_id = JOptionPane.showInputDialog("아이디를 입력하세요.");
		String user_pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
		JFrame jf = new JFrame();
		if (db_id.equals(user_id)) {//db에서 가져온 아이디와 사용자가 입력한 아이디가 같니?
			if (db_pw.equals(user_pw)) {//db에서 가져온 비번과 사용자가 입력한 비번이 같니?
				JOptionPane.showMessageDialog(jf,db_name+"님 환영합니다.","HELLO"
													,JOptionPane.INFORMATION_MESSAGE);				
			}
			else {//달라요
				JOptionPane.showMessageDialog(jf, "비밀번호가 일치하지 않습니다.","ERROR"
													,JOptionPane.WARNING_MESSAGE);			
			}
		}
		else {//아이디가 존재하지 않음
			JOptionPane.showMessageDialog(jf, "입력하신 아이디가 존재하지 않습니다.","ERROR"
													,JOptionPane.WARNING_MESSAGE);
		}
		
		//클래스급 사용
		/*JFrame logIn = new JFrame();
		String user_id = JOptionPane.showInputDialog(logIn,"아이디를 입력하세요.");
		String user_pw = JOptionPane.showInputDialog(logIn,"비밀번호를 입력하세요.");
		Boolean id_check = (db_id == user_id);
		Boolean pw_check = (db_pw == user_pw);
		if (id_check){
			if (pw_check) {
				JOptionPane.showMessageDialog(logIn, "이순신님 환영합니다.");
			}
			else {
				JOptionPane.showMessageDialog(logIn, "입력하신 아이디가 존재하지 않습니다.");				
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "입력하신 아이디가 존재하지 않습니다.");				
		}*/
	}

}
