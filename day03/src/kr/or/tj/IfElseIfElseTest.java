package kr.or.tj;

import java.util.Scanner;

public class IfElseIfElseTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int age = 0;
		int charge = 0;

		System.out.println("몇살입니까? ");
		age = scan.nextInt();

		if (age < 8) {
			charge = 1000;
			System.out.println("미 취학 아동입니다.");
		} else if (age < 14) {
			charge = 2000;
			System.out.println("초등학생입니다.");
		} else if (age < 17) {
			charge = 3000;
			System.out.println("중학생입니다.");
		} else if (age < 20) {
			charge = 4000;
			System.out.println("고등학생입니다.");
		} else if (age > 20) {
			charge = 5000;
			System.out.println("일반인입니다.");
		}

		System.out.printf("%d원입니다.", charge);

		scan.close();
	}

}
