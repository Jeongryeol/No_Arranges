package com.semi.chat0629;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MultiClientThread extends Thread {
	MultiClient multiClient = null;
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;
	}
	public SimpleAttributeSet makeAttribute(String style[]) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//��Ʈ �÷�
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(style[0])));
		//��Ʈ Ÿ��
		switch(style[1]) {
			case "Font.ITALIC":
				sas.addAttribute(StyleConstants.CharacterConstants.Italic, true);
				break;
			case "Font.BOLD":
				sas.addAttribute(StyleConstants.CharacterConstants.Bold, true);
				break;
		}
		//��Ʈ ������
		sas.addAttribute(StyleConstants.CharacterConstants.Size, Integer.parseInt(style[2]));
		return sas;
	}
	@Override
	public void run() {//���:run-�����忡��, ���ϱ�:actionPerformed-MultiClient
		String message = "";//100|��ȭ��
		boolean isStop = false;
		while(!isStop) {
			try {
				message = (String)multiClient.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;//���������̴ϱ� �ʱ�ȭ
				if(message !=null) {
					st = new StringTokenizer(message,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case Protocol.ROOM_IN:{
					String chatName = st.nextToken();
					String[] names = new String[3];
					names[0] = chatName;
					names[1] = "��";
					names[2] = "29";
					multiClient.dtm_list.addRow(names);
					//insert here - DefaultTableModel.addRow(Vector)
					try {
						multiClient.sd_display.insertString(multiClient.sd_display.getLength(), chatName+"���� �����Ͽ����ϴ�.\n", null);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}break;
				case Protocol.MESSAGE:{
					String chatName 	= st.nextToken();
					String msg 			= st.nextToken();
					String fontColor 	= st.nextToken();
					String fontType  	= st.nextToken();
					String fontSize  	= st.nextToken();
					String[] style = new String[3];
					style[0] = fontColor;
					style[1] = fontType;
					style[2] = fontSize;
					String imgChoice = st.nextToken();
					JOptionPane.showMessageDialog(multiClient, "imgChoice:"+imgChoice);
					//�о�� ��ȭ������ ����ϱ�
					try {
						MutableAttributeSet attr1 = new SimpleAttributeSet();
						if(!imgChoice.equals("default")) {//�̸�Ƽ���� ���� ��� ó��
							for(int i=0;i<multiClient.pm.imgsFile.length;i++) {
								if(imgChoice.equals(multiClient.pm.imgsFile[i])) {
									JOptionPane.showMessageDialog(multiClient, "����");
									StyleConstants.setIcon(attr1, new ImageIcon(multiClient.pm.imgPath+imgChoice));
									//StyleConstants.setIcon(attr1, new ImageIcon("src\\com\\images\\emoticon\\Ƽÿ����.gif"));
									try {
										multiClient.sd_display.insertString(multiClient.sd_display.getLength()
												                          , "\n", attr1);
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
							}
						}/////////////////////end of if
						if(!"�̸�Ƽ��".equals(msg)) {
							SimpleAttributeSet sas = makeAttribute(style);
							multiClient.sd_display.insertString(multiClient.sd_display.getLength(),"["+chatName+"]"+msg+"\n",sas);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					multiClient.jtp_display.setCaretPosition(multiClient.sd_display.getLength());
				}break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}








