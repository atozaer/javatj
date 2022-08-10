package kr.co.tj.etc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateFormatTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String birth = scan.next();
		LocalDate birthday;
		
		int dayTest = 0;
		try {
			birthday = LocalDate.parse(birth, formatter);
			dayTest = Integer.parseInt(formatter.format(birthday));
//			System.out.println("date format : "+formatter.format(birthday));
//			System.out.println("int : "+dayTest);
		} catch (Exception e) {			
			System.out.println("날짜 입력 에러(YYYYMMDD)");
		}
		if (!String.valueOf(dayTest).equals(birth)) {
			System.out.println("날짜 입력 에러(YYYYMMDD)");
		}
	}

}
