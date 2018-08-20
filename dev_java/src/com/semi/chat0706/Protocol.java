package com.semi.chat0706;

public class Protocol {
	public final static int WAIT_ROOM 	= 100;//대기실 입장
	public final static int WAIT_APPEND = 110;//대기실 추가
	public final static int CREATE_ROOM = 200;//방만들기
	public final static int ROOM_IN		= 210;//방추가
	public final static int INTRO_ROOM 	= 220;//방입장
	public final static int MESSAGE 	= 300;//메시지 전달
	public final static int WHISPER 	= 310;//귓속말
	public final static int CHANGE  	= 320;//대화명 변경
	public final static int ROOM_OUT 	= 500;//방나가기
	public final static int CLOSED 		= 900;//종료
}
