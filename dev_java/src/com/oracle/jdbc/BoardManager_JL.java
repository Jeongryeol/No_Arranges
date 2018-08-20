package com.oracle.jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;

//SELECT�� ����� ��Ƽ� UI�� ��Ÿ���� ����Ŵ��� Ŭ����
public class BoardManager_JL extends JFrame implements ActionListener {
	
/*�����*/
	//DefaultTableModel�� ����� ��� �÷�����(1���迭)�� ��µ� ���� ���� �����ͺ���(2���迭)
	String cols[]	= {"�۹�ȣ", "����", "�ۼ���", "�ۼ���", "��ȸ��"};
	String data[][]	= new String[0][5];
	//DefaultTabelModel�� ����� �ڷᰡ �� 2�������� ����������Ƿ� �־��
	DefaultTableModel dtm_board = new DefaultTableModel(data,cols);
	//dtm�� ���� JTable�� JTable�� ��Ƽ� �������� ���̰� �� JScrollPane ����
	JTable jtb_board = new JTable(dtm_board);
	JScrollPane jsp_board = new JScrollPane(jtb_board
											,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//��ư��� - ��ư�� 4�� ���� ���� GridLayout(1,4)
	JPanel jp_north = new JPanel();
	JButton jbtn_select = new JButton("��ȸ�ϱ�");
	JButton jbtn_insert = new JButton("�Է��ϱ�");
	JButton jbtn_update = new JButton("�����ϱ�");
	JButton jbtn_delete = new JButton("�����ϱ�");
	//����� �����ڵ� ��������
	//(����̹�����, Ŀ�ؼ����� ������ �� ����)
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
/*������*/
	public BoardManager_JL() {
		initDisplay();
	}
/*�Խñ� ��� ��ȸ ���� �޼ҵ�*/
	/*********************************************
	 * �Խñ� ��� ��ȸ ���� �޼ҵ�
	 * @param : HashMap<String,Object> �ش����
	 * @return : List<HashMap<String,Object>>
	 * �ۼ��� : ������
	 *********************************************/
	public ArrayList getBoardList() {
		
		//��ȸ����� ����� ���� ����
		//(��? ResultSet�� �ݾ����� ��ȸ����� ������������, ��ȸ����� �ٸ� ������ �������� ���ؼ� )
		ArrayList<HashMap<String,Object>> lists
			= new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> maps = null;
		
		try {
			
			dbMgr = new DBConnectionMgr();	//��������Ŭ������ �ν��Ͻ� ������Ʈ����
			con = dbMgr.getConnection();	//�� ������Ʈ�� ������ �ϴ� �޼ҵ� ȣ���Ͽ� ����������������
			
			//sql���� ���� ��Ʈ������ �����ϰ�, ��Ʈ�������� SQL�� ����
			StringBuilder sbd = new StringBuilder();	
			sbd.append("SELECT b_no,b_title,b_content,b_writer,b_date,b_hit FROM jdbc_board");
			
			//pstmt�� ��������(con)�� ���� preparedStatement()�޼ҵ带 ȣ���Ҷ�,
			//�Ķ���Ϳ� 'sql���� ��Ʈ������ �ٲ�ְ� ȣ��'�ؼ� ������ ���Ϲ޾� �غ���
			pstmt = con.prepareStatement(sbd.toString());
			
			//DML SQL�� SELECT���� ������ ��û�ϰ��� (pstmt ������ ������ ��û�� : executeQuery)
			//��ȸ����� ���ϵǹǷ�, ��ȸ����� ����� ������ �ʿ��� (����Ÿ�� : ResultSet)
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {//��ȸ����� �� �ο��� ������ ��� �ԷµǸ� Ŀ���� �̵���Ų��.
				maps = new HashMap<String, Object>();
				maps.put("b_no",rs.getInt("b_no"));
				maps.put("b_title",rs.getString("b_title"));
				maps.put("b_writer",rs.getString("b_writer"));
				maps.put("b_date",rs.getString("b_date"));
				maps.put("b_hit",rs.getInt("b_hit"));
				lists.add(maps);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;
	}
	
/*�Խñ� ��� ���� �޼ҵ�*/
	/*****************************************
	 * �Խñ� ��� ���� �޼ҵ�
	 * @param : HashMap<String,Object> �� �ʿ���
	 * @return : int
	 * �ۼ���  : ������
	 *****************************************/
	public int boardInsert(HashMap<String,Object> pMap) {
		int result = 0;
		// �Ķ���Ϳ� ���� ����ִ��� �׽�Ʈ�غ���
		System.out.println("���� : " + pMap.get("b_title"));
		System.out.println("���� : " + pMap.get("b_content"));
		System.out.println("�ۼ��� : " + pMap.get("b_writer"));

		try {
			dbMgr = new DBConnectionMgr(); // ��������Ŭ������ �ν��Ͻ� ������Ʈ����
			con = dbMgr.getConnection(); // �� ������Ʈ�� ������ �ϴ� �޼ҵ� ȣ���Ͽ� ����������������

			// sql���� ���� ��Ʈ������ �����ϰ�, ��Ʈ�������� SQL�� ����
			StringBuilder sbd = new StringBuilder();
			sbd.append("INSERT INTO jdbc_board ( b_no,b_title,b_content,b_writer,b_date " + 
					"VALUES (seq_jdbc_board_no.nextval,?,?,?,TO_CHAR(sysdate,'YYYY-MM-DD'))");
			// pstmt�� ��������(con)�� ���� preparedStatement()�޼ҵ带 ȣ���Ҷ�,
			// �Ķ���Ϳ� 'sql���� ��Ʈ������ �ٲ�ְ� ȣ��'�ؼ� ������ ���Ϲ޾� �غ���
			pstmt = con.prepareStatement(sbd.toString());
			// ����ǥ ��ũ�� ������ �Է½��Ѻ���
			pstmt.setString(1, "�׽�Ʈ������");
			pstmt.setString(2, "�׽�Ʈ�۳���");
			pstmt.setString(3, "�׽�Ʈ���ۼ���");
			
			// DML SQL�� INSERT,UPDATE,DELETE ���� ������ ��û�ϰ���
			// ����� �ο찳��(int)�� ���ϵǹǷ�, ��ȸ����� ����� ������ �ʿ��� (����Ÿ�� :int)
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
/*�Խñ� ���� ���� �޼ҵ�*/
	/*****************************************
	 * �Խñ� ���� ���� �޼ҵ�
	 * @param : HashMap<String,Object> �� �ʿ���
	 * @return : int
	 * �ۼ���  : ������
	 *****************************************/
	public int boardUpdate(HashMap<String,Object> pMap) {
		int result = 0;
		//�Ķ���Ϳ� ���� ����ִ��� �׽�Ʈ�غ���
		System.out.println("���� : "+pMap.get("b_title"));
		System.out.println("���� : "+pMap.get("b_content"));
		System.out.println("�ۼ��� : "+pMap.get("b_writer"));
		return result;
	}
/*�Խñ� ���� ���� �޼ҵ�*/
	/*****************************************
	 * �Խñ� ���� ���� �޼ҵ�
	 * @param : int �� PK�̾�� �� - ������ �����ҰŴ�?
	 * @return : int
	 * �ۼ���  : ������
	 *****************************************/
	public int boardDelete(int b_no) {
		int result = 0;
		//�Ķ���Ϳ� ���� ����ִ��� �׽�Ʈ�غ���
		System.out.println("�۹�ȣ : "+b_no);
		return result;
	}
	
/*ȭ��ó����*/
	public void initDisplay() {
		//���̺��� ����� ������Ѻ���
		jtb_board.getColumnModel().getColumn(0).setWidth(100);
		//��ư�� �������̱� ������ GridLayout�� �ʿ��ϰ�,�� ���̾ƿ��� ����(JPanel)�� �����Ѵ�.
		//���Ŀ� ������� �ִ´�.
		jp_north.setLayout(new GridLayout(1, 4));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		//�׼��� �߰�����
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		//������ ���ʿ� ����
		this.add("North", jp_north);
		//�߾ӿ� ǥ�� ��ġ�Ұž�
		this.add("Center",jsp_board);
		this.setTitle("�������Խ���");
		this.setSize(800,500);
		this.setVisible(true);
	}
/*���θ޼ҵ�*/
	public static void main(String[] args) {
		BoardManager_JL bm = new BoardManager_JL();
	}
/*�������̵�޼ҵ�*/
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_select) {
			//Ȯ��â ����
			System.out.println("��ȸ�ϱ� ��ư �׼�ȣ�⼺��");
			JOptionPane.showMessageDialog(this,"��ȸ����","INFO",JOptionPane.INFORMATION_MESSAGE);
			
			//��ȸ���ִ� �޼ҵ带 ȣ���ؼ� ��ȯŸ�Կ� ���߾� ������ ����
			ArrayList<HashMap<String,Object>> selectRs = getBoardList();
			
			//������ for������ ��ü(����)�� ������Ʈ(������)�� ���缭 ������� ����
			for(HashMap<String,Object> item : selectRs) {
				System.out.println(item);
			}
/*			System.out.println("1");
			//��ư �������� �����Ű�� �ǰ���?
			dbMgr = new DBConnectionMgr();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b_no, b_title, b_writer, b_date, b_hit FROM jdbc_board");
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				//�ڷᱸ���� ��ȭ�� �־�� (VO�� �����Ƿ� �ؽ������� �غ���)
				//HashMap�� ��뷮 �ڷᱸ���� ó���ӵ��� ������ ������.
				List<HashMap<String,Object>> boardList =
						new ArrayList<HashMap<String,Object>>();
				
				while(rs.next()) {
					HashMap<String,Object> rMap = new HashMap<String, Object>();
					rMap.put("b_no",	rs.getInt("b_no"));
					rMap.put("b_title",	rs.getString("b_title"));
					rMap.put("b_writer",rs.getString("b_writer"));
					rMap.put("b_date",	rs.getString("b_date"));
					rMap.put("b_hit",	rs.getInt("b_hit"));
					boardList.add(rMap);
				}
				//boardList�� 0���� ū ����� ������, ������ �Ǿ����� �ƴ����� Ȯ���� �� �ִ� �����׽�Ʈ�� �ɰ��̴�!!
				System.out.println(boardList.size());
				
			}catch (Exception e) {
				// TODO: handle exception'
			e.printStackTrace();
			
			}////end of try-catch
*/			
		}////////end of if(��ȸ�ϱ�)
		else if(obj==jbtn_insert) {
			//Ȯ��â ����
			System.out.println("�Է��ϱ� ��ư �׼�ȣ�⼺��");
			JOptionPane.showMessageDialog(this,"�Է¼���","INFO",JOptionPane.INFORMATION_MESSAGE);
			
			//�ؽ��ʿ� ���� �ڷ���
			HashMap<String,Object> insertHm= new HashMap<String, Object>();
			insertHm.put("b_title","�۵�Ͽ���");
			insertHm.put("b_content","�۵�ϳ���");
			insertHm.put("b_writer","�۵���ۼ���");
			
			//��ȸ���ִ� �޼ҵ带 ȣ���ؼ� ��ȯŸ�Կ� ���߾� ������ ����
			
		}////////end of if(�Է��ϱ�)
		else if(obj==jbtn_update) {
			
		}////////end of if(�����ϱ�)
		else if(obj==jbtn_delete) {
			
		}////////end of if(�����ϱ�)
		
	}////////////end of actionPerformed()�޼ҵ�

}////////////////end of class
