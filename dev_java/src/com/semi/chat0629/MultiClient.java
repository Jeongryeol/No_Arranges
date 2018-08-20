package com.semi.chat0629;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
import javax.swing.text.StyledDocument;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;

public class MultiClient extends JFrame implements ActionListener{
	Socket socket = null;
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos = null;//말하기
	//대화명을 받아서 담기
	String nickName = null;
	JPanel 			jp_first		= new JPanel();
	JPanel 			jp_first_south	= new JPanel();
	JPanel 			jp_second		= new JPanel();
	JPanel 			jp_second_south	= new JPanel();
	StyledDocument  sd_display	= new DefaultStyledDocument(new StyleContext());
	JTextPane       jtp_display = new JTextPane(sd_display);
	JScrollPane     jsp_display = 
			new JScrollPane(jtp_display
					       ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					       ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField 		jtf_msg		= new JTextField();
	JButton			jbtn_send	= new JButton("전송");
	///////////////////////두번째 속지에 추가할 화면 ////////////////////
	String cols[] 		= {"대화명","성별","년식"};
	String data[][]	 	= new String[0][3];
	DefaultTableModel dtm_list		= new DefaultTableModel(data,cols);
	JTable			  jtb_list		= new JTable(dtm_list);
	JScrollPane		  jsp_list		= new JScrollPane(jtb_list
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JButton			  jbtn_change	= new JButton("대화명 변경");
	JButton			  jbtn_whisper	= new JButton("1:1대화");
	JButton			  jbtn_emoticon	= new JButton("이모티콘");
	JButton			  jbtn_fontColr	= new JButton("글자색");
	JButton			  jbtn_mijung	= new JButton("머할까?");
	JButton			  jbtn_exit		= new JButton("종료");
	//JTable 헤더 객체 추가 -색깔 변경이나 헤더 관련 설정처리시 필요함.
	JTableHeader      jth_list		= jtb_list.getTableHeader();
	String fontColor = "0";
	String imgPath = "src\\com\\images\\";
	ImageIcon img_back = new ImageIcon(imgPath+"talk.jpg");
	String fontType = "Font.PLAIN";
	int fontSize = 12;
	PictureMessage pm = new PictureMessage();
	public MultiClient() {
		initDisplay();
		connect_process();
	}
	//소켓통신을 위한 초기화
	public void connect_process() {
		try {
			socket = new Socket("192.168.0.17",5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//나 서버에 입장했어요
			oos.writeObject(Protocol.ROOM_IN+"|"+nickName);
			MultiClientThread mct = new MultiClientThread(this);
			mct.start();//run()호출
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	//화면 처리하기
	public void initDisplay() {
		nickName = JOptionPane.showInputDialog("사용할 대화명을 입력하세요.");
		/////////////////////////// 이벤트 리스너 연결 ////////////////////////////////
		jtf_msg.addActionListener(this);
		jbtn_change.addActionListener(this);	   
		jbtn_whisper.addActionListener(this);
		jbtn_emoticon.addActionListener(this);
		jbtn_fontColr.addActionListener(this);
		jbtn_mijung.addActionListener(this);	   
		jbtn_exit.addActionListener(this);	
		jbtn_send.addActionListener(this);
		/////////////////////////// 이벤트 리스너 연결 ////////////////////////////////
		//JTextPane에 쓰기 금지
		jtp_display.setEditable(false);
		//JTextField에 포커스 이동하기
		jtf_msg.requestFocus();
		//JTextPane에 폰트 지정
		jtp_display.setFont(new Font(null,0,14));
		//JTextField에 폰트 지정
		jtf_msg.setFont(new Font(null,0,14));
		//테이블 헤더 설정변경해 볼까??????
		jth_list.setBackground(Color.RED);
		//테이블 헤더 순서 변경 금지처리
		jth_list.setReorderingAllowed(false);
		//테이블 헤더 폭크기 변경 금지 처리
		jth_list.setResizingAllowed(false);
		jp_first.setLayout(new BorderLayout());//동,서,남,북,중앙
		jp_first.add("Center",jsp_display);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		jp_first.add("South",jp_first_south);
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second_south.add(jbtn_change	);
		jp_second_south.add(jbtn_whisper	);
		jp_second_south.add(jbtn_emoticon	);
		jp_second_south.add(jbtn_fontColr	);
		jp_second_south.add(jbtn_mijung	);
		jp_second_south.add(jbtn_exit		);
		jp_second.add("Center",jsp_list);
		jp_second.add("South",jp_second_south);
		this.setLayout(new GridLayout(1,2));
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName+"님의 대화창");
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MultiClient();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//말하기 - 듣기처리
		if(obj == jtf_msg || obj==jbtn_send) {
			if(msg==null || msg.length()==0) {
				msg = "이모티콘";
			}
			try {
				oos.writeObject(Protocol.MESSAGE
						   +"|"+nickName
						   +"|"+msg
						   +"|"+fontColor
						   +"|"+fontType
						   +"|"+fontSize
						   +"|"+pm.imgChoice
						   );
				jtf_msg.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();//stack저장된 에러메시지를 출력-이력관리(줄번호)
			}
		}
		//글자색변경 이벤트 처리
		else if(obj == jbtn_fontColr) {
			JDialog jdl_color = new JDialog();
			JColorChooser jc_color = new JColorChooser();
			ColorSelectionModel model = jc_color.getSelectionModel();
			ChangeListener listener = new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent ce) {
					Color newFontColor = jc_color.getColor();
					fontColor = String.valueOf(newFontColor.getRGB());
				}
			};
			model.addChangeListener(listener);
			jdl_color.add("Center",jc_color);
			jdl_color.setSize(600, 500);
			jdl_color.setVisible(true);
		}
		else if(obj == jbtn_emoticon) {
			pm.setVisible(true);
		}
	}

}







