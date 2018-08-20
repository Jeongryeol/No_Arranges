package com.semi.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.oracle.jdbc.DBConnection;

//DB���� �ϱ⸸ �����ϴ� Ŭ���� ����
public class AddressBookDAO {
	Connection 			con 	= null;
	//Statement�� �������� ó���� ��
	PreparedStatement 	pstmt 	= null;//���������� ó���� ��
	ResultSet  			rs		= null;
	DBConnection        dbCon	= new DBConnection();
	//�ּҷ� �߰�
	/****************************************************************
	 * INSERT INTO addrtb(ano, a_id, a_pw,a_name, a_hp)
                   VALUES(8,'test','123','�̼���','010-5553-8899')
	 ***************************************************************/
	public int addrInsert(AddressVO pavo) {
		System.out.println("addrInsert ȣ�� ����");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO addrtb(ano, a_id, a_pw,a_name, gender,a_bigo)");
        sql.append(" VALUES(seq_addrtb_ano.nextval,?,?,?,?,?)");
        try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i=0;
			pstmt.setString(++i, pavo.getA_id());
			pstmt.setString(++i, pavo.getA_pw());
			pstmt.setString(++i, pavo.getA_name());
			pstmt.setString(++i, pavo.getGender());
			pstmt.setString(++i, pavo.getA_bigo());
			result = pstmt.executeUpdate();
			System.out.println("result:"+result);//1�̸� ��� ����, 0�̸� ��Ͻ���
		} catch (Exception e) {
			//�� ������ ���� �� ����...
			System.out.println("[[query]]"+sql.toString());//��Ʈ
			JOptionPane.showMessageDialog(AddressBookUI.aBook.jf_addr, e.toString()
					                   , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	//�ּҷ� ����
	public int addrUpdate(AddressVO pavo) {
		System.out.println("addrUpdate ȣ�� ����");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE addrtb       ");
		sql.append("   SET a_id = ?");
		sql.append("      ,a_pw = ? ");
		sql.append("      ,gender = ? ");
		sql.append("      ,bigo = ?  ");
		sql.append(" WHERE ano = ?;    ");
        try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i=0;
			pstmt.setString(++i, pavo.getA_id());
			pstmt.setString(++i, pavo.getA_pw());
			pstmt.setString(++i, pavo.getGender());
			pstmt.setString(++i, pavo.getA_bigo());
			pstmt.setInt(++i, pavo.getAno());
			result = pstmt.executeUpdate();
			System.out.println("result:"+result);//1�̸� ��� ����, 0�̸� ��Ͻ���
		} catch (Exception e) {
			//�� ������ ���� �� ����...
			System.out.println("[[query]]"+sql.toString());//��Ʈ
			JOptionPane.showMessageDialog(AddressBookUI.aBook.jf_addr, e.toString()
					                   , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
        return result;
	}	
	//�ּҷ� ����
	public int addrDelete(int anos[]) {//�������� �ο츦 �ѹ��� �����
		System.out.println("addrDelete ȣ�� ����");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM addrtb WHERE ano IN(");
		try {
			con = dbCon.getConnection();
			for(int i=0;i<anos.length;i++) {
				sql.append(anos[i]);
				if(i==anos.length-1) {
					sql.append(")");					
					break;
				}
				sql.append(",");
			}
			pstmt = con.prepareStatement(sql.toString());
			System.out.println("sql : "+sql);
			result = pstmt.executeUpdate();
			System.out.println("result:"+result);//1�̸� ��� ����, 0�̸� ��Ͻ���
		} catch (Exception e) {
			//�� ������ ���� �� ����...
			System.out.println("[[query]]"+sql.toString());//��Ʈ
			JOptionPane.showMessageDialog(AddressBookUI.aBook.jf_addr, e.toString()
					, "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
		
		return result;
	}	
	//�ּҷ� ��ȸ
	public AddressVO[] getAddressList(AddressVO pavo) {
		AddressVO[] ravos = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ano, a_name, DECODE(gender,1,'����','����') gender");
		sql.append(", a_id, a_pw, a_bigo FROM addrtb                      ");
		if(pavo.getAno()>0) {
			sql.append(" WHERE ano = ?");
		}//�κа˻���� ����IF�� �߰�
		AddressVO ravo = null;
		Vector v = new Vector();//�迭�� �޸� �þ��� �پ��� �ؿ�.
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(pavo.getAno()>0) {
				pstmt.setInt(1, pavo.getAno());
			}//�κа˻���� ����
			rs = pstmt.executeQuery();
			//while(rs.absolute(2)) {
			//while(rs.previous()) {
			while(rs.next()) {
				ravo = new AddressVO();
				ravo.setAno(rs.getInt("ano"));
				ravo.setA_name(rs.getString("a_name"));
				ravo.setGender(rs.getString("gender"));
				ravo.setA_id(rs.getString("a_id"));
				ravo.setA_pw(rs.getString("a_pw"));
				ravo.setA_bigo(rs.getString("a_bigo"));
				v.add(ravo);
			}
			ravos = new AddressVO[v.size()];
			v.copyInto(ravos);//�����Ϸ�:Vector�� �ִ� �ּҹ����� AddressVO[]����
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ravos;
	}
}






