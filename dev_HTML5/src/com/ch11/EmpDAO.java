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

//DAO : Data Access Object (DB������ �����ϴ� Ŭ������ ������)
//������������ : ���뼺�� ���̱� ���� Ŭ��������
//������ �������̿��� ���谡 �ְ�, �� ���迡 ���������� ���� ���·� Ŭ�������踦 �ؾ�
//�����ִ� �������̿��� �޼ҵ带 ������ �� �ִ�.
//--->���յ��� ���� �ڵ带 �����ϴ� ���� ����.
//--->���յ��� ���ƾ� �����׽�Ʈ�� �����ϰ� �����׽�Ʈ�� ����������.
//������Ʈ �������
//�м� ���� --> ����(�ڵ�) ---> �׽�Ʈ ---> �ý��� ���� ---> ��

public class EmpDAO {//JDBC���� Ŭ����
   /*�����*/
   //static�� �ٿ��� ������ �ٷ� �ν��Ͻ�ȭ ��
      //Calendar cal = Calendar.getInstance(); �̷������� �ν��Ͻ�ȭ�� �����ϴ�!!
   DBConnectionMgr      dbMgr = DBConnectionMgr.getInstance();
   Connection         con     = null;
   PreparedStatement   pstmt = null;
   ResultSet         rs      = null;//Ŀ���� ��Ʈ������ ::��ü����ó��/�κй���ó��/�ӵ��� ���� ����
   
   //��ü���� -> NextPhase : DI(dependency injection)
   
   /*�Է�ó��*/
   
   /*����ó��*/
   
   /*����ó��*/
   
   /*��ȸó��*/
   //�޼ҵ��̸� : getEmpList(??):??
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
      
      //����� ��� �޼ҵ��� ��ȯ������ �� ����Ʈ ����
         //EmpVO Ŭ������ �ѹ��� 1���� �ο�ۿ� ����� ������,
         //EmpVO Ŭ������ ���� �� ����ִ� ArrayList�� �ʿ�������.
         //�� ��, �������� �����Ͽ� �ڵ��� ���뼺�� �����ش�. 
      List<VO_FoodStore> empList = new ArrayList<VO_FoodStore>();
      
      //SQL���� �ۼ��Ҷ���
         //StringBuilder(�񵿱�ȭ/�ܵ�/���)��
         //StringBuffer(����ȭ/����/����)�� ����Ѵ�.
      //SQL���� Toad���� �׽�Ʈ�� ��ģ �� ������ ��
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT empno, ename, job");
      sql.append(", mgr, To_CHAR(hiredate, 'YYYY-MM_DD') hiredate, sal, comm, deptno");
      sql.append(" FROM emp                        ");
      //JDBC�� �������ϰ� ��Ʈ���ϱ� ���ؼ��� �������ó�� �����ؾ��Ѵ�. 
      //myBatis���°�� ���Ͱ��� �� �ʿ䰡 ����������, �������� ��Ʈ���� ��������.
      
