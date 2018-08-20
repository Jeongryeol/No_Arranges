package com.ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class LoginServlet extends HttpServlet {

	//로그객체 준비
	Logger logger = Logger.getLogger(LoginServlet.class);
	
	//수행메소드
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		HttpSession session = req.getSession();	//요청객체로부터 세션객체얻기
		Cookie cookies[] = req.getCookies();	//요청객체로부터 쿠키배열 얻기
		
		Map<String,Object> pMap
				= new HashMap<String,Object>();	//빈 Map계열 자료형 준비
		HashMapBinder hmb
				= new HashMapBinder(req);//공통코드 Binder클래스에 요청객체 원본주소 저장
		hmb.bind(pMap);					 //bind()로 Map계열 자료형 보내고 저장하기
		
		//Map계열 자료형을 <key>로 꺼내서 Set계열 자료형으로 변환하고,
		//이 Set계열 자료형을 객체타입 배열로 반환하여 저장하기 
		Object keys[] = pMap.keySet().toArray();
		
		//단위테스트 : 로그를 통해 웹에서 넘어온 키와 값을 확인하기
		for(int i=0;i<keys.length;i++) {
			String key = (String)keys[i];//저장된 키배열의 각 방에 담긴 키값을 저장하고
			logger.info("pMap.get("+key+")="
						+pMap.get(key)); //저장된 키값으로 반환하는 내용을 로그로 확인하기
		}
		//단위테스트 : 배열의 길이 로그
		logger.info("배열의 길이 : "+keys.length);		
		
		//단위테스트 : 웹화면에 출력하기
		PrintWriter out = res.getWriter();
		res.setContentType("text/html;charset=euc-kr");
		out.print("<b>fin.....</b>");
	}
	
	@Override //GET방식
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req, res);
	}
	
	@Override //POST방식
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req, res);
	}
}
