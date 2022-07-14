package kr.co.tj2;

class Student {
	int studentNumber;
	String studentName;
	int grade;
	public Student() {
		studentNumber=0;
		studentName=null;
		grade=0;
	}
	
	public Student(int studentNumber, String studentName, int grade) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.grade = grade;
	}
	public String showStudentInfo() {
		return studentName+"학생의학번은"+studentNumber+"이고,"+grade+"학년입니다.";
	}
	

	public static void main(String[] args) {
		Student studentLee = new Student();
		Student studentKim = new Student(123456,"kim",3);
		//studentLee.grade = 1;
		System.out.println(studentLee.showStudentInfo());
		System.out.println(studentKim.showStudentInfo());
		
	}

}