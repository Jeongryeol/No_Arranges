package com.semi.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.oracle.jdbc.DBConnection;

//DB연동 하기만 전담하는 클래스 설계
public class AddressBookDAO {
	Connection 			con 	= null;
	//Statement는 정적쿼리 처리할 때
	PreparedStatement 	pstmt 	= null;//동적쿼리를 처리할 때
	ResultSet  			rs		= null;
	DBConnection        dbCon	= new DBConnection();
	//주소록 추가
	/****************************************************************
	 * INSERT INTO addrtb(ano, a_id, a_pw,a_name, a_hp)
                   VALUES(8,'test','123','이순신','010-5553-8899')
	 ***************************************************************/
	public int addrInsert(AddressVO pavo) {
		System.out.println("addrInsert 호출 성공");
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
			System.out.println("result:"+result);//1이면 등록 성공, 0이면 등록실패
		} catch (Exception e) {
			//이 문장을 쓰는 그 아이...
			System.out.println("[[query]]"+sql.toString());//힌트
			JOptionPane.showMessageDialog(AddressBookUI.aBook.jf_addr, e.toString()
					                   , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
	//주소록 수정
	public int addrUpdate(AddressVO pavo) {
		System.out.println("addrUpdate 호출 성공");
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
			System.out.println("result:"+result);//1이면 등록 성공, 0이면 등록실패
		} catch (Exception e) {
			//이 문장을 쓰는 그 아이...
			System.out.println("[[query]]"+sql.toString());//힌트
			JOptionPane.showMessageDialog(AddressBookUI.aBook.jf_addr, e.toString()
					                   , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
        return result;
	}	
	//주소록 삭제
	public int addrDelete(int anos[]) {//여러개의 로우를 한번에 지우기
		System.out.println("addrDelete 호출 성공");
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
			System.out.println("result:"+result);//1이면 등록 성공, 0이면 등록실패
		} catch (Exception e) {
			//이 문장을 쓰는 그 아이...
			System.out.println("[[query]]"+sql.toString());//힌트
			JOptionPane.showMessageDialog(AddressBookUI.aBook.jf_addr, e.toString()
					, "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
		
		return result;
	}	
	//주소록 조회
	public AddressVO[] getAddressList(AddressVO pavo) {
		AddressVO[] ravos = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ano, a_name, DECODE(gender,1,'남자','여자') gender");
		sql.append(", a_id, a_pw, a_bigo FROM addrtb                      ");
		if(pavo.getAno()>0) {
			sql.append(" WHERE ano = ?");
		}//부분검색기능 선택IF문 추가
		AddressVO ravo = null;
		Vector v = new Vector();//배열과 달리 늘었다 줄었다 해요.
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(pavo.getAno()>0) {
				pstmt.setInt(1, pavo.getAno());
			}//부분검색기능 구현
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
			v.copyInto(ravos);//복제완료:Vector에 있는 주소번지를 AddressVO[]복제
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ravos;
	}
}






