package com.ch11;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;
import com.vo.VO_FoodStore;

//DAO : Data Access Object (DB연동을 전담하는 클래스로 설계함)
//별도설계이유 : 재사용성을 높이기 위한 클래스설계
//업무와 업무사이에는 관계가 있고, 그 관계에 종속적이지 않은 상태로 클래스설계를 해야
//관련있는 업무사이에서 메소드를 공유할 수 있다.
//--->결합도가 낮은 코드를 전개하는 것이 좋대.
//--->결합도가 낮아야 단위테스트가 가능하고 통합테스트가 가능해진다.
//프로젝트 진행과정
//분석 설계 --> 개발(코딩) ---> 테스트 ---> 시스템 이행 ---> 끝

public class EmpDAO {//JDBC구현 클래스
   /*선언부*/
   //static을 붙였기 때문에 바로 인스턴스화 됨
      //Calendar cal = Calendar.getInstance(); 이런식으로 인스턴스화가 가능하다!!
   DBConnectionMgr      dbMgr = DBConnectionMgr.getInstance();
   Connection         con     = null;
   PreparedStatement   pstmt = null;
   ResultSet         rs      = null;//커서를 컨트롤하자 ::전체범위처리/부분범위처리/속도에 관한 이해
   
   //객체주입 -> NextPhase : DI(dependency injection)
   
   /*입력처리*/
   
   /*수정처리*/
   
   /*삭제처리*/
   
