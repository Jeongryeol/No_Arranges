package com.ch15;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Memo extends JFrame implements ActionListener{
	//선언부
	JMenuBar jmb = new JMenuBar();
	JMenu    jm_file = new JMenu("File");
	JMenu    jm_edit = new JMenu("Edit");
	JMenuItem jmi_new = new JMenuItem("New");
	JMenuItem jmi_open = new JMenuItem("Open");
	JMenuItem jmi_save = new JMenuItem("Save");
	JSeparator js_exit = new JSeparator();
	JMenuItem jmi_exit = new JMenuItem("Exit");
	JMenuItem jmi_copy = new JMenuItem("Copy");
	JMenuItem jmi_cut = new JMenuItem("Cut");
	JMenuItem jmi_paste = new JMenuItem("Paste");
	String filePath = "src//com//ch15//";
	final URL memoImg = getClass().getResource("memo.png");
	ImageIcon memoIC = new ImageIcon(memoImg);
	JTextArea jta_display = new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display//스크롤바를 내장하고 있는 속지
											  //수직, 수평 순서로 스크롤바에 대한 정책 지정
											 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JFileChooser jfc = new JFileChooser();
	//생성자
	public Memo() {
		initDisplay();
	}
	
	//화면 처리부
	public void initDisplay() {
		//액션리스너 장착
		jmi_open.addActionListener(this);
		jmi_save.addActionListener(this);
		jmi_copy.addActionListener(this);
		jmi_cut.addActionListener(this);
		jmi_paste.addActionListener(this);
		
		//insert here - JTextArea의 자동줄바꿈 메소드를 찾으세요
		jta_display.setLineWrap(true);
		
		//단축키부여 및 해당문자 강조 : 단축키사용법은 Alt+'문자'
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		
		//set shortcut CTRL+T
        KeyStroke ctrlT = KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		jmi_cut.setAccelerator(ctrlT);
		//set shortcut CTRL+F
		KeyStroke ctrlF = KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		jmi_paste.setAccelerator(ctrlF);
		
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(js_exit);
		jm_file.add(jmi_exit);
		jm_edit.add(jmi_cut);
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_paste);	
		jmb.add(jm_file);
		jmb.add(jm_edit);
		
		this.add("Center",jsp_display);
		
		this.setJMenuBar(jmb);
		this.setTitle("메모");
		this.setIconImage(memoIC.getImage());//아이콘 고정하기
		this.setSize(500,800);
		this.setVisible(true);
	}
	//메인 메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Memo();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//이벤트가 일어난 주소번지를 담음
		
		//저장 구현
		if(obj==jmi_save) {
			//저장 대화상자 오픈
			int status = jfc.showOpenDialog(this);
			//저장버튼 누른거니?
			if(status==JFileChooser.APPROVE_OPTION) {
				try {
					//파일 저장하기 처리수행
					File myFile = jfc.getSelectedFile();
					BufferedWriter bw =
								new BufferedWriter(
										new FileWriter(myFile.getAbsolutePath()));
					//String은 원본이 바뀌지 않기 때문에, 반드시 변수에 담아서 초기화한다.
					String temp = jta_display.getText().replace("\n", "\r\n");//줄바꾸어 저장하도록 조치
					bw.write(temp);
					bw.close();
					
				}catch (Exception e) {

				}
			}
			
		}/////////////end of outter if
		
		//copy구현
		else if(obj==jmi_copy) {
			jta_display.copy();
		}
		
		//cut구현
		else if(obj==jmi_cut) {
			jta_display.cut();
		}
		
		//paste구현
		else if(obj==jmi_paste) {
			jta_display.paste();
		}
		
		//열기 구현
		else if(obj==jmi_open) {
			int status = jfc.showOpenDialog(this); //일어들이기용 String 객체
			
			//열기버튼 누른거니??
			if(status==JFileChooser.APPROVE_OPTION) {
				//파일을 여는 처리를 수행하기 ( 예외처리가 필수! )
				try {
					String strLine = null; //일어들이기용 String 객체
					//FileChooser에서 선택된 파일을 File객체 대입하기(자바는  모든 대상을 객체로 만들어 다룬다)
					//File myFile = new File("src//com//ch15//HP.java");
					//위와같이 파일을 객체화했던 방식에서 아래와같은 방식으로 선택하도록 변경
					File myFile = jfc.getSelectedFile();
					
				/** 불러오기방법 1 */
					//선택된 파일의 절대경로를 지정해서 BufferedReader객체 생성 [필터클래스-단독으로 사용불가]
					BufferedReader myReader
							= new BufferedReader(
									new FileReader(
											myFile.getAbsolutePath()
												  )
												);
					//Buffered 란, 대상에 대한 접근까지의 시간을 유보할 수 있는 것.
					//버퍼기능이 있으면 한결같은 속도로 읽어갈 수 있다.
					//왜냐하면, 내보는 것보다 많은 것을 확보해놓고 같은 속도로 읽어내기 때문
					
					//insert here - JTextArea에 처음 1행을 대입하도록 해보자
					jta_display.setText(myReader.readLine());
					//insert here - 나머지 행도 출력하자
					while((strLine=myReader.readLine())!=null) {
						jta_display.append("\n"+strLine);
					}
					
				/** 불러오기방법 2 : 아래방법은 읽어온 데이터의 자료를 각 한글자씩 읽어서 올리는 방식으로,
				  				모든 글자를 띄우기위해서는 반복문이 필요하며, 매우 비효율적이다. 때문에 1번방법을 사용함ㄴ다.*/
				/*	FileReader fr = new FileReader(myFile.getAbsolutePath());
					jta_display.setText(String.valueOf(
							(char)fr.read()	//읽어온 코드는 16진수로 표현된 데이터이므로,
							)				//문자타입(char)로 변환하면 대응되는 글자로 변환됨
							);*/
				}catch (Exception e) {
					e.printStackTrace();
				}/////end of try-catch
				
			}/////////end of inner if
			
		}/////////////end of outter else if
		
	}///////////end of actionPerformed
	
}///////////////end of class
