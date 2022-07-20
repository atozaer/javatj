package kr.co.tj4;

class School{
	protected int kor;
	protected int eng;
	protected int mat;
	public School(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	
}
class ManSchool extends School{
	public int gisul;
	public ManSchool(int kor, int eng, int mat, int gisul) {
		super(kor, eng, mat);
		this.gisul = gisul;
	}
	
}
class WomanSchool extends School{
	int gajung;
	public WomanSchool(int kor, int eng, int mat, int gajung) {
		super(kor, eng, mat);
		this.gajung=gajung;
	}
	
	
}
class ManGongupSchool extends ManSchool{
	public int gongup;
	public ManGongupSchool(int kor, int eng, int mat, int gisul, int gongup) {
		super(kor, eng, mat, gisul);
		this.gongup = gongup;
	}

	
	
}
class WomanGongupSchool extends WomanSchool{
	public int sangup;
	public WomanGongupSchool(int kor, int eng, int mat, int gajung, int sangup) {
		super(kor, eng, mat, gajung);
		this.sangup = sangup;
	}

}

public class SchoolTest {

	public static void main(String[] args) {

	}

}
