package com.semi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame implements ActionListener{//-Ŭ�����ȿ����� ���� ����
   //����� -����ο��� ����� �޼ҵ带 ȣ������ �ʴ´�.
   JFrame jf_ball = new JFrame();//��������
   JPanel jp_east = new JPanel();//���ʿ� ���� ����
   JPanel jp_center = new JPanel();//JFrame
   
   //��ư 4�� �߰��غ��� - ��ư�� ���ؼ��� �̺�Ʈ ó���� �ؾߵǴϱ� ���������� ����
   //�̺�Ʈ ó���� ���� �޼ҵ带 ������ ó���Ѵ�. -��������
   JButton jbtn_new =new JButton("������");
   JButton jbtn_dap =new JButton("����");
   JButton jbtn_clear =new JButton("�����");
   JButton jbtn_exit =new JButton("����");
   
   JTextArea jta_display  = new JTextArea();//���Ϳ� ��ġ
   JScrollPane jsp_display =new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                                    //���� ��ũ�ѹٴ� ���� ���� ��ũ�ѹٴ� ���� ����.
   JTextField jtf_input =new JTextField();
   Font f = new Font("Thoma",Font.BOLD,16);
   //���Ͱ� ä���� ���� ���� �迭
   int com[] =new int[3];
   //����ڰ� �Է��� ���� ���� �迭
   int user[] =new int[3];
   //��Ʈ�� ���� ��Ʈ����ũ ������ ���� ����
   int strike = 0;
   //��Ʈ�� ���� �� ������ ���� ����
   int ball = 0;
   //ȸ���� ����ϴ� ���� ����
   int cnt =1;
   Random r =new Random();
   //���Ͱ� ä���� ���� �����ϴ� �޼ҵ� ����
   public void ranCom() {
      // Do-while���� �ѹ��� ��� ����(�����Ű��) while�� �ȿ� �ִ� ������ �˻��ϰ�,
      //�� ������ ������ ��쿣 ������! �������� ���� ��쿣 �ٽ� do {}�� ���� �ݺ� 
      com[0] = r.nextInt(10);
      do {
         com[1] = r.nextInt(10);
      }while(com[0]==com[1]);
      do {
         com[2] = r.nextInt(10);
      }while(com[0]==com[2] || com[1]==com[2]);
   }
   //ȭ��ó����
   public void initDisplay() {
      //�̺�Ʈ ó����� ���۳�Ʈ�� �̺�Ʈ ó�� Ŭ������ �����ϱ�
      //���⼭ this�� BaseBallGame�� ����Ű�� ����� �ε�
      //�̺�Ʈ ó���� ����ϴ� actionPerformed�޼ҵ带 �����ϰ� �ֱ� ������..
      jtf_input.addActionListener(this);
      jbtn_new.addActionListener(this);
      jbtn_clear.addActionListener(this);
      jbtn_exit.addActionListener(this);
      jbtn_dap.addActionListener(this);
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
      
      jf_ball.setTitle("�߱����ڰ���");
      jf_ball.setSize(300,400);//â�� ���ο� ���� ���� ����
      jf_ball.setVisible(true);//â Ȱ��ȭ/��Ȱ��ȭ   
      
   }
   
   //���� ���� ó���ϴ� �޼ҵ�
   public String result(String userInPut) {
      //��Ʈ�� ���� ��Ʈ����ũ ������ ���� ����
      int strike = 0;
      //��Ʈ�� ���� �� ������ ���� ����
      int ball = 0;//��������
      //�Է¹��� ���ڿ��� ����Ÿ������ �ٲپ� ���� ��������
      int temp = 0;
      try{
    	  temp =Integer.parseInt(userInPut);
      }catch (NumberFormatException nfe) {
    	  System.out.println("NumberFormatException : "+nfe.getMessage());
    	  JOptionPane.showMessageDialog(jf_ball, "���ڸ� �Է��ϼ���.", "Error", JOptionPane.ERROR_MESSAGE);
      }
      user[0] =temp/100;
      user[1] = (temp%100)/10;
      user[2] = temp%10; 
      for (int i=0;i<3;i++) {
         for(int j=0;j<3;j++) {
            if(user[i]==com[j]) {
               if(i==j) {
                  strike++;
               }
               else {
                  ball++;
               }
            }////////////////////////end of if
         }///////////////////////////end of inner for
      }//////////////////////////////end of outter for
      if(strike==3) {
      return "�����Դϴ�";   
      }
      
      return +strike+"��"+ball+ "��";//��������
   }/////////////////////////////////end of result
   

   //���θ޼ҵ�
   public static void main(String[] args) {
      //insert here - initDisplay()ȣ���ϱ�
      //���ȿ� �ִ� �޼ҵ�� �ν��Ͻ�ȭ ���� ����� �� ����, �׷��� non-static�� static�������� ���Ұ��ϱ�
      //�ν��Ͻ�ȭ �ؾ���.
      BaseBallGame bbgame = new BaseBallGame();
      bbgame.initDisplay();
      bbgame.ranCom();//ä���ϱ�
      
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      
      Object obj = e.getSource();//�̺�Ʈ�� �߻��� Ŭ������ �ּҹ���
      String label = e.getActionCommand();//��ư�� �� -������, ����,�����, ����
      System.out.println(obj);
      System.out.println(label);
      
      
      if(obj==jtf_input){
         //jta_display.append(jtf_input.getText()+"\n");//append �����̴�
         //����ڰ� 3�ڸ� ���ڸ� �Է��ϰ� enter���� �� �Ʒ�ó�� ����� �ּ���
         //1ȸ 257 : 0�� 1��
         //2ȸ 526 : 1�� 0
         jta_display.append((cnt++)+"ȸ."+jtf_input.getText()+":"+result(jtf_input.getText())+"\n");
         jtf_input.setText("");
         
         }
      //�� �����ӹ�ư Ŭ���Ѱž�?
      //else if(obj==jbtn_new) {//�ּҹ����� ����?
      else if("������".equals(label)) {//�ʰ� Ŭ���� ��ư�� ���ڿ��� �������̾�? �ּҹ���(who? jbtn_new)�� ���� ���ڿ��� ��
         ranCom();
      }
      //�� ����� ��ư �����ž�?
      else if("�����".equals(label)) {
         jta_display.setText("");
      }
      else if("����".equals(label)) {
         System.exit(0);
      }
       else if("����".equals(label)) {
          jtf_input.setText("");   
     }
      
      }

   
}