package kr.co.tj2;

class Academy{
	private int studentNo;
	private String studentName;
	public Academy() {
		this(2022,"김철수"); //기본생성자
	}
	public Academy(int studentNo, String studentName) {//매개변수가있는생성자
		this.studentNo = studentNo;
		this.studentName = studentName;
	}
	public void academyAll() {
		System.out.println(studentNo+":"+studentName);
	}
}


public class AcademyTest {

	public static void main(String[] args) {
		Academy  academy = new Academy(0001,"이순신");
		Academy  academy1 = new Academy();
		academy.academyAll();
		academy1.academyAll();
		
	}

}
