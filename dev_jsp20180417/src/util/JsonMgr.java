package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
/****************************************************************************************************************
 * [[ ������ �ʿ���� �����͵��� ���ڿ��� �����ϰ��� �Ҷ� ����ϴ� JSON�Ŵ��� ]]
 * @author	Jeongryeol Lee
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @List����_JSON�����
 * 		{@linkplain #getJSONfromLIST(List plist)}
 * <br>	return : JSON���ڿ�
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @JSON����_List�����
 * 		{@linkplain #getListFromJSON(String jsonString)}
 * <br>	return : JSON���ڿ�
 ****************************************************************************************************************/
public class JsonMgr {

	Logger logger = Logger.getLogger(CookieMgr.class);//�α�
	Gson gs = new Gson();
	List<Map<String,Object>> savedList = null;
	
	/************************************************************************************************************
     * [[ List���� JSON���ڿ� ��� ]] : DB���� ��ȸ�� ��� Ȥ�� ��ٱ��Ͽ� ���� ������� ���ڿ��� �����Ҷ� ����
     * @param	plist : List�ڷ���
     * @return	String : JSON���ڿ�
     ************************************************************************************************************/
    public String getJSONfromLIST(List<Map<String, Object>> plist) {
    	String jsonString = gs.toJson(plist);//List�� JSON���� �ٲ�
    	logger.info("	[[ JsonMgr ]] jsonString = "+jsonString);
    	return jsonString;
    }
    
    /************************************************************************************************************
     * [[ JSON���ڿ��κ��� List��� ]] : ȭ�鿡�� �Ѿ�� JSON���ڿ� ���� �����ϰ����Ҷ� List�� ��ȯ�Ͽ� ���
     * @param	jsonString : JSON���ڿ�
     * @return	jsonList : List�ڷ���
     ************************************************************************************************************/
    public List<Map<String,Object>> getListFromJSON(String jsonString){
    	List<Map<String,Object>> jsonList = gs.fromJson(jsonString, List.class);//JSON���κ��� List�� ����
    	setJsonList(jsonList);
    	logger.info("	[[ JsonMgr ]] jsonlist = "+jsonList);
    	return jsonList;
    }
    
    public void setJsonList(List<Map<String, Object>> plist) {
    	this.savedList = plist;
    }
    
    //�׽�Ʈ�� ���θ޼ҵ�
	public static void main(String[] args) {
		JsonMgr jm = new JsonMgr();
		
		//List�� Map���� JSON���ڿ��� �����ϴ� ����
		List<Map<String, Object>> plist = new ArrayList<>();
		Map<String, Object> pMap = new LinkedHashMap<String,Object>();
		pMap.put("mem_no", "1");
		pMap.put("mem_id", "test");
		pMap.put("mem_pw", "0000");
		pMap.put("mem_name", "�׽�Ʈ����");
		plist.add(pMap);
		
		//JSON���ڿ� ���
		String jsonString = jm.getJSONfromLIST(plist);
		
		//JSON List ���
		List<Map<String,Object>> jsonList = jm.getListFromJSON(jsonString);
		
		//JSON List���� ���о��			��row number	��column name
		System.out.println(jsonList.get(0).get("mem_no"));
		System.out.println(jsonList.get(0).get("mem_id"));
		System.out.println(jsonList.get(0).get("mem_pw"));
		System.out.println(jsonList.get(0).get("mem_name"));
		
	}
}
