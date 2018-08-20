package com.google.googleMap_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/* 
 * ���������� ������ DataBase�� �����Ͽ�
 * ���ϴ� ���������� ��ȸ�ؿ��� Data Access Object class
 * 
 * ��ȸ�� ������ Google Map API�� marker�� ǥ���� ������ ���ȴ�.
 */
public class DAO_Food {
	
	/*�����*/
	//static�� �ٿ��� ������ �ٷ� �ν��Ͻ�ȭ ��
		//Calendar cal = Calendar.getInstance(); �̷������� �ν��Ͻ�ȭ�� �����ϴ�!!
	parkDBConnectionMgr	dbMgr = parkDBConnectionMgr.getInstance();
	Connection			con	  = null;
	PreparedStatement	pstmt = null;
	ResultSet			rs 	  = null;//Ŀ���� ��Ʈ������ ::��ü����ó��/�κй���ó��/�ӵ��� ���� ����
		//web.xml Ȯ��/
	Logger logger = Logger.getLogger(DAO_Food.class);
	
	/*��ȸó��*/
	//�������� ��ȸó��
	public List<VO_FS_Menu> getFoodInfoList(VO_FS_Menu fsmvo) {
		/**********************************************
		 * ����� ��� �޼ҵ��� ��ȯ������ �� ����Ʈ ����
		 * EmpVO Ŭ������ �ѹ��� 1���� �ο�ۿ� ����� ������,
		 * EmpVO Ŭ������ ���� �� ����ִ� ArrayList�� �ʿ�������.
		 * �� ��, �������� �����Ͽ� �ڵ��� ���뼺�� �����ش�.
		 **********************************************/
		List<VO_FS_Menu> foodInfoList = null;
		foodInfoList = new ArrayList<VO_FS_Menu>();
		
		/**********************************************
		 * SQL���� �ۼ��Ҷ���
		 * 		StringBuilder(�񵿱�ȭ/�ܵ�/���)��
		 * 		StringBuffer(����ȭ/����/����)�� ����Ѵ�.
		 * SQL���� �ݵ�� Toad���� �׽�Ʈ�� ��ģ �Ŀ� ����Ѵ�.
		 **********************************************/
		StringBuilder sql = new StringBuilder();
	//	sql.append("");
		sql.append("SELECT fs.fs_code, fs.fs_name, fs.fs_latitude, fs.fs_longitude");
		sql.append("      ,fs.fs_size, fs.fs_opentime, fs.fs_closetime");
		sql.append("      ,fs.fs_good, fs.fs_bad, fs.fs_picture, fs.fs_juso");
		sql.append("      ,fsm.fsm_name, fsm.fsm_price");
		sql.append("  FROM FOOD_STORE fs, FS_menu fsm");
		sql.append(" WHERE fs.fsm_code = fsm.fsm_code");

		/* ********************************************************************
		  	�ڽİ��迡 �ִ� ���̺��� ������ �θ����̺�VOŬ�������� �ٷ�� �ϰ��� ��
		  		�θ����̺��� VOŬ�����κ���
		  		�ڽ����̺��� VOŬ������ ���� �� ����,�б� ����
		  
	  		[���� ���̺���� �޴����̺��� �θ�(PK����)�̰� ��������̺��� �ڳ�(FK����)]
	  
		  		ALTER TABLE KING.FS_MENU ADD (
				  CONSTRAINT XPKFS_MENU
				  PRIMARY KEY
				  (FSM_CODE)
				  USING INDEX KING.XPKFS_MENU
				  ENABLE VALIDATE);
				
				ALTER TABLE KING.FS_MENU ADD (
				  CONSTRAINT FOOD_STORE_FK 
				  FOREIGN KEY (FS_CODE) 
				  REFERENCES KING.FOOD_STORE (FS_CODE)
				  ENABLE VALIDATE);
		  
		   	[�ؽ����� ��� Ű�� ������ ���� �ذ��� �� ����]
		 **********************************************************************/
		//DB������ ����Ŭ ������ �����ϴ� ���̹Ƿ� ����ó�� �ʼ���.
		try {
			con = dbMgr.getConnection();
				//���������κ��� ������ �غ��Ҷ� SQL���� ����
			System.out.println("[[��û�� ����������]] "+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
				//���� ������ ������ ����� ���� Ŀ�� ������
			rs = pstmt.executeQuery();

			//�׽�Ʈ�� �α�
		//	logger.info(sql);
		//	logger.info("rs.next() : "+rs.next());
		//	logger.info("rs.isFirst() : "+rs.isFirst());
			
			VO_FS_Menu menuVO = null;//VOŬ����
			VO_FoodStore storeVO = null;//VOŬ����
			
		//	System.out.println(rs.isFirst());//Ŀ���� ���� �տ� �ִ�?
		//	System.out.println(rs.isLast()); //Ŀ���� ���� �ڿ� �ִ�?
		//	while(rs.previous()) {	//Ŀ���� ���� �ڿ� �ִٸ� �ڷ� ���ư��� �ݺ��� ����
		//	while(rs.absolute(3) {	//Ŀ���� Ư����ġ�� �Űܰ��� ���ش�. 
			while(rs.next()) {//Ŀ���� ���� ���̶�� �������� �޷����� �ݺ��� ����
			/*��ȸ�� row �ϳ��� ���� ���ο� VO �ν��Ͻ��� �����ϱ�*/
				//�ڽ� : ��������̺� VO
				storeVO = new VO_FoodStore();
				//��ȸ�� ����� �� �÷��� �ش��ϴ� �ο찪�� VOŬ������ ����(set)�ϱ�
				storeVO.setFs_code(rs.getInt("fs_code"));
				storeVO.setFs_name(rs.getString("fs_name"));
				storeVO.setFs_latitude(rs.getString("fs_latitude"));
				storeVO.setFs_longitude(rs.getString("fs_longitude"));
				storeVO.setFs_size(rs.getString("fs_size"));
				storeVO.setFs_opentime(rs.getString("fs_opentime"));
				storeVO.setFs_closetime(rs.getString("fs_closetime"));
				storeVO.setFs_good(rs.getInt("fs_good"));
				storeVO.setFs_bad(rs.getInt("fs_bad"));
				storeVO.setFs_picture(rs.getString("fs_picture"));
				storeVO.setFs_juso(rs.getString("fs_juso"));
				
				//�θ� : �޴����̺� VO
				menuVO = new VO_FS_Menu();
				//�θ����̺�VO�� �ڽ����̺�VO���
				menuVO.setFsvo(storeVO);
				//��ȸ�� ����� �� �÷��� �ش��ϴ� �ο찪�� VOŬ������ ����(set)�ϱ�
				menuVO.setFsm_name(rs.getString("fsm_name"));
				menuVO.setFsm_price(rs.getString("fsm_price"));
				
				//����� EmpVOŬ������ List�� ���
				foodInfoList.add(menuVO);
				
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
		
		return foodInfoList;
	}
}
