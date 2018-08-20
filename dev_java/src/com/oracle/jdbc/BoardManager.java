package com.oracle.jdbc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class BoardManager extends JFrame implements ActionListener {
	//DefaultTableModel
	String cols[] = {"�۹�ȣ","������","�ۼ���","�ۼ���","��ȸ��"};
	//DefaultTableModel
	String data[][] = new String[0][5];
	DefaultTableModel dtm_board
				= new DefaultTableModel(data,cols);
	JTable jtb_board = new JTable(dtm_board);
	JScrollPane jsp_board 
		= new JScrollPane(jtb_board
				         ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				         ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//��ư�� 4�� ���� ����-GridLayout(1,4)
	JPanel jp_north = new JPanel();
	JButton jbtn_select = new JButton("��ȸ");
	JButton jbtn_insert = new JButton("�Է�");
	JButton jbtn_update = new JButton("����");
	JButton jbtn_delete = new JButton("����");
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//������
	public BoardManager() {
		
	}
	//�Խñ� ��� ��ȸ ���� �޼ҵ�
	/****************************************************************
	 * �Խñ� ��� ��ȸ ���� �޼ҵ�
	 * @param : HashMap<String,Object> �ش����
	 * @return : List<HashMap<String,Object>>
	 * �ۼ��� : �����
	 ***************************************************************/
	public List<HashMap<String,Object>> getBoardList(){
		List<HashMap<String,Object>> boardList = 
				new ArrayList<HashMap<String,Object>>();
		
		return boardList;
	}
	//�Խñ� ��� ���� �޼ҵ�
	/****************************************************************
	 * �Խñ� ���  ���� �޼ҵ�
	 * @param : HashMap<String,Object> �� �ʿ���
	 * @return : int
	 * �ۼ��� : �����
	 ***************************************************************/	
	public int boardInsert(HashMap<String,Object> pMap){
		int result=0;
		//�Ķ���Ϳ� ���� ����ִ��� �׽�Ʈ �غ���
/*		System.out.println("����:"+pMap.get("b_title"));
		System.out.println("����:"+pMap.get("b_content"));
		System.out.println("�ۼ���:"+pMap.get("b_writer"));*/
		dbMgr=DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO jdbc_board (b_no,            ");
        sql.append("        b_title,                         ");
        sql.append("        b_content,                       ");
        sql.append("        b_writer,                        ");
        sql.append("        b_date)                          ");
        sql.append("VALUES (seq_jdbc_board_no.NEXTVAL,       ");
        sql.append("        ?,                        ");
        sql.append("        ?,                           ");
        sql.append("        ?,                           ");
        sql.append("        TO_CHAR (SYSDATE, 'YYYY-MM-DD'))");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pMap.get("b_title").toString());
			pstmt.setString(2, pMap.get("b_content").toString());
			pstmt.setString(3, pMap.get("b_writer").toString());
			result = pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//����� �ڿ� �ݳ��ϱ�
			dbMgr.freeConnection(con, pstmt);
		}
		return result;
	}	
	//�Խñ� ���� ���� �޼ҵ�
	/****************************************************************
	 * �Խñ� ����  ���� �޼ҵ�
	 * @param : HashMap<String,Object> �� �ʿ��� - ������ �����ҰŴ�?
	 * @return : int
	 * �ۼ��� : �����
	 ***************************************************************/
	public int boardUpdate(HashMap<String,Object> pMap){
		int result=0;
		//�Ķ���Ϳ� ���� ����ִ��� �׽�Ʈ �غ���
		System.out.println("����:"+pMap.get("b_title"));
		System.out.println("����:"+pMap.get("b_content"));
		System.out.println("�ۼ���:"+pMap.get("b_writer"));
		result = 1;
		return result;
	}	
	//�Խñ� ���� ���� �޼ҵ�
	/****************************************************************
	 * �Խñ� ����  ���� �޼ҵ�
	 * @param : int �� PK�̾�� �� - ������ �����ҰŴ�?
	 * @return : int
	 * �ۼ��� : �����
	 ***************************************************************/	
	public int boardDelete(int b_no){
		int result=0;
		//�Ķ���Ϳ� ���� ����ִ��� �׽�Ʈ �غ���
		System.out.println("�۹�ȣ:"+b_no);
		result = 1;
		return result;
	}	
	//ȭ��ó����
	public void initDisplay() {
		jp_north.setLayout(new GridLayout(1,4));
		jp_north.add(jbtn_select);
		jp_north.add(jbtn_insert);
		jp_north.add(jbtn_update);
		jp_north.add(jbtn_delete);
		jbtn_select.addActionListener(this);
		jbtn_insert.addActionListener(this);
		jbtn_update.addActionListener(this);
		jbtn_delete.addActionListener(this);
		this.add("North", jp_north);
		this.add("Center",jsp_board);
		this.setTitle("������ �Խ���");
		this.setSize(800, 500);
		this.setVisible(true);
	}
	//main�޼ҵ�
	public static void main(String[] args) {
		BoardManager bm = new BoardManager();
		bm.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jbtn_select) {
			dbMgr=DBConnectionMgr.getInstance();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT b_no, b_title, b_writer, b_date, b_hit FROM jdbc_board");
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				List<HashMap<String,Object>> boardList = 
						new ArrayList<HashMap<String,Object>>();
				while(rs.next()) {
					HashMap<String,Object> rMap =
							new HashMap<String,Object>();
					rMap.put("b_no", rs.getInt("b_no"));
					rMap.put("b_title", rs.getString("b_title"));
					rMap.put("b_writer", rs.getString("b_writer"));
					rMap.put("b_date", rs.getString("b_date"));
					rMap.put("b_hit", rs.getInt("b_hit"));
					boardList.add(rMap);
				}
				System.out.println(boardList.size());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//////////////////////end of ��ȸ ��
		else if(obj==jbtn_insert) {
			int result = 0;
			HashMap<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("b_title","�۵�� ����");
			pMap.put("b_content","�׽�Ʈ");
			pMap.put("b_writer","�ۼ���1");
			result = boardInsert(pMap);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "��ϼ���"
						                   , "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "��Ͻ���"
		                   , "ERROR", JOptionPane.ERROR_MESSAGE);				
			}
		}//////////////////////end of �Է�
		else if(obj==jbtn_update) {
			int result = 0;
			HashMap<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("b_no",2);
			pMap.put("b_title","�۵�� ����2");
			pMap.put("b_content","�׽�Ʈ2");
			pMap.put("b_writer","�ۼ���2");
			result = boardUpdate(pMap);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "��������"
						                   , "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "��������"
		                   , "ERROR", JOptionPane.ERROR_MESSAGE);				
			}			
		}//////////////////////end of ����
		else if(obj==jbtn_delete) {
			int result = 0;
			int b_no = 2;
			result = boardDelete(b_no);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "��������"
						                   , "INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "��������"
		                   , "ERROR", JOptionPane.ERROR_MESSAGE);				
			}				
		}//////////////////////end of ����
	}//////////////////////////end of actionPerformed

}
