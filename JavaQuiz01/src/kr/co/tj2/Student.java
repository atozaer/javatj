package kr.co.tj2;

public class Student {
	public Score score = new Score();
	public String name;
	public int age;
	public double avg;
	
	public Student() {
		
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showStudentInfo() {
		System.out.println(name + ":" + age);
		score.showScore();
	}

}
