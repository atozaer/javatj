package kr.co.tj;

import java.util.Scanner;

public class ArrayTest05 {
	public final static int STUDENTS;
	static {
		STUDENTS = 5;
	}

	public static void main(String[] args) {
		int[] scores = new int[STUDENTS];
		getValues(scores);
		getAverage(scores);

	}

	private static void getValues(int[] array) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.println("성적을입력하세요 : ");
			array[i] = scan.nextInt();
		}
	}

	private static void getAverage(int[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		System.out.println("평균성적은 " + total / array.length + "점 입니다.");
	}

}
