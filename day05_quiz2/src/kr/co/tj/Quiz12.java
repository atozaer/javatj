package kr.co.tj;

import java.util.Scanner;

public class Quiz12 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int i = 0, j = 0, n = 0;
		System.out.print("줄수입력:");
		n = scan.nextInt();

		for (i = 1; i <= n; i++) {
			for (j = i; j <= n; j++) {	//	공백제어 for문
				System.out.printf(" ");
			}
			for (j = 1; j <= i; j++) {	//	*제어 for문
				System.out.printf("*");
			}
			System.out.printf("\n");
		}

	}
}
