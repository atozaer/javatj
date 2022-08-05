package kr.co.tj;

import java.util.Scanner;

public class Student {
	public Score score = new Score();
	public String name;
	public int age;
	public double avg;
	
	Scanner scan = new Scanner(System.in);
	
	public Student() {
		
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void studentInfoInput() {
		System.out.println("학생정보를 입력하세요.");
		System.out.println("이름:");
		name = scan.next();
		System.out.println("나이:");
		age = scan.nextInt();
		score.inputScore();
	}

	public void showStudentInfo() {
		System.out.println(name + ":" + age);
		score.showScore();
	}

}
