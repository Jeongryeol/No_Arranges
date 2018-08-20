package ajax.book;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class DeptDAO_MyBatis {
	//�α�
	Logger logger = Logger.getLogger(DeptDAO_MyBatis.class);
	//MyBatis
	String resource = "com/mybatis/MapperConfig.xml";//Ŀ�ؼǿ� �ʿ��� ������ ���� xml����
	SqlSessionFactory sqlMapper = null;
	SqlSession		  sqlSes	= null;

	//PROCEDURE ȣ���ϱ�
	public String proc_emp_sal_update(Map<String,Object> pMap){
		logger.info("proc_emp_sal_update ȣ�� ����");
		String msg = null;
		HashMap<String,Object> rMap = new HashMap<String,Object>();
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        
	        /*
	         * ���ν����� ��� IN�Ӽ��� OUT�Ӽ��� �ִ�.
	         * IN�Ӽ��� �Ķ���� ���� �ѱ�� �뵵�� ����ϰ�
	         * OUT�Ӽ��� ���ν����� ��ȯ�ϴ� ���� ��� �Ӽ���
	         * �� �� ������ ���� �Ķ���ͷ� �ѱ�� �ּғ����� OUT�Ӽ��� ��ȯ���� ���� �޾� �´ٴ� ��. 
	         * ������ �α׿��� OUT�Ӽ��ڸ��� NULL�� �־��� �� ���� ����ִ� �ڵ尡 ������ ����
	         */
	        rMap.put("empno",7566);
	        sqlSes.selectOne("proc_emp_sal_update", rMap);
	        msg = rMap.get("msg").toString();
	        
	        logger.info("��ȸ��� : "+pMap.get("msg"));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	
	
	//MULTI-SELECT ������ȸ���� : ��ȸ�� ����� session�� �ƴ� forward�� ȭ��ó���Ұ�
	public List<Map<String,Object>> getDeptList(int deptno, String dname){
		logger.info("getDeptList ȣ�� ����");
		List<Map<String,Object>> deptList = null;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        
	        Map<String,Object> pMap = new HashMap<String,Object>();
	        pMap.put("deptno",deptno);
	        pMap.put("dname",dname);
	        
	        deptList = sqlSes.selectList("getDeptList", pMap);//n���� ��ȸ�ϴ� �޼ҵ� selectList()
	        logger.info("��ȸ��� : "+deptList.size()+"��");
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return deptList;
	}

	//INSERT ���Ծ��� : ���Ե� ����� sendRedirect�� ó���Ұ�
	public int deptInsert(Map<String,Object> pMap){
		logger.info("deptInsert ȣ�� ����");
		int result = 0;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
	        
	        result = sqlSes.insert("deptInsert",pMap);
	        logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
	        
	        //JVM�� �ٷ�� JDBC�� commit�� ���Ͽ� "AutoCommit"�� �⺻���̴� (�ڵ�Ŀ��)
	        //ORM Solution�� MyBatis�� commit�� ���Ͽ� "ManualCommit"�� �⺻���̴� (����Ŀ��)
	        sqlSes.commit();//DBcommit
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//INSERT2 ����+SELECT���� : ���Ե� ����� sendRedirect�� ó���Ұ�
	public int deptInsert2(Map<String,Object> pMap){
		logger.info("deptInsert2 ȣ�� ����");
		int result = 0;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			result = sqlSes.insert("deptInsert2",pMap);
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			//JVM�� �ٷ�� JDBC�� commit�� ���Ͽ� "AutoCommit"�� �⺻���̴� (�ڵ�Ŀ��)
			//ORM Solution�� MyBatis�� commit�� ���Ͽ� "ManualCommit"�� �⺻���̴� (����Ŀ��)
			sqlSes.commit();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//UPDATE �������� : ������ ����� sendRedirect�� ó���Ұ�
	public int deptUpdate(Map<String,Object> pMap){
		logger.info("deptUpdate ȣ�� ����");
		int result = 0;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			result = sqlSes.insert("deptUpdate",pMap);
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			//JVM�� �ٷ�� JDBC�� commit�� ���Ͽ� "AutoCommit"�� �⺻���̴� (�ڵ�Ŀ��)
			//ORM Solution�� MyBatis�� commit�� ���Ͽ� "ManualCommit"�� �⺻���̴� (����Ŀ��)
			sqlSes.commit();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//MULTI-DELETE [Array] ���߻������� : ������ ����� sendRedirect�� ó���Ұ�
	public int deptDeleteArray(Map<String,Object> pMap){
		logger.info("deptDeleteArray ȣ�� ����");
		int result = 0;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			//delete�� list�迭�̳� �迭�� ������
			int[] deptnos = new int[4];
			deptnos[0] = 70;
			deptnos[1] = 75;
			deptnos[2] = 90;
			deptnos[3] = 99;
			
			result = sqlSes.delete("deptDeleteArray",deptnos);
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			//JVM�� �ٷ�� JDBC�� commit�� ���Ͽ� "AutoCommit"�� �⺻���̴� (�ڵ�Ŀ��)
			//ORM Solution�� MyBatis�� commit�� ���Ͽ� "ManualCommit"�� �⺻���̴� (����Ŀ��)
			sqlSes.rollback();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//MULTI-DELETE [List] ���߻������� : ������ ����� sendRedirect�� ó���Ұ�
	public int deptDeleteList(Map<String,Object> pMap){
		logger.info("deptDeleteList ȣ�� ����");
		int result = 0;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			//delete�� list�迭�̳� �迭�� ������
			List<Integer> plist = new ArrayList<Integer>();
			plist.add(70);
			plist.add(75);
			plist.add(90);
			plist.add(99);
			
			result = sqlSes.delete("deptDeleteList",plist);
			logger.info("result = "+result);//result 1:�Է¼���, 0:�Է½���
			
			//JVM�� �ٷ�� JDBC�� commit�� ���Ͽ� "AutoCommit"�� �⺻���̴� (�ڵ�Ŀ��)
			//ORM Solution�� MyBatis�� commit�� ���Ͽ� "ManualCommit"�� �⺻���̴� (����Ŀ��)
			sqlSes.rollback();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
