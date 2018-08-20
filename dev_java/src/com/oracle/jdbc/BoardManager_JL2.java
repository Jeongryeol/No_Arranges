package com.oracle.jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

/**********************************************
 * util������ DBConnectionMgr�� �������� ������ ����
 * Oracle DB�� ����� ������ �Խ����� �����͸� ������ �ͼ� ǥ���غ���
 * 
 * �� Ŭ������ ȭ������� �����ϱ����� JFrame�� ��ӹ޾Ҵ�.
 * �� Ŭ������ ��ư�׼��� �����ϱ����� ActionListener��  ��ӹ޾Ҵ�.
 * 
 * 0.������
 * 1.UI �����޼ҵ�
 * 2.�Խ��Ǹ�� ��ȸ �����޼ҵ�
 * 3.�Խ��Ǹ�� �Է� �����޼ҵ�
 * 4.�Խ��Ǹ�� ���� �����޼ҵ�
 * 5.�Խ��Ǹ�� ���� �����޼ҵ�
 * ++���θ޼ҵ�
 * ++�������̵�޼ҵ�(����ü)
 **********************************************/
public class BoardManager_JL2 extends JFrame implements ActionListener{
	/*�����*/
	//ȭ�� ����� ǥ���Ϸ���, DB�� �ִ� �÷������ ���� �÷��� ���� ǥ�� ȭ�鿡 �ʿ��ϴ� ( JTable )
	//JTable�� ��� DefaultTableModel, DTM�� �����ϴ� �÷�(1���迭)�� �����ͺ���(2���迭)
	String cols_name[] 	= {"�����ȣ", "�����", "��å", "�������", "����"};
	String datas[][] 	= new String[0][5];//�÷��� �� �ڸ��� ������ �Ǵϱ� �ο�� 0
	DefaultTableModel dtm_board_JL
						= new DefaultTableModel(datas, cols_name);
										//�Ķ����(�����ͺ���(2���迭),������ �÷���(1���迭))
	JTable jtb_board2 	= new JTable(dtm_board_JL);//JTable�� DTM�� ��´�
	JScrollPane jsp_board2 = new JScrollPane(jtb_board2,//JScollPane�� ��� ��ũ�ѽð���å�� �����Ѵ�.
									JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
									JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//JScrollPane << JTable << DefalutTableModle << data[][](��������� 2���迭), cols[](�÷� 1���迭)
	
	//SQL���� ����ϴ� 4�� ��ư�� ������
	//JButton�� �������̸�, GridLayout���� ��ܾ��Ѵ�
	//GridLayout�� JPanel���� �� ��ġ�� ������ �� �ִ�.
	JPanel jp_north_4b = new JPanel();
	JButton jbtn_select = new JButton("��ȸ");
	JButton jbtn_insert = new JButton("�Է�");
	JButton jbtn_update = new JButton("����");
	JButton jbtn_delete = new JButton("����");
	
	//����� ���� ���̺��� �����Ǿ����Ƿ�, �������� SQL���� ��û�Ͽ� ����� �ޱ����� ������ ���� �� �����⸦ �غ��Ѵ�.
	//�������������� ����� Connection�� util������ DBConnectionMgr�� �ִ�.
	DBConnectionMgr dbcMgr	= null;	//�����Ҷ� �ν��Ͻ�
	Connection		con		= null;	//dbcMgr.getConnection():Connection
	PreparedStatement pstmt	= null;	//con�� ���� ������ ��û�� SQL�������� ���������̹Ƿ� �̰��� ���� �������� pstmt
	ResultSet		rs		= null;	//SELECT���� ���ϰ��� ResultSet�̰� ���⿡ ��ȸ������� �������
	int				rpoint	= 0;	//INS,UPD,DEL���� ���ϰ��� int�̰� ���⿡ ��������� 0,1�� ���
	//ResultSet�� ��Ƽ� �ٸ� Ŭ������ �Ѿ���� List<HashMap<String.Object>>�� �ʿ��� (�� �޼ҵ忡�� �������� ����)
	List<HashMap<String,Object>> lists					
		= new ArrayList<HashMap<String,Object>>();	//�ؽ����� ��� ��̸���Ʈ�� ������(��������)
	
	/*������*/
	public BoardManager_JL2() {//���θ޼ҵ��� �ν��Ͻ�ȭ�� ȣ��Ǵ� ����Ʈ�޼ҵ�
		initDisplay();//ȭ��ó���� ȣ��
	}
	/*��������Ǹ޼ҵ�*/
	public void initDisplay() {//ȭ��ó����
		//��ư�� ������ ���δ�.(GridLayout(���α���,���α���))
		jp_north_4b.setLayout(new GridLayout(1,4));//1�ο� 4�÷����� 4ĭ�� Ⱦ���� ��ġ�� �ڸ� ����
		jp_north_4b.add(jbtn_select);
		jp_north_4b.add(jbtn_insert);
		jp_north_4b.add(jbtn_update);
		jp_north_4b.add(jbtn_delete);
		//��ư�� �׼ǰ����� �غ��Ѵ�.
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		//JFrame�� ��ġ�� ������ ���̺��� ���δ�
		this.add("North",jp_north_4b);
		this.add("Center",jsp_board2);
		//�ܰ� JFrame�� ������
		this.setTitle("DB�����Ͽ� �Խ�������ϱ�(2���õ�)");
		this.setSize(600, 500);
		this.setVisible(true);
		//Ȯ�ο� �޼ҵ�Ϸ��˾�â 
		//JOptionPane.showMessageDialog(this, "ȭ���˾��Ϸ�", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	public void boardSelect() {//�Խ��� ��ȸ�ϱ�
		
	}
	/*���θ޼ҵ�*/
	public static void main(String[] args) {//���� ���� ����Ǵ� ���θ޼ҵ�
		new BoardManager_JL2();//�ν��Ͻ�+����Ʈ������ ȣ��
	}
	/*����ü�޼ҵ�-�������̵�*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		//JOptionPane.showMessageDialog(this, "��ư�׼ǰ���", "INFO2", JOptionPane.INFORMATION_MESSAGE); //Ȯ�ο� �޼ҵ�Ϸ��˾�â
		Object obj = ae.getSource();					//�׼��̺�Ʈ�� �ҽ��� ������Ʈ�� ��´�
		
		//�����κ��� ��ȸ�� �����ϰ� >> ��ȸ�� ������� �޾Ƽ� �ڷᱸ���� ��� >> ���� �ڷᱸ���� ȭ�鿡 ����
		dbcMgr = DBConnectionMgr.getInstance();			//DBConnectionMgr�� �ν��Ͻ�ȭ�ϴ� �޼ҵ� ȣ�� :���ϰ��� �ν��Ͻ���
		con = dbcMgr.getConnection();					//�����������
		StringBuilder sb_sql = new StringBuilder();		//���������� ���� ���ɰ� ���ɿ� ���� sql�� �غ�
		
		if(obj==jbtn_select) { //������ �׼��� ��ȸ������ ��°Ŷ��
			try {
				sb_sql.append("SELECT empno, ename, job, hiredate, sal FROM emp");	//sql�� �߰��ϱ�
				pstmt = con.prepareStatement(sb_sql.toString());			//���������� ���� ���ɿ� sql�� ���
			//	pstmt.setString(parameterIndex, x);		//���������� �����Ҷ�, �����Ǵ� ?�ڸ��� ��  ��ġ�Ҷ� ����ϴ� �޼ҵ� setString
				rs = pstmt.executeQuery(); 				//sql���� ����� �������� ������ ��û�ϰ� ����� ��Ƶα� (SELECT���̱� ����)
				
				//��Ƶ� ������� �ڷᱸ���� �Űܴ��
				while(rs.next()) {									//���� ������� Ŀ���� �������� �̵��� �ȴٸ�
					HashMap<String,Object> hmaps
						= new HashMap<String, Object>();			//���ο� �ؽ����� �����
			//�⺻��	hmaps.put("�����ε�����", rs.getType("�÷���"));		//� �÷����� �ڷḦ � Ÿ������ � �ε����� �޾Ƽ� �ؽ��ʿ� �־��
					hmaps.put("empno", rs.getInt("empno"));			//empno�÷��� ���� int������ empno�ε����� �޾Ƽ� �ؽ��ʿ� �־��
					hmaps.put("ename", rs.getString("ename"));
					hmaps.put("job", rs.getString("job"));
					hmaps.put("hiredate", rs.getString("hiredate"));
					hmaps.put("sal", rs.getInt("sal"));			//empno�÷��� ���� int������ empno�ε����� �޾Ƽ� �ؽ��ʿ� �־��
					lists.add(hmaps);								//�ؽ����� ��̸���Ʈ�� �־��
				}
			//	System.out.println(lists);//Ȯ�ο� ��±���
				
				//������ for������ �ؽ����� ���� dtm�� ���
				//Lists(������)�� ����ִ� HashmapŸ���� hmaps(����)�� ������� ��������
				for(HashMap<String,Object> hmaps:lists) {
					Vector ss = new Vector();				//1���� �ο츦 ���� ���ο� �ڷᱸ�� ���� (dtm�� Vector�ڷ����� ���� �� ����)
			/*		System.out.println(hmaps.get("empno"));
					System.out.println(hmaps.get("ename"));
					System.out.println(hmaps.get("job"));		//hmaps.get("�ε����̸�") : �ش� �̸����� �� �ؽ����� ���� ���´�
					System.out.println(hmaps.get("hiredate"));
					System.out.println(hmaps.get("sal"));	*/	//Ȯ�ο� ��±���
					
					ss.add(hmaps.get("empno"));				//�ؽ����� �ε����� ���� �ҷ��� ������ Vector�� ����
					ss.add(hmaps.get("ename"));
					ss.add(hmaps.get("job"));
					ss.add(hmaps.get("hiredate"));
					ss.add(hmaps.get("sal"));
					
					dtm_board_JL.addRow(ss);				//Vector�� dtm�� 1���� �ο�� �Űܴ��� (���⼭ �������� ȭ���� ������ ä����)
															//for���� ���� ������ �ݺ��Ǿ� ��� �ο찡 ���
				}
				
			}catch (SQLException se) {
				se.printStackTrace();
			}catch (Exception e) {

			}//////////////end of try-catch
			
		}//////////////////end of if(obj==jbtn_select)
		
	}//////////////////////end of actionPerformed(ActionEvent ae)
	
}//////////////////////////end of class
