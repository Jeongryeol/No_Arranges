package com.oracle.jdbc;

public class EmpVO {
	/* [ ���̺����ϱ� - ���̺� ��ȸ(SELECT)�� ���� ��ü�迭�� ����ؾ��� ]
	 * 1. ���̺� ���� �� F4(describe) Ȯ��
	 * 2. script�ǿ��� CREATE TABLE �κ��� �÷��� ���� �ܾ��
	 * 3. Ctrl+Shift+Y : ��ϼ����� ���ڸ� �ҹ��ڷ� ����
	 * 4. �÷� ������Ÿ�� ���� �ּ�ȭ (Alt Shift+A : �ϰ�������)
	 * 5. �÷����� ������ �����ϱ�  
	 * 6. private ������ �����ϱ� (Alt Shift+A : �ϰ�������)
	 */
	private int		empno	=0;     //number(4),
	private String	ename	="";	//varchar2(10 byte),
	private String	job		="";    //varchar2(9 byte),
	private int		mgr		=0;     //number(4),
	private String	hiredate="";	//date,
	private double	sal		=0;	    //number(7,2),
	private double	comm	=0;	    //number(7,2),
	private int		deptno	=0;     //number(2)
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	  
}
