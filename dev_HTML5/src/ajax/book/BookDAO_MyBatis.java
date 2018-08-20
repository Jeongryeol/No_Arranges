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

public class BookDAO_MyBatis {
	//�α�
	Logger logger = Logger.getLogger(BookDAO_MyBatis.class);
	//Mybatis
	//�Ʒ������� ����Ŭ������ ����̹� Ŭ����,���������� �������ִ� ������ IP�ּ�, ��Ʈ��ȣ, SID�̸�, �����̸�, ��й�ȣ�� �����.
	String resource = "com/mybatis/MapperConfig.xml";//�޴��� 2������ Ȯ��
		/* MapperConfig.xml������ �о ����Ŭ������ Ŀ�ؼ��� �δµ� �ʿ��� ������ ��ĵ�ϰ� ��ü�� ������.
		 * �� ��ü�� �޸𸮿� �ε��Ǿ� �־�� ����Ŭ ������ ���ǰ�ü�� ������ �� ����.
		 * ���ǰ�ü�� Ȱ���Ͽ� commit�� rollback ó���� ������. (�Է�|����|���� �� �ݵ�� �ʿ���)
		 * 
		 * [����������!!]
		 * Ʈ������ó���� �ʿ��� ��� : INSERT/UPDATE/DELETE �� commit�� rollback
		 * 		Connection con = DriverManager.getConnection();
		 * 		con.setAutoCommit(false|true); //false-����Ŀ��,true-�ڵ�Ŀ��
		 * 		con.commit();
		 * 		con.rollback();
		 * */
	//�������� ����ִ� xml������ �������� ��ġ ���� �غ�
	SqlSessionFactory sqlMapper = null;//�޴��� 2������ �ϴ�
	SqlSession 		  sqlSes 	= null;
	
	//��ȸ
	/**
	 * [ MyBatis Test ]
	 */
	public List<Map<String,Object>> getEmployer(Map<String,Object> pMap){
		logger.info("getEmployer ȣ�� ����");
		List<Map<String,Object>> bookList = null;
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);//�ҽ���� �о��
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//��θ� �о SQL���� �����غ�
			sqlSes	  = sqlMapper.openSession();//SQL���� ���� �� ����
			reader.close();//�ҽ��ڿ��ݳ�
			
			//@param pMap�� ������ ���� req�� �ڷᰡ �Ǹ� �� �Ͱ���
			//�����׽�Ʈ������ �ϴ� �����Ͽ� �� ����
			pMap = new HashMap<String,Object>();
			pMap.put("param_num",7620);
		        	//������������ ?�� �ش��ϴ� ����.
		        	//�ۼ��ص� �������� #{ }�� ��ġ�ϴ� Ű���̾�� sqlSession�� �Ķ���ͷ� ������� �� �ִ�.
			logger.info("Map�� �� ��峪��?");
			logger.info(pMap);
			
			//�������� ����ִ� xml������ ������ ������ �ݿ���	//selectOne() sql�� ��û�ϵ�, 1���� ��ȸ�ϴ� �޼ҵ�
			Map<String,Object> rMap = sqlSes.selectOne("testMapSelect",pMap);
			logger.info("�ȿ� �÷��� ��ΰ���? "+rMap.size());
			logger.info("��� ��峪��? "+rMap);
			logger.info("�����ȣ="+rMap.get("�����ȣ"));
			logger.info("�����="+rMap.get("�����"));
			logger.info("����="+rMap.get("����"));
			logger.info("�μ�Ƽ��="+rMap.get("�μ�Ƽ��"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	/********************************************************************
	 * [ ���� �˻� ���� ���� ]
	 * @author ������
	 * @param pMap : ������, ����, ���ǻ�
	 * @return bookList - select��� - ���� - index_book.jsp
	 ********************************************************************/
	public List<Map<String,Object>> getBookList(Map<String,Object> pMap){
		logger.info("getBookList ȣ�� ����");
		List<Map<String,Object>> bookList = null;
		
		try {
			//InputStream ��� Reader class��� : �ѱ۹���Ʈ���� ( �޴���2������  �ϴ� )
			Reader reader = null;//2byte������ ó���ϴ� readerŬ����(�ѱ�-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        
	        //�����׽�Ʈ : Map�� �غ�����
	        pMap = new HashMap<String,Object>();
	        pMap.put("param_text", "���");
	        	//������������ ?�� �ش��ϴ� ����.
	        	//�ۼ��ص� �������� #{ }�� ��ġ�ϴ� Ű���̾�� sqlSession�� �Ķ���ͷ� ������� �� �ִ�.
	        
	        //�������� ����ִ� xml������ ������ ������ �ݿ���	//selectOne() sql�� ��û�ϵ�, 1���� ��ȸ�ϴ� �޼ҵ� 
	    //	resultType 		   name = sqlSession.selectOne("id", parameterType);
	        Map<String,Object> rMap = sqlSes.selectOne("myBatisTest", pMap);
	        logger.info(rMap.get("val"));
	        bookList = new ArrayList<Map<String,Object>>();
	        bookList.add(rMap);
	        logger.info(bookList.get(0).get("val"));
	        
	        //�����׽�Ʈ2 : �ι�° sql �׽�Ʈ�غ���
	        Map<String,Object> rMap2 = sqlSes.selectOne("currentTime", pMap);
	        logger.info("������� ���̼�?");
	        logger.info(rMap2.size());
	        logger.info(rMap2);
	        logger.info(rMap2.get("curDay"));//MyBatis�� ���������̼�(")�� ������ �״�� ����Ѵ�
	        logger.info(rMap2.get("CURDAY"));//MyBatis�� ���������̼�(")�� ���� ��� �÷����� �빮�ڷ� ��ȯ�Ѵ�
	        logger.info(rMap2.get("curday"));//�׷��Ƿ� �� Ÿ���� ������, ���� ���� ���� Ű�� �ι� ���Ƿ� ������� 2��
	        logger.info(rMap2.get("�ѱ����Ǽ���?"));//�ѱ۵� ����
	       
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	//�Է�
	/********************************************************************
	 * [ ���� ���� �Է� ���� ���� ]
	 * @author ������
	 * @param pMap : ������, ���ڸ�, ��������, ���ǻ�, ������, 
	 * @return int=0 : ��Ͻ��� / int=1 : ��ϼ���
	 ********************************************************************/
	public int getBookInsert(Map<String,Object> pMap){
		logger.info("getBookInsert ȣ�� ����");
		int result = 0;
		return result;
	}
	//����
	/********************************************************************
	 * [ ���� ���� ���� ���� ���� ]
	 * @author ������
	 * @param pMap : ������, ���ڸ�, ��������, ���ǻ�, ������, 
	 * @return int=0 : �������� / int=1 : ��������
	 ********************************************************************/
	public int getBookUpdate(Map<String,Object> pMap){
		logger.info("getBookUpdate ȣ�� ����");
		int result = 0;
		return result;
	}

	//����
	/********************************************************************
	 * [ ���� ���� ���� ���� ���� ]
	 * @author ������
	 * @param pMap : ������, ���ڸ�, ��������, ���ǻ�, ������, 
	 * @return int=0 : �������� / int=1 : ��������
	 ********************************************************************/
	public int getBookDelete(Map<String,Object> pMap){
		logger.info("getBookDelete ȣ�� ����");
		int result = 0;
		return result;
	}
}