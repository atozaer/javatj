// ——————————————— 클래스 문제(변칙 문제)
// 기존 생성한 Student, Score, StudentTest를 새로운 패키지로 복사 후 개인정보 및 점수를 입력 받아 출력 될 수 있도록 코딩 변환 해보기
// 최대 5명: 배열 활용
// 학생명을 입력해 주세요
// 학생의 나이를 입력해 주세요
// 학생의 성적 정보를 입력하시겠습니까?(y/n)
// 국어 점수 : ?
// 영어 점수 : ?
// 수학 점수 : ?
// 입력 루프 종료
// 등록된 학생 수만큼 반복 하며 개인 성적 정보가 존재하는 경우 출력 여부 확인
// {이름} : 학생의 성적 정보가 있습니다. 출력 하시겠습니까?(y/n)
// 국어 : 70, 영어 : 100, 수학 : 80, 평균 : 83.333333

package kr.co.tj3;

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
		
	}

}
