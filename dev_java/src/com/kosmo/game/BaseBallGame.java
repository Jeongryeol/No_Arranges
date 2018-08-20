package com.kosmo.game;
/*
 * 1)내가 만든 어플을 친구에게 배포하고 싶어요. 어떡하지?
 * 2)복습시간
 * 	- 변수를 배워서 어떻게 활용하지?
 * 	- 왜 클래스를 먼저 이야기 하였는가?
 *  - 실행하고 확인 방법에 대해 말할 수 있다.
 */
//Java가상머신이 제공하고 있는 API로 불러온다는 코드
//JDKAPI로 저장해놓은 페이지에서 모든 API를 확인가능
import javax.swing.JFrame;

public class BaseBallGame {

	public static void main(String[] args) {
	//◆◆◆◆문제 : 윈도우 창에 적힌 제목을 변수로 처리해 볼래?◆◆◆◆
	//아래 메소드 3가지는 모두 자바에서 제공되는 메소드 이다.
	//내가 선언한 메소드가 아니라, 정의되어있는(약속되어있는, 제공되는, 개발자의 사전의도로 짜여진)
	//파라미터가 결정되어있기 때문에 지켜주어야 한다. (파라미터에 갯수, 타입,
		//예약어로 지정된 단어는 변수로 지정할 수 없다.
		//new라는 예약어를 사용해서
		//JFrame이라는 자바가상머신을 지원하는 클래스를 메모리에 올리기.
		JFrame jf = new JFrame();
		String gameTitle = "★★★★야구숫자 게임★★★★";
		int sizeW = 500;
		int sizeH = 400;//500과 400의 값을 초기화해줌
		Boolean popUp = true;
		//jf.setTitle() : jf에 로딩된 setTitle이라는 메소드
		jf.setTitle(gameTitle);
		jf.setSize(sizeW, sizeH);//창의 크기로 좌상단 꼭지점이 (0,0)기준, 음수로 반대로 뒤집어짐
		//true의 상태는 메모리에 로딩이 되고, 화면에 출력 나가는 상태
		//false의 상태는 메모리에는 로딩이 되어 있지만, 화면에는 출력안함
		//스마트폰으로 게임을 진행하다가 전화가 들어왔을때 -boolean타입의 변수로 치환하면 제어할 수 있다.
		//선언하고 초기화된 값들은 재정의가 될 수 있다.
		//변수 하나에는 동시에 두 개의 값을 담을 수 없다.
		//popUp = false//로 입력되면 화면이 출력되지 않는다.
		jf.setVisible(popUp);
		if(popUp) {
			System.out.println("Window size : "+sizeW+", "+sizeH);
		}
		else {
			System.out.println("Window size : "+sizeW+", "+sizeH);
			System.out.println(popUp);
		}
	}

}
