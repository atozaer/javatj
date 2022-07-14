package kr.or.tj;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("년도를입력해주세요 : ");
		int year = scan.nextInt();
		
		System.out.println("월을입력하세요 : ");
		int month = scan.nextInt();
		boolean result = (year%4==0 && year%100 !=0 || year%400==0);
		
		if(result) {
			System.out.println("윤년입니다. 2월달이29일");
			System.out.println(year+"년도입니다.");
			System.out.println("2월달29일");
			System.out.println("3월달31일");
			System.out.println("4월달30일");
			System.out.println("5월달31일");
			System.out.println("6월달30일");
			System.out.println("7월달31일");
			System.out.println("8월달31일");
			System.out.println("9월달30일");
			System.out.println("10월달31일");
			System.out.println("11월달30일");
			System.out.println("12월달31일");
		}else {
			System.out.println("윤년이아닙니다. 2월달이28일");
			System.out.println("1월달31일");
			System.out.println("2월달28일");
			System.out.println("3월달31일");
			System.out.println("4월달30일");
			System.out.println("5월달31일");
			System.out.println("6월달30일");
			System.out.println("7월달31일");
			System.out.println("8월달31일");
			System.out.println("9월달30일");
			System.out.println("10월달31일");
			System.out.println("11월달30일");
			System.out.println("12월달31일");
		}
		
	}

}
