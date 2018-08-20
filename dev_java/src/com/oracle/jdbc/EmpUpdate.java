package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class EmpUpdate extends JFrame {//JOptionPane을 위해 상속시킴

	DBConnection dbcon = new DBConnection();
	Connection con = null;
	Statement stmt = null;
	
	public int empUpd(int empno, String ename, String job, String hiredate)
	{
		int result = 0;//처리결과 반환값 저장할 변수선언 ( 1:수정성공 / 0: 수정실패 )
		/* ★★★[유용한 단축키]-[일괄입력]★★★
		 * Shift+Alt+A 키를 이용해서 일괄입력상태로 커서를 변경(┼)
		 * 일괄입력할 구간을 드래그 후 드롭하고, 일괄입력
		 * Shift+Alt+A 재입력해서 일괄입력상태 해제 */
		String sql = ""; 
		sql+="UPDATE emp                       ";
		sql+="   SET ename    = '"+ename+"'    ";
		sql+="      ,job      = '"+job+"'      ";
		sql+="      ,hiredate = '"+hiredate+"' ";
		sql+=" WHERE empno="+empno+"           ";
	    
	    try {
	    	//con.setAutoCommit(false);
	    	con = dbcon.getConnection();//연결시도
	    	stmt = con.createStatement();//Statement메소드인스턴스화
	    	System.out.println("[[query]]"+sql);//쿼리문 출력
	    	result = stmt.executeUpdate(sql);
	    	//Statement메소드에 SQL문을 넣어서 오라클에 입력시키고 그 결과값을 받고 result변수에 초기화시킨다. 
	    	
	    	//insert here = 입력성공 |입력실패
	    	if(result==1) {
	    		System.out.println("입력성공!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"수정성공","처리결과"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("입력실패!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
	    return result;
	}

	public int empUpd(EmpVO evo) {
		int result = 0;
		
	/*	String sql = ""; 
		sql+="UPDATE emp                       ";
		sql+="   SET ename    = '"+ename+"'    ";
		sql+="      ,job      = '"+job+"'      ";
		sql+="      ,hiredate = '"+hiredate+"' ";
		sql+=" WHERE empno="+empno+"           ";*/
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE emp SET ename = "+evo.getEname()+", job = "+evo.getJob()
				+", hiredate = "+evo.getHiredate()+" WHERE empno = "+evo.getEmpno());
	    
	    try {
	    	//con.setAutoCommit(false);
	    	con = dbcon.getConnection();//연결시도
	    	stmt = con.createStatement();//Statement메소드인스턴스화
	    	System.out.println("[[query]]"+sql);//쿼리문 출력
	    	result = stmt.executeUpdate(sql.toString());
	    	//Statement메소드에 SQL문을 넣어서 오라클에 입력시키고 그 결과값을 받고 result변수에 초기화시킨다. 
	    	
	    	//insert here = 입력성공 |입력실패
	    	if(result==1) {
	    		System.out.println("입력성공!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"수정성공","처리결과"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("입력실패!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
	    
		return result;
	}

}
