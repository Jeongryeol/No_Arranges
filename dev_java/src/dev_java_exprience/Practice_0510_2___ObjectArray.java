package dev_java_exprience;

//타패키지의 클래스를 불러오는 경우, 불러올 클래스의 main메소드가 public일때 가능함
//이때 import로 먼저 선언하는 것이 코딩입력에 유리함.
import dev_java_exprience.Practice_0510_2___ObjectArraySub;

public class Practice_0510_2___ObjectArray {

	public static void main(String[] args) {
		//불러온 클래스를 복제시키고 새로운 배열을 선언함
		Practice_0510_2___ObjectArraySub stud_names[] = new Practice_0510_2___ObjectArraySub[5];
		//불러온 클래스를 복제하여 변수로 선언함
		Practice_0510_2___ObjectArraySub studs = new Practice_0510_2___ObjectArraySub();
		//복제된 새 배열의 방에 복제한 변수로 초기화시킴  
		stud_names[0] = studs;
		//출력하면 주소번지가 출력되고, 남은 배열의 방은 불러온 클래스에 정의된 길이만큼 빈방(null)으로 기록됨
		for(int i=0;i<stud_names.length;i++) {
			System.out.println(stud_names[i]);
		}
		
		System.out.println("\n★★★★★JAVA상에서 DB를 구축하기 위한 1차객체배열 연습하기★★★★★\n");

		//불러온 클래스를 복제시키고 새로운 배열을 선언함 (테이블역할)
		Practice_0510_2___ObjectArraySub high_studs[] = new Practice_0510_2___ObjectArraySub[4];
		//불러온 클래스를 복제하여 변수로 선언함 (복제된 새 주소번지를 가짐)
		Practice_0510_2___ObjectArraySub high_stud = new Practice_0510_2___ObjectArraySub();
		high_stud.stud_no 	= 20050001;//각 변수를 새로 초기화 함
		high_stud.stud_name = "홍길동";
		high_stud.stud_age 	= 14430000;
		high_stud.stud_grd	= "조선중";
		high_studs[0]		= high_stud;//복제된 배열(테이블)의 0번방(1번로우)에 복제된 변수를 입력함
		
		high_stud = new Practice_0510_2___ObjectArraySub();//새로운 주소번지 부여
		high_stud.stud_no 	= 20050002;//각 변수를 다시 새로 초기화 함
		high_stud.stud_name = "강감찬";
		high_stud.stud_age 	= 9481228;
		high_stud.stud_grd	= "고려중";
		high_studs[1]		= high_stud;//복제된 배열(테이블)의 1번방(2번로우)에 복제된 변수를 입력함
		
		high_stud = new Practice_0510_2___ObjectArraySub();//새로운 주소번지 부여
		high_stud.stud_no 	= 20050003;//각 변수를 다시 새로 초기화 함
		high_stud.stud_name = "을지문덕";
		high_stud.stud_age 	= 6290000;
		high_stud.stud_grd	= "고구려중";
		high_studs[2]		= high_stud;//복제된 배열(테이블)의 2번방(3번로우)에 복제된 변수를 입력함
		
		high_stud = new Practice_0510_2___ObjectArraySub();//새로운 주소번지 부여
		high_stud.stud_no 	= 20050004;//각 변수를 다시 새로 초기화 함
		high_stud.stud_name = "이황";
		high_stud.stud_age 	= 15020103;
		high_stud.stud_grd	= "조선중";
		high_studs[3]		= high_stud;//복제된 배열(테이블)의 3번방(4번로우)에 복제된 변수를 입력함
		
		//출력하기
		for(int i=0;i<high_studs.length;i++) {
			Practice_0510_2___ObjectArraySub high_studsA = high_studs[i];
			System.out.printf("학번 : %d / 이름 : %s / 생년월일 : %d / 출신학교 : %s%n"
						     ,high_studsA.stud_no
						     ,high_studsA.stud_name
						     ,high_studsA.stud_age
						     ,high_studsA.stud_grd);
		}
	}

}
