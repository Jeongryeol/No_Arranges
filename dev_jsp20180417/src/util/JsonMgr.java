package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
/****************************************************************************************************************
 * [[ 순서가 필요없는 데이터들을 문자열로 관리하고자 할때 사용하는 JSON매니저 ]]
 * @author	Jeongryeol Lee
 * <br>─────────────────────────────────────────────────────────────────────────────────────────────────────────
 * @List에서_JSON만들기
 * 		{@linkplain #getJSONfromLIST(List plist)}
 * <br>	return : JSON문자열
 * <br>─────────────────────────────────────────────────────────────────────────────────────────────────────────
 * @JSON에서_List만들기
 * 		{@linkplain #getListFromJSON(String jsonString)}
 * <br>	return : JSON문자열
 ****************************************************************************************************************/
public class JsonMgr {

	Logger logger = Logger.getLogger(CookieMgr.class);//로그
	Gson gs = new Gson();
	List<Map<String,Object>> savedList = null;
	
	/************************************************************************************************************
     * [[ List에서 JSON문자열 얻기 ]] : DB에서 조회된 결과 혹은 장바구니에 담은 내용들을 문자열로 변경할때 유용
     * @param	plist : List자료형
     * @return	String : JSON문자열
     ************************************************************************************************************/
    public String getJSONfromLIST(List<Map<String, Object>> plist) {
    	String jsonString = gs.toJson(plist);//List를 JSON으로 바꿈
    	logger.info("	[[ JsonMgr ]] jsonString = "+jsonString);
    	return jsonString;
    }
    
    /************************************************************************************************************
     * [[ JSON문자열로부터 List얻기 ]] : 화면에서 넘어온 JSON문자열 값에 접근하고자할때 List로 변환하여 사용
     * @param	jsonString : JSON문자열
     * @return	jsonList : List자료형
     ************************************************************************************************************/
    public List<Map<String,Object>> getListFromJSON(String jsonString){
    	List<Map<String,Object>> jsonList = gs.fromJson(jsonString, List.class);//JSON으로부터 List를 얻음
    	setJsonList(jsonList);
    	logger.info("	[[ JsonMgr ]] jsonlist = "+jsonList);
    	return jsonList;
    }
    
    public void setJsonList(List<Map<String, Object>> plist) {
    	this.savedList = plist;
    }
    
    //테스트용 메인메소드
	public static void main(String[] args) {
		JsonMgr jm = new JsonMgr();
		
		//List와 Map에서 JSON문자열을 생성하는 구문
		List<Map<String, Object>> plist = new ArrayList<>();
		Map<String, Object> pMap = new LinkedHashMap<String,Object>();
		pMap.put("mem_no", "1");
		pMap.put("mem_id", "test");
		pMap.put("mem_pw", "0000");
		pMap.put("mem_name", "테스트계정");
		plist.add(pMap);
		
		//JSON문자열 얻기
		String jsonString = jm.getJSONfromLIST(plist);
		
		//JSON List 얻기
		List<Map<String,Object>> jsonList = jm.getListFromJSON(jsonString);
		
		//JSON List에서 값읽어내기			▼row number	▼column name
		System.out.println(jsonList.get(0).get("mem_no"));
		System.out.println(jsonList.get(0).get("mem_id"));
		System.out.println(jsonList.get(0).get("mem_pw"));
		System.out.println(jsonList.get(0).get("mem_name"));
		
	}
}
