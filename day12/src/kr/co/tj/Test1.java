package kr.co.tj;

class School extends Object{
	int kor;
	int eng;
	int mat;
	
	@Override
	public String toString() {
		return "School [kor=" + kor + ", eng=" + eng + ", mat=" + mat + "]";
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		School school = new School();
		System.out.println(school);
	}

}
