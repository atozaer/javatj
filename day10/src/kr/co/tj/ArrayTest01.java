package kr.co.tj;

import java.util.Scanner;

public class ArrayTest01 {

	public static void main(String[] args) {
		final int STUDENTS = 5;
		int total = 0;
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = new int[STUDENTS];
		
		for(int i = 0; i<STUDENTS; i++) {
			System.out.println("성적을입력하시오 : ");
			score[i] = scan.nextInt();
		}
		for(int i = 0; i<STUDENTS; i++) {
			total +=score[i];
		}
		System.out.println("평균성적은 "+total/STUDENTS+"점 입니다.");
		
	}

}
