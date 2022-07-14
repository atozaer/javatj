package kr.co.tj;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age = 0;
				
		System.out.print("당신의 나이는 몇살입니까? ");
		age = sc.nextInt();
		
		System.out.printf("당신의나이는 %d살이군요.", age);
		
		sc.close();
	}

}