package ko.co.tj;

import java.util.Scanner;

public class Quiz13 {

	public static void main(String[] args) {
		int dice1=0, dice2=0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("주사위굴리기!!!!");
		dice1=(int)(Math.random()*(6-1+1)+1);
		dice2=(int)(Math.random()*(6-1+1)+1);
		
		System.out.println("첫번째 주사위 : "+dice1);
		System.out.println("두번째 주사위 : "+dice2);
		
		if(dice1>4 && dice2>4) {
			System.out.println("이겼습니다.");
		}
		else if(dice1>4 || dice2>4) {
			System.out.println("비겼습니다.");
		}
		else if(dice1<4 && dice2<4) {
			System.out.println("졌습니다.");
		}
	}

}
