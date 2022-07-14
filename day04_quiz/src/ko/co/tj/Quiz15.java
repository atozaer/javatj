package ko.co.tj;

import java.util.Scanner;

public class Quiz15 {

	public static void main(String[] args) {
		int a;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.삽입");
		System.out.println("2.수정");
		System.out.println("3.삭제");
		System.out.println("숫자를 선택하세요.");
		a = scan.nextInt();
		
		switch(a) {
		case 1:
			System.out.println("삽입을 선택하셨습니다.");
			break;
		case 2:
			System.out.println("수정을 선택하셨습니다.");
			break;
		case 3:
			System.out.println("삭제을 선택하셨습니다.");
			break;
		default :
			System.out.println("1,2,3번 중 선택하세요.");
			break;
		}
	}

}
