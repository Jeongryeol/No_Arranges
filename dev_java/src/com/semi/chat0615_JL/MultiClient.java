package com.semi.chat0615_JL;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener {

	//클라이언트에서 서버로 전송하기위해서 소켓생성
	Socket socket = null;
	//개체직렬화를 일으켜주는 inputStream과 OutputStream이 필요하다
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos = null;//말하기
	//대화명 받아서 넘길 문자열
	String nickname = null;
	//화면구성
	JPanel		jp_first	= new JPanel();
	JTextArea	jta_display = new JTextArea();
	JScrollPane	jsp_display = new JScrollPane(jta_display
											 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField	jtf_msg		= new JTextField();
	
	public MultiClient() {
		nickname = JOptionPane.showInputDialog("사용할 대화명을 입력해주세요.");
		
		jtf_msg.addActionListener(this);
		
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_display);
		jp_first.add("South",jtf_msg);
		this.add("Center",jp_first);
		
		this.setTitle(nickname+"님과의 대화창");
		this.setSize(500, 400);
		this.setVisible(true);
		
		try {
			socket = new Socket("192.168.0.20",8000);
			//듣기와 말하기 창구 설정
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//100#닉네임 [프로토콜 설계후 사용] : 나 서버에 입장했어요.
			oos.writeObject(Protocol.ROOM_IN+"|"+nickname);
			//다자간 대화를 위해 필요한 내용
			MultiClientThread mct = new MultiClientThread(this);
			mct.start();//run()호출
			
		}catch (Exception e) {

		}
	}
	
	public static void main(String[] args) {
		new MultiClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//말하기처리 (메세지 입력하고 엔터쳤을때를 처리하자)
		if(obj==jtf_msg) {
			try {
				oos.writeObject(Protocol.MESSAGE+"|"+nickname+"|"+msg);
				jtf_msg.setText("");//비워두기
			}catch (Exception e2) {
				e2.printStackTrace();//stack에 저장된 에러 메시지를  출력-이력관리(줄번호)
			}
		}
	}
	
}
