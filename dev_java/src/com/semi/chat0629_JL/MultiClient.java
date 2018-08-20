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

	//Ŭ���̾�Ʈ���� ������ �����ϱ����ؼ� ���ϻ���
	Socket socket = null;
	//��ü����ȭ�� �������ִ� inputStream�� OutputStream�� �ʿ��ϴ�
	ObjectInputStream	ois = null;	//���
	ObjectOutputStream	oos = null;	//���ϱ�
	//��ȭ�� �޾Ƽ� �ѱ� ���ڿ�
	String nickname = null;
	
	//������Ʈ ȭ�鱸��
	JPanel		jp_first		= new JPanel();
	JPanel		jp_first_south	= new JPanel();
	JPanel		jp_second		= new JPanel();
	JPanel		jp_second_south	= new JPanel();
	/*****************************[ �� API ]************************************/
	StyledDocument sd_display	= new DefaultStyledDocument(new StyleContext());
	JTextPane	jtp_display		= new JTextPane(sd_display);
	/**************************************************************************/
	//JTextArea	jta_display = new JTextArea();
	JScrollPane	jsp_display = new JScrollPane(jtp_display
											 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField	jtf_msg		= new JTextField();
	JButton		jbtn_send	= new JButton("����");
	
	//��������Ʈ ȭ�鱸��
	String data[][]		= new String[0][3];
	String cal[]		= {"��ȭ��","����","����"};
	DefaultTableModel	dtm_list	= new DefaultTableModel(data, cal);
	JTable				jtb_list	= new JTable(dtm_list);
	JScrollPane			jsp_list	= new JScrollPane(jtb_list
													,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
													,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JButton	jbtn_change		= new JButton("��ȭ�� ����");
	JButton	jbtn_whisper	= new JButton("1:1 ��ȭ");
	JButton	jbtn_emotion	= new JButton("�̸�Ƽ��");
	JButton	jbtn_fontColor	= new JButton("���ڻ� ����");
	JButton	jbtn_mijung		= new JButton("���ұ�?");
	JButton	jbtn_exit		= new JButton("����");
	/*****************************[ �� API ]************************************/
	//JTable ��� ��ü �߰� : ���� �����̳� ��� ���� ����ó���� �ʿ���. ex)���ο���, ���� .. etc.
	JTableHeader jth_list	= jtb_list.getTableHeader();
	/**************************************************************************/
	String	fontColor		= "0";
	
	String imgPath = "src\\com\\images\\";
	ImageIcon img_back = new ImageIcon();
	String fontType = "Font.PLAIN";
	int fontSize = 12;
	
	//������
	public MultiClient() {
		initDisplay();
		connect_process();
	}
	//��������� ���� �ʱ�ȭ
	public void connect_process() {
		try {
			socket = new Socket("192.168.0.230",5000);
			//���� ���ϱ� â�� ����
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			//100#�г��� [�������� ������ ���] : �� ������ �����߾��.
			oos.writeObject(Protocol.ROOM_IN+"|"+nickname);
			//���ڰ� ��ȭ�� ���� �ʿ��� ����
			MultiClientThread mct = new MultiClientThread(this);
			mct.start();//run()ȣ��
			
		}catch (Exception e) {
			
		}
	}
	//ȭ��ó����
	public void initDisplay() {
		nickname = JOptionPane.showInputDialog("����� ��ȭ���� �Է����ּ���.");
		//�̺�Ʈ ������ ���� 
		jtf_msg.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_emotion.addActionListener(this);
		jbtn_fontColor.addActionListener(this);
		jbtn_mijung.addActionListener(this);
		jbtn_exit.addActionListener(this);
		//�ؽ�Ʈ�Է°��� ȭ�麯ȭ �� ����
		jsp_display.setEnabled(false);	//JTextPane�� ���� ����
		jtf_msg.requestFocus(); 		//��Ŀ�� �̵��ϱ�
		jtp_display.setFont(new Font(null,0,14));	//JTextPane�� ��Ʈ����
		jtf_msg.setFont(new Font(null,0,14));		//JTextField�� ��Ʈ����
		//JTable���� ȭ�麯ȭ �� ����
		jth_list.setBackground(Color.white);		//JTable����� ��������
		jth_list.setReorderingAllowed(false);		//JTable����� ��ġ���� ����
		jth_list.setResizingAllowed(false);			//JTable����� ũ�⺯�� ����
		jth_list.setReorderingAllowed(false);		//JTbble����� �������� ����
		//JFrame ������Ʈ
		jp_first.setLayout(new BorderLayout());	//JPanel�� ȭ�����(��,��,��,��,�߾�)
		jp_first.add("Center",jsp_display);
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);
		jp_first.add("South",jp_first_south);
		//JFrame ��������Ʈ
		jp_second.setLayout(new BorderLayout());//JPanel�� ȭ�����(��,��,��,��,�߾�)
		jp_second_south.setLayout(new GridLayout(3,2));//JPanel�� ȭ�����(row,column)
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_whisper); 
		jp_second_south.add(jbtn_emotion);
		jp_second_south.add(jbtn_fontColor); 
		jp_second_south.add(jbtn_mijung);
		jp_second_south.add(jbtn_exit);
		jp_second.add("Center",jsp_list);
		jp_second.add("South",jp_second_south);
		
		//JFrame ��������
		this.setLayout(new GridLayout(1,2));	
		this.add(jp_first);
		this.add(jp_second);
		//JFrame����
		this.setTitle(nickname+"�԰��� ��ȭâ");		
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		//this�� super�� static�������� �����⶧����, JFrame���� ȣ���ؾ��� (��Ӱ� ����)
		JFrame.setDefaultLookAndFeelDecorated(true);//JAVA FRAME �⺻��Ų
		new MultiClient();
	}
	//�׼�_�������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//���ϱ�ó�� (�޼��� �Է��ϰ� ������������ ó������)
		if(obj==jtf_msg) {
			try {
				oos.writeObject(Protocol.MESSAGE
								+"|"+nickname
								+"|"+msg
								+"|"+fontColor
								+"|"+fontType
								+"|"+fontSize);
				jtf_msg.setText("");//����α�
			}catch (Exception e2) {
				e2.printStackTrace();//stack�� ����� ���� �޽�����  ���-�̷°���(�ٹ�ȣ)
			}
		} else if(obj==jbtn_change) {
			
		} else if(obj==jbtn_whisper) {
			
		} else if(obj==jbtn_emotion) {
			
		}
		//��Ʈ���򺯰� �̺�Ʈó��
		else if(obj==jbtn_fontColor) {
			JDialog jdl_color = new JDialog();
			JColorChooser jc_color = new JColorChooser();
			ColorSelectionModel csm = jc_color.getSelectionModel();
			ChangeListener listener = new ChangeListener() {//�͸�Ŭ������ ó���ϴ� �߻�Ŭ����
				@Override
				public void stateChanged(ChangeEvent ce) {
					Color newFontColor = jc_color.getColor();
					fontColor = String.valueOf(newFontColor.getRGB());
				}
			};
			csm.addChangeListener(listener);
			jdl_color.add("Center",jc_color);
			jdl_color.setTitle("��Ʈ���򺯰�");
			jdl_color.setSize(600,500);
			jdl_color.setVisible(true);
		} else if(obj==jbtn_mijung) {
			
		}
		//����ó��
		else if(obj==jbtn_exit) {
			System.exit(0);
		}//----- end of if-else if
		
	}//--------- end of actionPerformed
	
}//------------- end of class 
