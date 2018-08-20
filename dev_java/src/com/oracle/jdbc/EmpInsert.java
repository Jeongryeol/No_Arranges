package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class EmpInsert {
	
	DBConnection dbcon = new DBConnection();//전역 인스턴스 변수 선언
	Connection con = null;//Connection타입 변수 선언 및 초기화
	/*위와같이 인스턴스화 하여 다른 클래스에서 재사용가능하게 호출하면,
	 *서버 이전 등의 상황에도 모든 페이지를 수정할 필요가 없고,
	 *또한 메소드 내부의 코드도 간결해짐 */
	Statement stmt = null;
	
	/* Toad에서 1개의 로우값이 입력되었을때, 리턴값이 1이다. ( 1 row inserted )
	 * 그러므로 파라메터에는 각 컬럼에 대한 해당값의 로우를 입력하고
	 * 입력성공에 대한 반환값은 1로 리턴한다.*/
	public int empAdd(int empno, String ename, String job, int mgr
					, String hiredate, double sal, double comm, int deptno)
	{
		int result = 0;//result가 1로 초기화되면 입력성공, 0으로 그대로일때는 입력실패
		/* ★★★[유용한 단축키]-[일괄입력]★★★
		 * Shift+Alt+A 키를 이용해서 일괄입력상태로 커서를 변경(┼)
		 * 일괄입력할 구간을 드래그 후 드롭하고, 일괄입력
		 * Shift+Alt+A 재입력해서 일괄입력상태 해제 */
		String sql = ""; 
		sql+="INSERT INTO emp(empno,ename,job, mgr          		 ";
		sql+="			   ,hiredate, sal, comm, deptno)   			 ";
	    sql+=" 	   VALUES("+empno+",'"+ename+"','"+job+"',"+mgr+" 	 ";
	    sql+=" 			 ,'"+hiredate+"',"+sal+","+comm+","+deptno+")";
	    
	    try {
	    	con = dbcon.getConnection();//연결시도
	    	stmt = con.createStatement();//Statement메소드인스턴스화
	    	System.out.println("[[query]]"+sql);//쿼리문 출력
	    	result = stmt.executeUpdate(sql);
	    	//Statement메소드에 SQL문을 넣어서 오라클에 입력시키고 그 결과값을 받고 result변수에 초기화시킨다.
	    	
	    	//insert here = 입력성공 |입력실패
	    	if(result==1) {
	    		System.out.println("수정성공!! result = "+result);
	    	}
	    	else {
	    		System.out.println("수정실패!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
	    
		return result;
	}
	
	/* 컬럼명을 모두 적어서 넘기는 방법은 매우 비효율적이다. 왜? 컬럼명 50~100개 전부 써서 넘길거야? 감당돼??
	 * 그럼 어떡하지????? 메소드 오버로딩이 답이다!!!!*/
	public int empAdd(EmpVO evo)//VO관련책이 궁금하다면 자바디자인패턴 책 구매 추천!!
		//ORM솔루션 : Object Relation Management Solution
	{
		int result = 0;//result가 1로 초기화되면 입력성공, 0으로 그대로일때는 입력실패
		/* ★★★[유용한 단축키]-[일괄입력]★★★
		 * Shift+Alt+A 키를 이용해서 일괄입력상태로 커서를 변경(┼)
		 * 일괄입력할 구간을 드래그 후 드롭하고, 일괄입력
		 * Shift+Alt+A 재입력해서 일괄입력상태 해제 */
/*		String sql = ""; 
		sql+="INSERT INTO emp(empno,ename,job, mgr          		 ";
		sql+="			   ,hiredate, sal, comm, deptno)   			 ";
		sql+=" 	   VALUES("+evo.getEmpno()+",'"+evo.getEname()+"','"+evo.getJob()+"',"+evo.getMgr()+" 	 ";
		sql+=" 			 ,'"+evo.getHiredate()+"',"+evo.getSal()+","+evo.getComm()+","+evo.getDeptno()+")";*/
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)");
		sql.append(" VALUE("+evo.getEname()+", '"+evo.getEname()+"', '"+evo.getMgr()+"', "+evo.getHiredate());
		sql.append(", "+evo.getSal()+", "+evo.getComm()+", "+evo.getDeptno()+")");
		
		try {
			con = dbcon.getConnection();//연결시도
			stmt = con.createStatement();//Statement메소드인스턴스화
			System.out.println("[[query]]"+sql);//쿼리문 출력
			result = stmt.executeUpdate(sql.toString());
			//Statement메소드에 SQL문을 넣어서 오라클에 입력시키고 그 결과값을 받고 result변수에 초기화시킨다.
			
			//insert here = 입력성공 |입력실패
			if(result==1) {
				System.out.println("수정성공!! result = "+result);
			}
			else {
				System.out.println("수정실패!! result = "+result);	    		
			}
		} catch(Exception e) {
			//TODO : handle exception
			System.out.println(e.toString());
		}
		
		return result;
	}

}
