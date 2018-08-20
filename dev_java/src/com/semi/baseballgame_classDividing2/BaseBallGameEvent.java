package com.semi.baseballgame_classDividing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseBallGameEvent implements ActionListener{

	int cnt = 0;
	
/*	JTextArea jta_display  = new JTextArea();//���Ϳ� ��ġ
	JScrollPane jsp_display =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	                                    //���� ��ũ�ѹٴ� ���� ���� ��ũ�ѹٴ� ���� ����.
	JTextField jtf_input =new JTextField();*/
	
	BaseBallGameLogic bbgl = null;
	public BaseBallGameEvent(BaseBallGameLogic bbgl) {
		this.bbgl = bbgl;
	}
	
	BaseBallGameView bbgv  = null;					 
	//��� bbgv�� �ν��Ͻ�ȭ ���� �ʾƵ�
	//ViewŬ�������� �ν��Ͻ�ȭ�Ҷ� �Ķ���Ϳ� viewŬ������ �ּҹ���(this)�� �Ѱܼ� �����Ա� ������
	//�Ʒ� �������� �Ķ���ͷ� EventŬ������ ���������� ����� bbgv�� ����־���
	public BaseBallGameEvent(BaseBallGameView bbgv,BaseBallGameLogic bbgl) {
		this.bbgv = bbgv;//���������� bbgv�� �Ķ���ͷ� ���� bbgv�� ���� �ʱ�ȭ���ش�.
		this.bbgl = bbgl;//���������� bbgl�� �Ķ���ͷ� ���� bbgl�� ���� �ʱ�ȭ���ش�.
		//�� �ڵ忡�� ���������� ���� ���������� �ּҹ����� �ԷµǾ��ֱ� ������
		//�Ʒ� actionPerformed �޼ҵ��  �������� ���� �� �ְ� �Ǳ⶧����
		//�ν��Ͻ����� bbgv���� �����տ� �Է��ϴ� �� ������, ��� �ణ�ּ��κ��� ���������� �ʿ��������.
	}
	
	public BaseBallGameEvent(BaseBallGameView bbgv) {
		this.bbgv = bbgv;
	}//���� �����ڸ� ����� ����
	
	//�̺�Ʈ �����ϴ� ???	
	@Override
	public void actionPerformed(ActionEvent e) {

	      
	   Object obj = e.getSource();//�̺�Ʈ�� �߻��� Ŭ������ �ּҹ���
	   String label = e.getActionCommand();//��ư�� �� -������, ����,�����, ����
	   System.out.println(obj);
	   System.out.println(label);
	   
	   
	   if(obj==bbgv.jtf_input){
	      //jta_display.append(jtf_input.getText()+"\n");//append �����̴�
	      //����ڰ� 3�ڸ� ���ڸ� �Է��ϰ� enter���� �� �Ʒ�ó�� ����� �ּ���
	      //1ȸ 257 : 0�� 1��
	      //2ȸ 526 : 1�� 0
		   bbgv. jta_display.append((cnt++)+"ȸ."+bbgv.jtf_input.getText()+":"+bbgl.result(bbgv.jtf_input.getText())+"\n");
		   bbgv.jtf_input.setText("");
	      
	      }
	   //�� �����ӹ�ư Ŭ���Ѱž�?
	   //else if(obj==jbtn_new) {//�ּҹ����� ����?
	   else if("������".equals(label)) {//�ʰ� Ŭ���� ��ư�� ���ڿ��� �������̾�? �ּҹ���(who? jbtn_new)�� ���� ���ڿ��� ��
	      bbgl.ranCom();
	   }
	   //�� ����� ��ư �����ž�?
	   else if("�����".equals(label)) {
	      bbgv.jta_display.setText("");
	   }
	   else if("����".equals(label)) {
	      System.exit(0);
	   }
	    else if("����".equals(label)) {
	      bbgv.jtf_input.setText("");   
	  }
	   
	}
	
}
