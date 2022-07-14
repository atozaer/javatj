package ko.co.tj;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		int count = 0, sum = 0, su = 0;
		double avg = 0.0;
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력");

		while(true) {
			su = scan.nextInt();
			if(su == 0)break;
			sum+=su;
			count++;
		}
		avg = (double)sum/count;
		System.out.printf("입력된자료의 개수 = %d \n",count);
		System.out.printf("입력된자료의 합계 = %d \n",sum);
		System.out.printf("입력된자료의 개수 = %.2f \n",avg);
				
	}

}
