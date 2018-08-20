package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//�ڹٸ� �̿��ؼ� ���������� ������ ����Ŭ������ �����Ͽ� EMP ������ ������ �о��
public class EmpManager {

/*	public int empInsert(EmpVO evo) {
*/	public int empInsert() {
		int result = 0;//��������
		//����ڷκ��� ���� �Է¹޾Ƽ� ó���غ�����. - Commandâ�� �̿��ؼ� �غ�����...
		int		empno	= 0;
		String	ename	= null;
		String	job		= null;
		String	hiredate= null;
		double	sal		= 0.0;
		double	comm	= 0.0;
		int 	deptno	= 0;
		int 	mgr		= 0;
		
		EmpVO evo = new EmpVO();
		System.out.println("[�����ȣ-empno]�� �Է��ϼ���. <int>");
		Scanner sc_empno = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try {
			empno = Integer.parseInt(sc_empno.nextLine());//null�̳� �ѱ��� �� ���� ����. NumberFormatException ���� �� ����
			evo.setEmpno(empno);
		}catch (NumberFormatException nfe) {
			System.out.println("����Ÿ���� �ƴմϴ�.");
			nfe.printStackTrace();
		}
		
		System.out.println("[�����-ename]�� �Է��ϼ���. <String>");
		Scanner sc_ename = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			ename = sc_ename.toString();
			evo.setEname(ename);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[��å-job]�� �Է��ϼ���. <String>");
		Scanner sc_job = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try {
			job	 = sc_job.toString();
			evo.setJob(job);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[�������-hiredate]�� �Է��ϼ���. <String>");
		Scanner sc_hiredate = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			hiredate= sc_hiredate.toString();
			evo.setHiredate(hiredate);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[����-sal]�� �Է��ϼ���. <double>");
		Scanner sc_sal = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			sal	 = Double.parseDouble(sc_sal.nextLine());
			evo.setSal(sal);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		System.out.println("[���ʽ�-comm]�� �Է��ϼ���. <double>");
		Scanner sc_comm = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			comm = Double.parseDouble(sc_comm.nextLine());
			evo.setComm(comm);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		//FK�κ��� �ſ� �����ؾ���. PK�����߻��� �� �ִ� �ڸ�
		System.out.println("[�μ���ȣ-deptno]�� �Է��ϼ���. <int>");
		Scanner sc_deptno = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			deptno = Integer.parseInt(sc_deptno.nextLine());//null�̳� �ѱ��� �� ���� ����. NumberFormatException ���� �� ����
			evo.setHiredate(hiredate);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		System.out.println("[�׷��ȣ-mgr]�� �Է��ϼ���.<int>");
		Scanner sc_mgr = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try {
			mgr = Integer.parseInt(sc_mgr.nextLine());//null�̳� �ѱ��� �� ���� ����. NumberFormatException ���� �� ����
			evo.setMgr(mgr);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		//�ԷµǾ����� Ȯ��
		System.out.println("evo.getEmpno() : "+evo.getEmpno());
		System.out.println("evo.getEname() : "+evo.getEname());
		System.out.println("evo.getJob() : "+evo.getJob());
		System.out.println("evo.getHiredate() : "+evo.getHiredate());
		System.out.println("evo.getSal() : "+evo.getSal());
		System.out.println("evo.getComm() : "+evo.getComm());
		System.out.println("evo.getDeptno() : "+evo.getDeptno());
		System.out.println("evo.getMgr() : "+evo.getMgr());
		
		EmpInsert empINS = new EmpInsert();//����üŬ���� �ν��Ͻ�ȭ
	/*		//�Ķ���͸� ����� �� �ִ� >> Ÿ���� ���߾���Ѵ�. >> ����!! �Ÿ���� ������������ ���� �� �ִ� �ɷ��� �ʿ�!!
			//result = empINS.empAdd(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			//VO�� ������ �� ȿ������. ���忡�� �÷��� 50���� �⺻,100���� ��������.. �׷��ٸ� �ξ� ȿ������ ����� ��ü�迭�� �ξ� ȿ����
			
			//�����ϴ¹����? �޼ҵ� �����ε�!!!!
			//�׸���,  
	 */
		//
		result = empINS.empAdd(evo);
			//�ڵ带 ���� ��ĥ���� ������ �߻�Ȱ Ȯ���� �� ��������. �׷��Ƿ� �ڵ带 ���� �Ҽ��� �����ϴ�.
		return result;
	}
	
	/*�����غ���*/
	public int empDelete() {
		int empno = 0;// ���������ϱ�
		int result = 0;
		System.out.println("������ �����ȣ�� �Է��ϼ���.");
		try {
			Scanner sc = new Scanner(System.in);
			empno = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException ne) {
			System.out.println("����Ÿ���� �ƴմϴ�.");
		}
		EmpDelete empDEL = new EmpDelete();// ��ü����
		result = empDEL.empDel(empno);
		return result;
	}
	
	/*�����غ���*/
	public int empUpdate() {
		EmpVO evo = new EmpVO();
		int result = 0;
		int empno = 0;
		String ename = null;
		String job = null;
		String hiredate = null;
		
		System.out.println("�����ȣ�� �Է��ϼ���");
		try {
			Scanner sc_empno = new Scanner(System.in);
			empno = Integer.parseInt(sc_empno.nextLine());
			evo.setEmpno(empno);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("[�����-ename]�� �Է��ϼ���. <String>");
		Scanner sc_ename = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			ename = sc_ename.toString();
			evo.setEname(ename);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[��å-job]�� �Է��ϼ���. <String>");
		Scanner sc_job = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try {
			job	 = sc_job.toString();
			evo.setJob(job);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[�������-hiredate]�� �Է��ϼ���. <String>");
		Scanner sc_hiredate = new Scanner(System.in);//����ڰ� Command â���� �Է��� ���� �о������ ����
		try{
			hiredate= sc_hiredate.toString();
			evo.setHiredate(hiredate);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		EmpUpdate empUPD = new EmpUpdate();
		result = empUPD.empUpd(evo);
		
		return result;
	}

	public static void main(String[] args) {
//												IP�ּ�		  Port SID
		final String _URL 	= "jdbc:oracle:thin:@192.168.0.230:1521:orcl11";
		final String _USER 	= "scott";
		final String _PW	= "tiger";
		
		Connection 	con		= null;
		Statement	stmt	= null;//����
		ResultSet	rs		= null;
		
		//��û�� SQL�� �ۼ�
		String sql	= "SELECT ename, sal, hiredate, TO_CHAR(sal,'9,999.99') AS test FROM emp";
		
		//�����ϰ� ���α׷��� �����Ͽ� ������ �����ϱ����� ������ġ�� try catch ���� �����Ѵ�
		try {
	    //[1�ܰ�] : DB���� ��ǰ�� ����̹� Ŭ������ �޸𸮿� �ε��Ѵ�. - decode����
			//DriverClass : ������,���, Ư�� Ȯ��
			//����Ŭȸ�翡�� ����̺������� ��������� ��
				//E:\app\509\product\11.1.0\db_1\jdbc\lib :: ���̺귯�� �� JAR File Ȯ�� (��޾��)
				//ojdbc6\oracle\jdbc\driver :: JAR File �� class file Ȯ�� (���޾��)
			Class.forName("oracle.jdbc.driver.OracleDriver");

		//[2�ܰ�] : ���������� �������ִ� DB������ �����ϱ�. - Ŀ�ؼǸα�
			con = DriverManager.getConnection(_URL, _USER, _PW);//�ν��Ͻ�ȭ�� ���� ȿ��

		//[3�ܰ�] : ����Ŭ ������ ���� �ۼ��� SELECT���� ������, ó���� ��û�ϱ�. : ��ü�ε�-�ν��Ͻ�ȭ
			stmt = con.createStatement();//�ν��Ͻ�ȭ�� ���� ȿ��
			//��û�ϱ� : �ڹ���Ŭ����(��)�� ���� sql�� ����ִ� SELECT���� ����Ŭ���� ó�����ٷ�?��� ��Ƽ���������� ��Ű��
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("ename")+" "+rs.getDouble("sal")
														+" "+rs.getDate("hiredate")
														+" "+rs.getString("test"));
			}
		
			EmpManager empMng = new EmpManager();
			//empMng.empInsert();//�����׽�Ʈ��
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		//DB��ǰ�� JAR����̹��� ojdbc6�ȿ� �ִ� ������, JVM�ȿ��� ���� ���̱� ������ java.lang.ClassNotFoundException �߻�
		//java project ������ Oracle���� �����ϴ� drive JAR ������ �߰��ϸ� �ذ� ��. ��Ʈ���� (W05-3)

	}

}
