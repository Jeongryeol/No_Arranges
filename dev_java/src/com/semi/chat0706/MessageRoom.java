package com.semi.chat0706;

import javax.swing.JPanel;
/*
 * ��ü����
 * 
 */
public class MessageRoom extends JPanel {
	MultiClient multiClient = null;
	public MessageRoom(MultiClient multiClient) {
		this.multiClient = multiClient;
	}

}
