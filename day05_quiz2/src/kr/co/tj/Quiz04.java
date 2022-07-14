package kr.co.tj;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		
		int i=0;
		int sum=0;
		int num;
		int count=0;

		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를입력하세요");
		num = scan.nextInt();
		
		for(i=0;i<=num;i++) {
			sum+=i;
			count++;	
			
		}
		System.out.println(sum);
		System.out.println(count);
		
	}

}
