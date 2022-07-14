package kr.co.tj;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int height = 0;
		double weight = 0.0;
		char name = 'N';

		System.out.println("키를 입력하세요.");
		height = sc.nextInt();

		System.out.println("몸무게를 입력하세요.");
		weight = sc.nextDouble();

		System.out.println("이름를 입력하세요.");
		name = sc.next().charAt(0);

		System.out.printf("키 = %d \n", height);
		System.out.printf("몸무게 = %.1f \n", weight);
		System.out.printf("이름 = %c \n", name);
		
		sc.close();
	}

}
