package kr.co.tj1;

import java.text.Format;

public class Student {
	public String name;
	public int age;
	public int kor;
	public int eng;
	public int math;
	public double avg;

	public Student(String name, int age, int kor, int eng, int math) {
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void showStudentInfo() {
		avg = (double) (kor + eng + math) / 3;
		System.out.println(name + ":" + age);
		System.out.println("이름:" + name + "," + "국어:" + kor + "," + "영어:" + eng + "," + "수학:" + math + "," + "평균:"
				+ String.format("%.6f", avg));
	}

}
