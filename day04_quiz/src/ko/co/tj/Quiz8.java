package ko.co.tj;

import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		int a = 0;
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("한개의정수를입력하시오.");
		a = scan.nextInt();
		
		
		System.out.printf("%d/4=%d \n",a,a/4);
		System.out.printf("%d/4.0=%.2f \n",a,a/4.0);
		
	
	}

}
