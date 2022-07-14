package ko.co.tj;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		int score = 0;

		Scanner scan = new Scanner(System.in);

//		while (score < 101) {
//			System.out.println("점수를 입력하세요.");
//			score = scan.nextInt();
//			if (score >= 80 && score <= 100) {
//				System.out.printf("축하합니다. %d점으로 합격입니다.\n", score);
//			} else if (score < 80 && score>=0) {
//				System.out.printf("%d점으로 불합격입니다.\n", score);
//			} else if (score > 100) {
//				break;
//			}
//		}
		
		System.out.println("점수를 입력하세요.");
		score = scan.nextInt();
		while(score>=0 && score<=100) {
			if(score>=80) {
				System.out.println("합격");
			}else {
				System.out.println("불합격");
			}
			System.out.println("점수입력하세요.");
			score = scan.nextInt();
		}
		
	}

}