   /*조회처리*/
   //메소드이름 : getEmpList(??):??
   public int delete(int no) {
      
      int result = 0;

      
      String sql = "delete emp where empno = ?";
            
      
      try {
         con = dbMgr.getConnection();
         pstmt = con.prepareStatement(sql);
           pstmt.setInt(1, no);
           result =   pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   
      
      return result;
      
      
      
   }
   public List<VO_FoodStore> getEmpList(VO_FoodStore pevo) {
      
      //결과를 담아 메소드의 반환값으로 낼 리스트 선언
         //EmpVO 클래스는 한번에 1개의 로우밖에 못담기 때문에,
         //EmpVO 클래스를 여러 개 담아주는 ArrayList가 필요해진다.
         //이 때, 다형성을 적용하여 코드의 재사용성을 높여준다. 
      List<VO_FoodStore> empList = new ArrayList<VO_FoodStore>();
      
      //SQL문을 작성할때는
         //StringBuilder(비동기화/단독/고속)나
         //StringBuffer(동기화/경합/저속)를 사용한다.
      //SQL문은 Toad에서 테스트를 마친 후 가져올 것
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT empno, ename, job");
      sql.append(", mgr, To_CHAR(hiredate, 'YYYY-MM_DD') hiredate, sal, comm, deptno");
      sql.append(" FROM emp                        ");
      //JDBC를 디테일하게 컨트롤하기 위해서는 상위방법처럼 진행해야한다. 
      //myBatis쓰는경우 위와같이 할 필요가 없어지지만, 디테일한 컨트롤이 떨어진다.
      
      //DB연동은 오라클 서버에 접속하는 것이므로 예외처리 필수임.
      try {
         //자바에서 제공하는 인터페이스들 중, 메소드 호출을 통해 객체주입되는경우도 많음.
         con = dbMgr.getConnection();
         //연결정보로부터 전령을 준비할때 SQL문을 담음
         System.out.println("[[요청한 동적쿼리문]] "+sql.toString());
         pstmt = con.prepareStatement(sql.toString());
         
         //담은 정보를 돌리고 결과에 대한 커서 가져옴
         rs = pstmt.executeQuery();
            //System.out.println(rs.isFirst());//커서가 제일 앞에 있니?
            //System.out.println(rs.isLast()); //커서가 제일 뒤에 있니?
            //while(rs.previous()) {   //커서가 제일 뒤에 있다면 뒤로 돌아가게 반복문 가동
            //while(rs.absolute(3){      //커서를 특정위치에 옮겨가게 해준다. 
         VO_FoodStore evo = null;
         while(rs.next()) {//커서가 제일 앞이라면 다음으로 달려가게 반복문 가동
            
            //새로운 하나의 row를 담을 EmpVO 인스턴스로 생성하기
            evo = new VO_FoodStore();
            //조회한 결과의 각 컬럼에 해당하는 로우값을 EmpVO클래스에 저장(set)하기
            evo.setEmpno(rs.getInt("empno"));
            evo.setEname(rs.getString("ename"));
            evo.setJob(rs.getString("job"));
            evo.setMgr(rs.getInt("mgr"));
            evo.setHiredate(rs.getString("hiredate"));
            evo.setSal(rs.getDouble("sal"));
            evo.setComm(rs.getDouble("comm"));
            evo.setDeptno(rs.getInt("deptno"));
            //저장된 EmpVO클래스를 List에 담기
            empList.add(evo);
         }//반복하기
         
      } catch (SQLException se) {
         System.out.println("SQL요청 중 에러발생!");
         System.out.println("[[query]] "+sql.toString());
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return empList;
   }
   //부서정보 조회처리 - 메소드 선언 = getDeptList(?):?
   public List<DeptVO> getDeptList(DeptVO pevo) {
      
      //결과를 담아 메소드의 반환값으로 낼 리스트 선언
         //EmpVO 클래스는 한번에 1개의 로우밖에 못담기 때문에,
         //EmpVO 클래스를 여러 개 담아주는 ArrayList가 필요해진다.
         //이 때, 다형성을 적용하여 코드의 재사용성을 높여준다. 
      List<DeptVO> deptList = new ArrayList<DeptVO>();
      
      //SQL문을 작성할때는
         //StringBuilder(비동기화/단독/고속)나
         //StringBuffer(동기화/경합/저속)를 사용한다.
      //SQL문은 Toad에서 테스트를 마친 후 가져올 것
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT deptno,dname,loc");
      sql.append(" FROM dept");
      //JDBC를 디테일하게 컨트롤하기 위해서는 상위방법처럼 진행해야한다. 
      //myBatis쓰는경우 위와같이 할 필요가 없어지지만, 디테일한 컨트롤이 떨어진다.
      
      //DB연동은 오라클 서버에 접속하는 것이므로 예외처리 필수임.
      try {
         //자바에서 제공하는 인터페이스들 중, 메소드 호출을 통해 객체주입되는경우도 많음.
         con = dbMgr.getConnection();
         //연결정보로부터 전령을 준비할때 SQL문을 담음
         System.out.println("[[요청한 동적쿼리문]] "+sql.toString());
         pstmt = con.prepareStatement(sql.toString());
         
         //담은 정보를 돌리고 결과에 대한 커서 가져옴
         rs = pstmt.executeQuery();
            //System.out.println(rs.isFirst());//커서가 제일 앞에 있니?
            //System.out.println(rs.isLast()); //커서가 제일 뒤에 있니?
            //while(rs.previous()) {   //커서가 제일 뒤에 있다면 뒤로 돌아가게 반복문 가동
            //while(rs.absolute(3){      //커서를 특정위치에 옮겨가게 해준다. 
         DeptVO evo = null;
         while(rs.next()) {//커서가 제일 앞이라면 다음으로 달려가게 반복문 가동
            
            //새로운 하나의 row를 담을 EmpVO 인스턴스로 생성하기
            evo = new DeptVO();
            //조회한 결과의 각 컬럼에 해당하는 로우값을 EmpVO클래스에 저장(set)하기
            evo.setDeptno(rs.getInt("deptno"));
            evo.setDname(rs.getString("dname"));
            evo.setLoc(rs.getString("loc"));
         
            //저장된 EmpVO클래스를 List에 담기
            deptList.add(evo);
         }//반복하기
         
      } catch (SQLException se) {
         System.out.println("SQL요청 중 에러발생!");
         System.out.println("[[query]] "+sql.toString());
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return deptList;
   }
}