package kr.co.tj2;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.studentID = 1;
		studentLee.studentName = "이순신";
		studentLee.address = "서울";
		studentLee.showStudentInfo();
		
		
		Student studentKim = new Student();
		studentKim.studentID = 2;
		studentKim.studentName = "김유신";
		studentKim.address = "경주";
		studentKim.showStudentInfo();

		System.out.println(studentLee);
		System.out.println(studentKim);
	}

}
