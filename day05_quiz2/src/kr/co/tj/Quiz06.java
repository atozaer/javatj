package kr.co.tj;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int i = 0, sum = 0, score = 0;
		double avg = 0.0;

		System.out.println("점수를 입력하세요.");

		for (i = 1; i <= 5; i++) {
			score = scan.nextInt();
			sum+=score;
		}
		avg = (double)sum/5;
		System.out.printf("총점 : %d\n",sum);
		System.out.printf("평균 : %.1f\n",avg);
	}

	
}
