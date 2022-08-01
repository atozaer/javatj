// ——————————————— 클래스 문제
// 새로운 패키지를 만들고
// 클래스 파일은 분리 하여 Student 클래스와 StudentTest 클래스 파일을 분리 해서 생성 한다.
// Student 클래스 = 학생 정보 클래스
// StudentTest = main 메소드가 담긴 클래스로 Student 클래스를 인스턴스(객체화)해서만 활용 해야함.
// Student라는 클래스를 만들고
// Primitive type 자료형은 본인이 생각해서 작성 필요
// name, age, kor(국어성적), eng(영어성적), math(수학성적)을 담을 수 있는 필드를 만들고.
// 학생 5명의 정보를 담고
// Student 클래스 내 개인 정보를 출력하는 메소드 (이름과 나이 출력) 전용 메소드
// Student 클래스내 이름 및 개인 과목 점수, 평균을 출력하는 메소드
// 1. "이름 : 나이" 형태로 출력하세요
// 2. "이름 : 000, 국어 : 00, 영어 : 00, 수학 : 00, 평균 : 00 형태로 출력하세요

/* 결과 예제
홍길동 : 18
이름 : 홍길동, 국어 : 70, 영어 : 80, 수학 : 75, 평균 : 75.000000
홍길순 : 35
이름 : 홍길순, 국어 : 60, 영어 : 70, 수학 : 80, 평균 : 70.000000
디렉터 : 22
이름 : 디렉터, 국어 : 65, 영어 : 70, 수학 : 77, 평균 : 70.666667
나옹이 : 15
이름 : 나옹이, 국어 : 100, 영어 : 70, 수학 : 90, 평균 : 86.666667
피카츄 : 27
이름 : 피카츄, 국어 : 70, 영어 : 100, 수학 : 80, 평균 : 83.333333
*/

package kr.co.tj1;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동",18,70,80,75);
		Student s2 = new Student("홍길순",35,60,70,80);
		Student s3 = new Student("디렉터",22,65,70,77);
		Student s4 = new Student("나옹이",15,100,70,90);
		Student s5 = new Student("피카츄",27,70,100,80);
		
		s1.showStudentInfo();
		s2.showStudentInfo();
		s3.showStudentInfo();
		s4.showStudentInfo();
		s5.showStudentInfo();
		
	}

}
