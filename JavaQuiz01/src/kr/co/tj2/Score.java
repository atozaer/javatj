package kr.co.tj2;

public class Score {
	int kor;
	int eng;
	int math;
	double avg;

	public Score() {
	}

	public Score(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public void showScore() {
		System.out.println("국어:" + kor + "," + "영어:" + eng + "," + "수학:" + math + "," + "평균:"
				+ avgScore());
	}
	
	public String avgScore() {
		avg=(double)(kor+eng+math)/3;
		return String.format("%.6f", avg);
	}

}
