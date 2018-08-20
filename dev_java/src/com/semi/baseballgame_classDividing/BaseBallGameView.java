package com.semi.baseballgame_classDividing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.semi.BaseBallGame;

public class BaseBallGameView {

	    //����� -����ο��� ����� �޼ҵ带 ȣ������ �ʴ´�.
	    JFrame jf_ball = new JFrame();//��������
	    JPanel jp_east = new JPanel();//���ʿ� ���� ����
	    JPanel jp_center = new JPanel();//JFrame
	   
	    //��ư 4�� �߰��غ��� - ��ư�� ���ؼ��� �̺�Ʈ ó���� �ؾߵǴϱ� ���������� ����
	    JButton jbtn_new =new JButton("������");
	    JButton jbtn_dap =new JButton("����");
	    JButton jbtn_clear =new JButton("�����");
	    JButton jbtn_exit =new JButton("����");
	   
	    JTextArea jta_display  = new JTextArea();//���Ϳ� ��ġ
	    JScrollPane jsp_display =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	                                    //���� ��ũ�ѹٴ� ���� ���� ��ũ�ѹٴ� ���� ����.
	    JTextField jtf_input =new JTextField();
	    Font f = new Font("Thoma",Font.BOLD,16);
	
	    /*
	     *����Ʈ�����ڴ� ������ �� �ִ�. - �Ķ���Ͱ� �����ϱ� ������ ��� ���� �� �ִ�.
	     *�Ķ���͸� ���� �����ڰ� �ϳ��� ������, ����Ʈ�����ڴ� �����ȵȴ�.
	     */										//���콺���� �� ��Ʈ��Ű ������ �ּҰ� ����
	    BaseBallGameLogic bbgLogic = new BaseBallGameLogic( );
	    BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this,bbgLogic);
	    //[�߰���]Ŭ������ �����⶧����, (�Ʒ� ����) addActionListener�� ������ ���⶧����, �������� �ν��Ͻ�ȭ �ؼ� ȣ���Ѵ�
	    //�Ķ���͸� viewŬ������ �ּҹ����� �־ EventŬ������ �ѱ�(������ ���)

	    
	//ȭ��ó�� �޼ҵ�
	public void initDisplay() {
		//�̺�Ʈ ó����� ���۳�Ʈ�� �̺�Ʈ ó�� Ŭ������ �����ϱ�
		//implements ActionListener �� �ִ� Ŭ������ BaseBallGameEvent�� �и��Ǿ 
		//�� Ŭ���� ���ο��� �̺�Ʈ ó���� ����ϴ� actionPerformed�޼ҵ带 �����ϰ� �ֱ� ������..
		//������ �Է��ߴ� this�� BaseBallGame�� ����Ű�� ������ ����ҽ� ������ ����.

		//�׷��� �Ʒ� �޼ҵ��� ȣ���� �Ķ���Ϳ� �ּҹ����� bbgEvent�� �����ϸ�
		//�̺�Ʈó���ҽ��� ��ư(jtf_input)�� �̺�Ʈó���� ����ϴ� Ŭ������ �����ϵ��� �ڵ尡 �ۼ��ȴ�.
		//(actionPerformed�޼ҵ带 �����ϵ��� �޼ҵ带 ȣ����)
		jtf_input.addActionListener(bbgEvent); 
		jbtn_new.addActionListener(bbgEvent);
		jbtn_clear.addActionListener(bbgEvent);
		jbtn_exit.addActionListener(bbgEvent);
		jbtn_dap.addActionListener(bbgEvent);
		
		jbtn_new.setBackground(new Color(115,9,9));
		jbtn_new.setForeground(new Color(255,9,9));
		jbtn_dap.setBackground(new Color(45,50,3));
		jbtn_dap.setForeground(new Color(255,9,9));
		
		jbtn_clear.setBackground(new Color(46,6,2));
		jbtn_clear.setForeground(new Color(255,9,9));
		
		jbtn_exit.setBackground(new Color(8,73,85));
		jbtn_exit.setForeground(new Color(255,9,9));
		
		jta_display.setLineWrap(true);
		//jp_center������ �߾ӿ� JTextArea, ���ʿ� JTextField�� ���ϰŴϱ�
		//���̾ƿ��� BorderLayout���� ������.
		jp_center.setLayout(new BorderLayout());
		jp_center.setBackground(Color.MAGENTA);
		//��ư 4���� jp_east������ ���̱� ���ؼ��� ���� ���̾ƿ�(��ġ) �����ؾ���.
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.setBackground(Color.blue);
		
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit );
		//Center ������ jta_display�� jtf_input���� 
		//jp_center������ �߾ӿ� ��ġ.
		//���� ȭ�鿡 ������ ������ �ʾƿ�- �޸𸮴� �ε��Ǿ� ������ jf_ball��  ���� ������ ����.
		jf_ball.add("East",jp_east);
		//jp_center������ JFrame���̱�
		
		jp_center.add("Center",jsp_display);
		jp_center.add("Center",jta_display);
		jp_center.add("South",jtf_input);
		jf_ball.add("Center",jp_center);
		
		jf_ball.setTitle("�߱����ڰ���  ver2.0");
		jf_ball.setSize(300,400);//â�� ���ο� ���� ���� ����
		jf_ball.setVisible(true);//â Ȱ��ȭ/��Ȱ��ȭ   
		
	}
	
	//���� �޼ҵ�
	public static void main(String[] args) {
	      
		BaseBallGame bbgame = new BaseBallGame();
	    bbgame.initDisplay();
	    //bbgame.ranCom();//ä���ϱ�
	      
	}

}
