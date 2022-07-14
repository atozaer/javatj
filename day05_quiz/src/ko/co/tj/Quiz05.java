package ko.co.tj;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		int su = 0, sum = 0, count = 0, avg=0;
				
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자입력");
		while(true) {
			su = scan.nextInt();
			if(su==0)break;
			if(su%2==0)continue;
			sum+=su;
			count++;
		}
		avg = sum/count;
		System.out.printf("홀수의 합 = %d\n",sum);
		System.out.printf("홀수의 평균 = %d\n",avg);
		
		
	}

}
