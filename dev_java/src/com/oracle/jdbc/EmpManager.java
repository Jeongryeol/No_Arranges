package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//자바를 이용해서 물리적으로 떨어진 오라클서버에 접속하여 EMP 집합의 정보를 털어보자
public class EmpManager {

/*	public int empInsert(EmpVO evo) {
*/	public int empInsert() {
		int result = 0;//지역변수
		//사용자로부터 값을 입력받아서 처리해보세요. - Command창을 이용해서 해보세요...
		int		empno	= 0;
		String	ename	= null;
		String	job		= null;
		String	hiredate= null;
		double	sal		= 0.0;
		double	comm	= 0.0;
		int 	deptno	= 0;
		int 	mgr		= 0;
		
		EmpVO evo = new EmpVO();
		System.out.println("[사원번호-empno]를 입력하세요. <int>");
		Scanner sc_empno = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try {
			empno = Integer.parseInt(sc_empno.nextLine());//null이나 한글이 올 수도 있음. NumberFormatException 당할 수 있음
			evo.setEmpno(empno);
		}catch (NumberFormatException nfe) {
			System.out.println("숫자타입이 아닙니다.");
			nfe.printStackTrace();
		}
		
		System.out.println("[사원명-ename]을 입력하세요. <String>");
		Scanner sc_ename = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try{
			ename = sc_ename.toString();
			evo.setEname(ename);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[직책-job]을 입력하세요. <String>");
		Scanner sc_job = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try {
			job	 = sc_job.toString();
			evo.setJob(job);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[고용일자-hiredate]를 입력하세요. <String>");
		Scanner sc_hiredate = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try{
			hiredate= sc_hiredate.toString();
			evo.setHiredate(hiredate);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[연봉-sal]를 입력하세요. <double>");
		Scanner sc_sal = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try{
			sal	 = Double.parseDouble(sc_sal.nextLine());
			evo.setSal(sal);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		System.out.println("[보너스-comm]를 입력하세요. <double>");
		Scanner sc_comm = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try{
			comm = Double.parseDouble(sc_comm.nextLine());
			evo.setComm(comm);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		//FK부분은 매우 주의해야함. PK에러발생할 수 있는 자리
		System.out.println("[부서번호-deptno]를 입력하세요. <int>");
		Scanner sc_deptno = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try{
			deptno = Integer.parseInt(sc_deptno.nextLine());//null이나 한글이 올 수도 있음. NumberFormatException 당할 수 있음
			evo.setHiredate(hiredate);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		System.out.println("[그룹번호-mgr]를 입력하세요.<int>");
		Scanner sc_mgr = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try {
			mgr = Integer.parseInt(sc_mgr.nextLine());//null이나 한글이 올 수도 있음. NumberFormatException 당할 수 있음
			evo.setMgr(mgr);
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		//입력되었는지 확인
		System.out.println("evo.getEmpno() : "+evo.getEmpno());
		System.out.println("evo.getEname() : "+evo.getEname());
		System.out.println("evo.getJob() : "+evo.getJob());
		System.out.println("evo.getHiredate() : "+evo.getHiredate());
		System.out.println("evo.getSal() : "+evo.getSal());
		System.out.println("evo.getComm() : "+evo.getComm());
		System.out.println("evo.getDeptno() : "+evo.getDeptno());
		System.out.println("evo.getMgr() : "+evo.getMgr());
		
		EmpInsert empINS = new EmpInsert();//구현체클래스 인스턴스화
	/*		//파라미터를 사용할 수 있다 >> 타입을 맞추어야한다. >> 팀플!! 어떤타입이 정해져있으니 맞출 수 있는 능력이 필요!!
			//result = empINS.empAdd(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			//VO로 받으면 더 효율적임. 현장에선 컬럼이 50개가 기본,100개가 넘을수도.. 그렇다면 훨씬 효율적인 방법은 객체배열이 훨씬 효율적
			
			//개선하는방법은? 메소드 오버로딩!!!!
			//그리고,  
	 */
		//
		result = empINS.empAdd(evo);
			//코드를 많이 고칠수록 에러가 발생활 확률은 더 높아진다. 그러므로 코드를 적게 할수록 유리하다.
		return result;
	}
	
	/*삭제해보자*/
	public int empDelete() {
		int empno = 0;// 지역변수니까
		int result = 0;
		System.out.println("삭제할 사원번호를 입력하세요.");
		try {
			Scanner sc = new Scanner(System.in);
			empno = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException ne) {
			System.out.println("숫자타입이 아닙니다.");
		}
		EmpDelete empDEL = new EmpDelete();// 객체주입
		result = empDEL.empDel(empno);
		return result;
	}
	
	/*수정해보자*/
	public int empUpdate() {
		EmpVO evo = new EmpVO();
		int result = 0;
		int empno = 0;
		String ename = null;
		String job = null;
		String hiredate = null;
		
		System.out.println("사원번호를 입력하세요");
		try {
			Scanner sc_empno = new Scanner(System.in);
			empno = Integer.parseInt(sc_empno.nextLine());
			evo.setEmpno(empno);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("[사원명-ename]을 입력하세요. <String>");
		Scanner sc_ename = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try{
			ename = sc_ename.toString();
			evo.setEname(ename);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[직책-job]을 입력하세요. <String>");
		Scanner sc_job = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
		try {
			job	 = sc_job.toString();
			evo.setJob(job);
		}catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		
		System.out.println("[고용일자-hiredate]를 입력하세요. <String>");
		Scanner sc_hiredate = new Scanner(System.in);//사용자가 Command 창에서 입력한 값을 읽어오도록 해줌
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
//												IP주소		  Port SID
		final String _URL 	= "jdbc:oracle:thin:@192.168.0.230:1521:orcl11";
		final String _USER 	= "scott";
		final String _PW	= "tiger";
		
		Connection 	con		= null;
		Statement	stmt	= null;//전령
		ResultSet	rs		= null;
		
		//요청할 SQL문 작성
		String sql	= "SELECT ename, sal, hiredate, TO_CHAR(sal,'9,999.99') AS test FROM emp";
		
		//안전하게 프로그램을 종료하여 에러에 대응하기위한 안전장치로 try catch 예약어를 제공한다
		try {
	    //[1단계] : DB서버 제품의 드라이버 클래스를 메모리에 로딩한다. - decode지원
			//DriverClass : 제조사,기능, 특성 확인
			//오라클회사에서 드라이브정보를 제공해줘야 함
				//E:\app\509\product\11.1.0\db_1\jdbc\lib :: 라이브러리 내 JAR File 확인 (고급언어)
				//ojdbc6\oracle\jdbc\driver :: JAR File 내 class file 확인 (저급언어)
			Class.forName("oracle.jdbc.driver.OracleDriver");

		//[2단계] : 물리적으로 떨어져있는 DB서버에 접속하기. - 커넥션맺기
			con = DriverManager.getConnection(_URL, _USER, _PW);//인스턴스화와 같은 효과

		//[3단계] : 오라클 서버에 내가 작성한 SELECT문을 보내고, 처리를 요청하기. : 객체로딩-인스턴스화
			stmt = con.createStatement();//인스턴스화와 같은 효과
			//요청하기 : 자바이클립스(너)가 변수 sql에 들어있는 SELECT문을 오라클에게 처리해줄래?라고 옵티마이저에게 시키기
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("ename")+" "+rs.getDouble("sal")
														+" "+rs.getDate("hiredate")
														+" "+rs.getString("test"));
			}
		
			EmpManager empMng = new EmpManager();
			//empMng.empInsert();//단위테스트용
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		//DB제품의 JAR드라이버는 ojdbc6안에 있는 것이지, JVM안에는 없는 것이기 때문에 java.lang.ClassNotFoundException 발생
		//java project 폴더에 Oracle에서 제공하는 drive JAR 정보를 추가하면 해결 됨. 노트참고 (W05-3)

	}

}
