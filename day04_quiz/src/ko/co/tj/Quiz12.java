package ko.co.tj;

import java.util.Scanner;

public class Quiz12 {

	public static void main(String[] args) {
		String a="수", b="우", c="미", d="양", e="가";
		int score = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		score = scan.nextInt();
		
		if(score>80) {
			System.out.printf("%s",a);
		}
		else if(score>60) {
			System.out.printf("%s",b);
		}
		else if(score>40) {
			System.out.printf("%s",c);
		}
		else if(score>20) {
			System.out.printf("%s",d);
		}
		else if(score>0) {
			System.out.printf("%s",e);
		}
		
	}

}
