package ko.co.tj;

import java.util.Scanner;

public class Quiz17 {

	public static void main(String[] args) {
		int a = 0, b = 0;
		int max = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("두개의 정수를 입력하시오.");
		a = scan.nextInt();
		b = scan.nextInt();

		max = a > b ? a : b;
		System.out.println(max);

	}

}
