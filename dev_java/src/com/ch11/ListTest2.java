package com.ch11;

//util과 awt를 헷갈리지 말것!! (awt는 화면구성용 API)
import java.util.Iterator;
import java.util.List;

public class ListTest2 {

	public static void main(String[] args) {
		ListTest1 lt1 = new ListTest1();
		//List타입으로 이름을 담았다
		List nameList = lt1.setNameList();
		//List에 접근하는 iterator
		Iterator iter = nameList.iterator();
		
		//접근하고자하는 List의 다음값을 읽을수 있으면 (true)
		while(iter.hasNext()) {
			Object obj  = iter.next();	//읽어서 담음
			System.out.println(obj);	//출력
		}
	}
}
