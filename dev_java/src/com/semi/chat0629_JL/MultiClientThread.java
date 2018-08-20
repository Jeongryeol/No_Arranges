package com.semi.chat0629_JL;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MultiClientThread extends Thread{
	
	/*�����*/
	MultiClient multiClient = null;
	
	/*������*/
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;//run()���� �ּҹ����� ó���ϱ� ���ؼ� �ʱ�ȭ��
	}
	/*��������Ǹ޼ҵ�*/
	//��Ʈ�����ϵ��� ������ִ� �޼ҵ�
	public SimpleAttributeSet makeAttribute(String style[]) {
		//�ν��Ͻ�
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//��Ʈ�÷�
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
						,new Color(Integer.parseInt(style[0])));
		//��ƮŸ��
		switch(style[1]) {
			case "Font.ITALIC":
				sas.addAttribute(StyleConstants.Italic, true);
				break;
			case "Font.BOLD":
				sas.addAttribute(StyleConstants.Bold, true);
				break;
		}//---------end of switch
		//��Ʈ������
		sas.addAttribute(
				 StyleConstants.CharacterConstants.Size
				,Integer.parseInt(style[2]));
		
		return sas;
	}
	
	/*����ü �޼ҵ�(�������̵�)*/
	@Override//ThreadŬ������ run�޼ҵ带 �������̵�
	public void run() {//��� : run - �����忡�� / ���ϱ� : actionPerformed-MultiClient
		
		String message = "";//100|��ȭ�� ������ ���� �� ���ڿ�
		boolean isStop = false;
		
		while(!isStop) {//run�޼ҵ带 ���ѷ���
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;//���ڿ��� ����� ����
				int protocol = 0;//���������� ���� ���ڿ�
		
				//�Ǵܽ���
				if(message != null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());//�������� �߶����
				}//-----------end of if
				switch(protocol) {
					case Protocol.ROOM_IN:{
						String chatName = st.nextToken();
						String[] names = new String[3];
						names[0] = chatName;
						names[1] = "��";
						names[2] = "29";
						multiClient.dtm_list.addRow(names);
							//���̺� �ְ�ʹ�??? DefaultTableModel.addRow(Vector)
							//TextField�� ������ ���ڿ��� �ھƳִ� append�� �ذᰡ��
							//multiClient.jta_display.append("�������� �о���� ��ȭ�� : "+chatName+"\n");
				
						
						//JTextPane�� ����ϴ°��, �׸��� �׷��ִ� �����̱⶧���� InsertString()�޼ҵ带 Ȱ���ؾ���. (try-catch�ʿ�)
						try {
							
							multiClient.sd_display.insertString(multiClient.sd_display.getLength()
																,chatName+"���� �����Ͽ����ϴ�.\n",null);
						} catch (Exception e) {
							System.out.println("MultiClientThread �۵��� �����߻� : ROOM_IN Protocol");
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
						//�о�� ��ȭ���� ����ϱ�
						try {
							SimpleAttributeSet sas = makeAttribute(style);
							multiClient.sd_display.insertString(multiClient.sd_display.getLength()
																,"<"+chatName+"> : "+msg+"\n",sas);
						} catch (Exception e) {
							System.out.println("MultiClientThread �۵��� �����߻� : MESSAGE Protocol");
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
