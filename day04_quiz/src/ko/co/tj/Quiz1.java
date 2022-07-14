package ko.co.tj;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1=0, num2=0, num3=0, num4=0, num5 = 0;
		
		System.out.println("5개의수를입력하시오. ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		num4 = scan.nextInt();
		num5 = scan.nextInt();
		
		num1+=3;//num1 = num1 + 3;
		num2-=3;//num2 = num2 - 3;
		num3*=3;//num3 = num3 * 3;
		num4/=3;//num4 = num4 / 3;
		num5%=3;//num5 = num5 % 3;
				
		System.out.printf("%d %d %d %d %d ", num1,num2,num3,num4,num5);
			
		scan.close();
	}

}
