package com.oracle.jdbc;

public class EmpVO {
	/* [ 테이블설계하기 - 테이블 조회(SELECT)을 위해 객체배열을 사용해야함 ]
	 * 1. 테이블 선택 후 F4(describe) 확인
	 * 2. script탭에서 CREATE TABLE 부분의 컬럼명 전부 긁어옴
	 * 3. Ctrl+Shift+Y : 블록설정된 문자를 소문자로 변경
	 * 4. 컬럼 데이터타입 영역 주석화 (Alt Shift+A : 일괄변경모드)
	 * 5. 컬럼명을 변수로 선언하기  
	 * 6. private 변수로 변경하기 (Alt Shift+A : 일괄변경모드)
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
