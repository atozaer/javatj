package ko.co.tj;

import java.util.Scanner;

public class Quiz16 {

	public static void main(String[] args) {
		int score = 0; int result = 0;
		String a = "수",b = "우",c = "미",d = "양",e = "가";
		String result1 = "n";
		Scanner scan = new Scanner(System.in);

		System.out.println("점수를 입력하세요.");
		score = scan.nextInt();
		
		result=score/10;
		
		switch (result) {
		case 10: case 9:
			result1="수";
			break;
		case 8:
			result1="우";
			break;
		case 7:
			result1="미";
			break;
		case 6:
			result1="양";
			break;
		case 5:
			result1="가";
			break;
		default :
			System.out.println("올바른 점수를 입력해주세요.");
			break;
		}
		System.out.println(result1);
	}

}
