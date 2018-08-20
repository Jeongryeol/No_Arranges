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
	//�����
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
	JScrollPane jsp_display = new JScrollPane(jta_display//��ũ�ѹٸ� �����ϰ� �ִ� ����
											  //����, ���� ������ ��ũ�ѹٿ� ���� ��å ����
											 ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											 ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JFileChooser jfc = new JFileChooser();
	//������
	public Memo() {
		initDisplay();
	}
	
	//ȭ�� ó����
	public void initDisplay() {
		//�׼Ǹ����� ����
		jmi_open.addActionListener(this);
		jmi_save.addActionListener(this);
		jmi_copy.addActionListener(this);
		jmi_cut.addActionListener(this);
		jmi_paste.addActionListener(this);
		
		//insert here - JTextArea�� �ڵ��ٹٲ� �޼ҵ带 ã������
		jta_display.setLineWrap(true);
		
		//����Ű�ο� �� �ش繮�� ���� : ����Ű������ Alt+'����'
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
		this.setTitle("�޸�");
		this.setIconImage(memoIC.getImage());//������ �����ϱ�
		this.setSize(500,800);
		this.setVisible(true);
	}
	//���� �޼ҵ�
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Memo();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//�̺�Ʈ�� �Ͼ �ּҹ����� ����
		
		//���� ����
		if(obj==jmi_save) {
			//���� ��ȭ���� ����
			int status = jfc.showOpenDialog(this);
			//�����ư �����Ŵ�?
			if(status==JFileChooser.APPROVE_OPTION) {
				try {
					//���� �����ϱ� ó������
					File myFile = jfc.getSelectedFile();
					BufferedWriter bw =
								new BufferedWriter(
										new FileWriter(myFile.getAbsolutePath()));
					//String�� ������ �ٲ��� �ʱ� ������, �ݵ�� ������ ��Ƽ� �ʱ�ȭ�Ѵ�.
					String temp = jta_display.getText().replace("\n", "\r\n");//�ٹٲپ� �����ϵ��� ��ġ
					bw.write(temp);
					bw.close();
					
				}catch (Exception e) {

				}
			}
			
		}/////////////end of outter if
		
		//copy����
		else if(obj==jmi_copy) {
			jta_display.copy();
		}
		
		//cut����
		else if(obj==jmi_cut) {
			jta_display.cut();
		}
		
		//paste����
		else if(obj==jmi_paste) {
			jta_display.paste();
		}
		
		//���� ����
		else if(obj==jmi_open) {
			int status = jfc.showOpenDialog(this); //�Ͼ���̱�� String ��ü
			
			//�����ư �����Ŵ�??
			if(status==JFileChooser.APPROVE_OPTION) {
				//������ ���� ó���� �����ϱ� ( ����ó���� �ʼ�! )
				try {
					String strLine = null; //�Ͼ���̱�� String ��ü
					//FileChooser���� ���õ� ������ File��ü �����ϱ�(�ڹٴ�  ��� ����� ��ü�� ����� �ٷ��)
					//File myFile = new File("src//com//ch15//HP.java");
					//���Ͱ��� ������ ��üȭ�ߴ� ��Ŀ��� �Ʒ��Ͱ��� ������� �����ϵ��� ����
					File myFile = jfc.getSelectedFile();
					
				/** �ҷ������� 1 */
					//���õ� ������ �����θ� �����ؼ� BufferedReader��ü ���� [����Ŭ����-�ܵ����� ���Ұ�]
					BufferedReader myReader
							= new BufferedReader(
									new FileReader(
											myFile.getAbsolutePath()
												  )
												);
					//Buffered ��, ��� ���� ���ٱ����� �ð��� ������ �� �ִ� ��.
					//���۱���� ������ �Ѱᰰ�� �ӵ��� �о �� �ִ�.
					//�ֳ��ϸ�, ������ �ͺ��� ���� ���� Ȯ���س��� ���� �ӵ��� �о�� ����
					
					//insert here - JTextArea�� ó�� 1���� �����ϵ��� �غ���
					jta_display.setText(myReader.readLine());
					//insert here - ������ �൵ �������
					while((strLine=myReader.readLine())!=null) {
						jta_display.append("\n"+strLine);
					}
					
				/** �ҷ������� 2 : �Ʒ������ �о�� �������� �ڷḦ �� �ѱ��ھ� �о �ø��� �������,
				  				��� ���ڸ� �������ؼ��� �ݺ����� �ʿ��ϸ�, �ſ� ��ȿ�����̴�. ������ 1������� ����Ԥ���.*/
				/*	FileReader fr = new FileReader(myFile.getAbsolutePath());
					jta_display.setText(String.valueOf(
							(char)fr.read()	//�о�� �ڵ�� 16������ ǥ���� �������̹Ƿ�,
							)				//����Ÿ��(char)�� ��ȯ�ϸ� �����Ǵ� ���ڷ� ��ȯ��
							);*/
				}catch (Exception e) {
					e.printStackTrace();
				}/////end of try-catch
				
			}/////////end of inner if
			
		}/////////////end of outter else if
		
	}///////////end of actionPerformed
	
}///////////////end of class
