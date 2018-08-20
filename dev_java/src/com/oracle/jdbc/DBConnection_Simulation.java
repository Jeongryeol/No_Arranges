package com.oracle.jdbc;

import java.sql.Connection;

public class DBConnection_Simulation {//�ڵ��۵��� �׽�Ʈ������ ����� Ŭ����
	
	public static void main(String[] args) {
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getConnection();
		System.out.println("con : "+con);


		/* [ Toad���� ���� INSERT SQL���� ]
		 * INSERT INTO emp(empno,ename,job, mgr, hiredate, sal, comm, deptno)
		 * VALUES(9000,'�̼���','SALESMAN',7566,'2018-04-21',3300,0,50);*/
/* INSERT JAVA.SQL �ڵ�		
		EmpInsert empIns = new EmpInsert();
		empIns.empAdd(9000,"�̼���","SALESMAN",7566,"2018-04-21",3300,0,40);
		//�ش� �÷��� FK�� ��쿡, PK�� �ִ� ���� �ƴϸ� �Է��� �ȵ� (�θ�Ű�� �����ϴ�.�����߻�)
 */
		
		
		/* [ Toad���� ���� UPDATE SQL���� ]
		 * UPDATE emp
		 *    SET ename    = '������'
		 *       ,job      = 'CLERK'
		 *       ,hiredate = '2018-05-03'
		 *  WHERE empno=9000 */
/* UPDATE JAVA.SQL �ڵ�
		EmpUpdate empUpd = new EmpUpdate();
		empUpd.empUpd(9000, "������", "CLERK", "2018-05-03");
 */

		
		/* [ Toad���� ���� DELETE SQL���� ]
		 * DELETE FROM emp
		 *  WHERE empno=9000
		 */
/* DELETE JAVA.SQL �ڵ�		
		EmpDelete empDel = new EmpDelete();
		empDel.empDel(9000);		
 */		
		
	}

}
