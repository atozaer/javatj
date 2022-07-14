package ko.co.tj;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		
		int a=0, b=0, c=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 2개를 입력하시오.");
		a = scan.nextInt();
		b = scan.nextInt();
		
		c=++a + b--;
		
		System.out.printf("a=%d, b=%d, c=%d",a, b, c);
		
	}

}
