package kr.co.tj;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int i = 0, num=0, count=0;
		
		System.out.println("숫자입력");
		
		for(i=1;i<=10;i++) {
			num = scan.nextInt();
			if(num%2==0) {
				count++;
			}
		}
		System.out.printf("입력받은짝수는 %d개 입니다.", count);
	
	}
	
}
