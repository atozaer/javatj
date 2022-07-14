package kr.co.tj;

class Student{
	public int student_ID;
	public String studentName;
	public String address;
	
	public void showStudentInfo() {
		System.out.println(studentName+","+address);
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentID() {
		student_ID=1;
	}
}

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student();
		Student studentKim = new Student();
		
		
		studentLee.student_ID = 1;
		studentLee.address = "서울시";
		studentLee.studentName = "이순신";
		studentLee.showStudentInfo();
		
		studentKim.address = "경기도";
		studentKim.studentName = "김유신";
		studentKim.showStudentInfo();
		
		System.out.println(studentLee);
		System.out.println(studentKim);
	}

}
