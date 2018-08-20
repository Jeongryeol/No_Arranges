package com.ch7;

public class Encaps_TimeSimul {

	public void methodA(Encaps_TimeVO tvo) {
		//tvo 지역변수(파라미터로 넘어오므로 선택권없음)
		System.out.println(tvo.name+" 님! "
				+tvo.getYear()+"/"+tvo.getMonth()+"/"+tvo.getDate()+" "
				+tvo.getHour()+":"+tvo.getMinute()+":"+tvo.getSecond()
				+" 축하합니다. 수료하셨습니다! ^0^");
		//insert here - 원본이 바뀌지 않도록 코드를 수정해 보세요.
		tvo = null;
		tvo = new Encaps_TimeVO();//candidate상태로 빠지도록 조치하는 가장 좋은 형태
		tvo.name = "정렬쩡렬";//원본이 바뀌게 됨
	}
	
	public static void main(String[] args) {
		Encaps_TimeSimul tsim = new Encaps_TimeSimul();
		Encaps_TimeVO tvo = new Encaps_TimeVO();
		
		tvo.name = "이정렬";//public이므로 직접접근이 됨 (원본이 바뀌게 됨)
		
		tvo.setYear(2018);//private로 선언해둔 내용은 직접접근 불가
		tvo.setMonth(10);
		tvo.setDate(26);
		tvo.setHour(11);
		tvo.setMinute(31);
		tvo.setSecond(13);
		
		tsim.methodA(tvo);
		System.out.println(tvo.name+" 님! "
				+tvo.getYear()+"/"+tvo.getMonth()+"/"+tvo.getDate()+" "
				+tvo.getHour()+":"+tvo.getMinute()+":"+tvo.getSecond()
				+" 축하합니다. 수료하셨습니다! ^0^");
	}

}
