package kr.or.tj;

import java.util.Scanner;

public class IfElseTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

//		int age;
//		System.out.println("나이를 입력하세요:");
//		age = scan.nextInt();
//
//		if (age >= 8) {
//			System.out.println("학교에다니고있습니다.");
//		} else {
//			System.out.println("학교에다니지않습니다.");
//		}
		int age;
		
		System.out.println("나이를 입력하세요:");
		age = scan.nextInt();
		
		String str = (age>=8&&age<20)?"학교에다니고있습니다.":"학교에다니지않습니다";
		System.out.println(str);

		scan.close();

	}

}
