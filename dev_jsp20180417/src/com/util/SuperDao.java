package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SuperDao {
	SqlSession session = new SuperDao_DBCon_MyBatis().getSqlSession();
	String tableName;

	SuperDao(String tableName) {
		this.tableName = tableName;
	}

	/************************
	 * @author 박의
	 * @explain 생성자로 넘어온 테이블의 컬럼이름과 컬럼타입을 가져올수 있는 메소드
	 * @return [{CNAME = 컬럼명},{TYPE = 컬럼타입}]
	 ************************/
	public List<Map<String, String>> columns() {
		tableName = tableName.toUpperCase();
		List<Map<String, String>> tables = session.selectList("mybatis.superMapper.selectCol", tableName);
		return tables;
	}

	/************************
	 * @author 박의
	 * @explain 들어온 map을 조건에 맞는 값 하나를 보여줌
	 * @param map
	 * @return map
	 ************************/
	public Map<String, Object> findOne(Map<String, Object> map) {
		map = find(map).get(0);
		return map;
	}

	/************************
	 * @author 박의
	 * @explain 들어온 정보 map 정보를 가지고 맞는 모든 데이터 값을 보여줌
	 * @param map
	 * @return list
	 ************************/
	public List<Map<String, Object>> find(Map<String, Object> map) {
		map.put("tableName", tableName);
		List<Map<String, Object>> list = session.selectList("mybatis.superMapper.find", map);
		return list;
	}

	/************************
	 * @author 박의
	 * @explain like로 만들어 조금이라도 들어있는 모든 정보를 가져와서 보여줌 // 대소문자 구분없이 검색가능
	 * @param value
	 * @return list
	 ************************/
	public List<Map<String, Object>> findRegex(String value) {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, String>> list = columns();
		for (Map<String, String> map2 : list) {
			map.put(map2.get("CNAME"), value);
		}
		map.put("tableName", tableName);
		List<Map<String, Object>> lists = session.selectList("mybatis.superMapper.findRegex", map);
		return lists;
	}

	/**********************
	 * @author 박의
	 * @explain map의 조건대로 테이블에 값을 넣어줌 map 에는 column명과 넣고싶은 값을 넣어야함 //단, not null인
	 *          부분은 꼭 넣어주어야 한다
	 * @param map
	 * @return int
	 **********************/
	public int create(Map<String, Object> map) {
		int result = 0;
		map.put("tableName", tableName);
		try {
			result = session.insert("mybatis.superMapper.create", map);
			if (result == 1) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제대로 된 값이 들어가지 못했어요"); // 대부분 null 값을 받을수 없는 데이터에 null을 넣었거나 //타입이 잘못되는 경우이다
			System.out.println("not null에 null이 들어 갔거나  값과 테이블의 타입달라요");
			result = 0;
		}
		return result;
	}
	/************************
	 * @author 박의
	 * @explain 식별자로 먼저 검색을 진행한후 조회가된 로우의 데이터를 수정한다
	 * @param keyId - 식별자의 컬럼명
	 * @param valueId - 식별자의 값
	 * @param pmap - 바꾸고자 하는 내용을 넣기
	 * @return int 성공하면 1 실패하면 0
	 ************************/
	public int update(String keyId, String valueId, Map<String,Object> pmap) {
		int result = 0;
		pmap.put("tableName", tableName);
		pmap.put("keyId", keyId);
		pmap.put("valueId", valueId);
		result = session.update("mybatis.superMapper.update",pmap);
		if(result != 0) {
			session.commit();
		}
		return result;
	}

	/***********************
	 * @author 박의
	 * @explain 삭제코드입니다.
	 * @param keyId - 바꾸고자 하는 로우의 컬럼명
	 * @param valueId - 바꾸고자 하는 로우의 컬럼값
	 * @return int 1이면 성공 0이면 실패
	 ***********************/
	public int remove(String keyId, String valueId) {
		int result = 0;
		Map<String,Object> map = new HashMap<>();
		map.put("keyId", keyId);
		map.put("valueId", valueId);
		map.put("tableName", tableName);
		result = session.delete("mybatis.superMapper.remove",map);
		if(result != 0) {
			session.commit();
		}
		return result;
	}

	public static void main(String[] args) {
		SuperDao sDao = new SuperDao("member");
		Map<String,Object> map = new HashMap<>();
		map.put("mem_name","테스");
		System.out.println(sDao.update("mem_no","2",map));
	}
}
