package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*****************************************************************************************
 * [[[ Cookie Manager ]]]
 * @version
 * 		<br>1.5
 * 		<br>�� bindCookies
 * 		<br>1.4
 * 		<br>�� isNumber() �߰� : �Ǽ� �� ������ ���� ���ڿ� Ȯ��+���ڵ�+���ڵ� �� �Ϻ� ����
 * 		<br>1.3
 * 		<br>�� showAllCookieList() �߰�
 * 		<br>1.2
 * 		<br>�� ��Ű����� �����ε� �޼ҵ� �߰�
 * 		<br>1.1
 * 		<br>�� ��ȿ�ð����� , ��μ��� �߰�
 * 		<br>1.0
 * 		<br>�� ���ʹ���
 * @author
 * 		Jeongryoel Lee(������)
 * 		<br>�׽��� : ����, ������
 * 
 * @�ȳ����� ���� ���ϴ� ��ɸ� ���ļ� �н��ϱ� �����մϴ�.
 * <br>�Ʒ� ������� �����Ǿ� �ֽ��ϴ�.
 * <br>��ũ�� Ŭ���ؼ� �����ּ��� Ȯ���Ͻñ� �ٶ��ϴ�.
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @������ �ν��Ͻ�ȣ��
 * <br>{@linkplain #CookieMgr(HttpServletRequest req, HttpServletResponse res)}
 * <br>request/responser��ü �������� �ʱ�ȭ
 * <br>������ ��Ű�� �ʿ� ���
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @Ȯ���ϱ�_1	�̸�����_����Ȯ��
 * <br>{@linkplain #checkCookie(String targetCookieName)}
 * <br>return : boolean
 * @Ȯ���ϱ�_2	���_��Ű_����ϱ�_�ܼ�â
 * <br>{@linkplain #showAllCookie_console()}
 * <br>retrun : void
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @����1	��Ű_�����
 * <br>{@linkplain #setCookie(String cookieName, String value)}
 * <br>return : void
 * @����2	��Ű_�����+�ð�
 * <br>{@linkplain #setCookie(String cookieName, String value, int maxAge)}
 * <br>return : void
 * @����3	��Ű_�����_�ð�_���
 * <br>{@linkplain #setCookie(String cookieName, String value, int maxAge, String path)}
 * <br>return : void
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @�б�1	�̸�����_��Ű�ּҹ���_�б�
 * <br>{@linkplain #getCookie(String targetCookieName)}
 * <br>return : Cookie
 * @�б�2	�̸�����_��Ű��_�б�	
 * <br>{@linkplain #getCookieValue(String targetCookieName)}
 * <br>return : String
 * @�б�3	������_��Ű�̸�_�б�
 * <br>{@linkplain #getCookieNameFromValue(String targetCookieName)}
 * <br>return : String
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @����	�̸�����_��_�����ϱ�
 * <br>{@linkplain #changeCookieValue(String targetCookieName, String newValue)}
 * <br>return : int
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @����	�̸�����_�����ϱ�
 * <br>{@linkplain #deleteCookie(String targetCookieName)}
 * <br>return : int
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @�ð�1	�̸�����_��ȿ�ð�_�����ϱ�
 * <br>{@linkplain #setCookieAge(String targetCookieName, int second)}
 * <br>return : int
 * @�ð�2	�̸�����_��ȿ�ð�_�˾Ƴ���
 * <br>{@linkplain #getCookieAge(String targetCookieName)}
 * <br>return : int
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @���1	�̸�����_�������_�����ϱ�
 * <br>{@linkplain #setCookiePath(String targetCookieName, String path)}
 * <br> : Cookie
 * @���2	�̸�����_�������_�˾Ƴ���
 * <br>{@linkplain #getCookiePath(String targetCookieName)}
 * <br> : String
 * <br>������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
 * @����_��������_�˾Ƴ���
 * <br>{@linkplain #isNumber(String value)}
 * <br> : boolean
 *****************************************************************************************/
public class CookieMgr {
	Logger logger = Logger.getLogger(CookieMgr.class);//�α�
	//�������� ���Թ��� ��û��ü(request)�� ���䰴ü(response) 
	HttpServletRequest  req = null;
	HttpServletResponse res = null;
	private Map<String,Cookie> cookieMap = new HashMap<>();//��Ű��� Map
	private List<Map<String,Cookie>> cookieList = null;
	
//����������������������������������������������������������������������������������������������������������
	
	/**************************************************
	 * [[ ������ ]] �ν��Ͻ��Ҷ� �Ķ���Ϳ� ��Ű�� �Է�, ��� �ʿ� ���� 
	 * @param req : ���������� ���Թ��� ��û ��ü
	 * @param res : ���������� ���Թ��� ���� ��ü
	 **************************************************/
	public CookieMgr(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;	//���������� �ʱ�ȭ
		this.res = res;	//���������� �ʱ�ȭ
		
		Cookie[] cs = req.getCookies();//��û��ü�κ��� ��ü��Ű �迭�� ��ȯ
		if(cs!=null)
			for(int i=0;i<cs.length;i++)
				cookieMap.put(cs[i].getName(),cs[i]); //Map�� ���(��Ű�̸�:��)
	}
	/*******************************************************************
	 * [[ ��Ű�̸����� ���� Ȯ���ϱ� ]]
	 * @param	targetCookieName : ã�� ��Ű �̸�
	 * @return	boolean : true(������) / false(����)
	 *******************************************************************/
	public boolean checkCookie(String targetCookieName) {
		boolean isExist = cookieMap.get(targetCookieName)!=null;//��������� true, ������ false
		if(isExist) {
			logger.info("[[��Ű�α�]] checkCookie : "+isExist+" | '"+targetCookieName+"' ��� ��Ű�� �����մϴ�");
			return isExist;
		}
		logger.info("[[��Ű�α�]] checkCookie : "+isExist+" | '"+targetCookieName+"' ��� ��Ű�� ã�� �� ���׿�");
		return isExist;
	}
	
//����������������������������������������������������������������������������������������������������������
	
	/*******************************************************************
	 * [[ ���� ���䰴ü�� ��ϵ� ��� ��Ű�� �ܼ�â�� ����ϱ� ]]	
	 * @return	void : �ܼ�â���� Ȯ���ϴ� �뵵�̹Ƿ� ���ϰ��� ����ֽ��ϴ�.
	 *******************************************************************/
	public void showAllCookie_console() throws IOException{
		logger.info("");
		logger.info("	[[ ��Ű�Ŵ��� ]] �� ���� response�� ��ϵ� ��� ��Ű ����Ʈ");
		logger.info("	[[ ��Ű�Ŵ��� ]] ------------------------------------");
		logger.info("	[[ ��Ű�Ŵ��� ]]	.   |	��Ű�̸�	: ��Ű��");
		logger.info("	[[ ��Ű�Ŵ��� ]] ====================================");
		String getCookieName, getCookieValue;
		int count = 0;
		for (Entry<String, Cookie> entry : cookieMap.entrySet()) {
			getCookieName  = URLDecoder.decode(entry.getValue().getName().toString(),"UTF-8");
			if("JSESSIONID".equals(getCookieName)) continue;
			getCookieValue = URLDecoder.decode(entry.getValue().getValue().toString(),"UTF-8");
			logger.info("		[[ ��Ű�Ŵ��� ]]	"+(++count)+"   |	"+getCookieName+"	: "+getCookieValue);
		}
		logger.info("	[[ ��Ű�Ŵ��� ]] ------------------------------------");
		logger.info("");
	}
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[ ��Ű ����� ]]
	 * @param	cookieName : ������ ��Ű �̸�
	 * @param	value : ������ ��Ű�� ���� ��
	 * @return	void : res��ü�� ���� ��� ��ȯ�� ���� ����
	 *******************************************************************/
	public void setCookie(String cookieName, String value) throws IOException	{
		Cookie cookie = null;//�����϶��� ���ڵ��ϵ��� ����
		if(isNumber(value)) { cookie = new Cookie(cookieName, value); }
		else { cookie = new Cookie(cookieName, URLEncoder.encode(value,"UTF-8")); }
		res.addCookie(cookie);//���䰴ü�� ����
		cookieMap.put(cookie.getName(),cookie);//�ʿ� ����
		logger.info("[[ ��Ű�Ŵ��� ]] ��Ű�� ���䰴ü�� �����ϴ�. / "+cookieName+":"+value+"			������-�����Ű���� : showAllCookie_console();");
		showAllCookie_console();
	}
	/*******************************************************************
	 * [[ ��Ű ����� +�ð� ]]
	 * @param	cookieName : ������ ��Ű �̸�
	 * @param	value : ������ ��Ű�� ���� ��
	 * @param	maxAge : ������ ��Ű�� ������ ��ȿ�ð�
	 * @return	void : res��ü�� ���� ��� ��ȯ�� ���� ����
	 *******************************************************************/
	public void setCookie(String cookieName, String value, int maxAge) throws IOException	{
		Cookie cookie = null;//�����϶��� ���ڵ��ϵ��� ����
		if(isNumber(value)) { cookie = new Cookie(cookieName, value); }
		else { cookie = new Cookie(cookieName, URLEncoder.encode(value,"UTF-8")); }
		cookie.setMaxAge(maxAge);//��ȿ�ð�����
		res.addCookie(cookie);//���䰴ü�� ����
		cookieMap.put(cookie.getName(),cookie);//�ʿ� ����
		logger.info("[[ ��Ű�Ŵ��� ]] ��Ű�� ���䰴ü�� �����ϴ�. / "+cookieName+":"+value+"			������-�����Ű���� : showAllCookie_console();");
		showAllCookie_console();
	}
	/*******************************************************************
	 * [[ ��Ű ����� +�ð�,��� ]]
	 * @param	cookieName : ������ ��Ű �̸�
	 * @param	value : ������ ��Ű�� ���� ��
	 * @param	maxAge : ������ ��Ű�� ������ ��ȿ�ð�
	 * @param	path : ������ ��Ű�� ������ ���
	 * @return	void : res��ü�� ���� ��� ��ȯ�� ���� ����
	 *******************************************************************/
	public void setCookie(String cookieName, String value, int maxAge, String path) throws IOException	{
		Cookie cookie = null;//�����϶��� ���ڵ��ϵ��� ����
		if(isNumber(value)) { cookie = new Cookie(cookieName, value); }
		else { cookie = new Cookie(cookieName, URLEncoder.encode(value,"UTF-8")); }
		cookie.setMaxAge(maxAge);//��ȿ�ð�����
		cookie.setPath(path);//��μ���
		res.addCookie(cookie);//���䰴ü�� ����
		cookieMap.put(cookie.getName(),cookie);//�ʿ� ����
		logger.info("[[ ��Ű�Ŵ��� ]] ��Ű�� ���䰴ü�� �����ϴ�. / "+cookieName+":"+value+"			������-�����Ű���� : showAllCookie_console();");
		showAllCookie_console();
	}
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[ ��Ű�̸����� ��Ű �ּҹ��� �б� ]]
	 * @param	targetCookieName : ã�� ��Ű �̸�
	 * @return	Cookie : ã�� ��Ű�� �ּҹ���
	 *******************************************************************/
	public Cookie getCookie(String targetCookieName){
		Cookie ckAddr = cookieMap.get(targetCookieName);
		logger.info("[[ ��Ű�Ŵ��� ]] getCookie = "+ckAddr);
		return ckAddr;
	}
	/*******************************************************************
	 * [[ ��Ű�̸����� ��Ű �� �б� ]]
	 * @param	targetCookieName : ã�� ��Ű �̸�
	 * @return	String : ã�� ��Ű�� ��� �� ( UTF-8 ���ڵ� �Ϸ� )
	 *******************************************************************/
	public String getCookieValue(String targetCookieName) throws IOException{
		Cookie cookie = cookieMap.get(targetCookieName);//��Ű�ʿ��� �ش���Ű����
		if(cookie!=null) {
			if(isNumber(targetCookieName)) {//���ڸ� ���ڵ��� ���մϴ�.
				String ckValue = cookie.getValue();
				logger.info("[[ ��Ű�Ŵ��� ]] getCookieValue = "+ckValue);
				return ckValue;
			}else {//�����϶� ���ڵ��մϴ�.
				String ckValue = URLDecoder.decode(cookie.getValue(),"UTF-8");
				logger.info("[[ ��Ű�Ŵ��� ]] getCookieValue = "+ckValue);
				return ckValue;
			}
		} else {
			logger.info("[[ ��Ű�Ŵ��� ]] ���� ������ �����ϴ� / targetCookieName = "+targetCookieName);
		}
		logger.info("[[ ��Ű�Ŵ��� ]] �� �б� �����߽��ϴ�.  null�� ��ȯ�մϴ�.");
		return null;
	}
	/*******************************************************************
	 * [[ ��Ű������ ��Ű �̸�  �б� ]]
	 * @param	targetCookieValue : ã�� ��Ű��
	 * @return	String : ã�� ��Ű�� �̸�
	 *******************************************************************/
	public String getCookieNameFromValue(String targetCookieValue) throws IOException{
		if(targetCookieValue==null) {
			logger.info("[[ ��Ű�Ŵ��� ]] ã���� �ϴ� ��Ű�� ���� ����ֽ��ϴ�.(null) �ٽ�Ȯ�����ּ���. ");
			return null;
		} else {
			logger.info("[[ ��Ű�Ŵ��� ]] ��Ű�� �˻��մϴ�. / ��� ��Ű�� = "+targetCookieValue);
		}
		String getCookieValue = null; 
		for (Entry<String, Cookie> entry : cookieMap.entrySet()) {
			getCookieValue = entry.getValue().getValue();//��Ű�ʿ��� �о ��Ű��
			if(targetCookieValue.equals(getCookieValue)){
				String getCookieName = entry.getValue().getName().toString();
				logger.info("[[ ��Ű�Ŵ��� ]] ��Ű�� �˻��Ǿ����ϴ�. / �˻� ��Ű�̸� = "+getCookieName);
				return entry.getKey();
			}
		}
		logger.info("[[ ��Ű�Ŵ��� ]] ��Ű�˻������ �����ϴ�.");
		return null;
	}
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[ ��Ű�̸����� �ش� ��� ���� �����ϱ� ]]
	 * @param	targetCookieName : ������ ��Ű �̸�
	 * @param	newValue : ������ ��Ű ��
	 * @return	Cookie : ���� ����� ��Ű
	 *******************************************************************/
	public int changeCookieValue(String targetCookieName, String newValue) throws IOException {
		if(checkCookie(targetCookieName)) {
			setCookie(targetCookieName,newValue);
			logger.info("[[ ��Ű�Ŵ��� ]] ���泻�� / targetCookieName = "+targetCookieName+"/ newValue : "+newValue);
			return 1;//�������� �ܼ�â�� ����ϰ� �������� 1�� ��ȯ��
		} else {
			logger.info("[[ ��Ű�Ŵ��� ]] ���泻���� �����ϴ� / targetCookieName = "+targetCookieName);
		}
		return 0;//������ �������� �ܼ�â�� ����ϰ� �������� 0���� ��ȯ��
	}
	
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[ ��Ű �̸����� �ش���Ű �����ϱ� ]]
	 * @param	targetCookieName : ��������ϴ� ��Ű �̸�
	 * @return	int : 1 (��Ű��������) / 0 (��Ű��������)
	 *******************************************************************/
	public int deleteCookie(String targetCookieName) throws IOException{
		if(checkCookie(targetCookieName)) {
			Cookie cookie_del = cookieMap.get(targetCookieName);//��Ű�ʿ��� ��������ϴ� ��Ű�� ����
			cookie_del = new Cookie(targetCookieName,"");
			cookie_del.setMaxAge(0);
			res.addCookie(cookie_del);
			logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� �����߽��ϴ�.");
			return 1;//�����Ű�� �����ϸ� ������ �α���� �� 1�� ��ȯ
		} else {
			logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� �����ϴ�. ������ �����߽��ϴ�.");
		}
		return 0;//�����Ű�� �������� ������ ������ �����ϰ�  �α���� �� 0�� ��ȯ
	}
	
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[ ��Ű�̸����� ��ȿ�ð� �����ϱ� ]]
	 * @param	targetCookieName : ��� ��Ű �̸�
	 * @param	second : �����ϰ����ϴ� ��ȿ�ð� (��)
	 * @return	int : 1 (�ð���������) / 0 (�ð���������)
	 *******************************************************************/
	public int setCookieAge(String targetCookieName,int second) {
		Cookie cookie_age = cookieMap.get(targetCookieName);//��Ű�ʿ��� �����ϰ��� �ϴ� ��Ű�� ����
		if(cookie_age!=null) {
			cookie_age.setMaxAge(second);
			res.addCookie(cookie_age);
			logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� ����� ��ȿ�ð� : "+cookie_age.getMaxAge());
			return 1;//��� ��Ű�� �����ϸ� ��ȿ�ð� ������ 1�� ��ȯ
		} else {
			logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� �����ϴ�.");
		}
		return 0;//��� ��Ű�� �������� ������ 0�� ��ȯ
	}
	/*******************************************************************
	 * [[ ��Ű�̸����� ��ȿ�ð� �˾Ƴ��� ]]
	 * @param	targetCookieName : ��� ��Ű �̸�
	 * @return	int : ������ ��ȿ�ð� (��)
	 *******************************************************************/
	public int getCookieAge(String targetCookieName) {
		Cookie cookie = cookieMap.get(targetCookieName);//��Ű�ʿ��� �ش���Ű����
		int ckAge = cookie.getMaxAge();//������ ��ȿ�ð��� ��ȯ
		logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� ��ȿ�ð� : "+ckAge);
		return ckAge;//������ ��ȿ�ð��� ��ȯ
	}
	
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[ ��Ű�̸����� ��μ����ϱ� ]]
	 * @param	targetCookieName : ��� ��Ű �̸�
	 * @param	path : ������ ��Ű �������
	 * @return	int : 1 (��������) / 0 (��������)
	 *******************************************************************/
	public int setCookiePath(String targetCookieName, String path) throws IOException	{
		Cookie cookie_path = cookieMap.get(targetCookieName);
		if(cookie_path!=null) {
			cookie_path.setPath(path);
			res.addCookie(cookie_path);
			logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� ����� ��� : "+cookie_path.getPath());
			return 1;//��� ��Ű�� �����ϸ� ��ȿ�ð� ������ 1�� ��ȯ
		} else {
			logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� �����ϴ�.");
		}
		return 0;//�����Ű�� �������� ������ 0�� ��ȯ
	}
	/*******************************************************************
	 * [[ ��Ű�̸����� ��� �˾Ƴ��� ]]
	 * @param	targetCookieName : ��� ��Ű �̸�
	 * @return	String : ������ ��� 
	 *******************************************************************/
	public String getCookiePath(String targetCookieName) {
		Cookie cookie_Path = cookieMap.get(targetCookieName);//��Ű�ʿ��� �ش���Ű����
		String ckPath = cookie_Path.getPath();//������ ��Ű�����θ� ��ȯ
		logger.info("[[ ��Ű�Ŵ��� ]] '"+targetCookieName+"' ��Ű�� ��� : "+ckPath);
		return ckPath;//������ ��Ű�����θ� ��ȯ
	}
	
	
//����������������������������������������������������������������������������������������������������������
	
	
	/*******************************************************************
	 * [[��Ű������ �Էµ� ���ڿ��� �������� �������� �Ǵ��ϱ�]]
	 * @param	value : �Ǻ����
	 * @return	result : ���ڸ� true / ���ڸ� false�� ��ȯ
	 *******************************************************************/
	public boolean isNumber(String value) {
		char 	tempCh;
	    int 	dotCount = 0;//�Ǽ��� ��� .�� ������ üũ�ϴ� ����
	    boolean result = true;

	    for (int i=0; i<value.length(); i++){
			tempCh= value.charAt(i);//�Է¹��� ���ڿ��� ���ڴ����� �˻�
			//�ƽ�Ű �ڵ� ���� 45�̸� '-'���ڷ�, ������ �ȴ�.
			if((int)tempCh==45) return true;
			//�ƽ�Ű �ڵ� ���� 48 ~ 57���̸� 0�� 9������ �����̴�.
			if ((int)tempCh < 48 || (int)tempCh > 57){//0~9������ ���ڰ� �ƴϰ�
				if(tempCh!='.' || dotCount > 0){		//'.'�� �ƴϰų� '.'�� ������ �̹� 1�� �̻��̶��
					result = false;			  		// �� ���ڿ��� ���ڰ� �ƴϴ�.
					break;
				}else{//.�� ��� .���� ����
					dotCount++;
				}
			}
	    }
	    return result;
	}
	
	
	/**
	 * [[ Ư�� ���ڿ��� �����ϴ� ��Ű�� �ʿ� ��� ��ȯ�ϱ� ]]
	 * @param	certainName : ��Ű�̸� �˻��� ����� ���ǹ��ڿ�
	 * @return	rCkMap : ���ǿ� �ش��ϴ� ��Ű��
	 */
	public Map<String,Cookie> addCookieBasket(String certainName){
		String guide = (.contains(certainName));
		for(String str : cookieMap.keySet()) {
			
		}
		return null;
	}
}
