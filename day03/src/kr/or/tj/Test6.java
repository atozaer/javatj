package kr.or.tj;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("나이입력:");
		int num = scan.nextInt();

		String str = (num > 0 && num <= 10) ? "10세미만" : "10세이상";
		System.out.println(str);

		System.out.println("나이입력:");
		num = scan.nextInt();
		str = (num > 10 && num <= 20) ? "10대입니다." : "10대가아닙니다.";
		System.out.println(str);

		scan.close();
	}

}
