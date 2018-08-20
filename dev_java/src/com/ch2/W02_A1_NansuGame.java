package com.ch2;

public class W02_A1_NansuGame {

	public static void main(String[] args) {
		//컴퓨터가 채번한 숫자를 담는 변수 dap
		int dap = 3;
		//사용자가 입력한 값을 담을 변수
		int user = -1; //0~9 범위값이 유효한 값으로 만들 계획이므로, 범위밖의 수를 초기화지점으로 설정
		//-1이라는 것은 프로그램계에서는 end of file 이라고 하여 더이상 찾을수 없을때, 혹은 끝까지 다 찾았을때 사용하는 상수값으로 많이 사용
		user = 7;
		String hint = "";
		if(user>dap) {//-1은 7보다 크니? true of flase - boolean
			hint = "낮춰라";//if문 괄호안에 조건식이 참일때만 실행되는 문장임.
			System.out.println(hint);
		}
		else if(user<dap) {//-1은 7보다 작니, 네 당첨
			hint = "높여라";
			System.out.println(hint);
		}
		else if (user==dap) {
			System.out.println("축하합니다...짝짝짝...");
			System.exit(0);//자바가상머신과 연결고리를 끊어서 어플을 종료함 (괄호안의 0은  종료할때 들어가는 약속된 상수 System.exit(0);이 한세트)
		}
		
	}

}
