package com.semi.chat0706;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener, Runnable {
	//선언부
	Socket client = null;
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos = null;//말하기
	//개인정보 담을 변수
	String myname, myid, myroom, mynick, mygender;
	MultiClient mClient = new MultiClient();
	//화면처리에 필요한 클래스
	JPanel global = new JPanel();
	JPanel jp1 = new JPanel();
	JLabel jlb_id = new JLabel();
	JTextField idTF = new JTextField();
	JLabel jlb_nick = new JLabel();
	JTextField nickTF = new JTextField();
	JPanel jp2 = new JPanel();
	JLabel jlb_gen = new JLabel("성별");
	JRadioButton gen1 = new JRadioButton("남",true);
	JRadioButton gen2 = new JRadioButton("여",false);
	ButtonGroup bg = new ButtonGroup();
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("CANCEL");
	//생성자
	public Login() {
		initDisplay();
	}
	//화면처리부
	public void initDisplay() {
		ok.addActionListener(this);
		cancel.addActionListener(this);
		this.setTitle("로그인");
		this.setLayout(null);
	    this.getContentPane().setLayout(null);
	    global.setBackground(new Color(158, 217, 203));
	    global.setBorder(BorderFactory.createEtchedBorder());
	    global.setBounds(new Rectangle(3, 4, 240, 148));
	    global.setLayout(null);
	    jp1.setBackground(new Color(158, 217, 203));
	    jp1.setBorder(BorderFactory.createEtchedBorder());
	    jp1.setBounds(new Rectangle(7, 6, 223, 64));
	    jp1.setLayout(null);
	    jlb_id.setFont(new java.awt.Font("SansSerif", 0, 12));
	    jlb_id.setText("I  D");
	    jlb_id.setBounds(new Rectangle(21, 8, 26, 23));
	    idTF.setFont(new java.awt.Font("SansSerif", 0, 13));
	    idTF.setBounds(new Rectangle(52, 7, 162, 22));
	    jlb_nick.setBounds(new Rectangle(10, 34, 40, 23));
	    jlb_nick.setText("대화명");
	    jlb_nick.setFont(new java.awt.Font("SansSerif", 0, 12));
	    nickTF.setFont(new java.awt.Font("SansSerif", 0, 13));
	    nickTF.setBounds(new Rectangle(52, 34, 162, 22));
	    jp2.setBackground(new Color(158, 217, 203));
	    jp2.setBorder(BorderFactory.createEtchedBorder());
	    jp2.setBounds(new Rectangle(7, 74, 222, 30));
	    jp2.setLayout(null);
	    jlb_gen.setFont(new java.awt.Font("SansSerif", 0, 12));
	    jlb_gen.setText("성  별");
	    jlb_gen.setBounds(new Rectangle(11, 6, 36, 18));
	    gen1.setText("남");
	    gen1.setBackground(new Color(158, 217, 203));
	    gen1.setFont(new java.awt.Font("SansSerif", 0, 12));
	    gen1.setBounds(new Rectangle(76, 6, 44, 19));
	    gen2.setBounds(new Rectangle(140, 6, 41, 19));
	    gen2.setText("여");
	    gen2.setBackground(new Color(158, 217, 203));
	    gen2.setFont(new java.awt.Font("SansSerif", 0, 12));
	    ok.setFont(new java.awt.Font("SansSerif", 0, 12));
	    ok.setBorder(BorderFactory.createEtchedBorder());
	    ok.setText("확인");
	    ok.setBounds(new Rectangle(40, 111, 70, 28));
	    cancel.setBounds(new Rectangle(122, 110, 70, 29));
	    cancel.setText("취소");
	    cancel.setFont(new java.awt.Font("SansSerif", 0, 12));
	    cancel.setBorder(BorderFactory.createEtchedBorder());
	    this.getContentPane().setBackground(new Color(142, 186, 195));
	    this.getContentPane().add(global, null);
	    global.add(jp1, null);
	    jp1.add(idTF, null);
	    jp1.add(jlb_nick, null);
	    jp1.add(jlb_id, null);
	    jp1.add(nickTF, null);
	    global.add(jp2, null);
	    jp2.add(jlb_gen, null);
	    jp2.add(gen2, null);
	    jp2.add(gen1, null);
	    global.add(cancel, null);
	    global.add(ok, null);
	    bg.add(gen1);
	    bg.add(gen2);
		this.setSize(265, 200);
		this.setVisible(true);
	}
	/**************************************************************
	 * 서버에 접속하기 구현
	 *************************************************************/
	public void connect_process() {
		//사용자가 입력한 아이디 , 대화명, 성별
		String id = idTF.getText().trim();//공백제거
		String nick = nickTF.getText().trim();
		String gender = gen1.isSelected() ? "남" : "여";
		//아이디와 대화명 입력 여부 체크하기
		if(id.length()<1||nick.length()<1) {
			JOptionPane.showMessageDialog(this,"ID와 대화명은 반드시 입력하세요.");
			return;//connect_process()탈출
		}
		//사용자가 입력한 정보를 전역변수 치환하기
		myid = id;
		mynick = nick;
		mygender = gender;
		//이제 막 서버에 접속하였으므로 현재 사용자의 대화방은 존재하지 않음.디폴트를 대기실로 함.
		myroom ="대기실";
		setVisible(false);
		//Login화면은 비활성화
		dispose();
		//클라이언트 화면을 활성화
		//사용자가 입력한 대화명을 타이틀바에 출력하기
		mClient.setTitle(mynick);
		mClient.setVisible(true);
		try {
			client = new Socket("localhost",3100);
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			oos.writeObject(Protocol.WAIT_ROOM+"|"+
			                              myid+"|"+
					                    mynick+"|"
			              );
			new Thread(this).start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//메인메소드
	public static void main(String[] args) {
		Login login = new Login();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == ok) {//확인 버튼 누른거야?
			connect_process();//채팅 서버 접속하기
		}
		else if(obj == cancel) {//취소 버튼 누른거야?
			dispose();
			setVisible(false);
			System.exit(0);
		}
	}

}














