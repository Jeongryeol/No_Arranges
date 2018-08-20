package com.vo;

/**
 * [VO���̺� ������]
 * -��������� �����ϴ� ���̺��� �ִ�. emp����
 * -emp���տ��� 8���� �÷��� �ִ�.
 * -8���� �÷��� ���� �������� ������ 8�� �����ؾ� �ȴ�.
 * -�׷��� VO�� ����ϸ� �ּҹ��� �ϳ��� 8�� ���� ��� �ѱ� �� �Ǵ� ���� �� �ִ�.
 * -���������� private�� �Ͽ���.
 * 		-��?? ���������� �������ؼ�!!
 * 		-�׷��ٸ� ���� ��� ��� ��������??
 * -�׷��� getter�� setter�޼ҵ�� ���������ڸ� public���� �Ͽ���.
 * 		-���� �� setXXX()�޼ҵ�� ��´�
 * 		-���� �� getXXX()�޼ҵ�� ������
 * 
 * [VO�ۼ����]
 * 1. ������ ���̺� �ִ� Script�ڷ�κ��� ������������ �÷������� �޾ƿ´�.
 * 2. �÷��� �ҹ��ں��� : Ctrl+shift+Y
 * 3. �ϰ����� : Ctrl+shift+A
 * 4. �ʱ�ȭ ( 0, null, false etc...)
 * 5. getter,setter ����
 * 
 * [������ ���������� : �Ʒ� 2���� ������ ����]
 * 1. VO	: Value Object
 * 2. DTO	: Data Transfer Object
 * �� ���̺� �������� �ʴ� �÷��̴��� �����ڰ� ����ó���� �ʿ��ϸ� VO�� ������ �߰��� �� �ִ�.
 */

public class EmpVO {
	
	private int		empno    = 0;
	private String	ename    = null;
	private String	job      = null;
	private int		mgr      = 0;
	private String	hiredate = null;
	private double	sal      = 0;
	private double	comm     = 0;
	private int		deptno   = 0;
	//�����ڰ�, �Էµ� ��ȣ�� �������� �ľ��ϱ� ���� VO���� �߰�..INSERT | SELECT | UPDATE | DELETE
	private String	command	 = null;
	
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
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
}
