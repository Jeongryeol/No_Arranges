package com.ch8;

/* 예외를 반드시 처리해야하는 패키지가 존재한다
	* javaj.net.Socket
	* java.io.PrintWriter | ObjectInputStream | ObjectOutputStream
	* java.lang.Thread
 * 위의 경우 예외처리를 별도로 하지 않으면 에러가 발생한다.*/

public class ThrowTest {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	//throw를 호출하면 예외를 강제로 발생시켜주는데
	//예외를 강제로 일으켜서 시간을 벌어놓고 그 사이에 다른 처리를 할 수 있다.
	//예를 들면 오라클에서 트랜잭션 처리를 할때...
			throw new ClassNotFoundException();
		}catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을  수 없습니다.");
		}catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		System.out.println("◆출력됨◆");
	}
}
//트랜잭션 처리란, 각각 처리되는 업무가 하나로 묶어 처리되어야 할때 (ex.묶음배송)
	//주문마스터 테이블에 누가?언제? 주문했는지에 대한 정보를 기록하고
	//주문상세 테이블에 무엇을?몇개? 주문했는지에 대한 정보를 다음으로 기록한다면
	//주문마스터 테이블에 정보를 INSERT하고, (commit을 하는게 아니라 대기시킨뒤)
	//주문상세 테이블에 정보를 INSERT한 뒤에 commit을 시킨다.
	//왜냐하면, 정보입력이 잘못되었을경우, rollback을 시켜서,
	//다시 모든 정보를 동시에 처리(commit)하기 위한 조치 (묶음배송은 개별로 정보가 따로 들어가면 의미가 없기 때문이지)
