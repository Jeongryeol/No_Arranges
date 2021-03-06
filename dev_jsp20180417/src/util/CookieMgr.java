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
 * 
 * @version <br>
 *          1.5 <br>
 *          Ⅰ bindCookies <br>
 *          1.4 <br>
 *          Ⅰ isNumber() 蹺陛 : 褒熱 塽 擠熱縑 渠и 僥濠翮 �挫�+檣囀註+蛤囀註 諼 橾睡 熱薑 <br>
 *          1.3 <br>
 *          Ⅰ showAllCookieList() 蹺陛 <br>
 *          1.2 <br>
 *          Ⅰ 瓔酈虜菟晦 螃幗煎萄 詭模萄 蹺陛 <br>
 *          1.1 <br>
 *          Ⅰ 嶸�蕭簸ˉ麥� , 唳煎撲薑 蹺陛 <br>
 *          1.0 <br>
 *          Ⅰ 譆蟾寡ん
 * @author Jeongryoel Lee(檜薑溺) <br>
 *         纔蝶攪 : 夢曖, 檜⑷艙
 * 
 * @寰頂餌о 餌辨衛 錳ж朝 晦棟虜 り藥憮 з蝗ж望 掏濰м棲棻. <br>
 *       嬴楚 牖憮渠煎 薑葬腎橫 氈蝗棲棻. <br>
 *       葭觼蒂 贗葛п憮 撮睡輿戮擊 �挫恉牮簽� 夥奧棲棻. <br>
 *       式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @儅撩濠 檣蝶欐蝶��轎 <br>
 *      {@linkplain #CookieMgr(HttpServletRequest req, HttpServletResponse res)}
 *      <br>
 *      request/responser偌羹 瞪羲滲熱 蟾晦�� <br>
 *      儅撩脹 瓔酈蒂 裘縑 氬晦 <br>
 *      式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @�挫恉炱槂1 檜葷戲煎_襄營�挫� <br>
 *         {@linkplain #checkCookie(String targetCookieName)} <br>
 *         return : boolean
 * @�挫恉炱槂2 賅萇_瓔酈_轎溘ж晦_夔樂璽 <br>
 *         {@linkplain #showAllCookie_console()} <br>
 *         retrun : void <br>
 *         式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @儅撩1 瓔酈_虜菟晦 <br>
 *      {@linkplain #setCookie(String cookieName, String value)} <br>
 *      return : void
 * @儅撩2 瓔酈_虜菟晦+衛除 <br>
 *      {@linkplain #setCookie(String cookieName, String value, int maxAge)}
 *      <br>
 *      return : void
 * @儅撩3 瓔酈_虜菟晦_衛除_唳煎 <br>
 *      {@linkplain #setCookie(String cookieName, String value, int maxAge, String path)}
 *      <br>
 *      return : void <br>
 *      式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @檗晦1 檜葷戲煎_瓔酈輿模廓雖_檗晦 <br>
 *      {@linkplain #getCookie(String targetCookieName)} <br>
 *      return : Cookie
 * @檗晦2 檜葷戲煎_瓔酈高_檗晦 <br>
 *      {@linkplain #getCookieValue(String targetCookieName)} <br>
 *      return : String
 * @檗晦3 高戲煎_瓔酈檜葷_檗晦 <br>
 *      {@linkplain #getCookieNameFromValue(String targetCookieName)} <br>
 *      return : String <br>
 *      式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @滲唳 檜葷戲煎_高_滲唳ж晦 <br>
 *     {@linkplain #changeCookieValue(String targetCookieName, String newValue)}
 *     <br>
 *     return : int <br>
 *     式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @餉薯 檜葷戲煎_餉薯ж晦 <br>
 *     {@linkplain #deleteCookie(String targetCookieName)} <br>
 *     return : int <br>
 *     式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @衛除1 檜葷戲煎_嶸�蕭簸δ撲薑ж晦 <br>
 *      {@linkplain #setCookieAge(String targetCookieName, int second)} <br>
 *      return : int
 * @衛除2 檜葷戲煎_嶸�蕭簸δ憲嬴頂晦 <br>
 *      {@linkplain #getCookieAge(String targetCookieName)} <br>
 *      return : int <br>
 *      式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @唳煎1 檜葷戲煎_儅撩唳煎_撲薑ж晦 <br>
 *      {@linkplain #setCookiePath(String targetCookieName, String path)} <br>
 *      : Cookie
 * @唳煎2 檜葷戲煎_儅撩唳煎_憲嬴頂晦 <br>
 *      {@linkplain #getCookiePath(String targetCookieName)} <br>
 *      : String <br>
 *      式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式
 * @高檜_璋濠檣雖_憲嬴頂晦 <br>
 *               {@linkplain #isNumber(String value)} <br>
 *               : boolean
 *****************************************************************************************/
public class CookieMgr {
	Logger logger = Logger.getLogger(CookieMgr.class);// 煎斜
	// む檜雖陛 輿殮嫡擎 蹂羶偌羹(request)諦 擬港偌羹(response)
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	private Map<String, Cookie> cookieMap = new HashMap<>();// 瓔酈氬朝 Map
	private List<Map<String, Cookie>> cookieList = null;

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/**************************************************
	 * [[ 儅撩濠 ]] 檣蝶欐蝶й陽 だ塭嘐攪縑 瓔酈蒂 殮溘, 闊衛 裘縑 氬擠
	 * 
	 * @param req : 壎む檜雖陛 輿殮嫡擎 蹂羶 偌羹
	 * @param res : 壎む檜雖陛 輿殮嫡擎 擬港 偌羹
	 **************************************************/
	public CookieMgr(HttpServletRequest req, HttpServletResponse res) {
		this.req = req; // 瞪羲滲熱縑 蟾晦��
		this.res = res; // 瞪羲滲熱縑 蟾晦��

		Cookie[] cs = req.getCookies();// 蹂羶偌羹煎睡攪 瞪羹瓔酈 寡翮煎 奩��
		if (cs != null)
			for (int i = 0; i < cs.length; i++)
				cookieMap.put(cs[i].getName(), cs[i]); // Map縑 氬晦(瓔酈檜葷:高)
	}

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 襄營 �挫恉炱� ]]
	 * 
	 * @param targetCookieName : 瓊擊 瓔酈 檜葷
	 * @return boolean : true(襄營л) / false(橈擠)
	 *******************************************************************/
	public boolean checkCookie(String targetCookieName) {
		boolean isExist = cookieMap.get(targetCookieName) != null;// 菟橫氈戲賊 true, 橈戲賊 false
		if (isExist) {
			logger.info("[[瓔酈煎斜]] checkCookie : " + isExist + " | '" + targetCookieName + "' 塭朝 瓔酈朝 襄營м棲棻");
			return isExist;
		}
		logger.info("[[瓔酈煎斜]] checkCookie : " + isExist + " | '" + targetCookieName + "' 塭朝 瓔酈朝 瓊擊 熱 橈啻蹂");
		return isExist;
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ ⑷營 擬港偌羹縑 蛔煙脹 賅萇 瓔酈蒂 夔樂璽縑 轎溘ж晦 ]]
	 * 
	 * @return void : 夔樂璽縑憮 �挫恉炴� 辨紫檜嘎煎 葬欐高擎 綠橫氈蝗棲棻.
	 *******************************************************************/
	public void showAllCookie_console() throws IOException {
		logger.info("");
		logger.info("	[[ 瓔酈衙棲盪 ]] ∪ ⑷營 response縑 蛔煙脹 賅萇 瓔酈 葬蝶お");
		logger.info("	[[ 瓔酈衙棲盪 ]] ------------------------------------");
		logger.info("	[[ 瓔酈衙棲盪 ]]	.   |	瓔酈檜葷	: 瓔酈高");
		logger.info("	[[ 瓔酈衙棲盪 ]] ====================================");
		String getCookieName, getCookieValue;
		int count = 0;
		for (Entry<String, Cookie> entry : cookieMap.entrySet()) {
			getCookieName = URLDecoder.decode(entry.getValue().getName().toString(), "UTF-8");
			if ("JSESSIONID".equals(getCookieName))
				continue;
			getCookieValue = URLDecoder.decode(entry.getValue().getValue().toString(), "UTF-8");
			logger.info("		[[ 瓔酈衙棲盪 ]]	" + (++count) + "   |	" + getCookieName + "	: " + getCookieValue);
		}
		logger.info("	[[ 瓔酈衙棲盪 ]] ------------------------------------");
		logger.info("");
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ 瓔酈 虜菟晦 ]]
	 * 
	 * @param cookieName : 儅撩й 瓔酈 檜葷
	 * @param value      : 儅撩й 瓔酈縑 氬擊 高
	 * @return void : res偌羹縑 氬擎 唸婁 奩�納� 匙檜 橈擠
	 *******************************************************************/
	public void setCookie(String cookieName, String value) throws IOException {
		Cookie cookie = null;// 僥濠橾陽虜 檣囀註ж紫煙 滲唳
		if (isNumber(value)) {
			cookie = new Cookie(cookieName, value);
		} else {
			cookie = new Cookie(cookieName, URLEncoder.encode(value, "UTF-8"));
		}
		res.addCookie(cookie);// 擬港偌羹縑 氬擠
		cookieMap.put(cookie.getName(), cookie);// 裘縑 氬擠
		logger.info("[[ 瓔酈衙棲盪 ]] 瓔酈陛 擬港偌羹縑 氬啣蝗棲棻. / " + cookieName + ":" + value
				+ "			≦霤堅-賅萇瓔酈爾晦 : showAllCookie_console();");
		showAllCookie_console();
	}

	/*******************************************************************
	 * [[ 瓔酈 虜菟晦 +衛除 ]]
	 * 
	 * @param cookieName : 儅撩й 瓔酈 檜葷
	 * @param value      : 儅撩й 瓔酈縑 氬擊 高
	 * @param maxAge     : 儅撩й 瓔酈縑 撲薑й 嶸�蕭簸�
	 * @return void : res偌羹縑 氬擎 唸婁 奩�納� 匙檜 橈擠
	 *******************************************************************/
	public void setCookie(String cookieName, String value, int maxAge) throws IOException {
		Cookie cookie = null;// 僥濠橾陽虜 檣囀註ж紫煙 滲唳
		if (isNumber(value)) {
			cookie = new Cookie(cookieName, value);
		} else {
			cookie = new Cookie(cookieName, URLEncoder.encode(value, "UTF-8"));
		}
		cookie.setMaxAge(maxAge);// 嶸�蕭簸ˉ麥�
		res.addCookie(cookie);// 擬港偌羹縑 氬擠
		cookieMap.put(cookie.getName(), cookie);// 裘縑 氬擠
		logger.info("[[ 瓔酈衙棲盪 ]] 瓔酈陛 擬港偌羹縑 氬啣蝗棲棻. / " + cookieName + ":" + value
				+ "			≦霤堅-賅萇瓔酈爾晦 : showAllCookie_console();");
		showAllCookie_console();
	}

	/*******************************************************************
	 * [[ 瓔酈 虜菟晦 +衛除,唳煎 ]]
	 * 
	 * @param cookieName : 儅撩й 瓔酈 檜葷
	 * @param value      : 儅撩й 瓔酈縑 氬擊 高
	 * @param maxAge     : 儅撩й 瓔酈縑 撲薑й 嶸�蕭簸�
	 * @param path       : 儅撩й 瓔酈陛 儅撩腆 唳煎
	 * @return void : res偌羹縑 氬擎 唸婁 奩�納� 匙檜 橈擠
	 *******************************************************************/
	public void setCookie(String cookieName, String value, int maxAge, String path) throws IOException {
		Cookie cookie = null;// 僥濠橾陽虜 檣囀註ж紫煙 滲唳
		if (isNumber(value)) {
			cookie = new Cookie(cookieName, value);
		} else {
			cookie = new Cookie(cookieName, URLEncoder.encode(value, "UTF-8"));
		}
		cookie.setMaxAge(maxAge);// 嶸�蕭簸ˉ麥�
		cookie.setPath(path);// 唳煎撲薑
		res.addCookie(cookie);// 擬港偌羹縑 氬擠
		cookieMap.put(cookie.getName(), cookie);// 裘縑 氬擠
		logger.info("[[ 瓔酈衙棲盪 ]] 瓔酈陛 擬港偌羹縑 氬啣蝗棲棻. / " + cookieName + ":" + value
				+ "			≦霤堅-賅萇瓔酈爾晦 : showAllCookie_console();");
		showAllCookie_console();
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 瓔酈 輿模廓雖 檗晦 ]]
	 * 
	 * @param targetCookieName : 瓊擊 瓔酈 檜葷
	 * @return Cookie : 瓊擎 瓔酈曖 輿模廓雖
	 *******************************************************************/
	public Cookie getCookie(String targetCookieName) {
		Cookie ckAddr = cookieMap.get(targetCookieName);
		logger.info("[[ 瓔酈衙棲盪 ]] getCookie = " + ckAddr);
		return ckAddr;
	}

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 瓔酈 高 檗晦 ]]
	 * 
	 * @param targetCookieName : 瓊擊 瓔酈 檜葷
	 * @return String : 瓊擎 瓔酈縑 氬曹 高 ( UTF-8 蛤囀萄 諫猿 )
	 *******************************************************************/
	public String getCookieValue(String targetCookieName) throws IOException {
		Cookie cookie = cookieMap.get(targetCookieName);// 瓔酈裘縑憮 п渡瓔酈橢擠
		if (cookie != null) {
			if (isNumber(targetCookieName)) {// 璋濠賊 蛤囀註擎 寰м棲棻.
				String ckValue = cookie.getValue();
				logger.info("[[ 瓔酈衙棲盪 ]] getCookieValue = " + ckValue);
				return ckValue;
			} else {// 僥濠橾陽 蛤囀註м棲棻.
				String ckValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
				logger.info("[[ 瓔酈衙棲盪 ]] getCookieValue = " + ckValue);
				return ckValue;
			}
		} else {
			logger.info("[[ 瓔酈衙棲盪 ]] 檗擎 頂羲檜 橈蝗棲棻 / targetCookieName = " + targetCookieName);
		}
		logger.info("[[ 瓔酈衙棲盪 ]] 高 檗晦 褒ぬц蝗棲棻.  null擊 奩�納桭炴�.");
		return null;
	}

	/*******************************************************************
	 * [[ 瓔酈高戲煎 瓔酈 檜葷 檗晦 ]]
	 * 
	 * @param targetCookieValue : 瓊擊 瓔酈高
	 * @return String : 瓊擎 瓔酈曖 檜葷
	 *******************************************************************/
	public String getCookieNameFromValue(String targetCookieValue) throws IOException {
		if (targetCookieValue == null) {
			logger.info("[[ 瓔酈衙棲盪 ]] 瓊堅濠 ж朝 瓔酈曖 高檜 綠橫氈蝗棲棻.(null) 棻衛�挫恉媮祤撚�. ");
			return null;
		} else {
			logger.info("[[ 瓔酈衙棲盪 ]] 瓔酈蒂 匐儀м棲棻. / 渠鼻 瓔酈高 = " + targetCookieValue);
		}
		String getCookieValue = null;
		for (Entry<String, Cookie> entry : cookieMap.entrySet()) {
			getCookieValue = entry.getValue().getValue();// 瓔酈裘縑憮 檗橫魚 瓔酈高
			if (targetCookieValue.equals(getCookieValue)) {
				String getCookieName = entry.getValue().getName().toString();
				logger.info("[[ 瓔酈衙棲盪 ]] 瓔酈陛 匐儀腎歷蝗棲棻. / 匐儀 瓔酈檜葷 = " + getCookieName);
				return entry.getKey();
			}
		}
		logger.info("[[ 瓔酈衙棲盪 ]] 瓔酈匐儀唸婁陛 橈蝗棲棻.");
		return null;
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 п渡 瓔晦 高擊 滲唳ж晦 ]]
	 * 
	 * @param targetCookieName : 滲唳й 瓔酈 檜葷
	 * @param newValue         : 滲唳й 瓔酈 高
	 * @return Cookie : 高檜 滲唳脹 瓔酈
	 *******************************************************************/
	public int changeCookieValue(String targetCookieName, String newValue) throws IOException {
		if (checkCookie(targetCookieName)) {
			setCookie(targetCookieName, newValue);
			logger.info("[[ 瓔酈衙棲盪 ]] 滲唳頂羲 / targetCookieName = " + targetCookieName + "/ newValue : " + newValue);
			return 1;// 滲唳唸婁蒂 夔樂璽縑 轎溘ж堅 滲唳唸婁蒂 1煎 奩�納�
		} else {
			logger.info("[[ 瓔酈衙棲盪 ]] 滲唳頂羲檜 橈蝗棲棻 / targetCookieName = " + targetCookieName);
		}
		return 0;// 褒ぬи 滲唳唸婁蒂 夔樂璽縑 轎溘ж堅 滲唳唸婁蒂 0戲煎 奩�納�
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ 瓔酈 檜葷戲煎 п渡瓔酈 餉薯ж晦 ]]
	 * 
	 * @param targetCookieName : 雖辦堅濠ж朝 瓔酈 檜葷
	 * @return int : 1 (瓔酈餉薯撩奢) / 0 (瓔酈餉薯褒ぬ)
	 *******************************************************************/
	public int deleteCookie(String targetCookieName) throws IOException {
		if (checkCookie(targetCookieName)) {
			Cookie cookie_del = cookieMap.get(targetCookieName);// 瓔酈裘縑憮 雖辦堅濠ж朝 瓔酈蒂 橢擠
			cookie_del = new Cookie(targetCookieName, "");
			cookie_del.setMaxAge(0);
			res.addCookie(cookie_del);
			logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈蒂 餉薯ц蝗棲棻.");
			return 1;// 渠鼻瓔酈陛 襄營ж賊 餉薯�� 煎斜轎溘 塽 1擊 奩��
		} else {
			logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈朝 橈蝗棲棻. 餉薯縑 褒ぬц蝗棲棻.");
		}
		return 0;// 渠鼻瓔酈陛 襄營ж雖 彊戲賊 餉薯縑 褒ぬж堅 煎斜轎溘 塽 0擊 奩��
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 嶸�蕭簸� 撲薑ж晦 ]]
	 * 
	 * @param targetCookieName : 渠鼻 瓔酈 檜葷
	 * @param second           : 撲薑ж堅濠ж朝 嶸�蕭簸� (蟾)
	 * @return int : 1 (衛除撲薑撩奢) / 0 (衛除撲薑褒ぬ)
	 *******************************************************************/
	public int setCookieAge(String targetCookieName, int second) {
		Cookie cookie_age = cookieMap.get(targetCookieName);// 瓔酈裘縑憮 滲唳ж堅濠 ж朝 瓔酈蒂 橢擠
		if (cookie_age != null) {
			cookie_age.setMaxAge(second);
			res.addCookie(cookie_age);
			logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈曖 滲唳脹 嶸�蕭簸� : " + cookie_age.getMaxAge());
			return 1;// 渠鼻 瓔酈陛 襄營ж賊 嶸�蕭簸� 滲唳�� 1擊 奩��
		} else {
			logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈朝 橈蝗棲棻.");
		}
		return 0;// 渠鼻 瓔酈陛 襄營ж雖 彊戲賊 0擊 奩��
	}

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 嶸�蕭簸� 憲嬴頂晦 ]]
	 * 
	 * @param targetCookieName : 渠鼻 瓔酈 檜葷
	 * @return int : 撲薑脹 嶸�蕭簸� (蟾)
	 *******************************************************************/
	public int getCookieAge(String targetCookieName) {
		Cookie cookie = cookieMap.get(targetCookieName);// 瓔酈裘縑憮 п渡瓔酈橢擠
		int ckAge = cookie.getMaxAge();// 撲薑脹 嶸�蕭簸�擊 奩��
		logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈曖 嶸�蕭簸� : " + ckAge);
		return ckAge;// 撲薑脹 嶸�蕭簸�擊 奩��
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 唳煎撲薑ж晦 ]]
	 * 
	 * @param targetCookieName : 渠鼻 瓔酈 檜葷
	 * @param path             : 撲薑й 瓔酈 儅撩唳煎
	 * @return int : 1 (撲薑撩奢) / 0 (撲薑褒ぬ)
	 *******************************************************************/
	public int setCookiePath(String targetCookieName, String path) throws IOException {
		Cookie cookie_path = cookieMap.get(targetCookieName);
		if (cookie_path != null) {
			cookie_path.setPath(path);
			res.addCookie(cookie_path);
			logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈曖 滲唳脹 唳煎 : " + cookie_path.getPath());
			return 1;// 渠鼻 瓔酈陛 襄營ж賊 嶸�蕭簸� 滲唳�� 1擊 奩��
		} else {
			logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈朝 橈蝗棲棻.");
		}
		return 0;// 渠鼻瓔酈陛 襄營ж雖 彊戲賊 0擊 奩��
	}

	/*******************************************************************
	 * [[ 瓔酈檜葷戲煎 唳煎 憲嬴頂晦 ]]
	 * 
	 * @param targetCookieName : 渠鼻 瓔酈 檜葷
	 * @return String : 撲薑脹 唳煎
	 *******************************************************************/
	public String getCookiePath(String targetCookieName) {
		Cookie cookie_Path = cookieMap.get(targetCookieName);// 瓔酈裘縑憮 п渡瓔酈橢擠
		String ckPath = cookie_Path.getPath();// 撲薑脹 瓔酈盪濰唳煎蒂 奩��
		logger.info("[[ 瓔酈衙棲盪 ]] '" + targetCookieName + "' 瓔酈曖 唳煎 : " + ckPath);
		return ckPath;// 撲薑脹 瓔酈盪濰唳煎蒂 奩��
	}

//﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥

	/*******************************************************************
	 * [[瓔酈高戲煎 殮溘脹 僥濠翮檜 璋濠檣雖 僥濠檣雖 っ欽ж晦]]
	 * 
	 * @param value : っ滌渠鼻
	 * @return result : 璋濠賊 true / 僥濠賊 false蒂 奩��
	 *******************************************************************/
	public boolean isNumber(String value) {
		char tempCh;
		int dotCount = 0;// 褒熱橾 唳辦 .曖 偃熱蒂 羹觼ж朝 滲熱
		boolean result = true;

		for (int i = 0; i < value.length(); i++) {
			tempCh = value.charAt(i);// 殮溘嫡擎 僥濠翮擊 僥濠欽嬪煎 匐餌
			// 嬴蝶酈 囀萄 高檜 45檜賊 '-'僥濠煎, 擠熱陛 脹棻.
			if ((int) tempCh == 45)
				return true;
			// 嬴蝶酈 囀萄 高檜 48 ~ 57餌檜賊 0婁 9餌檜曖 僥濠檜棻.
			if ((int) tempCh < 48 || (int) tempCh > 57) {// 0~9餌檜曖 僥濠陛 嬴棲堅
				if (tempCh != '.' || dotCount > 0) { // '.'紫 嬴棲剪釭 '.'曖 偃熱陛 檜嘐 1偃 檜鼻檜塭賊
					result = false; // 斜 僥濠翮擎 璋濠陛 嬴棲棻.
					break;
				} else {// .橾 唳辦 .偃熱 隸陛
					dotCount++;
				}
			}
		}
		return result;
	}

	/**
	 * [[ か薑 僥濠翮擊 んлж朝 瓔酈蒂 裘縑 氬嬴 奩�納炱� ]]
	 * 
	 * @param certainName : 瓔酈檜葷 匐儀縑 餌辨й 褻勒僥濠翮
	 * @return rCkMap : 褻勒縑 п渡ж朝 瓔酈裘
	 */
//	public Map<String,Cookie> addCookieBasket(String certainName){
//		String guide = .contains(certainName);
//		for(String str : cookieMap.keySet()) {
//			
//		}
//		return null;
//	}
}
