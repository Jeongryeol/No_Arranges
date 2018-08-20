package com.ch7;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Inher_05_PopUp extends JFrame implements ActionListener{
	JButton jbtn_id = new JButton ("ID중복체크");
	JButton jbtn_zipcode = new JButton ("우편번호 검색");
	//부모창에 대한 화면처리 메소도를 디폴트 생성자에서 호출하고 있다. (아래확인)
	//상속관계에 있는 클래스가 있는 경우 자식클래스 생성자 호출전에 부모 생성자가 먼저 호출됨.
	//왜냐하면... 그래야 자식클래스의 메소드가 오버라이딩 관계인지 파악할 수 있음
	//아래 코드 [이벤트처리]에서 인스턴스화가 두번 일어남.
	//이건 부모창에 대한 디폴트 생성자가 두 번 호출이 되는 것임.
	//메인 메소드에서 한 번 창이 열리고, 이벤트가 일어나면 부모창이 두 번 열리는 것은 이 때문임
	//그럼 이 문제를 해결해보세요. : 생성자를 이용하여 해결하기
	public Inher_05_PopUp() { initDisplay(); }
	public Inher_05_PopUp(String str) { 
		System.out.println
		("PopUp(String str) 생성자 호출됨 :: initDisplay()가 호출되지않음");
	}
	public void diaLogView(int w, int h, String title, boolean vs) {
		System.out.println("diaLogView 호출성공 [ PopUP class ]");
	}
	public void initDisplay() {
		jbtn_id.addActionListener(this);
		jbtn_zipcode.addActionListener(this);
		this.add("North",jbtn_id);
		this.add("South",jbtn_zipcode);
		this.setSize(500,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Inher_05_PopUp();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {//Event처리하는것을 깔대기로 처리하기
		String label = ae.getActionCommand();//이벤트소스의 라벨값 반환(String)
	//자바는 선언부와 생성부에 오는 클래스가 다를 수 있다.
	//자바는 생성부에 사용한 클래스가 실제 메모리에 로딩된다.
	//그렇다면 선언부에 오는 변수 타입과 생성부 타입 중 같은 메소드이름이 호출되었을때, 누가 호출되는가?
		Inher_05_PopUp pop = null;
		//if(label.equals("ID중복체크")) 
		if("ID중복체크".equals(label)){
		//비교문자열이 먼저 들어온경우 null로인한 에러(nullPointException)를 방지할 수 있다.
			//Inher_05_IDCheck idChec	= new Inher_05_IDCheck("");
			pop		= new Inher_05_IDCheck("");
			//idChec.diaLogView(200,100,"ID중복체크",true);
			//pop.diaLogView(200,100,"ID중복체크2",true);
		}else if("우편번호검색".equals(label)) {
			Inher_05_ZipCodeSearch zcs 	= new Inher_05_ZipCodeSearch();
			pop 	= new Inher_05_ZipCodeSearch();
			
		}
	}
}
