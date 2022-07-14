package kr.or.tj;

import java.util.Scanner;

public class RealtionalTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		
		System.out.println("숫자 두 개를 입력하시오.");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
						
		System.out.println(num1>num2);
		System.out.println(num1<num2);
		System.out.println(num1>=num2);
		System.out.println(num1<=num2);
		System.out.println(num1==num2);
		System.out.println(num1!=num2);
		
		scan.close();
	}

}
