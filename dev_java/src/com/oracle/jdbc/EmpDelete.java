package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmpDelete extends JFrame {//JOptionPane을 위해 상속시킴

	DBConnection dbcon = new DBConnection();
	Connection con = null;
	Statement stmt = null;
					//삭제할때는 파라미터로 PK가 오면 되겠지??
					//PK는 유니크하다 + 인덱스를  가지고 있다 (검색속도 UP) + NOT NULL  
	public int empDel(int empno)
	{
		int result = 0;
		
/*		String sql ="";
		sql+="DELETE FROM emp    ";
		sql+=" WHERE empno="+empno;*/
	    
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM emp WEHERE empno = "+empno);
		
	    try {
	    	/* 자바에서는 기본적으로 AutoCommit모드가 잡혀있다.
	    	 * 즉, 자바에서 오라클 실행시 자동 commit됨
	    	 * 만일 AutoCommit모드를 끄고 싶으면 아래 참고
	    	 * [Oracle] commit;  ↔ [JAVA.SQL] con.commit();
	    	 * [Oracle] rollback;  ↔ [JAVA.SQL] con.rollback(); */
	    	//con.setAutoCommit(false);
	    	
	    	con = dbcon.getConnection();//연결시도
	    	stmt = con.createStatement();//Statement메소드인스턴스화
	    	System.out.println("[[query]]"+sql);//쿼리문 출력
	    	result = stmt.executeUpdate(sql.toString());
	    	//Statement메소드에 SQL문을 넣어서 오라클에 입력시키고 그 결과값을 받고 result변수에 초기화시킨다. 
	    	
	    	//insert here = 입력성공 |입력실패
	    	if(result==1) {
	    		System.out.println("삭제성공!! result = "+result);
	    		JOptionPane.showMessageDialog(this,"삭제성공","처리결과"
	    									 ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else {
	    		System.out.println("삭제실패!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
		return result;
	}
	
}
