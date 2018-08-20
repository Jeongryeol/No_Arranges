package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class EmpInsert {
	
	DBConnection dbcon = new DBConnection();//���� �ν��Ͻ� ���� ����
	Connection con = null;//ConnectionŸ�� ���� ���� �� �ʱ�ȭ
	/*���Ͱ��� �ν��Ͻ�ȭ �Ͽ� �ٸ� Ŭ�������� ���밡���ϰ� ȣ���ϸ�,
	 *���� ���� ���� ��Ȳ���� ��� �������� ������ �ʿ䰡 ����,
	 *���� �޼ҵ� ������ �ڵ嵵 �������� */
	Statement stmt = null;
	
	/* Toad���� 1���� �ο찪�� �ԷµǾ�����, ���ϰ��� 1�̴�. ( 1 row inserted )
	 * �׷��Ƿ� �Ķ���Ϳ��� �� �÷��� ���� �ش簪�� �ο츦 �Է��ϰ�
	 * �Է¼����� ���� ��ȯ���� 1�� �����Ѵ�.*/
	public int empAdd(int empno, String ename, String job, int mgr
					, String hiredate, double sal, double comm, int deptno)
	{
		int result = 0;//result�� 1�� �ʱ�ȭ�Ǹ� �Է¼���, 0���� �״���϶��� �Է½���
		/* �ڡڡ�[������ ����Ű]-[�ϰ��Է�]�ڡڡ�
		 * Shift+Alt+A Ű�� �̿��ؼ� �ϰ��Է»��·� Ŀ���� ����(��)
		 * �ϰ��Է��� ������ �巡�� �� ����ϰ�, �ϰ��Է�
		 * Shift+Alt+A ���Է��ؼ� �ϰ��Է»��� ���� */
		String sql = ""; 
		sql+="INSERT INTO emp(empno,ename,job, mgr          		 ";
		sql+="			   ,hiredate, sal, comm, deptno)   			 ";
	    sql+=" 	   VALUES("+empno+",'"+ename+"','"+job+"',"+mgr+" 	 ";
	    sql+=" 			 ,'"+hiredate+"',"+sal+","+comm+","+deptno+")";
	    
	    try {
	    	con = dbcon.getConnection();//����õ�
	    	stmt = con.createStatement();//Statement�޼ҵ��ν��Ͻ�ȭ
	    	System.out.println("[[query]]"+sql);//������ ���
	    	result = stmt.executeUpdate(sql);
	    	//Statement�޼ҵ忡 SQL���� �־ ����Ŭ�� �Է½�Ű�� �� ������� �ް� result������ �ʱ�ȭ��Ų��.
	    	
	    	//insert here = �Է¼��� |�Է½���
	    	if(result==1) {
	    		System.out.println("��������!! result = "+result);
	    	}
	    	else {
	    		System.out.println("��������!! result = "+result);	    		
	    	}
	    } catch(Exception e) {
	    	//TODO : handle exception
	    	System.out.println(e.toString());
	    }
	    
		return result;
	}
	
	/* �÷����� ��� ��� �ѱ�� ����� �ſ� ��ȿ�����̴�. ��? �÷��� 50~100�� ���� �Ἥ �ѱ�ž�? �����??
	 * �׷� �����????? �޼ҵ� �����ε��� ���̴�!!!!*/
	public int empAdd(EmpVO evo)//VO����å�� �ñ��ϴٸ� �ڹٵ��������� å ���� ��õ!!
		//ORM�ַ�� : Object Relation Management Solution
	{
		int result = 0;//result�� 1�� �ʱ�ȭ�Ǹ� �Է¼���, 0���� �״���϶��� �Է½���
		/* �ڡڡ�[������ ����Ű]-[�ϰ��Է�]�ڡڡ�
		 * Shift+Alt+A Ű�� �̿��ؼ� �ϰ��Է»��·� Ŀ���� ����(��)
		 * �ϰ��Է��� ������ �巡�� �� ����ϰ�, �ϰ��Է�
		 * Shift+Alt+A ���Է��ؼ� �ϰ��Է»��� ���� */
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
			con = dbcon.getConnection();//����õ�
			stmt = con.createStatement();//Statement�޼ҵ��ν��Ͻ�ȭ
			System.out.println("[[query]]"+sql);//������ ���
			result = stmt.executeUpdate(sql.toString());
			//Statement�޼ҵ忡 SQL���� �־ ����Ŭ�� �Է½�Ű�� �� ������� �ް� result������ �ʱ�ȭ��Ų��.
			
			//insert here = �Է¼��� |�Է½���
			if(result==1) {
				System.out.println("��������!! result = "+result);
			}
			else {
				System.out.println("��������!! result = "+result);	    		
			}
		} catch(Exception e) {
			//TODO : handle exception
			System.out.println(e.toString());
		}
		
		return result;
	}

}
