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
	//로그
	Logger logger = Logger.getLogger(DeptDAO_MyBatis.class);
	//MyBatis
	String resource = "com/mybatis/MapperConfig.xml";//커넥션에 필요한 정보를 담은 xml문서
	SqlSessionFactory sqlMapper = null;
	SqlSession		  sqlSes	= null;

	//PROCEDURE 호출하기
	public String proc_emp_sal_update(Map<String,Object> pMap){
		logger.info("proc_emp_sal_update 호출 성공");
		String msg = null;
		HashMap<String,Object> rMap = new HashMap<String,Object>();
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        
	        /*
	         * 프로시저의 경우 IN속성과 OUT속성이 있다.
	         * IN속성은 파라미터 값을 넘기는 용도로 사용하고
	         * OUT속성은 프로시저가 반환하는 값을 담는 속성임
	         * 이 때 주의할 점은 파라미터로 넘기는 주소벉지에 OUT속성에 반환값을 같이 받아 온다는 것. 
	         * 이전에 로그에서 OUT속성자리에 NULL이 있었던 건 따로 담아주는 코드가 빠졌기 때문
	         */
	        rMap.put("empno",7566);
	        sqlSes.selectOne("proc_emp_sal_update", rMap);
	        msg = rMap.get("msg").toString();
	        
	        logger.info("조회결과 : "+pMap.get("msg"));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	
	
	//MULTI-SELECT 다중조회업무 : 조회된 결과는 session이 아닌 forward로 화면처리할것
	public List<Map<String,Object>> getDeptList(int deptno, String dname){
		logger.info("getDeptList 호출 성공");
		List<Map<String,Object>> deptList = null;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        
	        Map<String,Object> pMap = new HashMap<String,Object>();
	        pMap.put("deptno",deptno);
	        pMap.put("dname",dname);
	        
	        deptList = sqlSes.selectList("getDeptList", pMap);//n건을 조회하는 메소드 selectList()
	        logger.info("조회결과 : "+deptList.size()+"건");
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return deptList;
	}

	//INSERT 삽입업무 : 삽입된 결과는 sendRedirect로 처리할것
	public int deptInsert(Map<String,Object> pMap){
		logger.info("deptInsert 호출 성공");
		int result = 0;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        logger.info("result = "+result);//result 1:입력성공, 0:입력실패
	        
	        result = sqlSes.insert("deptInsert",pMap);
	        logger.info("result = "+result);//result 1:입력성공, 0:입력실패
	        
	        //JVM이 다루는 JDBC는 commit에 대하여 "AutoCommit"이 기본값이다 (자동커밋)
	        //ORM Solution인 MyBatis는 commit에 대하여 "ManualCommit"이 기본값이다 (수동커밋)
	        sqlSes.commit();//DBcommit
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//INSERT2 삽입+SELECT업무 : 삽입된 결과는 sendRedirect로 처리할것
	public int deptInsert2(Map<String,Object> pMap){
		logger.info("deptInsert2 호출 성공");
		int result = 0;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			result = sqlSes.insert("deptInsert2",pMap);
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			//JVM이 다루는 JDBC는 commit에 대하여 "AutoCommit"이 기본값이다 (자동커밋)
			//ORM Solution인 MyBatis는 commit에 대하여 "ManualCommit"이 기본값이다 (수동커밋)
			sqlSes.commit();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//UPDATE 수정업무 : 수정된 결과는 sendRedirect로 처리할것
	public int deptUpdate(Map<String,Object> pMap){
		logger.info("deptUpdate 호출 성공");
		int result = 0;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			result = sqlSes.insert("deptUpdate",pMap);
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			//JVM이 다루는 JDBC는 commit에 대하여 "AutoCommit"이 기본값이다 (자동커밋)
			//ORM Solution인 MyBatis는 commit에 대하여 "ManualCommit"이 기본값이다 (수동커밋)
			sqlSes.commit();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//MULTI-DELETE [Array] 다중삭제업무 : 수정된 결과는 sendRedirect로 처리할것
	public int deptDeleteArray(Map<String,Object> pMap){
		logger.info("deptDeleteArray 호출 성공");
		int result = 0;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			//delete는 list계열이나 배열이 들어가야함
			int[] deptnos = new int[4];
			deptnos[0] = 70;
			deptnos[1] = 75;
			deptnos[2] = 90;
			deptnos[3] = 99;
			
			result = sqlSes.delete("deptDeleteArray",deptnos);
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			//JVM이 다루는 JDBC는 commit에 대하여 "AutoCommit"이 기본값이다 (자동커밋)
			//ORM Solution인 MyBatis는 commit에 대하여 "ManualCommit"이 기본값이다 (수동커밋)
			sqlSes.rollback();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//MULTI-DELETE [List] 다중삭제업무 : 수정된 결과는 sendRedirect로 처리할것
	public int deptDeleteList(Map<String,Object> pMap){
		logger.info("deptDeleteList 호출 성공");
		int result = 0;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSes 	  = sqlMapper.openSession();
			reader.close();
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			//delete는 list계열이나 배열이 들어가야함
			List<Integer> plist = new ArrayList<Integer>();
			plist.add(70);
			plist.add(75);
			plist.add(90);
			plist.add(99);
			
			result = sqlSes.delete("deptDeleteList",plist);
			logger.info("result = "+result);//result 1:입력성공, 0:입력실패
			
			//JVM이 다루는 JDBC는 commit에 대하여 "AutoCommit"이 기본값이다 (자동커밋)
			//ORM Solution인 MyBatis는 commit에 대하여 "ManualCommit"이 기본값이다 (수동커밋)
			sqlSes.rollback();//DBcommit
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
