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
	//로그
	Logger logger = Logger.getLogger(BookDAO_MyBatis.class);
	//Mybatis
	//아래문서에 오라클서버의 드라이버 클래스,물리적으로 떨어져있는 서버의 IP주소, 포트번호, SID이름, 계정이름, 비밀번호를 등록함.
	String resource = "com/mybatis/MapperConfig.xml";//메뉴얼 2페이지 확인
		/* MapperConfig.xml문서를 읽어서 오라클서버에 커넥션을 맺는데 필요한 정보를 스캔하고 객체를 생성함.
		 * 이 객체가 메모리에 로딩되어 있어야 오라클 서버에 세션객체를 생성할 수 있음.
		 * 세션객체를 활용하여 commit과 rollback 처리가 가능함. (입력|수정|삭제 시 반드시 필요함)
		 * 
		 * [기술면접대상!!]
		 * 트랜젝션처리가 필요한 경우 : INSERT/UPDATE/DELETE 의 commit과 rollback
		 * 		Connection con = DriverManager.getConnection();
		 * 		con.setAutoCommit(false|true); //false-수동커밋,true-자동커밋
		 * 		con.commit();
		 * 		con.rollback();
		 * */
	//쿼리문을 담고있는 xml문서의 물리적인 위치 담을 준비
	SqlSessionFactory sqlMapper = null;//메뉴얼 2페이지 하단
	SqlSession 		  sqlSes 	= null;
	
	//조회
	/**
	 * [ MyBatis Test ]
	 */
	public List<Map<String,Object>> getEmployer(Map<String,Object> pMap){
		logger.info("getEmployer 호출 성공");
		List<Map<String,Object>> bookList = null;
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);//소스경로 읽어옴
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//경로를 읽어서 SQL세션 생성준비
			sqlSes	  = sqlMapper.openSession();//SQL세션 생성 및 저장
			reader.close();//소스자원반납
			
			//@param pMap은 웹에서 받은 req의 자료가 되면 될 것같다
			//단위테스트용으로 일단 생성하여 값 담음
			pMap = new HashMap<String,Object>();
			pMap.put("param_num",7620);
		        	//동적쿼리문의 ?에 해당하는 내용.
		        	//작성해둔 쿼리문의 #{ }와 일치하는 키값이어야 sqlSession의 파라미터로 집어넣을 수 있다.
			logger.info("Map에 잘 담겼나요?");
			logger.info(pMap);
			
			//쿼리문을 담고있는 xml문서에 설정한 내용이 반영됨	//selectOne() sql을 요청하되, 1건을 조회하는 메소드
			Map<String,Object> rMap = sqlSes.selectOne("testMapSelect",pMap);
			logger.info("안에 컬럼이 몇개인가요? "+rMap.size());
			logger.info("어떻게 담겼나요? "+rMap);
			logger.info("사원번호="+rMap.get("사원번호"));
			logger.info("사원명="+rMap.get("사원명"));
			logger.info("연봉="+rMap.get("연봉"));
			logger.info("인센티브="+rMap.get("인센티브"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	/********************************************************************
	 * [ 도서 검색 서비스 구현 ]
	 * @author 이정렬
	 * @param pMap : 도서명, 저자, 출판사
	 * @return bookList - select결과 - 유지 - index_book.jsp
	 ********************************************************************/
	public List<Map<String,Object>> getBookList(Map<String,Object> pMap){
		logger.info("getBookList 호출 성공");
		List<Map<String,Object>> bookList = null;
		
		try {
			//InputStream 대신 Reader class사용 : 한글바이트때문 ( 메뉴얼2페이지  하단 )
			Reader reader = null;//2byte단위로 처리하는 reader클래스(한글-2byte)
			reader = Resources.getResourceAsReader(resource);
	        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	        sqlSes 	  = sqlMapper.openSession();
	        reader.close();
	        
	        //단위테스트 : Map을 준비하자
	        pMap = new HashMap<String,Object>();
	        pMap.put("param_text", "계산");
	        	//동적쿼리문의 ?에 해당하는 내용.
	        	//작성해둔 쿼리문의 #{ }와 일치하는 키값이어야 sqlSession의 파라미터로 집어넣을 수 있다.
	        
	        //쿼리문을 담고있는 xml문서에 설정한 내용이 반영됨	//selectOne() sql을 요청하되, 1건을 조회하는 메소드 
	    //	resultType 		   name = sqlSession.selectOne("id", parameterType);
	        Map<String,Object> rMap = sqlSes.selectOne("myBatisTest", pMap);
	        logger.info(rMap.get("val"));
	        bookList = new ArrayList<Map<String,Object>>();
	        bookList.add(rMap);
	        logger.info(bookList.get(0).get("val"));
	        
	        //단위테스트2 : 두번째 sql 테스트해보기
	        Map<String,Object> rMap2 = sqlSes.selectOne("currentTime", pMap);
	        logger.info("여기까진 오셨수?");
	        logger.info(rMap2.size());
	        logger.info(rMap2);
	        logger.info(rMap2.get("curDay"));//MyBatis는 더블쿼테이션(")이 있으면 그대로 사용한다
	        logger.info(rMap2.get("CURDAY"));//MyBatis는 더블쿼테이션(")이 없는 모든 컬럼명을 대문자로 변환한다
	        logger.info(rMap2.get("curday"));//그러므로 이 타입은 없으며, 같은 값이 같은 키에 두번 담기므로 사이즈는 2개
	        logger.info(rMap2.get("한글은되세요?"));//한글도 가능
	       
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	//입력
	/********************************************************************
	 * [ 도서 정보 입력 서비스 구현 ]
	 * @author 이정렬
	 * @param pMap : 도서명, 저자명, 도서가격, 출판사, 출판일, 
	 * @return int=0 : 등록실패 / int=1 : 등록성공
	 ********************************************************************/
	public int getBookInsert(Map<String,Object> pMap){
		logger.info("getBookInsert 호출 성공");
		int result = 0;
		return result;
	}
	//수정
	/********************************************************************
	 * [ 도서 정보 수정 서비스 구현 ]
	 * @author 이정렬
	 * @param pMap : 도서명, 저자명, 도서가격, 출판사, 출판일, 
	 * @return int=0 : 수정실패 / int=1 : 수정성공
	 ********************************************************************/
	public int getBookUpdate(Map<String,Object> pMap){
		logger.info("getBookUpdate 호출 성공");
		int result = 0;
		return result;
	}

	//삭제
	/********************************************************************
	 * [ 도서 정보 삭제 서비스 구현 ]
	 * @author 이정렬
	 * @param pMap : 도서명, 저자명, 도서가격, 출판사, 출판일, 
	 * @return int=0 : 삭제실패 / int=1 : 삭제성공
	 ********************************************************************/
	public int getBookDelete(Map<String,Object> pMap){
		logger.info("getBookDelete 호출 성공");
		int result = 0;
		return result;
	}
}