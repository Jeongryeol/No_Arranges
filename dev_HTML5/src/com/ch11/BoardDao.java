package com.ch11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

//DAO : Data Access Object (DB������ �����ϴ� Ŭ������ ������)
//������������ : ���뼺�� ���̱� ���� Ŭ��������
//������ �������̿��� ���谡 �ְ�, �� ���迡 ���������� ���� ���·� Ŭ�������踦 �ؾ�
//�����ִ� �������̿��� �޼ҵ带 ������ �� �ִ�.
//--->���յ��� ���� �ڵ带 �����ϴ� ���� ����.
//--->���յ��� ���ƾ� �����׽�Ʈ�� �����ϰ� �����׽�Ʈ�� ����������.
//������Ʈ �������
//�м� ���� --> ����(�ڵ�) ---> �׽�Ʈ ---> �ý��� ���� ---> ��

public class BoardDao {//JDBC���� Ŭ����
	/*�����*/
	DBConnectionMgr		dbMgr = DBConnectionMgr.getInstance();
	Connection			con	  = null;
	PreparedStatement	pstmt = null;
	ResultSet			rs 	  = null;//Ŀ���� ��Ʈ������ ::��ü����ó��/�κй���ó��/�ӵ��� ���� ����
	
	/*��ȸó��*/
	//�����ȣ ��ȸó�� [ �޼ҵ��̸� : getEmpList(??):?? ]
	public List<Map<String,Object>> getBoardList(Map<String,Object> pMap) {
		List<Map<String,Object>> boardList = new ArrayList<Map<String,Object>>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b_no, b_title, b_content, b_writer, b_date, b_hit FROM JDBC_BOARD");
		try {
			con = dbMgr.getConnection();
			System.out.println("[[��û�� ����������]] "+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String,Object> rMap = null;
			while(rs.next()) {//Ŀ���� ���� ���̶�� �������� �޷����� �ݺ��� ����
				rMap = new HashMap<String,Object>();
				rMap.put("B_NO",rs.getInt("b_no"));
				rMap.put("B_TITLE",rs.getString("b_title"));
				rMap.put("B_CONTENT",rs.getString("b_content"));
				rMap.put("B_WRITER",rs.getString("b_writer"));
				rMap.put("B_DATE",rs.getString("b_date"));
				rMap.put("B_HIT",rs.getInt("b_hit"));
				//����� Map<String,Object>Ŭ������ List�� ���
				boardList.add(rMap);
			}//�ݺ��ϱ�
			
		} catch (SQLException se) {
			System.out.println("SQL��û �� �����߻�!");
			System.out.println("[[query]] "+sql.toString());
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
}