      //DB������ ����Ŭ ������ �����ϴ� ���̹Ƿ� ����ó�� �ʼ���.
      try {
         //�ڹٿ��� �����ϴ� �������̽��� ��, �޼ҵ� ȣ���� ���� ��ü���ԵǴ°�쵵 ����.
         con = dbMgr.getConnection();
         //���������κ��� ������ �غ��Ҷ� SQL���� ����
         System.out.println("[[��û�� ����������]] "+sql.toString());
         pstmt = con.prepareStatement(sql.toString());
         
         //���� ������ ������ ����� ���� Ŀ�� ������
         rs = pstmt.executeQuery();
            //System.out.println(rs.isFirst());//Ŀ���� ���� �տ� �ִ�?
            //System.out.println(rs.isLast()); //Ŀ���� ���� �ڿ� �ִ�?
            //while(rs.previous()) {   //Ŀ���� ���� �ڿ� �ִٸ� �ڷ� ���ư��� �ݺ��� ����
            //while(rs.absolute(3){      //Ŀ���� Ư����ġ�� �Űܰ��� ���ش�. 
         VO_FoodStore evo = null;
         while(rs.next()) {//Ŀ���� ���� ���̶�� �������� �޷����� �ݺ��� ����
            
            //���ο� �ϳ��� row�� ���� EmpVO �ν��Ͻ��� �����ϱ�
            evo = new VO_FoodStore();
            //��ȸ�� ����� �� �÷��� �ش��ϴ� �ο찪�� EmpVOŬ������ ����(set)�ϱ�
            evo.setEmpno(rs.getInt("empno"));
            evo.setEname(rs.getString("ename"));
            evo.setJob(rs.getString("job"));
            evo.setMgr(rs.getInt("mgr"));
            evo.setHiredate(rs.getString("hiredate"));
            evo.setSal(rs.getDouble("sal"));
            evo.setComm(rs.getDouble("comm"));
            evo.setDeptno(rs.getInt("deptno"));
            //����� EmpVOŬ������ List�� ���
            empList.add(evo);
         }//�ݺ��ϱ�
         
      } catch (SQLException se) {
         System.out.println("SQL��û �� �����߻�!");
         System.out.println("[[query]] "+sql.toString());
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return empList;
   }
   //�μ����� ��ȸó�� - �޼ҵ� ���� = getDeptList(?):?
   public List<DeptVO> getDeptList(DeptVO pevo) {
      
      //����� ��� �޼ҵ��� ��ȯ������ �� ����Ʈ ����
         //EmpVO Ŭ������ �ѹ��� 1���� �ο�ۿ� ����� ������,
         //EmpVO Ŭ������ ���� �� ����ִ� ArrayList�� �ʿ�������.
         //�� ��, �������� �����Ͽ� �ڵ��� ���뼺�� �����ش�. 
      List<DeptVO> deptList = new ArrayList<DeptVO>();
      
      //SQL���� �ۼ��Ҷ���
         //StringBuilder(�񵿱�ȭ/�ܵ�/���)��
         //StringBuffer(����ȭ/����/����)�� ����Ѵ�.
      //SQL���� Toad���� �׽�Ʈ�� ��ģ �� ������ ��
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT deptno,dname,loc");
      sql.append(" FROM dept");
      //JDBC�� �������ϰ� ��Ʈ���ϱ� ���ؼ��� �������ó�� �����ؾ��Ѵ�. 
      //myBatis���°�� ���Ͱ��� �� �ʿ䰡 ����������, �������� ��Ʈ���� ��������.
      
      //DB������ ����Ŭ ������ �����ϴ� ���̹Ƿ� ����ó�� �ʼ���.
      try {
         //�ڹٿ��� �����ϴ� �������̽��� ��, �޼ҵ� ȣ���� ���� ��ü���ԵǴ°�쵵 ����.
         con = dbMgr.getConnection();
         //���������κ��� ������ �غ��Ҷ� SQL���� ����
         System.out.println("[[��û�� ����������]] "+sql.toString());
         pstmt = con.prepareStatement(sql.toString());
         
         //���� ������ ������ ����� ���� Ŀ�� ������
         rs = pstmt.executeQuery();
            //System.out.println(rs.isFirst());//Ŀ���� ���� �տ� �ִ�?
            //System.out.println(rs.isLast()); //Ŀ���� ���� �ڿ� �ִ�?
            //while(rs.previous()) {   //Ŀ���� ���� �ڿ� �ִٸ� �ڷ� ���ư��� �ݺ��� ����
            //while(rs.absolute(3){      //Ŀ���� Ư����ġ�� �Űܰ��� ���ش�. 
         DeptVO evo = null;
         while(rs.next()) {//Ŀ���� ���� ���̶�� �������� �޷����� �ݺ��� ����
            
            //���ο� �ϳ��� row�� ���� EmpVO �ν��Ͻ��� �����ϱ�
            evo = new DeptVO();
            //��ȸ�� ����� �� �÷��� �ش��ϴ� �ο찪�� EmpVOŬ������ ����(set)�ϱ�
            evo.setDeptno(rs.getInt("deptno"));
            evo.setDname(rs.getString("dname"));
            evo.setLoc(rs.getString("loc"));
         
            //����� EmpVOŬ������ List�� ���
            deptList.add(evo);
         }//�ݺ��ϱ�
         
      } catch (SQLException se) {
         System.out.println("SQL��û �� �����߻�!");
         System.out.println("[[query]] "+sql.toString());
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return deptList;
   }
}