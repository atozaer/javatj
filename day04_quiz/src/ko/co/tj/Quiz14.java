package ko.co.tj;

import java.util.Scanner;

public class Quiz14 {

	public static void main(String[] args) {
		int a=0, b=0, c=0;
		int max=0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("세 수를 입력하세요.");
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		
		if(a>=b && a>=c) {
			max = a;
		} else if(b>=a && b>=c) {
			max = b;
		} else{
			max = c;
		}
		System.out.printf("가장 큰 수는 %d입니다.", max);		
	}

}
