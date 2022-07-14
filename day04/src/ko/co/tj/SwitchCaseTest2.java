package ko.co.tj;

import java.util.Scanner;

public class SwitchCaseTest2 {

	public static void main(String[] args) {
		String medal = "null";
		Scanner scan = new Scanner(System.in);
		System.out.println("메달을선택해주세요.");
		medal = scan.next();

		switch (medal) {
		case "gold": case "GOLD": case "Gold":
			System.out.println("금메달입니다.");
			break;
		case "silver":
			System.out.println("은메달입니다.");
			break;
		case "bronze":
			System.out.println("동메달입니다.");
			break;
		default:
			System.out.println("메달이없습니다.");
			break;
		}

	}

}
