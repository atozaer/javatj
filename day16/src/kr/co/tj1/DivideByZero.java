package kr.co.tj1;

import java.util.Scanner;

public class DivideByZero {

	public static void main(String[] args) {
		int x, y;
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("피젯수\t:");
			x = scan.nextInt();
			System.out.print("젯수\t:");
			y = scan.nextInt();
			
			int result = x/y;
			System.out.println("나눗셈결과 : "+ result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
