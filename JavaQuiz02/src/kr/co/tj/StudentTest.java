// ——————————————— 클래스 문제 (“has a” 관계 정의)
// 클래스는 사용자정의 자료형이라고도 표현함.
// 배열도 참조 변수
// 클래스에서 타 클래스의 참조 변수를 선언하는 경우 has a 관계라 표현
// 직전에 생성한 Student, StudentTest 클래스가 있는 패키지를 복사하여 새로운 패키지로 복사
// 기존 Student에서 소유 하고 있는 kor, eng, math 인스턴스 변수는 점수라는 특성을 가지고 있어 별도 분리가 가능해 보인다.
// kor, eng, math 라는 인스턴스 변수를 소유한 Score 클래스를 생성
// Score 클래스는 국어 : 70, 영어 : 100, 수학 : 80, 평균 : 83.333333 와 같이 출력하는 메소드를 가진다.
// Score 클래스는 평균을 계산하는 메소드를 가진다.
// Student 클래스는 kor, eng, math라는 성적 필드를 제고 하고 Score라는 클래스를 has a 관계를 하고 있는 score 필드로 대체 한다.
// 기존 생성된 점수 출력 메소드는 제거 한다.
// 각자 수정된 내용을 가지고 기존 내용과 동일한 결과를 호출 할 수 있도록 StudentTest 클래스를 수정 한다.
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

package kr.co.tj;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동",18);
		Student s2 = new Student("홍길순",35);
		Student s3 = new Student("디렉터",22);
		Student s4 = new Student("나옹이",15);
		Student s5 = new Student("피카츄",27);
		
		s1.score = new Score(70,80,75);
		s2.score = new Score(60,70,80);
		s3.score = new Score(65,70,77);
		s4.score = new Score(100,70,90);
		s5.score = new Score(70,100,80);
		
		s1.showStudentInfo();
		s2.showStudentInfo();
		s3.showStudentInfo();
		s4.showStudentInfo();
		s5.showStudentInfo();
//		Student s1 = new Student();
//		s1.studentInfoInput();
//		s1.showStudentInfo();
	}

	
}
