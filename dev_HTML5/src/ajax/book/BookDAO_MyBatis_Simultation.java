package ajax.book;

import java.util.HashMap;
import java.util.Map;

public class BookDAO_MyBatis_Simultation {

	public static void main(String[] args) {

		BookDAO_MyBatis bDao = new BookDAO_MyBatis();
		Map<String,Object> pMap = new HashMap<String,Object>();
		//bDao.getBookList(pMap);
		bDao.getEmployer(pMap);
		
	}

}
