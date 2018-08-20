package com.semi.chat0629_JL;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MultiClientThread extends Thread{
	
	/*선언부*/
	MultiClient multiClient = null;
	
	/*생성자*/
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;//run()에서 주소번지를 처리하기 위해서 초기화함
	}
	/*사용자정의메소드*/
	//폰트설정하도록 만들어주는 메소드
	public SimpleAttributeSet makeAttribute(String style[]) {
		//인스턴스
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//폰트컬러
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
						,new Color(Integer.parseInt(style[0])));
		//폰트타입
		switch(style[1]) {
			case "Font.ITALIC":
				sas.addAttribute(StyleConstants.Italic, true);
				break;
			case "Font.BOLD":
				sas.addAttribute(StyleConstants.Bold, true);
				break;
		}//---------end of switch
		//폰트사이즈
		sas.addAttribute(
				 StyleConstants.CharacterConstants.Size
				,Integer.parseInt(style[2]));
		
		return sas;
	}
	
	/*구현체 메소드(오버라이드)*/
	@Override//Thread클래스의 run메소드를 오버라이드
	public void run() {//듣기 : run - 스레드에서 / 말하기 : actionPerformed-MultiClient
		
		String message = "";//100|대화명 형식을 담을 빈 문자열
		boolean isStop = false;
		
		while(!isStop) {//run메소드를 무한루프
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;//문자열을 썰어줄 공간
				int protocol = 0;//프로토콜을 담을 숫자열
		
				//판단시작
				if(message != null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());//프로토콜 잘라담음
				}//-----------end of if
				switch(protocol) {
					case Protocol.ROOM_IN:{
						String chatName = st.nextToken();
						String[] names = new String[3];
						names[0] = chatName;
						names[1] = "남";
						names[2] = "29";
						multiClient.dtm_list.addRow(names);
							//테이블에 넣고싶다??? DefaultTableModel.addRow(Vector)
							//TextField를 쓸때는 문자열을 박아넣는 append로 해결가능
							//multiClient.jta_display.append("서버에서 읽어들인 대화명 : "+chatName+"\n");
				
						
						//JTextPane을 사용하는경우, 그림을 그려넣는 개념이기때문에 InsertString()메소드를 활용해야함. (try-catch필요)
						try {
							
							multiClient.sd_display.insertString(multiClient.sd_display.getLength()
																,chatName+"님이 입장하였습니다.\n",null);
						} catch (Exception e) {
							System.out.println("MultiClientThread 작동중 오류발생 : ROOM_IN Protocol");
							e.printStackTrace();
						}
					}break;//end of case
					case Protocol.MESSAGE:{
						System.out.println("2");
						String chatName = st.nextToken();
						String msg		= st.nextToken();
						String fontColor	= st.nextToken();
						String fontType		= st.nextToken();
						String fontSize		= st.nextToken();
						String[] style	= new String[3];
						style[0] = fontColor;
						style[1] = fontType; 
						style[2] = fontSize;
						//읽어온 대화내용 출력하기
						try {
							SimpleAttributeSet sas = makeAttribute(style);
							multiClient.sd_display.insertString(multiClient.sd_display.getLength()
																,"<"+chatName+"> : "+msg+"\n",sas);
						} catch (Exception e) {
							System.out.println("MultiClientThread 작동중 오류발생 : MESSAGE Protocol");
							e.printStackTrace();
						}
						multiClient.jtp_display.setCaretPosition(multiClient.sd_display.getLength());
					}break;//end of case
				}//----------end of switch
				
			}catch (Exception e) {

			}//--------------end of try-catch
			
		}//------------------end of while
		
	}//----------------------end of run()
	
}//--------------------------end of class
