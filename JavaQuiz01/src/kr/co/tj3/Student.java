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

import java.util.Scanner;

public class Student {
	public Score score = new Score();
	public String name;
	public int age;
	public double avg;
	public String protocol;

	public Student() {

	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void inputStudentInfo() {

		Scanner scan = new Scanner(System.in);

		System.out.println("학생명을입력해주세요 : ");
		name = scan.next();
		System.out.println("학생의나이를입력해주세요 : ");
		age = scan.nextInt();
		System.out.println("학생의 성적정보를 입력하시겠습니까? (y/n)");
		protocol = scan.next();
		if (protocol.equals("Y") || protocol.equals("y")) {
			System.out.println("국어점수 : ");
			score.kor = scan.nextInt();
			System.out.println("영어점수 : ");
			score.eng = scan.nextInt();
			System.out.println("수학점수 : ");
			score.math = scan.nextInt();
		}else {
			score = null;
		}
	}

	public void outputStudentInfo() {
		Scanner scan = new Scanner(System.in);

		if (score == null) {
			System.out.println(name + " 학생의 성적정보가 없습니다.");
		} else {
			System.out.println(name + " 학생의 성적정보가 있습니다. 출력하시겠습니까??? (y/n)");
			if (scan.next().toLowerCase().equals("y")) {
				showStudentInfo();
			} else {
				System.out.println(name + " 학생의 성적정보를 출력하지 않습니다.");
			}
		}

	}

	public void showStudentInfo() {
		System.out.println(name + ":" + age);
		score.showScore();
	}

	public void startApp() {
		inputStudentInfo();
		outputStudentInfo();
	}

}
