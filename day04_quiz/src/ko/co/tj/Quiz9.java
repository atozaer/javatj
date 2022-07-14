package ko.co.tj;

import java.util.Scanner;

public class Quiz9 {

	public static void main(String[] args) {
		int a = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("하나의 정수를 입력하시오.");
		a = scan.nextInt();
		
		System.out.printf("%d\n",a);
		if(a>10) {
			System.out.println("10보다 큰 수를 입력하셨습니다.");
		}
		
	}

}
