package ko.co.tj;

import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		int a=0, b=0, c=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 2개를 입력하시오.");
		a = scan.nextInt();
		b = scan.nextInt();
		
		if(a<b) {
			 c = a;
			 a = b;
			 b = c;
		}
		System.out.printf("입력받은수중 큰수는 %d이고, 작은수는 %d입니다.",a,b);
	}

}
