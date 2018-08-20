package com.oracle.jdbc;

import java.sql.Connection;

public class DBConnection_Simulation {//코드작동을 테스트용으로 사용할 클래스
	
	public static void main(String[] args) {
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getConnection();
		System.out.println("con : "+con);


		/* [ Toad에서 쓰는 INSERT SQL구문 ]
		 * INSERT INTO emp(empno,ename,job, mgr, hiredate, sal, comm, deptno)
		 * VALUES(9000,'이순신','SALESMAN',7566,'2018-04-21',3300,0,50);*/
/* INSERT JAVA.SQL 코드		
		EmpInsert empIns = new EmpInsert();
		empIns.empAdd(9000,"이순신","SALESMAN",7566,"2018-04-21",3300,0,40);
		//해당 컬럼이 FK인 경우에, PK에 있는 값이 아니면 입력이 안됨 (부모키가 없습니다.에러발생)
 */
		
		
		/* [ Toad에서 쓰는 UPDATE SQL구문 ]
		 * UPDATE emp
		 *    SET ename    = '김유신'
		 *       ,job      = 'CLERK'
		 *       ,hiredate = '2018-05-03'
		 *  WHERE empno=9000 */
/* UPDATE JAVA.SQL 코드
		EmpUpdate empUpd = new EmpUpdate();
		empUpd.empUpd(9000, "김유신", "CLERK", "2018-05-03");
 */

		
		/* [ Toad에서 쓰는 DELETE SQL구문 ]
		 * DELETE FROM emp
		 *  WHERE empno=9000
		 */
/* DELETE JAVA.SQL 코드		
		EmpDelete empDel = new EmpDelete();
		empDel.empDel(9000);		
 */		
		
	}

}
