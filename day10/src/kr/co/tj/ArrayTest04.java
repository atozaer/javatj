package kr.co.tj;

import java.util.Scanner;

public class ArrayTest04 {

	public static void main(String[] args) {
		final int STUDENTS = 5;
		int total = 0;
		
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[STUDENTS];
		for(int i = 0; i<STUDENTS; i++) {
			System.out.println("성적을입력하세요:");
			scores[i] = scan.nextInt();
		}
		for(int i = 0; i<STUDENTS; i++) {
			total += scores[i];
		}
		System.out.println("평균성적은"+total/STUDENTS+"점 입니다.");
		
	}

}
