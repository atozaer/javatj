package kr.co.tj;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
				
		System.out.println("두 개의 수를 입력하시오.");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d \n", num1, num2, num1+num2);
		System.out.printf("%d - %d = %d \n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d \n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %d \n", num1, num2, num1/num2);
		System.out.printf("%d %% %d = %d", num1, num2, num1%num2);
		
		sc.close();
	}
}
