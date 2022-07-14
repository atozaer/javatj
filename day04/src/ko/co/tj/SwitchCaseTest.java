package ko.co.tj;

import java.util.Scanner;

public class SwitchCaseTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year;
		int month;
		int day;
		boolean result;

		System.out.println("년도를입력해주세요.");
		year = scan.nextInt();
		System.out.println("월을입력해주세요.");
		month = scan.nextInt();
		result = (year % 4 == 0 && year % 100 != 0);

		if (result) {
			System.out.println("윤년입니다. 2월달이29일");
			System.out.println(year + "년도입니다.");
			switch (month) {
			case 1:	case 3:	case 5:	case 7:	case 8:	case 10: case 12:
				day = 31;
				System.out.println("1 2 3 4 5\n"
						+ "6 7 8 9 10/n"
						+ "11 12 13 14 15\n"
						+ "16 17 18 19 20\n"
						+ "21 22 23 24 25\n"
						+ "26 27 28 29 30 31\n");
				break;
			case 4:	case 6:	case 9:	case 11:
				day = 30;
				System.out.println("1 2 3 4 5\n"
						+ "6 7 8 9 10/n"
						+ "11 12 13 14 15\n"
						+ "16 17 18 19 20\n"
						+ "21 22 23 24 25\n"
						+ "26 27 28 29 30\n");
				break;
			case 2:
				day = 29;
				System.out.println("1 2 3 4 5\n"
						+ "6 7 8 9 10\n"
						+ "11 12 13 14 15\n"
						+ "16 17 18 19 20\n"
						+ "21 22 23 24 25\n"
						+ "26 27 28 29/n");
				break;
			default:
				day = 0;
			
			}
		}
		else {
			System.out.println("윤년이아닙니다.");
			System.out.println(year + "년도입니다.");
			switch (month) {
			case 1:	case 3:	case 5:	case 7:	case 8:	case 10: case 12:
				day = 31;
				break;
			case 4:	case 6:	case 9:	case 11:
				day = 30;
				break;
			case 2:
				day = 28;
				break;
			
			default:
				day = 0;
				System.out.println("존재하지않는달입니다.");
			}
		}
		System.out.println(month+"월은"+day+"일입니다.");
	}
}