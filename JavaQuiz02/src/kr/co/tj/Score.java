package kr.co.tj;

import java.util.Scanner;

public class Score {
	int kor;
	int eng;
	int math;
	double avg;
	
	Scanner scan = new Scanner(System.in);
	
	public Score() {
	}

	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void inputScore() {
		System.out.println("점수를 입력하세요.");
		System.out.println("국어:");
		kor = scan.nextInt();
		System.out.println("영어:");
		eng = scan.nextInt();
		System.out.println("수학:");
		math = scan.nextInt();
	}
	
	public void showScore() {
		
		System.out.println("국어:" + kor + "," + "영어:" + eng + "," + "수학:" + math + "," + "평균:"
				+ avgScore());
	}
	
	
	
	public String avgScore() {
		avg=(double)((kor+eng+math)/3);
		return String.format("%.6f", avg);
	}

}
