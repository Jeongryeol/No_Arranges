package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmpSelect extends JFrame {

	DBConnection dbcon = new DBConnection();
	Connection con = null;
	Statement stmt = null;
	
	public EmpVO[] empSel()	{
		
		EmpVO[] evos = new EmpVO[14];//객체배열을 사용하기 위해 만든 EmpVO
		int result = 0;
		String sql="";
		
		try {
	    	con = dbcon.getConnection();//연결시도
	    	stmt = con.createStatement();//Statement메소드인스턴스화
	    	System.out.println("[[query]]"+sql);//쿼리문 출력
	    	result = stmt.executeUpdate(sql);
	    	//Statement메소드에 SQL문을 넣어서 오라클에 입력시키고 그 결과값을 받고 result변수에 초기화시킨다.
			
	    	if(result==1) {
	    		System.out.println("조회성공!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"조회성공","처리결과"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("조회실패!! result = "+result);	    		
	    	}
		} catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
		}
		
		return evos;
	}
	public static void main(String args[]) {
		EmpSelect aa = new EmpSelect();
		aa.empSel();
	}
}
