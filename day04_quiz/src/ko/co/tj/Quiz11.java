package ko.co.tj;

import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		int score=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		score = scan.nextInt();
				
		if(score>80) {
			System.out.println("축하합니다. 합격입니다.");
		}else {
		System.out.printf("%d점으로 불합격입니다.", score);
		}
	}

}
