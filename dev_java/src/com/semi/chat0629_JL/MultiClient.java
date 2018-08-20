package com.semi.chat0629_JL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MultiClient extends JFrame implements ActionListener {

	//클라이언트에서 서버로 전송하기위해서 소켓생성
	Socket socket = null;
	//개체직렬화를 일으켜주는 inputStream과 OutputStream이 필요하다
	ObjectInputStream	ois = null;	//듣기
	ObjectOutputStream	oos = null;	//말하기
	//대화명 받아서 넘길 문자열
	String nickname = null;
	
	//왼쪽파트 화면구성
	JPanel		jp_first		= new JPanel();
	JPanel		jp_first_south	= new JPanel();
	JPanel		jp_second		= new JPanel();
	JPanel		jp_second_south	= new JPanel();
	/*****************************[ 새 API ]************************************/
	StyledDocument sd_display	= new DefaultStyledDocument(new StyleContext());
	JTextPane	jtp_display		= new JTextPane(sd_display);
	/**************************************************************************/
	//JTextArea	jta_display = new JTextArea();
	JScrollPane	jsp_display = new JScrollPane(jtp_display
											 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField	jtf_msg		= new JTextField();
	JButton		jbtn_send	= new JButton("전송");
	
	//오른쪽파트 화면구성
	String data[][]		= new String[0][3];
	String cal[]		= {"대화명","성별","연식"};
	DefaultTableModel	dtm_list	= new DefaultTableModel(data, cal);
	JTable				jtb_list	= new JTable(dtm_list);
	JScrollPane			jsp_list	= new JScrollPane(jtb_list
													,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
													,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JButton	jbtn_change		= new JButton("대화명 변경");
	JButton	jbtn_whisper	= new JButton("1:1 대화");
	JButton	jbtn_emotion	= new JButton("이모티콘");
	JButton	jbtn_fontColor	= new JButton("글자색 변경");
	JButton	jbtn_mijung		= new JButton("뭐할까?");
	JButton	jbtn_exit		= new JButton("종료");
	/*****************************[ 새 API ]************************************/
	//JTable 헤더 객체 추가 : 색깔 변경이나 헤더 관련 설정처리시 필요함. ex)방인원수, 상태 .. etc.
	JTableHeader jth_list	= jtb_list.getTableHeader();
	/**************************************************************************/
	String	fontColor		= "0";
	
	String imgPath = "src\\com\\images\\";
	ImageIcon img_back = new ImageIcon();
	String fontType = "Font.PLAIN";
	int fontSize = 12;
	
	//생성자
	public MultiClient() {
		initDisplay();
		connect_process();
	}
	//소켓통신을 위한 초기화
	public void connect_process() {
		try {
			socket = new Socket("192.168.0.230",5000);
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
	//화면처리부
	public void initDisplay() {
		nickname = JOptionPane.showInputDialog("사용할 대화명을 입력해주세요.");
		//이벤트 리스너 연결 
		jtf_msg.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_emotion.addActionListener(this);
		jbtn_fontColor.addActionListener(this);
		jbtn_mijung.addActionListener(this);
		jbtn_exit.addActionListener(this);
		//텍스트입력관련 화면변화 및 권한
		jsp_display.setEnabled(false);	//JTextPane에 쓰기 금지
		jtf_msg.requestFocus(); 		//포커스 이동하기
		jtp_display.setFont(new Font(null,0,14));	//JTextPane에 폰트지정
		jtf_msg.setFont(new Font(null,0,14));		//JTextField에 폰트지정
		//JTable관련 화면변화 및 권한
		jth_list.setBackground(Color.white);		//JTable헤더의 색깔지정
		jth_list.setReorderingAllowed(false);		//JTable헤더의 위치변경 금지
		jth_list.setResizingAllowed(false);			//JTable헤더의 크기변경 금지
		jth_list.setReorderingAllowed(false);		//JTbble헤더의 순서변경 금지
		//JFrame 왼쪽파트
		jp_first.setLayout(new BorderLayout());	//JPanel의 화면분할(동,서,남,북,중앙)
		jp_first.add("Center",jsp_display);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		jp_first.add("South",jp_first_south);
		//JFrame 오른쪽파트
		jp_second.setLayout(new BorderLayout());//JPanel의 화면분할(동,서,남,북,중앙)
		jp_second_south.setLayout(new GridLayout(3,2));//JPanel의 화면분할(row,column)
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_whisper); 
		jp_second_south.add(jbtn_emotion);
		jp_second_south.add(jbtn_fontColor); 
		jp_second_south.add(jbtn_mijung);
		jp_second_south.add(jbtn_exit);
		jp_second.add("Center",jsp_list);
		jp_second.add("South",jp_second_south);
		
		//JFrame 파츠부착
		this.setLayout(new GridLayout(1,2));	
		this.add(jp_first);
		this.add(jp_second);
		//JFrame구성
		this.setTitle(nickname+"님과의 대화창");		
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		//this나 super는 static영역에서 못쓰기때문에, JFrame으로 호출해야함 (상속과 무관)
		JFrame.setDefaultLookAndFeelDecorated(true);//JAVA FRAME 기본스킨
		new MultiClient();
	}
	//액션_오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//말하기처리 (메세지 입력하고 엔터쳤을때를 처리하자)
		if(obj==jtf_msg) {
			try {
				oos.writeObject(Protocol.MESSAGE
								+"|"+nickname
								+"|"+msg
								+"|"+fontColor
								+"|"+fontType
								+"|"+fontSize);
				jtf_msg.setText("");//비워두기
			}catch (Exception e2) {
				e2.printStackTrace();//stack에 저장된 에러 메시지를  출력-이력관리(줄번호)
			}
		} else if(obj==jbtn_change) {
			
		} else if(obj==jbtn_whisper) {
			
		} else if(obj==jbtn_emotion) {
			
		}
		//폰트색깔변경 이벤트처리
		else if(obj==jbtn_fontColor) {
			JDialog jdl_color = new JDialog();
			JColorChooser jc_color = new JColorChooser();
			ColorSelectionModel csm = jc_color.getSelectionModel();
			ChangeListener listener = new ChangeListener() {//익명클래스로 처리하는 추상클래스
				@Override
				public void stateChanged(ChangeEvent ce) {
					Color newFontColor = jc_color.getColor();
					fontColor = String.valueOf(newFontColor.getRGB());
				}
			};
			csm.addChangeListener(listener);
			jdl_color.add("Center",jc_color);
			jdl_color.setTitle("폰트색깔변경");
			jdl_color.setSize(600,500);
			jdl_color.setVisible(true);
		} else if(obj==jbtn_mijung) {
			
		}
		//종료처리
		else if(obj==jbtn_exit) {
			System.exit(0);
		}//----- end of if-else if
		
	}//--------- end of actionPerformed
	
}//------------- end of class 
