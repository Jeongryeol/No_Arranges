package com.autoPerfection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.autoPerfection.JL_DBConnectionMgr;

/* 
 * ���������� ������ DataBase�� �����Ͽ�
 * ���ϴ� ���������� ��ȸ�ؿ��� Data Access Object class
 * 
 * ��ȸ�� ������ �ڵ��ϼ��� �����Ϳ� ǥ���� ������ ���ȴ�.
 */
public class DAO_Book {
	
	/*�����*/
	//static�� �ٿ��� ������ �ٷ� �ν��Ͻ�ȭ ��
		//Calendar cal = Calendar.getInstance(); �̷������� �ν��Ͻ�ȭ�� �����ϴ�!!
	JL_DBConnectionMgr	dbMgr = JL_DBConnectionMgr.getInstance();
	Connection			con	  = null;
	PreparedStatement	pstmt = null;
	ResultSet			rs 	  = null;//Ŀ���� ��Ʈ������ ::��ü����ó��/�κй���ó��/�ӵ��� ���� ����
		//web.xml Ȯ��/
	Logger logger = Logger.getLogger(DAO_Book.class);
	
	/*��ȸó��*/
	//�������� ��ȸó��
	public List<VO_BookList> getBookInfoList(VO_BookList bsmvo) {
		List<VO_BookList> bookInfoList = null;
		bookInfoList = new ArrayList<VO_BookList>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT b_code,b_name,b_price,b_picture FROM v_booklist");
		sql.append(" WHERE b_name='?'");

		//DB������ ����Ŭ ������ �����ϴ� ���̹Ƿ� ����ó�� �ʼ���.
		try {
			con = dbMgr.getConnection();
				//���������κ��� ������ �غ��Ҷ� SQL���� ����
			System.out.println("[[��û�� ����������]] "+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
				//���� ������ ������ ����� ���� Ŀ�� ������
			pstmt.setString(1, bsmvo.toString());
			rs = pstmt.executeQuery();

			if(rs==null) return bookInfoList;
			
			//�׽�Ʈ�� �α�
		//	logger.info(sql);
		//	logger.info("rs.next() : "+rs.next());
		//	logger.info("rs.isFirst() : "+rs.isFirst());
		//	System.out.println(rs.isFirst());//Ŀ���� ���� �տ� �ִ�?
		//	System.out.println(rs.isLast()); //Ŀ���� ���� �ڿ� �ִ�?
		//	while(rs.previous()) {	//Ŀ���� ���� �ڿ� �ִٸ� �ڷ� ���ư��� �ݺ��� ����
		//	while(rs.absolute(3) {	//Ŀ���� Ư����ġ�� �Űܰ��� ���ش�. 
			
			VO_BookList booklistVO = null;//VOŬ����
			while(rs.next()) {//Ŀ���� ���� ���̶�� �������� �޷����� �ݺ��� ����
			/*��ȸ�� row �ϳ��� ���� ���ο� VO �ν��Ͻ��� �����ϱ�*/
				booklistVO = new VO_BookList();
				//��ȸ�� ����� �� �÷��� �ش��ϴ� �ο찪�� VOŬ������ ����(set)�ϱ�
				booklistVO.setB_code(rs.getInt("b_code"));
				booklistVO.setB_name(rs.getString("b_name"));
				booklistVO.setB_price(rs.getString("b_price"));
				booklistVO.setB_picture(rs.getString("b_picture"));
				//����� VOŬ������ List�� ���
				bookInfoList.add(booklistVO);
			}//Ŀ���� ���� �����̹Ƿ� Ŀ���� ���������� ���������� �ݺ�������
			
		} catch (SQLException se) {//SQL����
			System.out.println("SQL��û �� �����߻�!");
			System.out.println("[[query]] "+sql.toString());
			se.printStackTrace();
			/* *********************************************************
			 * SQLException ������ �߻��ߴٸ� ���� �� �ش�Ǵ� ������ �ִ��� üũ�ϼ���.
			 * 	1. SQL���� ������ ���°�? - Toad���� ����üũ
			 * 	2. ��ȸ�� �÷��� Ÿ�԰� �޾Ƽ� �ִ� �ؽ����� Ÿ���� ��ġ�ϴ°�?
			 * 		( ex. int-date,String-varchar2 )
			 ***********************************************************/
			
		} catch (Exception e) {//��Ÿ����
			e.printStackTrace();
		}
		
		return bookInfoList;
	}
}
